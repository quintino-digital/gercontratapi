package quintino.digital.gercontratapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quintino.digital.gercontratapi.model.ContratoModel;
import quintino.digital.gercontratapi.model.ContratoParcelamentoModel;
import quintino.digital.gercontratapi.model.ParcelamentoModel;
import quintino.digital.gercontratapi.repository.ContratoParcelamentoRepository;

@Service
public class ContratoParcelamentoService {

    @Autowired
    private ContratoParcelamentoRepository contratoParcelamentoRepository;

    public ContratoParcelamentoModel saveOne(ContratoModel contratoModel, ParcelamentoModel parcelamentoModel) {
        return this.contratoParcelamentoRepository.save(new ContratoParcelamentoModel(contratoModel, parcelamentoModel));
    }

}
