package kr.banggooseok.core.controller;

import kr.banggooseok.database.repository.RoomsRepository;
import kr.banggooseok.database.vo.RoomsVO;
import kr.banggooseok.kakao.repository.KakaoAPIRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/api/room")
public class RoomController {

    @Resource(name = "kakaoAPIRepository")
    private KakaoAPIRepository kakaoAPIRepository;

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

    // TODO: 정보 유효한지 검사
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public HashMap<String, Object> postRoom(@RequestBody RoomsVO room,
                                            @RequestParam String token,
                                            @RequestParam long user_id) throws Exception {

        if (!kakaoAPIRepository.validateToken(token, user_id)) {
            throw new Exception("Kakao API Token is not valid");
        }
        room.setUser_id(user_id);

        return roomsRepository.postRoom(room);
    }

}
