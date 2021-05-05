package kr.banggooseok.aries.model;

import com.google.gson.annotations.SerializedName;

public class V20PresRequestByFormat {

    @SerializedName("dif")
    DIF dif;

    @SerializedName("indy")
    Indy indy;

    @SerializedName("trace")
    boolean trace;

    static class DIF {

        @SerializedName("some_dif")
        String someDIF;

    }

    static class Indy {

        @SerializedName("name")
        String name;

        @SerializedName("non_revoked")
        NonRevoked nonRevoked;

        @SerializedName("nonce")
        String nonce;

        @SerializedName("requested_attributes")
        IndyProofReqAttrSpec requestedAttributes;

        @SerializedName("requested_predicates")
        IndyProofReqPredSpec requestedPredicates;

        static class NonRevoked {

            @SerializedName("to")
            int to;

        }
    }

}
