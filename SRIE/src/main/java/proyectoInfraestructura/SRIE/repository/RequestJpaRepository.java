package proyectoInfraestructura.SRIE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyectoInfraestructura.SRIE.model.Request;

@Repository
public interface RequestJpaRepository extends JpaRepository<Request,Integer> {
}
