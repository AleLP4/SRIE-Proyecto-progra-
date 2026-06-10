package proyectoInfraestructura.SRIE.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyectoInfraestructura.SRIE.model.Admin;
import proyectoInfraestructura.SRIE.model.Users;
import proyectoInfraestructura.SRIE.repository.AdminJpaRepository;
import proyectoInfraestructura.SRIE.repository.UsersJpaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminJpaRepository adminRep;
    private UsersJpaRepository usersRep;

    public List<Users> findAllUs(){return this.usersRep.findAll();}

    public List<Admin> findAllAdm(){return this.adminRep.findAll();}

    public Users delete(Integer id) {
        Optional <Users> userExits = this.usersRep.findById(id);
        if (userExits.isPresent()) {
            this.usersRep.deleteById(id);
            return (Users)userExits.get();
        } else {
            return null;
        }
    }//eliminar usarios por id

    public Admin getById(Integer id) {
        Admin admin = this.adminRep.findById(id.intValue());
        if(admin==null)
        {
            return null;
        }
        else {
            return admin;
        }
    }


    public Admin getAdminByEmail(String email) {
        return adminRep.getByEmail(email);
    }

}

