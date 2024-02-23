package ch.thts.digitalwalletbackend.natwestclient.account.converter;

import ch.thts.digitalwalletbackend.business.account.AccountTransaction;
import ch.thts.digitalwalletbackend.natwestclient.account.model.NatWestTransaction;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class AccountTransactionConverter {

    public static AccountTransaction convert(final NatWestTransaction natWestTransaction) {
        return new AccountTransaction(
                natWestTransaction.bookingDateTime(),
                natWestTransaction.amount().currency(),
                AmountConverter.convert(natWestTransaction.amount().amount(), natWestTransaction.creditDebitIndicator()),
                natWestTransaction.transactionInformation()
        );
    }
}
