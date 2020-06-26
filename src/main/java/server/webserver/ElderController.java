package server.webserver;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import server.annotation.Admin;
import server.pojo.Elder;
import server.service.ElderService;
import server.service.RelativeService;
import server.service.RingService;
import server.utils.DateAndTime;
import server.utils.JwtUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static server.constant.ElderConstant.*;

/**
 * @author quyuxi
 * @since 2020/5/20
 */

@RestController
@RequestMapping(value = "/NursingHomeSystem/elder")
public class ElderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ElderController.class);

    @Autowired
    ElderService elderService;

    @Autowired
    RingService ringService;
    @Autowired
    RelativeService relativeService;

    @GetMapping(value = "/find/{id}")
    public Object getElderByID(@PathVariable("id") int id) {
        LOGGER.info("查询老人信息，id: " + id);
        Elder elder = elderService.selectElderById(id);
        if (elder == null)
            return FINDELDER_NULL;
        return elder;
    }


    @GetMapping(value = "/listAll")
    public Object listAllElder() {
        LOGGER.info("查询所有老人信息");
        List<Elder> elders = elderService.selectElderList();
        if (CollectionUtils.isEmpty(elders))
            return LISTELDER_NULL;
        return elders;
    }


    @GetMapping(value = "/newID")
    public String getNewElderID(HttpServletRequest request) {
        String id = "";
        try {
            id = elderService.getNewID();
        } catch (Exception e) {
            id = JwtUtils.getId(request.getHeader("token"));
            id = id.substring(1, 3);
            id = "93" + id + "0001";
        }
        return id;
    }

    @Admin
    @PostMapping(value = "/create")
    public String createElder(@RequestBody Elder elder) {
        LOGGER.debug("创建老人," + JSON.toJSONString(elder, true));
        if (null == elder.getJoinTime()) {
            elder.setJoinTime(DateAndTime.getCurrentTimeAsStr());
        }
        if (elderService.createElder(elder)
                && ringService.createRingInfo(elder.getId(), elder.getJoinTime())
                && relativeService.create(elder.getRelatives())) {
            return CREATE_SUCCESS;
        }
        return CREATE_FAILD;
    }

    @Admin
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String amendElder(@RequestBody Elder elder) {
        LOGGER.debug("修改老人信息," + JSON.toJSONString(elder, true));
        if (elderService.selectElderById(elder.getId()) == null)
            return UPDATE_NULL;
        if (elderService.updateElder(elder))
            return UPDATE_SUCCESS;
        return UPDATE_FAILD;
    }


    @Admin
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteElder(@RequestBody Elder elder) {
        LOGGER.debug("删除老人" + JSON.toJSONString(elder, true));
        if (elderService.deleteElderById(elder.getId()))
            return DELETE_SUCCESS;
        return DELETE_FAILD;
    }

}
