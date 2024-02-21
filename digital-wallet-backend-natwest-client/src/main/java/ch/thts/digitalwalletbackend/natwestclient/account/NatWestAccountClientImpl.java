package ch.thts.digitalwalletbackend.natwestclient.account;

import ch.thts.digitalwalletbackend.business.accounts.Account;
import ch.thts.digitalwalletbackend.business.accounts.NatWestAccountsClient;
import ch.thts.digitalwalletbackend.business.accounts.AccountTransaction;
import ch.thts.digitalwalletbackend.natwestclient.account.converter.AccountConverter;
import ch.thts.digitalwalletbackend.natwestclient.account.converter.AccountTransactionConverter;
import ch.thts.digitalwalletbackend.natwestclient.account.converter.AmountConverter;
import ch.thts.digitalwalletbackend.natwestclient.account.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
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
    public List<Account> findAccounts() {
        final NatWestAccountsResponse response = natWestAccountRestClient.getAccounts(accessToken);
        final List<NatWestAccount> accounts = response.data().accounts();
        return accounts.stream()
                .map(this::createAccount)
                .toList();
    }

    @Override
    public Account findByAccountId(final String accountId) {
        final NatWestAccount natWestAccount = natWestAccountRestClient.getAccount(accessToken, accountId).data().accounts().getFirst();
        return this.createAccount(natWestAccount);
    }

    private Account createAccount(final NatWestAccount natWestAccount) {
        final BigDecimal accountBalance = findAccountBalance(natWestAccount.accountId())
                .map(balance -> AmountConverter.convert(balance.amount().amount(), balance.creditDebitIndicator()))
                .orElse(null);
        return AccountConverter.convert(natWestAccount, accountBalance);
    }

    public Optional<NatWestAccountBalance> findAccountBalance(final String accountId) {
        final NatWestAccountBalanceResponse response = natWestAccountRestClient.getBalances(accessToken, accountId);
        return response.data().balances().stream()
                .filter(b -> Objects.equals(b.type(), "ForwardAvailable"))
                .findFirst();
    }

    @Override
    public List<AccountTransaction> findAccountTransactions(final String accountId) {
        final NatWestTransactionResponse response = natWestAccountRestClient.getTransactions(accessToken, accountId);
        return response.data().transactions().stream()
                .map(AccountTransactionConverter::convert)
                .toList();
    }

}
