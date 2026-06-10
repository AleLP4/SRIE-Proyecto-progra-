package proyectoInfraestructura.SRIE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyectoInfraestructura.SRIE.model.Admin;
import proyectoInfraestructura.SRIE.model.Users;

import java.util.List;

@Repository
public interface AdminJpaRepository extends JpaRepository<Admin, Integer> {

    List<Admin> findAll();

    Admin save(Admin admin);

    Admin getById(Integer id);

    boolean existsById(Integer id);

    Admin getByName(String name);

    boolean existsByEmail(String email);

    boolean existsByPassword(String password);

    Admin getByEmail(String email);

    Admin getByPassword(String password);

    Admin findById(int id);




}
