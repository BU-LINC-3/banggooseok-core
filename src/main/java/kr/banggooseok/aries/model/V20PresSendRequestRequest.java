package kr.banggooseok.aries.model;

import com.google.gson.annotations.SerializedName;

/**
 * POST /present-proof-2.0/send-request
 * Request Model
 */
public class V20PresSendRequestRequest {

    @SerializedName("comment")
    String comment;

    @SerializedName("connection_id")
    String connectionId;

    @SerializedName("presentation_request")
    V20PresRequestByFormat presentationRequest;

    @SerializedName("trace")
    boolean trace;

}
