package ch.thts.digitalwalletbackend.natwestclient.account.converter;

import ch.thts.digitalwalletbackend.natwestclient.account.exception.CreditDebitIndicatorUnknownException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AmountConverterTest {

    @Test
    void convertBalance_convertsAndRoundsCreditAmount() {
        final String creditDebitIndicator = "Credit";
        assertEquals(new BigDecimal("12.35"), AmountConverter.convert("12.374", creditDebitIndicator));
        assertEquals(new BigDecimal("12.40"), AmountConverter.convert("12.375", creditDebitIndicator));
    }

    @Test
    void convertBalance_convertsAndRoundsDebitAmountNegative() {
        final String creditDebitIndicator = "Debit";
        assertEquals(new BigDecimal("-12.35"), AmountConverter.convert("12.374", creditDebitIndicator));
        assertEquals(new BigDecimal("-12.40"), AmountConverter.convert("12.375", creditDebitIndicator));
    }

    @Test
    void convertBalance_invalidCreditDebitIndicator_throwsException() {
        final String amount = "19646.25";
        final String creditDebitIndicator = "";
        assertThrows(CreditDebitIndicatorUnknownException.class, () -> AmountConverter.convert(amount, creditDebitIndicator));
    }
}
