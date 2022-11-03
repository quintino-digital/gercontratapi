package quintino.digital.gercontratapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quintino.digital.gercontratapi.model.TipoContratoModel;
import quintino.digital.gercontratapi.repository.TipoContratoRepository;

import java.util.List;

@Service
public class TipoContratoService {

    @Autowired
    private TipoContratoRepository tipoContratoRepository;

    public List<TipoContratoModel> findAll() {
        return this.tipoContratoRepository.findAll();
    }

    public TipoContratoModel findOne(Long codigo) {
        return this.tipoContratoRepository.findByCodigo(codigo);
    }

}
