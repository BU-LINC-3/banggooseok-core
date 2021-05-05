import kr.banggooseok.kakao.repository.KakaoAPIRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml",
})
public class KakaoAPITest {

    @Test
    public void validateTokenTest() throws IOException {
        KakaoAPIRepository repository = new KakaoAPIRepository();

        System.out.println(repository.validateToken("132gyuwefyhu432hyui"));
    }

}
