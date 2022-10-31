package quintino.digital.gercontratapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quintino.digital.gercontratapi.model.ContratoModel;

@Repository
public interface ContratoRepository extends JpaRepository<ContratoModel, Long> { }
