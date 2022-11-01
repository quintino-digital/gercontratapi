package quintino.digital.gercontratapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quintino.digital.gercontratapi.model.ParcelamentoModel;

@Repository
public interface ParcelamentoRepository extends JpaRepository<ParcelamentoModel, Long> { }
