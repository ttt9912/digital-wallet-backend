package ch.thts.digitalwalletbackend.natwestclient.account.converter;

import ch.thts.digitalwalletbackend.natwestclient.account.exception.CreditDebitIndicatorUnknownException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class AmountConverter {

    public static BigDecimal convert(final String amount, final String creditDebitIndicator) {
        if (Objects.equals(creditDebitIndicator, "Credit")) {
            return parseAndRoundTo5Rp(amount);
        }
        if (Objects.equals(creditDebitIndicator, "Debit")) {
            return parseAndRoundTo5Rp(amount).negate();
        }
        throw new CreditDebitIndicatorUnknownException("Unknown CreditDebitIndicator " + creditDebitIndicator);
    }

    private static BigDecimal parseAndRoundTo5Rp(String amount) {
        final BigDecimal increment = new BigDecimal("0.05");
        return new BigDecimal(amount)
                .divide(increment, 0, RoundingMode.HALF_UP)
                .multiply(increment);
    }
}
