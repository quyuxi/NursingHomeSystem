package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.dao.RelativesDao;
import server.pojo.Relative;

@Service
public class RelativeService {

    @Autowired
    RelativesDao relativesDao;

    public boolean create(Relative[] relatives) {

        for (Relative relative : relatives) {
            boolean res = relativesDao.insert(relative);
            if(res){
                continue;
            }
            return res;
        }
        return true;
    }
}
