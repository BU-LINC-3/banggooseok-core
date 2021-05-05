package kr.banggooseok.aries.model;

import com.google.gson.annotations.SerializedName;

public class V20PresRequestByFormat {

    @SerializedName("dif")
    public DIF dif;

    @SerializedName("indy")
    public Indy indy;

    @SerializedName("trace")
    public boolean trace;

    public static class DIF {

        @SerializedName("some_dif")
        public String someDIF;

    }

    public static class Indy {

        @SerializedName("name")
        public String name;

        @SerializedName("non_revoked")
        public NonRevoked nonRevoked;

        @SerializedName("nonce")
        public String nonce;

        @SerializedName("requested_attributes")
        public IndyProofReqAttrSpec requestedAttributes;

        @SerializedName("requested_predicates")
        public IndyProofReqPredSpec requestedPredicates;

        public static class NonRevoked {

            @SerializedName("to")
            int to;

        }
    }

}
