package server.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import server.pojo.SystemUser;

import java.util.List;

@Component
public interface SystemUserDao {


    SystemUser findUserInfoById(@Param("id") String id);

    String queryRole(@Param("id") String id);

    List<SystemUser> findAllUsers();

    boolean createSystemUser(SystemUser user);

    boolean updateSystemUser(SystemUser user);

    boolean updateUserPassword(SystemUser user);

    boolean deleteSystemUserByUserName(@Param("id") String id);


}