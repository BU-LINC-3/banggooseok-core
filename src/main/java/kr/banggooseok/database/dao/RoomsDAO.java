package kr.banggooseok.database.dao;

import kr.banggooseok.database.vo.RoomsSimpleVO;
import kr.banggooseok.database.vo.RoomsVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("roomsDAO")
public class RoomsDAO {

    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate session;

    /**
     * Room List 쿼리
     * @param from Page 번호
     * @param count Page 당 Item 개수
     * @return Room List 반환
     */
    public List<RoomsSimpleVO> selectRoomList(int from, int count) {
        Map<String, Integer> parameters = new HashMap<>();

        parameters.put("from", from);
        parameters.put("count", count);

        return session.selectList("rooms.selectRoomList", parameters);
    }

    /**
     * Room 목록 수 쿼리
     * @return Room 목록 수 반환
     */
    public int selectRoomListLength() {
        return session.selectOne("rooms.selectRoomListLength");
    }

    /**
     * Room 정보 쿼리
     * @param room_id Room 고유 번호
     * @return Room 반환
     */
    public RoomsVO selectRoom(int room_id) {
        Map<String, Integer> parameters = new HashMap<>();

        parameters.put("room_id", room_id);

        return session.selectOne("rooms.selectRoom", parameters);
    }
}
