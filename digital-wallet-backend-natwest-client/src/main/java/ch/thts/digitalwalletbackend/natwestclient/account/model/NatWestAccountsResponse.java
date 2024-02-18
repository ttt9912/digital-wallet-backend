package ch.thts.digitalwalletbackend.natwestclient.account.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record NatWestAccountsResponse(
        @JsonProperty("Data") NatWestAccountsResponseData data
) {
}
