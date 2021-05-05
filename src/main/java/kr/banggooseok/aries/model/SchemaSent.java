package kr.banggooseok.aries.model;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class SchemaSent {

    @SerializedName("schema")
    Map<String, Object> schema;

    @SerializedName("schema_id")
    String schemaId;

}
