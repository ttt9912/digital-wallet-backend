package ch.thts.digitalwalletbackend.natwestclient.account;

import ch.thts.digitalwalletbackend.business.accounts.Account;
import ch.thts.digitalwalletbackend.business.accounts.NatWestAccountsClient;
import ch.thts.digitalwalletbackend.natwestclient.account.converter.AccountConverter;
import ch.thts.digitalwalletbackend.natwestclient.account.model.NatWestAccount;
import ch.thts.digitalwalletbackend.natwestclient.account.model.NatWestAccountBalance;
import ch.thts.digitalwalletbackend.natwestclient.account.model.NatWestAccountBalanceResponse;
import ch.thts.digitalwalletbackend.natwestclient.account.model.NatWestAccountsResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class NatWestAccountClientImpl implements NatWestAccountsClient {
    private final String accessToken;
    private final NatWestAccountRestClient natWestAccountRestClient;

    public NatWestAccountClientImpl(@Value("${natwest.client.accesstoken}") final String accessToken,
                                    final NatWestAccountRestClient natWestAccountRestClient) {
        this.accessToken = accessToken;
        this.natWestAccountRestClient = natWestAccountRestClient;
    }

    @Override
    public List<Account> findAll() {
        final NatWestAccountsResponse response = natWestAccountRestClient.getAccounts(accessToken);
        final List<NatWestAccount> accounts = response.data().accounts();
        return accounts.stream()
                .map(this::createAccount)
                .toList();
    }

    private Account createAccount(final NatWestAccount natWestAccount) {
        final NatWestAccountBalance natWestAccountBalance = findAccountBalance(natWestAccount.accountId()).orElse(null);
        return AccountConverter.convert(natWestAccount, natWestAccountBalance);
    }

    public Optional<NatWestAccountBalance> findAccountBalance(final String accountId) {
        final NatWestAccountBalanceResponse response = natWestAccountRestClient.getBalances(accessToken, accountId);
        return response.data().balances().stream()
                .filter(b -> Objects.equals(b.type(), "ForwardAvailable"))
                .findFirst();
    }
}
