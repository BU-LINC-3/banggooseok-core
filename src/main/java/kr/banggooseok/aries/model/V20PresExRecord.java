package kr.banggooseok.aries.model;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * POST /present-proof-2.0/records/{pres_ex_id}
 * Response Model
 */
public class V20PresExRecord {

    @SerializedName("auto_present")
    boolean autoPresent;

    @SerializedName("by_format")
    Map<String, Object> byFormat;

    @SerializedName("connection_id")
    String connectionId;

    @SerializedName("created_at")
    String createdAt;

    @SerializedName("error_msg")
    String errorMsg;

    @SerializedName("initiator")
    String initiator;

    @SerializedName("pres")
    Map<String, Object> pres;

    @SerializedName("pres_ex_id")
    String presExId;

    @SerializedName("pres_proposal")
    Map<String, Object> presProposal;

    @SerializedName("pres_request")
    Map<String, Object> presRequest;

    @SerializedName("role")
    String role;

    @SerializedName("state")
    String state;

    @SerializedName("thread_id")
    String threadId;

    @SerializedName("trace")
    boolean trace;

    @SerializedName("updated_at")
    String updatedAt;

    @SerializedName("verified")
    String verified;

}
