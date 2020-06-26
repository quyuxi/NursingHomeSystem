package server.webserver;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.iot.emergency.EmergencyCache;
import server.iot.emergency.EmergencyEvent;

import java.util.List;

@RestController
@RequestMapping("/NursingHomeSystem/Emergency")
public class EmergencyController {


    @RequestMapping("/getEmergency/{nursingHomeId}")
    public List<EmergencyEvent> getEmergency(@PathVariable int nursingHomeId) {
        return EmergencyCache.instance().getEvents(nursingHomeId);
    }
}
