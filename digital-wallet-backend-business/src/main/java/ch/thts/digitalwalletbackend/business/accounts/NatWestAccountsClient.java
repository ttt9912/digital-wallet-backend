package ch.thts.digitalwalletbackend.business.accounts;

import java.util.List;

public interface NatWestAccountsClient {

    List<Account> findAll();

}