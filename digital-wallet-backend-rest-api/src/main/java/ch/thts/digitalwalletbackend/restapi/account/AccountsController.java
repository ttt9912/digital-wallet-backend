package ch.thts.digitalwalletbackend.restapi.account;

import ch.thts.digitalwalletbackend.business.accounts.Account;
import ch.thts.digitalwalletbackend.business.accounts.AccountService;
import ch.thts.digitalwalletbackend.business.accounts.AccountTransaction;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/accounts")
@RequiredArgsConstructor
public class AccountsController {
    private final AccountService accountService;

    @GetMapping
    public List<Account> findAll() {
        return accountService.findAll();
    }

    @GetMapping("/{accountId}/transactions")
    public List<AccountTransaction> findTransactions(@PathVariable("accountId") final String accountId) {
        return accountService.findAccountTransactions(accountId);
    }
}
