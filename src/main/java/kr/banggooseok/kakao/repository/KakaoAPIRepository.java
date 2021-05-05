package kr.banggooseok.kakao.repository;

import kr.banggooseok.kakao.model.TokenInfoModel;
import org.springframework.stereotype.Repository;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@Repository("kakaoAPIRepository")
public class KakaoAPIRepository {

    private Retrofit retrofit;
    private KakaoAPIService service;

    public KakaoAPIRepository() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://kapi.kakao.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(KakaoAPIService.class);
    }

    public boolean validateToken(String token, long userId) throws IOException {
        Call<TokenInfoModel> request = service.validateToken("Bearer ".concat(token));
        Response<TokenInfoModel> response = request.execute();

        if (response.code() != 200 || response.body() == null) {
            return false;
        }

        return response.body().getUserId() == userId;
    }

}
