package ch.thts.digitalwalletbackend.restapi.account;

import ch.thts.digitalwalletbackend.business.account.Account;
import ch.thts.digitalwalletbackend.business.account.AccountService;
import ch.thts.digitalwalletbackend.business.account.AccountTransaction;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    public List<Account> findAll() {
        return accountService.findAll();
    }

    @GetMapping("/{accountId}")
    public Account findByAccountId(@PathVariable("accountId") final String accountId) {
        return accountService.findByAccountId(accountId);
    }

    @GetMapping("/{accountId}/transactions")
    public List<AccountTransaction> findAccountTransactions(@PathVariable("accountId") final String accountId) {
        return accountService.findAccountTransactions(accountId);
    }
}
