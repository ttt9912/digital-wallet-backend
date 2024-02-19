package ch.thts.digitalwalletbackend.natwestclient.account.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record NatWestTransaction(
        @JsonProperty("AccountId") String accountId,
        @JsonProperty("Amount") NatWestAmount amount,
        @JsonProperty("CreditDebitIndicator") String creditDebitIndicator,
        @JsonProperty("BookingDateTime") LocalDateTime bookingDateTime,
        @JsonProperty("TransactionInformation") String transactionInformation
) {
}
