package ch.thts.digitalwalletbackend.natwestclient.account.converter;

import ch.thts.digitalwalletbackend.natwestclient.account.exception.CreditDebitIndicatorUnknownException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AmountConverterTest {

    @Test
    void convertBalance_convertsCreditAmount() {
        final String amount = "19646.25";
        final String creditDebitIndicator = "Credit";
        assertEquals(AmountConverter.convert(amount, creditDebitIndicator), BigDecimal.valueOf(19646.25));
    }

    @Test
    void convertBalance_convertsDebitAmountNegative() {
        final String amount = "19646.25";
        final String creditDebitIndicator = "Debit";
        assertEquals(AmountConverter.convert(amount, creditDebitIndicator), BigDecimal.valueOf(-19646.25));
    }

    @Test
    void convertBalance_invalidCreditDebitIndicator_throwsException() {
        final String amount = "19646.25";
        final String creditDebitIndicator = "";
        assertThrows(CreditDebitIndicatorUnknownException.class, () -> AmountConverter.convert(amount, creditDebitIndicator));
    }
}