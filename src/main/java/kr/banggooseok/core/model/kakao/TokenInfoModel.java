package kr.banggooseok.core.model.kakao;

import com.google.gson.annotations.SerializedName;

public class TokenInfoModel {

    @SerializedName("id")
    private long userId;

    @SerializedName("expires_in")
    private int expiresIn;

    @SerializedName("app_id")
    private int appId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

}
