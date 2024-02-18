package ch.thts.digitalwalletbackend.business.accounts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final NatWestAccountsClient natWestAccountsClient;

    public List<Account> findAll() {
        return natWestAccountsClient.findAll();
    }
}
