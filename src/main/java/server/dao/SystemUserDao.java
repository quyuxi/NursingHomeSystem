package server.dao;

import org.springframework.stereotype.Component;
import server.entity.SystemUser;

import java.util.List;

@Component
public interface SystemUserDao {


    SystemUser findUserInfoByName(String userName);

    String queryRole(String userName);

    List<SystemUser> findAllUsers();

    boolean createSystemUser(SystemUser user);

    boolean updateSystemUser(SystemUser user);

    boolean updateUserPassword(SystemUser user);

    boolean deleteSystemUserByUserName(String userName);
}