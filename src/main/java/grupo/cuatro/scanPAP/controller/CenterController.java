package grupo.cuatro.scanPAP.controller;


import grupo.cuatro.scanPAP.model.Center;
import grupo.cuatro.scanPAP.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@CrossOrigin
@RestController
public class CenterController {

    @Autowired
    private CenterService centerService;

    @RequestMapping(value="/centers/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getCenters(@PathVariable long id)
    {
        return ResponseEntity.ok(this.centerService.getCenterByID(id));
    }
}
