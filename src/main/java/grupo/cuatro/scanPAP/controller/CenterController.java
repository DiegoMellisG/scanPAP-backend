package grupo.cuatro.scanPAP.controller;


import grupo.cuatro.scanPAP.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class CenterController {


    private final CenterService centerService;

    public CenterController(CenterService centerService) {
        this.centerService = centerService;
    }

    @RequestMapping(value="/centers/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getCenters(@PathVariable long id)
    {
        return ResponseEntity.ok(this.centerService.getCenterByID(id));
    }
}
