package ch.thts.digitalwalletbackend.natwestclient.account.converter;

import ch.thts.digitalwalletbackend.business.account.Account;
import ch.thts.digitalwalletbackend.natwestclient.account.model.NatWestAccount;
import ch.thts.digitalwalletbackend.natwestclient.account.model.NatWestAccountBalance;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class AccountConverter {
    public static final String BANK_NAME = "NatWest";

    public static Account convert(final NatWestAccount natWestAccount, final NatWestAccountBalance natWestAccountBalance) {
        return new Account(
                natWestAccount.accountId(),
                BANK_NAME,
                natWestAccount.accountType(),
                natWestAccount.accountSubType(),
                natWestAccount.currency(),
                AmountConverter.convert(natWestAccountBalance.amount().amount(), natWestAccountBalance.creditDebitIndicator())
        );
    }
}
