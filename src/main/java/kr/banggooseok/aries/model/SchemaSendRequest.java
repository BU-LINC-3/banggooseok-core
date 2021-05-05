package kr.banggooseok.aries.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * POST /schemas
 * Request Model
 */
public class SchemaSendRequest {

    @SerializedName("attributes")
    List<String> attributes;

    @SerializedName("schema_name")
    String schemaName;

    @SerializedName("schema_version")
    String schemaVersion;

}
