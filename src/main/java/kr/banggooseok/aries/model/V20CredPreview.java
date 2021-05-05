package kr.banggooseok.aries.model;

import com.google.gson.annotations.SerializedName;

public class V20CredPreview {

    @SerializedName("@type")
    String type;

    @SerializedName("attributes")
    V20CredAttrSpec attributes;

}
