package kr.banggooseok.core.controller;

import kr.banggooseok.database.repository.ImagesRepository;
import kr.banggooseok.database.vo.ImagesVO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/api/image")
public class ImageController {

    @Resource(name = "imagesRepository")
    private ImagesRepository imagesRepository;

    @RequestMapping(value = "/{room_id}", method = RequestMethod.GET)
    public List<ImagesVO> getImageList(@PathVariable int room_id) {

        return imagesRepository.getImageList(room_id);
    }

}
