package ch.thts.digitalwalletbackend.natwestclient.account.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record NatWestAmount(
        @JsonProperty("Amount") String amount,
        @JsonProperty("Currency") String currency
) {
}
