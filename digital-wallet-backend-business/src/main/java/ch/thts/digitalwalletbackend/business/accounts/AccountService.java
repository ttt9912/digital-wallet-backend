package ch.thts.digitalwalletbackend.business.accounts;

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

    public List<AccountTransaction> findAccountTransactions(final String accountId) {
        return natWestAccountsClient.findAccountTransactions(accountId);
    }
}
