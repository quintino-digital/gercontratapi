package quintino.digital.gercontratapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import quintino.digital.gercontratapi.model.ContratoModel;
import quintino.digital.gercontratapi.model.ContratoParcelamentoModel;
import quintino.digital.gercontratapi.model.ParcelamentoModel;
import quintino.digital.gercontratapi.repository.ContratoParcelamentoRepository;
import quintino.digital.gercontratapi.repository.ParcelamentoImplementacaoRepository;
import quintino.digital.gercontratapi.repository.ParcelamentoRepository;
import quintino.digital.gercontratapi.utility.DateUtility;

import java.util.Date;
import java.util.List;

@Service
public class ParcelamentoService {

    @Autowired
    private ParcelamentoRepository parcelamentoRepository;

    @Autowired
    private ParcelamentoImplementacaoRepository parcelamentoImplementacaoRepository;

    @Autowired
    private ContratoParcelamentoRepository contratoParcelamentoRepository;

    @GetMapping
    public List<ParcelamentoModel> findAll() {
        return this.parcelamentoRepository.findAll();
    }

    public void gerarContratoParcelamento(ContratoModel contratoModel) {
        for( int index = 0 ; index < contratoModel.getQuantidadeParcela() ; index++ ) {
            ParcelamentoModel parcelamentoModel = new ParcelamentoModel();
                parcelamentoModel.setIdentificador("PARCELAEMPRESTIMOBANCARIO001202224");
                parcelamentoModel.setDataVencimento(this.configurarDataVencimentoParcela(contratoModel.getDiaVencimento()-1, index-1));
                parcelamentoModel.setDataPagamento(null);
                this.parcelamentoRepository.save(parcelamentoModel);
                this.contratoParcelamentoRepository.save(new ContratoParcelamentoModel(contratoModel, parcelamentoModel));
        }
    }

    private Date configurarDataVencimentoParcela(Integer diaVencimento, Integer mesVencimento) {
        return DateUtility.gerarData(diaVencimento, mesVencimento);
    }

    public List<ParcelamentoModel> recuperarParcelamentoMesCorrente() {
        return this.parcelamentoImplementacaoRepository.recuperarParcelamentoMesCorrente();
    }

}
