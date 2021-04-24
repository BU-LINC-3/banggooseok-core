package kr.banggooseok.database.dao;

import kr.banggooseok.database.vo.ImagesVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("imagesDAO")
public class ImagesDAO {

    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate session;

    public List<ImagesVO> selectImageList(int roomId) {
        Map<String, Integer> parameters = new HashMap<>();

        parameters.put("room_id", roomId);

        return session.selectList("images.selectImageList", parameters);
    }
}
