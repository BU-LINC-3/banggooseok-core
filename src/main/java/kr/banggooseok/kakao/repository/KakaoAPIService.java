package kr.banggooseok.kakao.repository;

import kr.banggooseok.kakao.model.TokenInfoModel;
import kr.banggooseok.kakao.model.UserInfoModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

import java.util.Map;

public interface KakaoAPIService {

    @GET("/v1/user/access_token_info")
    Call<TokenInfoModel> validateToken(@Header("Authorization") String token);

    @GET("/v2/user/me")
    Call<UserInfoModel> getUserInfo(@Header("Authorization") String token);

}
