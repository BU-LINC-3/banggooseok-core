package kr.banggooseok.aries.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * GET /connections
 * Response Model
 */
public class ConnectionList {

    @SerializedName("results")
    public List<ConnRecord> results;

}
