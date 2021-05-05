package kr.banggooseok.core.controller;

import kr.banggooseok.database.repository.ImagesRepository;
import kr.banggooseok.database.vo.ImagesVO;
import kr.banggooseok.kakao.repository.KakaoAPIRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/image")
@PropertySource("classpath:core/config/core.properties")
public class ImageController {

    @Value("${image_path}")
    private String imagePath;

    @Resource(name = "kakaoAPIRepository")
    private KakaoAPIRepository kakaoAPIRepository;

    @Resource(name = "imagesRepository")
    private ImagesRepository imagesRepository;

    @RequestMapping(value = "/{room_id}", method = RequestMethod.GET)
    public List<ImagesVO> getImageList(@PathVariable int room_id) {

        return imagesRepository.getImageList(room_id);
    }

    @RequestMapping(value = "/{room_id}/submit", method = RequestMethod.POST)
    public ImagesVO postImage(@PathVariable int room_id,
                              @RequestParam String token,
                              @RequestParam long user_id,
                              @RequestParam MultipartFile file) throws Exception {

        if (!kakaoAPIRepository.validateToken(token)) {
            throw new Exception("Kakao API Token is not valid");
        }

        String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
        String destFilename = UUID.randomUUID().toString();

        originalFilename = originalFilename.toLowerCase();

        if (originalFilename.endsWith(".png")) {
            destFilename = destFilename.concat(".png");
        } else if (originalFilename.endsWith(".jpg")) {
            destFilename = destFilename.concat(".jpg");
        } else if (originalFilename.endsWith(".jpeg")) {
            destFilename = destFilename.concat(".jpeg");
        } else {
            throw new Exception("Only PNG, JPG and JPEG files are allowed");
        }

        Path copyPath = Paths.get(imagePath + File.separator + destFilename);
        Files.copy(file.getInputStream(), copyPath, StandardCopyOption.REPLACE_EXISTING);

        return imagesRepository.postImage(room_id, user_id, "/".concat(destFilename));
    }

}
