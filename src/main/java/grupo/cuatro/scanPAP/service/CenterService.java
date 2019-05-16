package grupo.cuatro.scanPAP.service;

import grupo.cuatro.scanPAP.dao.CenterDAO;
import grupo.cuatro.scanPAP.model.Center;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CenterService {

    private final CenterDAO centerDAO;

    @Autowired
    public CenterService(CenterDAO centerDAO) {
        this.centerDAO = centerDAO;
    }

    public Center getCenterByID(long id)
    {
        return centerDAO.findByIdCenter(id);
    }

    public Center getCenterByName(String name)
    {
        return centerDAO.findByName(name);
    }

    public Center getCenterByAddress(String address)
    {
        return centerDAO.findByAddress(address);
    }
}
