package ch.thts.digitalwalletbackend.business.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final NatWestAccountsClient natWestAccountsClient;

    public List<Account> findAll() {
        return natWestAccountsClient.findAccounts();
    }

    public Account findByAccountId(final String accountId) {
        return natWestAccountsClient.findByAccountId(accountId);
    }

    public List<AccountTransaction> findAccountTransactions(final String accountId) {
        return natWestAccountsClient.findAccountTransactions(accountId);
    }
}
