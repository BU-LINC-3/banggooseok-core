package kr.banggooseok.database.repository;

import kr.banggooseok.database.dao.RoomsDAO;
import kr.banggooseok.database.vo.RoomsSimpleVO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Repository("roomsRepository")
public class RoomsRepository {

    @Resource(name = "roomsDAO")
    private RoomsDAO roomsDAO;

    public HashMap<String, Object> getRoomList(int page) {
        HashMap<String, Object> hashMap = new HashMap<>();

        final int MAX_ITEM_PER_PAGE = 10;

        List<RoomsSimpleVO> rooms = roomsDAO.selectRoomList(page * MAX_ITEM_PER_PAGE, MAX_ITEM_PER_PAGE);
        int page_max = (int) Math.ceil((double) roomsDAO.selectRoomListLength() / MAX_ITEM_PER_PAGE);
        int rooms_length = rooms.size();

        hashMap.put("page_max", page_max);
        hashMap.put("rooms_length", rooms_length);
        hashMap.put("rooms", rooms);

        return hashMap;
    }

}
