package kr.banggooseok.aries.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ConnectionInvitation {

    @SerializedName("id")
    String id;

    @SerializedName("type")
    String type;

    @SerializedName("did")
    String did;

    @SerializedName("imageUrl")
    String imageUrl;

    @SerializedName("label")
    String label;

    @SerializedName("recipientKeys")
    List<String> recipientKeys;

    @SerializedName("routingKeys")
    List<String> routingKeys;

    @SerializedName("serviceEndpoint")
    String serviceEndPoint;

}
