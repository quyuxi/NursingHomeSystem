package server.webserver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.annotation.Admin;
import server.entity.SystemUser;
import server.service.SystemUserService;
import server.utils.JwtUtils;

import java.util.List;

import static server.constant.LoginConstant.*;

/**
 * @author  quyuxi
 * @since 2020/5/20
 */

@RestController
@RequestMapping(value = "/user")
public class SystemUserController {


    @Autowired
    SystemUserService systemUserService;


    /**
     * 登录成功返回token
     *
     * @param user
     * @return
     */
    @PostMapping("/login")
    public String login(@RequestBody SystemUser user) {

        SystemUser systemUser = systemUserService.findUserInfoByName(user.getUserName());
        if (systemUser.getPassword().equals(user.getPassword())) {
            return JwtUtils.sign(user.getUserName(), user.getPassword());
        }
        return LOGIN_WRONGPASSWORD;

    }

    //返回指定用户名的用户信息
    @Admin
    @RequestMapping(value = "/find/{name}", method = RequestMethod.GET)
    public Object findUserInfo(@PathVariable("name") String userName) {
        SystemUser user = systemUserService.findUserInfoByName(userName);
        if (null == user) {
            return FINDUSER_NULL;
        }
        return user;
    }

    //列举所有成员
    @Admin
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public List<SystemUser> lisLogUser() {
        List<SystemUser> users = systemUserService.findAllUsers();
        return users;
    }

    //新建桌面用户信息
    @Admin
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createNewUser(@RequestBody SystemUser user) {

        if (systemUserService.findUserInfoByName(user.getUserName()) != null) {
            return CREATE__REPEATNAME;
        }

        if (systemUserService.createSystemUser(user)) {
            return CREATE_SUCCESS;
        }
        return CREATE_FAILD;
    }

    //修改用户信息——原则上只能修改姓名和密码
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser(@RequestBody SystemUser user) {
        if (systemUserService.findUserInfoByName(user.getUserName()) == null) {
            return UPDATE_NULL;
        }

        if (systemUserService.updateSystemUser(user))
            return UPDATE_SUCCESS;
        return UPDATE_FAILD;
    }

    //修改用户的密码——这里采用template.updateUser(pauser)方法实现
    @RequestMapping(value = "/password", method = RequestMethod.POST)
    public String amendPassword(@RequestBody SystemUser user) {

        if (systemUserService.updateUserPassword(user))
            return PASSWORD_SUCCESS;
        return PASSWORD_FAILD;
    }

    //该方法被管理员身份的用户调用——————————————后续需要添加过滤器处理
    @Admin
    @RequestMapping(value = "/delete/{deleteName}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("deleteName") String name) {
        if (systemUserService.deleteSystemUserByUserName(name))
            return DELETE_SUCCESS;
        return DELETE_FAILD;
    }
}
