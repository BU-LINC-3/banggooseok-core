package kr.banggooseok.aries.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class IndyProofReqAttrSpec {

    @SerializedName("name")
    public String name;

    @SerializedName("names")
    public List<String> names;

    @SerializedName("non_revoked")
    public V20PresRequestByFormat.Indy.NonRevoked nonRevoked;

    @SerializedName("restrictions")
    public Map<String, Object> restrictions;

}
