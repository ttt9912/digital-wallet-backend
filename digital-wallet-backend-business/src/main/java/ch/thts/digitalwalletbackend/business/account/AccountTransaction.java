package ch.thts.digitalwalletbackend.business.account;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AccountTransaction(
        LocalDateTime bookingDateTime,
        String currency,
        BigDecimal amount,
        String transactionInformation
) {
}
