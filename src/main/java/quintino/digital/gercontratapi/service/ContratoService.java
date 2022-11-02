package quintino.digital.gercontratapi.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quintino.digital.gercontratapi.dto.ContratoRequestOriginDTO;
import quintino.digital.gercontratapi.dto.ContratoResponseDTO;
import quintino.digital.gercontratapi.model.ContratoModel;
import quintino.digital.gercontratapi.repository.ContratoRepository;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private ParcelamentoService parcerParcelamentoService;

    public ContratoResponseDTO saveOne(ContratoRequestOriginDTO contratoRequestOriginDTO) {
        ContratoModel contratoModel = new ContratoModel();
        ContratoResponseDTO contratoResponseDTO = new ContratoResponseDTO();
        convertContratoRequestOriginDTOToContratoModel(contratoRequestOriginDTO, contratoModel);
        contratoModel = this.contratoRepository.save(contratoModel);
        this.criarParcelamento(contratoModel);
        convertContratoModelToContratoResponseDTO(contratoModel, contratoResponseDTO);
        return contratoResponseDTO;
    }

    private void criarParcelamento(ContratoModel contratoModel) {
        this.parcerParcelamentoService.gerarContratoParcelamento(contratoModel);
    }

    public List<ContratoModel> findAll() {
        return this.contratoRepository.findAll();
    }

    // TODO -- Implementar Conversao de ContratoRequestOriginDTO para ContratoModel
    private static void convertContratoRequestOriginDTOToContratoModel(ContratoRequestOriginDTO contratoRequestOriginDTO, ContratoModel contratoModel) {
    	ContratoModel contratoModelResultado = new ContratoModel();
	    	contratoModelResultado.setDataFim(null);
	    	contratoModelResultado.setDataInicio(null);
	    	contratoModelResultado.setDiaVencimento(null);
	    	contratoModelResultado.setIdentificador(null);
	    	contratoModelResultado.setPessoaContratada(null);
	    	contratoModelResultado.setPessoaContratante(null);
	    	contratoModelResultado.setQuantidadeParcela(null);
	    	contratoModelResultado.setTipoContratoModel(null);
	    	contratoModelResultado.setTipoPeriodoModel(null);
	    	contratoModelResultado.setValorEfetivo(null);
	    	contratoModelResultado.setValorParcela(null);
    		
    }

    private static void convertContratoModelToContratoResponseDTO(ContratoModel contratoModel, ContratoResponseDTO contratoResponseDTO) {
        BeanUtils.copyProperties(contratoModel, contratoResponseDTO);
    }

}
