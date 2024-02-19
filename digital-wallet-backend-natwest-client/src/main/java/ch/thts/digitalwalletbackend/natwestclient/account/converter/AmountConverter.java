package ch.thts.digitalwalletbackend.natwestclient.account.converter;

import ch.thts.digitalwalletbackend.natwestclient.account.exception.CreditDebitIndicatorUnknownException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class AmountConverter {

    public static BigDecimal convert(final String amount, final String creditDebitIndicator) {
        if (Objects.equals(creditDebitIndicator, "Credit")) {
            return new BigDecimal(amount);
        }
        if (Objects.equals(creditDebitIndicator, "Debit")) {
            return new BigDecimal(amount).negate();
        }
        throw new CreditDebitIndicatorUnknownException("Unknown CreditDebitIndicator " + creditDebitIndicator);
    }
}
