package kr.banggooseok.aries.model;

import com.google.gson.annotations.SerializedName;

/**
 * POST /schemas
 * Response Model
 */
public class TxnOrSchemaSendResult {

    @SerializedName("sent")
    SchemaSent sent;

    @SerializedName("txn")
    Txn txn;

}
