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
     * @param id 用户id
     * @param password 用户id
     * @return
     */
    @PostMapping("/login")
    public String login(@RequestParam String id,@RequestParam String password, HttpServletResponse response) {

        SystemUser systemUser = systemUserService.findUserInfoById(id);
        if(null ==systemUser){
            return LOGIN_NOPERMISSION;
        }
        if (systemUser.getPassword().equals(password)) {
            response.setHeader("token", JwtUtils.sign(id, systemUser.getRole()));
            return systemUser.getRole().equals("admin")?LOGIN_ADMINSTRATOR:LOGIN_USERPERMIT;

        }else{
            return LOGIN_WRONGPASSWORD;
        }

    }


    @Admin
    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public Object findUserInfo(@PathVariable("id") String id) {
        SystemUser user = systemUserService.findUserInfoById(id);
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
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") String id) {
        if (systemUserService.deleteSystemUserById(id))
            return DELETE_SUCCESS;
        return DELETE_FAILD;
    }
}
