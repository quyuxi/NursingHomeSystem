package server.webserver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.annotation.Admin;
import server.pojo.SystemUser;
import server.service.SystemUserService;
import server.utils.JwtUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static server.constant.LoginConstant.*;

/**
 * @author quyuxi
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
    public String login(@RequestBody SystemUser user, HttpServletResponse response) {

        SystemUser systemUser = systemUserService.findUserInfoById(user.getId());
        if (systemUser.getPassword().equals(user.getPassword())) {
            response.setHeader("token", JwtUtils.sign(user.getId(), user.getRole()));
            return LOGIN_NOPERMISSION;

        }
        return LOGIN_WRONGPASSWORD;

    }


    @Admin
    @RequestMapping(value = "/find/{name}", method = RequestMethod.GET)
    public Object findUserInfo(@PathVariable("name") String userName) {
        SystemUser user = systemUserService.findUserInfoById(userName);
        if (null == user) {
            return FINDUSER_NULL;
        }
        return user;
    }


    @Admin
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public List<SystemUser> lisLogUser() {
        return systemUserService.findAllUsers();
    }


    @Admin
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createNewUser(@RequestBody SystemUser user) {

        if (systemUserService.findUserInfoById(user.getId()) != null) {
            return CREATE__REPEATNAME;
        }

        if (systemUserService.createSystemUser(user)) {
            return CREATE_SUCCESS;
        }
        return CREATE_FAILD;
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser(@RequestBody SystemUser user) {
        if (systemUserService.findUserInfoById(user.getId()) == null) {
            return UPDATE_NULL;
        }

        if (systemUserService.updateSystemUser(user))
            return UPDATE_SUCCESS;
        return UPDATE_FAILD;
    }


    @RequestMapping(value = "/password", method = RequestMethod.POST)
    public String amendPassword(@RequestBody SystemUser user) {

        if (systemUserService.updateUserPassword(user))
            return PASSWORD_SUCCESS;
        return PASSWORD_FAILD;
    }


    @Admin
    @RequestMapping(value = "/delete/{deleteName}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("deleteName") String name) {
        if (systemUserService.deleteSystemUserByUserName(name))
            return DELETE_SUCCESS;
        return DELETE_FAILD;
    }
}
