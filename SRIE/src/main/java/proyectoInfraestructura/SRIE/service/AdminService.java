package proyectoInfraestructura.SRIE.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyectoInfraestructura.SRIE.model.Users;
import proyectoInfraestructura.SRIE.repository.AdminJpaRepository;
import proyectoInfraestructura.SRIE.repository.UsersJpaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminJpaRepository AdminRep;
    private UsersJpaRepository UsersRep;

    public List<Users> findAll(){return this.UsersRep.findAll();}

    public Users delete(Integer id) {
        Optional <Users> userExits = this.UsersRep.findById(id);
        if (userExits.isPresent()) {
            this.UsersRep.deleteById(id);
            return (Users)userExits.get();
        } else {
            return null;
        }
    }//eliminar usarios por id
}

