package quintino.digital.gercontratapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quintino.digital.gercontratapi.model.TipoPeriodoModel;

@Repository
public interface TipoPeriodoRepository extends JpaRepository<TipoPeriodoModel, Long> { }
