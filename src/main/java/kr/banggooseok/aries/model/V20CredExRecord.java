package kr.banggooseok.aries.model;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * POST /issue-credential-2.0/send
 * Response Model
 */
public class V20CredExRecord {

    @SerializedName("auto_issue")
    boolean autoIssue;

    @SerializedName("auto_offer")
    boolean autoOffer;

    @SerializedName("auto_remove")
    boolean autoRemove;

    @SerializedName("by_format")
    Map<String, Object> byFormat;

    @SerializedName("connection_id")
    String connectionId;

    @SerializedName("created_at")
    String createdAt;

    @SerializedName("cred_ex_id")
    String credExId;

    @SerializedName("cred_id_stored")
    String credIdStored;

    @SerializedName("cred_issue")
    Map<String, Object> credIssue;

    @SerializedName("cred_offer")
    Map<String, Object> credOffer;

    @SerializedName("cred_preview")
    Map<String, Object> credPreview;

    @SerializedName("cred_proposal")
    Map<String, Object> credProposal;

    @SerializedName("cred_request")
    Map<String, Object> credRequest;

    @SerializedName("cred_request_metadata")
    Map<String, Object> credRequestMetadata;

    @SerializedName("error_msg")
    String errorMsg;

    @SerializedName("initiator")
    String initiator;

    @SerializedName("parent_thread_id")
    String parentThreadId;

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

}
