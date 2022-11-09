package quintino.digital.gercontratapi.service;

import java.util.Date;
import java.util.List;

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
                parcelamentoModel.setDataVencimento(this.configurarDataVencimentoParcela(contratoModel.getDiaVencimento()-1, index-1));
                parcelamentoModel.setIdentificador(this.gerarIdentificadorParcelamento(contratoModel, index));
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
    
    /**
     * Gerar Identificador do Parcelamento de Acordo com a regra:
     * PARCELAMENTO<IDCONTRATO><ANO_INICIO_CONTRATO><MES_INICIO_CONTRATO><DIA_INICIO_CONTRATO><NUMERO_PARCELA>
     * PARCELAMENTOXX12022010101
     * @param contratoModel
     */
    private String gerarIdentificadorParcelamento(ContratoModel contratoModel, int numeroParcelamento) {
    	StringBuilder stringBuilder = new StringBuilder()
    			.append("PARCELAMENTO")
    			.append(contratoModel.getCodigo() <= 9 ? "0" + contratoModel.getCodigo() : contratoModel.getCodigo())
    			.append(DateUtility.formatarData(contratoModel.getDataInicio(), DateUtility.FORMATO_DATA_AAAAMMDD))
    			.append(this.configurarNumeroParcelamento(numeroParcelamento));
    	System.out.println(stringBuilder.toString().toUpperCase());
    	return stringBuilder.toString().toUpperCase();
    }
    
    private String configurarNumeroParcelamento(int numeroParcelamento) {
    	numeroParcelamento += 1;
    	String numeroParcelamentoConfigurado = "";
    	if(numeroParcelamento <= 9) {
    		numeroParcelamentoConfigurado = "00" + numeroParcelamento;
    	} else {
    		if(numeroParcelamento <= 99) {
    			numeroParcelamentoConfigurado = "0" + numeroParcelamento;
    		} else {
    			numeroParcelamentoConfigurado = "" + numeroParcelamento;
    		}
    	}
    	return numeroParcelamentoConfigurado;
    }

}
