package server.webserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import server.annotation.Admin;

import server.pojo.Elder;
import server.service.ElderService;
import server.service.RelativeService;
import server.service.RingService;

import java.util.List;

import static server.constant.ElderConstant.*;

/**
 * @author quyuxi
 * @since 2020/5/20
 */

@RestController
@RequestMapping(value = "/NursingHomeSystem/elder")
public class ElderController {


    @Autowired
    ElderService elderService;

    @Autowired
    RingService ringService;
    @Autowired
    RelativeService relativeService;

    @GetMapping(value = "/find/{id}")
    public Object getElderByID(@PathVariable("id") int id) {
        Elder elder = elderService.selectElderById(id);
        if (elder == null)
            return FINDELDER_NULL;
        return elder;
    }


    @GetMapping(value = "/listAll")
    public Object listAllElder() {
        List<Elder> elders = elderService.selectElderList();
        if (CollectionUtils.isEmpty(elders))
            return LISTELDER_NULL;
        return elders;
    }


    @GetMapping(value = "/newID")
    public String getNewElderID() {
        return elderService.getNewID();
    }

    @Admin
    @PostMapping(value = "/create")
    public String createElder(@RequestBody Elder elder) {
        if (elderService.createElder(elder)
                && ringService.createRingInfo(elder.getId(), elder.getJoinTime())
                &&relativeService.create(elder.getRelatives())) {
            return CREATE_SUCCESS;
        }
        return CREATE_FAILD;
    }

    @Admin
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String amendElder(@RequestBody Elder elder) {
        if (elderService.selectElderById(elder.getId()) == null)
            return UPDATE_NULL;
        if (elderService.updateElder(elder))
            return UPDATE_SUCCESS;
        return UPDATE_FAILD;
    }


    @Admin
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deleteElder(@PathVariable("id") int id) {
        if (elderService.deleteElderById(id))
            return DELETE_SUCCESS;
        return DELETE_FAILD;
    }

}
