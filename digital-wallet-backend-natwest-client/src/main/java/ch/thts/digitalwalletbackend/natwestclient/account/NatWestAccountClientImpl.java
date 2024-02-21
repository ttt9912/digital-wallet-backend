package ch.thts.digitalwalletbackend.natwestclient.account;

import ch.thts.digitalwalletbackend.business.accounts.Account;
import ch.thts.digitalwalletbackend.business.accounts.NatWestAccountsClient;
import ch.thts.digitalwalletbackend.business.accounts.AccountTransaction;
import ch.thts.digitalwalletbackend.natwestclient.account.converter.AccountConverter;
import ch.thts.digitalwalletbackend.natwestclient.account.converter.AccountTransactionConverter;
import ch.thts.digitalwalletbackend.natwestclient.account.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

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
        return natWestAccountRestClient.getAccounts(accessToken).data().accounts().stream()
                .map(natWestAccount -> AccountConverter.convert(natWestAccount, findForwardAvailableAccountBalance(natWestAccount.accountId())))
                .toList();
    }

    @Override
    public Account findByAccountId(final String accountId) {
        return natWestAccountRestClient.getAccount(accessToken, accountId).data().accounts().stream()
                .findFirst()
                .map(natWestAccount -> AccountConverter.convert(natWestAccount, findForwardAvailableAccountBalance(natWestAccount.accountId())))
                .orElseThrow();
    }

    /*
     * Type "ForwardAvailable" represents the current balance
     * https://www.bankofapis.com/products/natwest-group-open-banking/accounts/documentation/nwb/3.1.11#balances
     */
    public NatWestAccountBalance findForwardAvailableAccountBalance(final String accountId) {
        final NatWestAccountBalanceResponse response = natWestAccountRestClient.getBalances(accessToken, accountId);
        return response.data().balances().stream()
                .filter(b -> Objects.equals(b.type(), "ForwardAvailable"))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<AccountTransaction> findAccountTransactions(final String accountId) {
        final NatWestTransactionResponse response = natWestAccountRestClient.getTransactions(accessToken, accountId);
        return response.data().transactions().stream()
                .map(AccountTransactionConverter::convert)
                .toList();
    }

}
