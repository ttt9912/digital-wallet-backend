package ch.thts.digitalwalletbackend.natwestclient.account;

import ch.thts.digitalwalletbackend.natwestclient.account.model.NatWestAccountBalanceResponse;
import ch.thts.digitalwalletbackend.natwestclient.account.model.NatWestAccountsResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.service.annotation.GetExchange;

public interface NatWestAccountRestClient {

    @GetExchange("/accounts")
    NatWestAccountsResponse getAccounts(@RequestHeader("Authorization") String jwt);

    @GetExchange("/accounts/{AccountId}/balances")
    NatWestAccountBalanceResponse getBalances(@RequestHeader("Authorization") String jwt, @PathVariable("AccountId") String accountId);

}
