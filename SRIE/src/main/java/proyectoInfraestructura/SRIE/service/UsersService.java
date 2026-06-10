package proyectoInfraestructura.SRIE.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyectoInfraestructura.SRIE.model.*;
import proyectoInfraestructura.SRIE.model.dto.*;
import proyectoInfraestructura.SRIE.repository.UsersJpaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private UsersJpaRepository usersRep;


    public List<Users> findAll(){return this.usersRep.findAll();}

    public Users add(UsersDTO user) {
        if (usersRep.existsByEmail(user.getEmail())) {
            return null;
        } else {
            if (user.getName() == null || user.getEmail() == null || user.getPassword() == null || user.getCareer() == null) {
                return null;
            }
        }
        Users userTemp = new Users();
        userTemp.setName(user.getName());
        userTemp.setEmail(user.getEmail());
        userTemp.setCareer(user.getCareer());
        userTemp.setPassword(user.getPassword());

        return usersRep.save(userTemp);
    }

    public Users getById(Integer id) {
        Users user = usersRep.findById(id.intValue());
        if (user != null) {
            return user;
        }

        return null;
    }

    public Users update(UsersDTO user) {
        Users usersExits = usersRep.getByEmail(user.getEmail());
        if (usersExits != null) {
            if (user.getName() != null) {
                usersExits.setName(user.getName());
            }
            if (user.getPassword() != null) {
                usersExits.setPassword(user.getPassword());
            }

        } else {
            return null;
        }
        return usersRep.save(usersExits);
    }

    public Users delete(Integer id) {
        Optional<Users> userExits = usersRep.findById(id);
        if (userExits.isPresent()) {
            usersRep.deleteById(id);
            return (Users) userExits.get();
        } else {
            return null;
        }
    }

    public Boolean login(LoginDTO login) {
        Users userExits = usersRep.getByEmail(login.getEmail());
        if (userExits != null) {
            if (login.getPassword().equals(userExits.getPassword())) {
                return true;
            }
        }

        return false;
    }

    public Users getUserByEmail(String email) {
        return usersRep.getByEmail(email);
    }




}
