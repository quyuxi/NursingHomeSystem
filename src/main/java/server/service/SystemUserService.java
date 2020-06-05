package server.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.dao.SystemUserDao;
import server.entity.SystemUser;

import java.util.List;

/**
 * @author quyuxi
 * @since 2020/5/20
 */
@Service
public class SystemUserService {

    @Autowired
    SystemUserDao systemuserDao;


    public String queryRole(String userName) {
        return systemuserDao.queryRole(userName);
    }


    public SystemUser findUserInfoByName(String userName) {
        return systemuserDao.findUserInfoByName(userName);

    }

    public List<SystemUser> findAllUsers() {
        return systemuserDao.findAllUsers();
    }

    public boolean createSystemUser(SystemUser user) {
        return systemuserDao.createSystemUser(user);
    }

    public boolean updateSystemUser(SystemUser user) {
        return systemuserDao.updateSystemUser(user);
    }

    public boolean updateUserPassword(SystemUser user) {
        return systemuserDao.updateUserPassword(user);
    }

    public boolean deleteSystemUserByUserName(String name) {
        return systemuserDao.deleteSystemUserByUserName(name);
    }
}
