package ch.thts.digitalwalletbackend.natwestclient.account.converter;

import ch.thts.digitalwalletbackend.business.accounts.Account;
import ch.thts.digitalwalletbackend.natwestclient.account.model.NatWestAccount;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class AccountConverter {

    public static Account convert(final NatWestAccount natWestAccount, final BigDecimal accountBalance) {

        return new Account(
                natWestAccount.accountId(),
                "NatWest",
                natWestAccount.accountType(),
                natWestAccount.accountSubType(),
                natWestAccount.currency(),
                accountBalance
        );
    }
}
