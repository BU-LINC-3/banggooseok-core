package kr.banggooseok.core.controller;

import kr.banggooseok.database.dao.RoomDAO;
import kr.banggooseok.database.vo.RoomsVO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/api/room")
public class RoomController {

    @Resource(name = "roomDAO")
    private RoomDAO roomDAO;

    @RequestMapping(value = "/list/{page}", method = RequestMethod.GET)
    public List<RoomsVO> getRoomList(@PathVariable int page) {

        return roomDAO.selectRoomList(page);
    }

}
