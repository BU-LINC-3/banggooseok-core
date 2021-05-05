package kr.banggooseok.aries.model;

import com.google.gson.annotations.SerializedName;

/**
 * POST /issue-credential-2.0/send
 * Request Model
 */
public class V20CredProposalRequestPreviewMand {

    @SerializedName("auto_remove")
    boolean autoRemove;

    @SerializedName("comment")
    String comment;

    @SerializedName("connection_id")
    String connectionId;

    @SerializedName("credential_preview")
    V20CredPreview credentialPreview;

    @SerializedName("filter")
    Filter filter;

    @SerializedName("trace")
    boolean trace;

    static class Filter {

        @SerializedName("dif")
        DIF dif;

        @SerializedName("indy")
        Indy indy;

        static class DIF {

            @SerializedName("some_dif_criterion")
            String someDIFCriterion;

        }

        static class Indy {

            @SerializedName("cred_def_id")
            String credDefId;

            @SerializedName("issuer_did")
            String issuerDID;

            @SerializedName("schema_id")
            String schemaId;

            @SerializedName("schema_issuer_did")
            String schemaIssuerDID;

            @SerializedName("schema_name")
            String schemaName;

            @SerializedName("schema_version")
            String schemaVersion;

        }

    }
}
