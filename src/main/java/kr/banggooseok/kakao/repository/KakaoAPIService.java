package kr.banggooseok.kakao.repository;

import kr.banggooseok.kakao.model.TokenInfoModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface KakaoAPIService {

    @GET("/v1/user/access_token_info")
    Call<TokenInfoModel> validateToken(@Header("Authorization") String token);

}
