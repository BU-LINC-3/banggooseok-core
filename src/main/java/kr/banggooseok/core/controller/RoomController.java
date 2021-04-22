package kr.banggooseok.core.controller;

import kr.banggooseok.database.repository.RoomsRepository;
import kr.banggooseok.database.vo.RoomsVO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/api/room")
public class RoomController {

    @Resource(name = "roomsRepository")
    private RoomsRepository roomsRepository;

    @RequestMapping(value = "/list/{page}", method = RequestMethod.GET)
    public HashMap<String, Object> getRoomList(@PathVariable int page) {

        return roomsRepository.getRoomList(page);
    }

    @RequestMapping(value = "/{room_id}", method = RequestMethod.GET)
    public RoomsVO getRoom(@PathVariable int room_id) {

        return roomsRepository.getRoom(room_id);
    }

}
