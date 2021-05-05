package kr.banggooseok.aries.model;

import com.google.gson.annotations.SerializedName;

/**
 * POST /connections/create-invitation
 * Response Model
 */
public class InvitationResult {

    @SerializedName("connection_id")
    String connectionId;

    @SerializedName("invitation")
    ConnectionInvitation invitation;

    @SerializedName("invitation_url")
    String invitationUrl;

}
