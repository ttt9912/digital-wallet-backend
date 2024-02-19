package ch.thts.digitalwalletbackend.business.accounts;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AccountTransaction(
        LocalDateTime bookingDateTime,
        String currency,
        BigDecimal amount,
        String transactionInformation
) {
}
