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
        Admin admin = adminService.getById(request.getAdminEmail());
        Users user = usersService.getUserByEmail(request.getUserEmail());
        Request requestTemp = new Request();

        requestTemp.setAdmin(admin);
        requestTemp.setUser(user);
        return requestRep.save(requestTemp);

    }


}
