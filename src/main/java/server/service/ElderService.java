package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.dao.ElderDao;
import server.pojo.Elder;


import java.util.List;

/**
 * @author quyuxi
 * @since 2020/5/20
 */
@Service
public class ElderService {

    @Autowired
    ElderDao elderDao;

    public Elder selectElderById(String id) {
        return elderDao.selectElderById(id);
    }

    public List<Elder> selectElderList() {
        return elderDao.selectElderList();
    }

    public String getNewID() {
        int id = elderDao.selectLastId();
        return Integer.toString(id + 1);
    }

    public boolean createElder(Elder elder) {
        return elderDao.createElder(elder);
    }

    public boolean updateElder(Elder elder) {
        return elderDao.updateElder(elder);
    }

    public boolean deleteElderById(String id) {
        return elderDao.deleteElderById(id);
    }


}
