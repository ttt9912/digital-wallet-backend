package ch.thts.digitalwalletbackend.natwestclient.account.converter;

import ch.thts.digitalwalletbackend.business.accounts.Account;
import ch.thts.digitalwalletbackend.natwestclient.account.model.NatWestAccount;
import ch.thts.digitalwalletbackend.natwestclient.account.model.NatWestAccountBalance;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class AccountConverter {

    public static Account convert(final NatWestAccount natWestAccount, final NatWestAccountBalance natWestAccountBalance) {
        return new Account(
                natWestAccount.accountId(),
                "NatWest",
                natWestAccount.accountType(),
                natWestAccount.accountSubType(),
                natWestAccount.currency(),
                BalanceConverter.convertBalance(natWestAccountBalance)
        );
    }
}
