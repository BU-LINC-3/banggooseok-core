package kr.banggooseok.core.controller;

import kr.banggooseok.database.repository.RoomsRepository;
import kr.banggooseok.database.vo.RoomsVO;
import org.springframework.web.bind.annotation.*;

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

    // TODO: TOKEN 처리랑 DB INSERT 시 문자 인코딩 깨지는 문제 해결
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public HashMap<String, Object> postRoom(@RequestBody RoomsVO room,
                                            @RequestParam String token,
                                            @RequestParam long user_id) {
        room.setUser_id(user_id);

        return roomsRepository.postRoom(room);
    }

}
