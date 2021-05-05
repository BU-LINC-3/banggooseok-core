package kr.banggooseok.aries.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class IndyProofReqAttrSpec {

    @SerializedName("name")
    String name;

    @SerializedName("names")
    List<String> names;

    @SerializedName("non_revoked")
    V20PresRequestByFormat.Indy.NonRevoked nonRevoked;

    @SerializedName("restrictions")
    Map<String, Object> restrictions;

}
