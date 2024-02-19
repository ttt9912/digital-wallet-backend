package ch.thts.digitalwalletbackend.natwestclient.account.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record NatWestTransactionResponse(
        @JsonProperty("Data") NatWestTransactionResponseData data
){
}
