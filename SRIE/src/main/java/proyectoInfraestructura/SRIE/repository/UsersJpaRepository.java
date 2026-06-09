package proyectoInfraestructura.SRIE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyectoInfraestructura.SRIE.model.Users;

import java.util.List;

public interface UsersJpaRepository extends JpaRepository <Users, Integer> {

    List<Users> findAll();

    Users save(Users user);

    Users getById(Integer id);

    Users getByName(String name);

    Users getByEmail(String email);

    Users getByPassword(String password);

    Users findById(int id);

}
