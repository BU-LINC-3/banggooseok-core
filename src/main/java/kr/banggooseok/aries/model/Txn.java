package kr.banggooseok.aries.model;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class Txn {

    @SerializedName("_id")
    String _id;

    @SerializedName("_type")
    String _type;

    @SerializedName("connection_id")
    String connectionId;

    @SerializedName("created_at")
    String createdAt;

    @SerializedName("formats")
    Map<String, Object> formats;

    @SerializedName("messages_attach")
    Map<String, Object> messagesAttach;

    @SerializedName("signature_request")
    Map<String, Object> signatureRequest;

    @SerializedName("signature_response")
    Map<String, Object> signatureResponse;

    @SerializedName("state")
    String state;

    @SerializedName("thread_id")
    String threadId;

    @SerializedName("timing")
    Map<String, Object> timing;

    @SerializedName("trace")
    boolean trace;

    @SerializedName("updated_at")
    String updatedAt;

}
