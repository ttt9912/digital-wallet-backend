package ch.thts.digitalwalletbackend.natwestclient.account.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record NatWestAccount(
        @JsonProperty("AccountId") String accountId,
        @JsonProperty("AccountType") String accountType,
        @JsonProperty("AccountSubType") String accountSubType,
        @JsonProperty("Currency") String currency
) {
}
