package proyectoInfraestructura.SRIE.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyectoInfraestructura.SRIE.model.Admin;
import proyectoInfraestructura.SRIE.model.Users;
import proyectoInfraestructura.SRIE.model.dto.AdminDTO;
import proyectoInfraestructura.SRIE.model.dto.LoginDTO;
import proyectoInfraestructura.SRIE.model.dto.UsersDTO;
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

//    public Users delete(Integer id) {
//        Optional <Users> userExits = this.usersRep.findById(id);
//        if (userExits.isPresent()) {
//            this.usersRep.deleteById(id);
//            return (Users)userExits.get();
//        } else {
//            return null;
//        }
//    }//eliminar usarios por id

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


    public Admin add(AdminDTO admin) {
        if (adminRep.existsByEmail(admin.getEmail())) {
            return null;
        } else {
            if (admin.getName() == null || admin.getEmail() == null || admin.getPassword() == null) {
                return null;
            }
        }
        Admin admin1 = new Admin();
        admin1.setName(admin.getName());
        admin1.setEmail(admin.getEmail());
        admin1.setPassword(admin.getPassword());

        return adminRep.save(admin1);
    }


    public Admin getAdminByEmail(String email) {
        return adminRep.getByEmail(email);
    }



    public Admin update(AdminDTO admin, Integer id) {

        if (adminRep.existsById(id)) {
            Admin adminExits = adminRep.getById(id);

            if (admin.getName() != null && !admin.getName().trim().isEmpty()) {
                adminExits.setName(admin.getName());
            }

            if (admin.getEmail() != null && !admin.getEmail().trim().isEmpty()) {
                adminExits.setEmail(admin.getEmail());
            }

            if (admin.getPassword() != null && !admin.getPassword().trim().isEmpty()) {
                adminExits.setPassword(admin.getPassword());
            }

            return adminRep.save(adminExits);
        }
        return null;
    }



    public Admin delete(Integer id) {
        Optional<Admin> adminExits = adminRep.findById(id);
        if (adminExits.isPresent()) {
            adminRep.deleteById(id);
            return (Admin) adminExits.get();
        } else {
            return null;
        }
    }

    public Boolean login(LoginDTO login) {
        Admin adminExits = adminRep.getByEmail(login.getEmail());
        if (adminExits != null) {
            if (login.getPassword().equals(adminExits.getPassword())) {
                return true;
            }
        }

        return false;
    }


}

