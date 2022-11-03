package quintino.digital.gercontratapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quintino.digital.gercontratapi.model.TipoPeriodoFinanceiroModel;
import quintino.digital.gercontratapi.repository.TipoPeriodoFinanceiroRepository;

import java.util.List;

@Service
public class TipoPeriodoFinanceiroService {

    @Autowired
    private TipoPeriodoFinanceiroRepository tipoPeriodoFinanceiroRepository;

    public List<TipoPeriodoFinanceiroModel> findAll() {
        return this.tipoPeriodoFinanceiroRepository.findAll();
    }

    public TipoPeriodoFinanceiroModel findByCodigo(Long codigo) {
        return this.tipoPeriodoFinanceiroRepository.findByCodigo(codigo);
    }

}
