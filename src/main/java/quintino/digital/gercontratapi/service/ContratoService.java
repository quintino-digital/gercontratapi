package quintino.digital.gercontratapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quintino.digital.gercontratapi.dto.ContratoRequestOriginDTO;
import quintino.digital.gercontratapi.dto.ContratoResponseDTO;
import quintino.digital.gercontratapi.dto.PessoaResponseDTO;
import quintino.digital.gercontratapi.model.ContratoModel;
import quintino.digital.gercontratapi.model.TipoContratoModel;
import quintino.digital.gercontratapi.model.TipoPeriodoFinanceiroModel;
import quintino.digital.gercontratapi.repository.ContratoRepository;

import java.util.List;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private ParcelamentoService parcerParcelamentoService;

    @Autowired
    private TipoContratoService tipoContratoService;

    @Autowired
    private TipoPeriodoFinanceiroService tipoPeriodoFinanceiroService;

    @Autowired
    private PessoaService pessoaService;

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
    private void convertContratoRequestOriginDTOToContratoModel(ContratoRequestOriginDTO contratoRequestOriginDTO, ContratoModel contratoModel) {
    	ContratoModel contratoModelResultado = new ContratoModel();
            contratoModelResultado.setTipoContratoModel(this.recuperarTipoContrato(contratoRequestOriginDTO.getCodigoTipoContratoModel()));
            contratoModelResultado.setTipoPeriodoModel(this.recuperarTipoPeriodoFinanceiro(contratoRequestOriginDTO.getCodigoTipoPeriodoModel()));
            contratoModelResultado.setPessoaContratada(null);
            contratoModelResultado.setPessoaContratante(null);
	    	contratoModelResultado.setDataFim(null);
	    	contratoModelResultado.setDataInicio(contratoRequestOriginDTO.getDataInicio());
            contratoModelResultado.setQuantidadeParcela(contratoRequestOriginDTO.getQuantidadeParcela());
            contratoModelResultado.setValorEfetivo(contratoRequestOriginDTO.getValorEfetivo());
            contratoModelResultado.setValorParcela(contratoRequestOriginDTO.getValorParcela());
	    	contratoModelResultado.setDiaVencimento(null);
	    	contratoModelResultado.setIdentificador(null);
    }

    private static void convertContratoModelToContratoResponseDTO(ContratoModel contratoModel, ContratoResponseDTO contratoResponseDTO) {
        BeanUtils.copyProperties(contratoModel, contratoResponseDTO);
    }

    private TipoContratoModel recuperarTipoContrato(Integer codigo) {
        return this.tipoContratoService.findOne(Long.valueOf(codigo));
    }

    private TipoPeriodoFinanceiroModel recuperarTipoPeriodoFinanceiro(Integer codigo) {
        return this.tipoPeriodoFinanceiroService.findByCodigo(Long.valueOf(codigo));
    }

    private PessoaResponseDTO recuperarPessoa(Integer codigo) {
        return null;
    }

}
