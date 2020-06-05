package server.webserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import server.annotation.Admin;
import server.entity.Elder;
import server.service.ElderService;

import java.util.List;

import static server.constant.ElderConstant.*;

/**
 * @author quyuxi
 * @since 2020/5/20
 */

@RestController
@RequestMapping(value = "/elder")
public class ElderController {


    @Autowired
    ElderService elderService;


    @GetMapping(value = "/find/{elderId}")
    public Object getElderByID(@PathVariable("elderId") String elderId) {
        Elder elder = elderService.selectElderById(elderId);
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
        if (elderService.createElder(elder))
            return CREATE_SUCCESS;
        return CREATE_FAILD;
    }

    @Admin
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String amendElder(@RequestBody Elder elder) {
        if (elderService.selectElderById(elder.getElderId()) == null)
            return UPDATE_NULL;
        if (elderService.updateElder(elder))
            return UPDATE_SUCCESS;
        return UPDATE_FAILD;
    }


    @Admin
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteElder(@RequestBody Elder delder) {
        if (elderService.deleteElderById(delder.getElderId()))
            return DELETE_SUCCESS;
        return DELETE_FAILD;
    }

}
