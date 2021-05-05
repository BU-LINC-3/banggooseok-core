package kr.banggooseok.aries.model;

import com.google.gson.annotations.SerializedName;

/**
 * POST /credential-definitions
 * Response Model
 */
public class TxnOrCredentialDefinitionSendResult {

    @SerializedName("sent")
    SchemaSent sent;

    @SerializedName("txn")
    Txn txn;

}
