package kr.banggooseok.database.repository;

import kr.banggooseok.database.dao.ImagesDAO;
import kr.banggooseok.database.vo.ImagesVO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("imagesRepository")
public class ImagesRepository {

    @Resource(name = "imagesDAO")
    private ImagesDAO imagesDAO;

    public List<ImagesVO> getImageList(int roomId) {

        return imagesDAO.selectImageList(roomId);
    }

}
