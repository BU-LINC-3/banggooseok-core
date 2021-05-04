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

        parameters.put("user_id", room.getUser_id());
        parameters.put("title", room.getTitle());
        parameters.put("description", room.getDescription());
        parameters.put("trans_type", room.getTrans_type());
        parameters.put("deposit", room.getDeposit());
        parameters.put("fee", room.getFee());
        parameters.put("manage_fee", room.getManage_fee());
        parameters.put("manage_tags", room.stringify(room.getManage_tags()));
        parameters.put("floor", room.getFloor());
        parameters.put("const_floor", room.getConst_floor());
        parameters.put("const_type", room.getConst_type());
        parameters.put("valid_dimen", room.getValid_dimen());
        parameters.put("supply_dimen", room.getSupply_dimen());
        parameters.put("avail_date", room.longToTimestamp(room.getAvail_date()));
        parameters.put("options", room.stringify(room.getOptions()));
        parameters.put("elevator", room.isElevator());
        parameters.put("parking", room.getParking());
        parameters.put("temp_sys", room.getTemp_sys());
        parameters.put("address", room.getAddress());
        parameters.put("contact", room.getContact());

        session.insert("rooms.insertRoom", parameters);

        return ((BigInteger) parameters.get("id")).intValue();
    }
}
