package ch.thts.digitalwalletbackend.business.account;

import java.math.BigDecimal;

public record Account(
        String accountId,
        String bank,
        String accountType,
        String accountSubType,
        String currency,
        BigDecimal balanceAmount
) {
}
