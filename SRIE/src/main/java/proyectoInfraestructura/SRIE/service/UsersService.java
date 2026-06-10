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
        Users userExits = usersRep.getByEmail(user.getEmail());
        if (userExits != null) {
            if (user.getName() != null) {
                userExits.setName(user.getName());
            }
            if (user.getPassword() != null) {
                userExits.setPassword(user.getPassword());
            }
            if (user.getCareer() != null) {
                userExits.setCareer(user.getCareer());
            }

        } else {
            return null;
        }
        Users userTemp = new Users();
        userTemp.setName(user.getName());
        userTemp.setEmail(user.getEmail());
        userTemp.setCareer(user.getCareer());

        return usersRep.save(userTemp);
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
