package ch.thts.digitalwalletbackend.natwestclient.account.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record NatWestAccountBalance(
        @JsonProperty("Amount") NatWestAmount amount,
        @JsonProperty("CreditDebitIndicator") String creditDebitIndicator,
        @JsonProperty("Type") String type,
        @JsonProperty("DateTime") LocalDateTime dateTime
) {
}
