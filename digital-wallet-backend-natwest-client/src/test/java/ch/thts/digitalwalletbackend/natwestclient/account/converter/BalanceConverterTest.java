package ch.thts.digitalwalletbackend.natwestclient.account.converter;

import ch.thts.digitalwalletbackend.natwestclient.account.exception.CreditDebitIndicatorUnknownException;
import ch.thts.digitalwalletbackend.natwestclient.account.model.NatWestAccountBalance;
import ch.thts.digitalwalletbackend.natwestclient.account.model.NatWestAmount;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BalanceConverterTest {

    @Test
    void convertBalance_convertsCreditAmount() {
        final NatWestAccountBalance natWestAccountBalance = new NatWestAccountBalance(
                new NatWestAmount("19646.25", "GBP"),
                "Credit",
                "ForwardAvailable",
                LocalDateTime.parse("2024-02-17T19:32:13.734")
        );

        assertEquals(BalanceConverter.convertBalance(natWestAccountBalance), BigDecimal.valueOf(19646.25));
    }

    @Test
    void convertBalance_convertsDebitAmountNegative() {
        final NatWestAccountBalance natWestAccountBalance = new NatWestAccountBalance(
                new NatWestAmount("19646.25", "GBP"),
                "Debit",
                "ForwardAvailable",
                LocalDateTime.parse("2024-02-17T19:32:13.734")
        );

        assertEquals(BalanceConverter.convertBalance(natWestAccountBalance), BigDecimal.valueOf(-19646.25));
    }

    @Test
    void convertBalance_invalidCreditDebitIndicator_throwsException() {
        final NatWestAccountBalance natWestAccountBalance = new NatWestAccountBalance(
                new NatWestAmount("19646.25", "GBP"),
                "",
                "ForwardAvailable",
                LocalDateTime.parse("2024-02-17T19:32:13.734")
        );

        assertThrows(CreditDebitIndicatorUnknownException.class, () -> BalanceConverter.convertBalance(natWestAccountBalance));
    }
}