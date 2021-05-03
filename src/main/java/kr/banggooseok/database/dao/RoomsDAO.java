package kr.banggooseok.database.dao;

import kr.banggooseok.database.vo.RoomsSimpleVO;
import kr.banggooseok.database.vo.RoomsVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.math.BigInteger;
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
     * @param roomId Room 고유 번호
     * @return Room 반환
     */
    public RoomsVO selectRoom(int roomId) {
        Map<String, Integer> parameters = new HashMap<>();

        parameters.put("room_id", roomId);

        return session.selectOne("rooms.selectRoom", parameters);
    }

    /**
     * Room 정보 등록
     * @param room Room 정보
     * @return 등록된 Room 고유 번호
     */
    public int insertRoom(RoomsVO room) {
        Map<String, Object> parameters = new HashMap<>();
        // TODO: null 처리 어떻게할 건지
        parameters.putIfAbsent("user_id", room.getUser_id());
        parameters.putIfAbsent("title", room.getTitle());
        parameters.putIfAbsent("description", room.getDescription());
        parameters.putIfAbsent("trans_type", room.getTrans_type());
        parameters.putIfAbsent("deposit", room.getDeposit());
        parameters.putIfAbsent("fee", room.getFee());
        parameters.putIfAbsent("manage_fee", room.getManage_fee());
        parameters.putIfAbsent("manage_tags", room.stringify(room.getManage_tags()));
        parameters.putIfAbsent("floor", room.getFloor());
        parameters.putIfAbsent("const_floor", room.getConst_floor());
        parameters.putIfAbsent("const_type", room.getConst_type());
        parameters.putIfAbsent("valid_dimen", room.getValid_dimen());
        parameters.putIfAbsent("supply_dimen", room.getSupply_dimen());
        parameters.putIfAbsent("avail_date", room.longToTimestamp(room.getAvail_date()));
        parameters.putIfAbsent("options", room.stringify(room.getOptions()));
        parameters.putIfAbsent("elevator", room.isElevator());
        parameters.putIfAbsent("parking", room.getParking());
        parameters.putIfAbsent("temp_sys", room.getTemp_sys());
        parameters.putIfAbsent("address", room.getAddress());
        parameters.putIfAbsent("contact", room.getContact());

        session.insert("rooms.insertRoom", parameters);

        return ((BigInteger) parameters.get("id")).intValue();
    }
}
