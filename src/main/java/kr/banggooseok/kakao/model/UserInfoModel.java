package kr.banggooseok.kakao.model;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class UserInfoModel {

    @SerializedName("id")
    public long id;

    @SerializedName("kakao_account")
    public Account kakaoAccount;

    @SerializedName("properties")
    public Map<String, Object> properties;

    public static class Account {

        @SerializedName("profile_needs_agreement")
        public boolean profileNeedsAgreement;

        @SerializedName("profile")
        public Profile profile;

        @SerializedName("email_needs_agreement")
        public boolean emailNeedsAgreement;

        @SerializedName("is_email_valid")
        public boolean isEmailValid;

        @SerializedName("is_email_verified")
        public boolean isEmailVerified;

        @SerializedName("email")
        public String email;

        @SerializedName("age_range_needs_agreement")
        public boolean ageRangeNeedsAgreement;

        @SerializedName("age_range")
        public String ageRange;

        @SerializedName("birthday_needs_agreement")
        public boolean birthdayNeedsAgreement;

        @SerializedName("birthday")
        public String birthday;

        @SerializedName("gender_needs_agreement")
        public boolean genderNeedsAgreement;

        @SerializedName("gender")
        public String gender;

        public static class Profile {

            @SerializedName("nickname")
            public String nickname;

            @SerializedName("thumbnail_image_url")
            public String thumbnailImageUrl;

            @SerializedName("profile_image_url")
            public String profileImageUrl;

            @SerializedName("is_default_image")
            public boolean isDefaultImage;

        }

    }
}
