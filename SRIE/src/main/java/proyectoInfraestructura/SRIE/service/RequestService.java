package proyectoInfraestructura.SRIE.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import proyectoInfraestructura.SRIE.model.*;
import proyectoInfraestructura.SRIE.service.*;
import proyectoInfraestructura.SRIE.model.dto.RequestDTO;
import proyectoInfraestructura.SRIE.repository.RequestJpaRepository;

import java.util.List;

@Repository
public class RequestService {
    @Autowired
    private RequestJpaRepository requestRep;
    @Autowired
    private UsersService usersService;
    @Autowired
    private AdminService adminService;

    public List<Request> findAll() {
        return requestRep.findAll();
    }


    public Request add(RequestDTO request) {
        Admin admin = adminService.getAdminByEmail(request.getAdminEmail());
        Users user = usersService.getUserByEmail(request.getUserEmail());

        if(user == null){
            return null;
        }

        Request requestTemp = new Request();
        requestTemp.setUser(user);

        requestTemp.setTitle(request.getTitle());
        requestTemp.setDescription(request.getDescription());
        requestTemp.setLocation(request.getLocation());
        requestTemp.setUrgency(Urgency.valueOf(request.getUrgency().toUpperCase()));
        requestTemp.setStatus(Status.valueOf(request.getStatus().toUpperCase()));
        requestTemp.setRequestDate(request.getRequestDate());

        return requestRep.save(requestTemp);
    }

    public Request update (RequestDTO request, Integer id)
    {
        Users user = usersService.getUserByEmail(request.getUserEmail());

        Admin admin = null;
        if (request.getAdminEmail() != null && !request.getAdminEmail().trim().isEmpty()) {
            admin = adminService.getAdminByEmail(request.getAdminEmail());
        }

        if(user == null || (request.getAdminEmail() != null && !request.getAdminEmail().trim().isEmpty() && admin == null)){
            return null;
        }

        if(requestRep.existsById(id))
        {
            Request requestTemp = requestRep.findById(id.intValue()).get();
            requestTemp.setAdmin(admin);
            requestTemp.setUser(user);

            requestTemp.setTitle(request.getTitle());
            requestTemp.setDescription(request.getDescription());
            requestTemp.setLocation(request.getLocation());
            requestTemp.setUrgency(Urgency.valueOf(request.getUrgency().toUpperCase()));
            requestTemp.setStatus(Status.valueOf(request.getStatus().toUpperCase()));
            requestTemp.setRequestDate(request.getRequestDate());

            return requestRep.save(requestTemp);
        }

       return null;
    }

    public String deleteById (Integer id)
    {

        if(requestRep.existsById(id))
        {
            requestRep.deleteById(id);
            return "Exito!";
        }

        return null;


    }




}
