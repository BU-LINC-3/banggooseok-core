package kr.banggooseok.database.vo;

import com.google.gson.annotations.SerializedName;

public class ImagesVO {

    @SerializedName("id")
    private int id;

    @SerializedName("user_id")
    private long user_id;

    @SerializedName("path")
    private String path;

    @SerializedName("timestamp")
    private long timestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
