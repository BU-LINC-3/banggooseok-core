package kr.banggooseok.database.dao;

import kr.banggooseok.database.vo.ImagesVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.math.BigInteger;
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

    public ImagesVO selectImage(int id) {
        Map<String, Integer> parameters = new HashMap<>();

        parameters.put("id", id);

        return session.selectOne("images.selectImage", parameters);
    }

    public int insertImage(int roomId, long userId, String path) {
        Map<String, Object> parameters = new HashMap<>();

        parameters.put("room_id", roomId);
        parameters.put("user_id", userId);
        parameters.put("path", path);

        session.insert("images.insertImage", parameters);

        return ((BigInteger) parameters.get("id")).intValue();
    }

}
