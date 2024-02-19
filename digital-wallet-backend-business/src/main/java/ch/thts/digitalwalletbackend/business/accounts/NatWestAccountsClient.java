package ch.thts.digitalwalletbackend.business.accounts;

import java.util.List;

public interface NatWestAccountsClient {

    List<Account> findAccounts();

    List<AccountTransaction> findAccountTransactions(String accountId);
}
