package ch.thts.digitalwalletbackend.natwestclient.account.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record NatWestTransactionResponseData(
        @JsonProperty("Transaction") List<NatWestTransaction> transactions
){
}
