package quintino.digital.gercontratapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quintino.digital.gercontratapi.model.TipoContratoModel;

@Repository
public interface TipoContratoRepository extends JpaRepository<TipoContratoModel, Long> {
    public TipoContratoModel findByCodigo(Long codigo);
}
