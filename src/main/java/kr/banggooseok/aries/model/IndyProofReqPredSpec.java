package kr.banggooseok.aries.model;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class IndyProofReqPredSpec {

    @SerializedName("name")
    String name;

    @SerializedName("non_revoked")
    V20PresRequestByFormat.Indy.NonRevoked nonRevoked;

    @SerializedName("p_type")
    String pType;

    @SerializedName("p_value")
    int pValue;

    @SerializedName("restrictions")
    Map<String, Object> restrictions;

}
