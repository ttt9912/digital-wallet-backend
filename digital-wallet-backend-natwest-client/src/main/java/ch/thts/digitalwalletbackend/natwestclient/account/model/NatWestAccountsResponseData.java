package ch.thts.digitalwalletbackend.natwestclient.account.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record NatWestAccountsResponseData(
        @JsonProperty("Account") List<NatWestAccount> accounts
) {
}
