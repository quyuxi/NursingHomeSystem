package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.dao.RelativesDao;
import server.pojo.Relative;

import java.util.List;

@Service
public class RelativeService {

    @Autowired
    RelativesDao relativesDao;

    public boolean create(List<Relative> relatives) {
        if (null == relatives) {
            return true;
        }
        for (Relative relative : relatives) {
            boolean res = relativesDao.insert(relative);
            if (res) {
                continue;
            }
            return res;
        }
        return true;
    }


    public boolean deleteByElderId(int id) {
        return relativesDao.deleteByElderId(id);
    }
}
