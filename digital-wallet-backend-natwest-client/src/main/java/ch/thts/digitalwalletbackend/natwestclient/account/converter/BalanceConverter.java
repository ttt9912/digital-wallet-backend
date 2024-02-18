package ch.thts.digitalwalletbackend.natwestclient.account.converter;

import ch.thts.digitalwalletbackend.natwestclient.account.exception.CreditDebitIndicatorUnknownException;
import ch.thts.digitalwalletbackend.natwestclient.account.model.NatWestAccountBalance;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class BalanceConverter {

    public static BigDecimal convertBalance(final NatWestAccountBalance natWestAccountBalance) {
        final BigDecimal amount = new BigDecimal(natWestAccountBalance.amount().amount());
        if (Objects.equals(natWestAccountBalance.creditDebitIndicator(), "Credit")) {
            return amount;
        }
        if (Objects.equals(natWestAccountBalance.creditDebitIndicator(), "Debit")) {
            return amount.negate();
        }

        throw new CreditDebitIndicatorUnknownException("Unknown CreditDebitIndicator " + natWestAccountBalance.creditDebitIndicator());
    }

}
