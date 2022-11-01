package quintino.digital.gercontratapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quintino.digital.gercontratapi.model.ContratoParcelamentoModel;

@Repository
public interface ContratoParcelamentoRepository extends JpaRepository<ContratoParcelamentoModel, Long> { }
