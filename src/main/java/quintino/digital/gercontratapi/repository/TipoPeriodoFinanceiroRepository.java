package quintino.digital.gercontratapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quintino.digital.gercontratapi.model.TipoPeriodoFinanceiroModel;

@Repository
public interface TipoPeriodoFinanceiroRepository extends JpaRepository<TipoPeriodoFinanceiroModel, Long> {
    public TipoPeriodoFinanceiroModel findByCodigo(Long codigo);
}
