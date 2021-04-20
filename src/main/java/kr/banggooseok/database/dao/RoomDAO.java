package kr.banggooseok.database.dao;

import kr.banggooseok.database.vo.RoomsVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("roomDAO")
public class RoomDAO {

    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate session;

    // Query Room List
    public List<RoomsVO> selectRoomList(int page) {
        Map<String, Integer> parameters = new HashMap<>();

        parameters.put("from", page * 10);
        parameters.put("count", 10);

        return session.selectList("room.selectRoomList", parameters);
    }

}
