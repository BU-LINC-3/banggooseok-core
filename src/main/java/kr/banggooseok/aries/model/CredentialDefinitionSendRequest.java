package kr.banggooseok.aries.model;

import com.google.gson.annotations.SerializedName;

/**
 * POST /credential-definitions
 * Request Model
 */
public class CredentialDefinitionSendRequest {

    @SerializedName("revocation_registry_size")
    int revocationRegistrySize;

    @SerializedName("schema_id")
    String schemaId;

    @SerializedName("support_revocation")
    boolean supportRevocation;

    @SerializedName("tag")
    String tag;

}
