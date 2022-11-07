package quintino.digital.gercontratapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quintino.digital.gercontratapi.dto.ContratoPessoaRequestDTO;
import quintino.digital.gercontratapi.dto.ContratoRequestOriginDTO;
import quintino.digital.gercontratapi.dto.ContratoResponseDTO;
import quintino.digital.gercontratapi.dto.PessoaResponseDTO;
import quintino.digital.gercontratapi.model.ContratoModel;
import quintino.digital.gercontratapi.model.TipoContratoModel;
import quintino.digital.gercontratapi.model.TipoPeriodoFinanceiroModel;
import quintino.digital.gercontratapi.repository.ContratoRepository;

import java.util.ArrayList;
import java.util.Date;
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
        contratoModel = this.contratoRepository.save(convertContratoRequestOriginDTOToContratoModel(contratoRequestOriginDTO, contratoModel));
        this.criarParcelamento(contratoModel);
        convertContratoModelToContratoResponseDTO(contratoModel, contratoResponseDTO);
        return contratoResponseDTO;
    }

    private void criarParcelamento(ContratoModel contratoModel) {
        this.parcerParcelamentoService.gerarContratoParcelamento(contratoModel);
    }

    public List<ContratoPessoaRequestDTO> findAll() {
        List<ContratoPessoaRequestDTO> contratoPessoaRequestDTOList = new ArrayList<>();
        for(ContratoModel contratoModel : this.contratoRepository.findAll()) {
            ContratoPessoaRequestDTO contratoPessoaRequestDTO = new ContratoPessoaRequestDTO();
                contratoPessoaRequestDTO.setNomePessoaContratante(this.recuperarNomePessoa(contratoModel.getPessoaContratante()));
                contratoPessoaRequestDTO.setNomePessoaContratada(this.recuperarNomePessoa(contratoModel.getPessoaContratada()));
                contratoPessoaRequestDTO.setDataFim(contratoModel.getDataFim());
                contratoPessoaRequestDTO.setDataInicio(contratoModel.getDataInicio());
                contratoPessoaRequestDTO.setDiaVencimento(contratoModel.getDiaVencimento());
                contratoPessoaRequestDTO.setIdentificador(contratoModel.getIdentificador());
                contratoPessoaRequestDTO.setTipoContratoModel(contratoModel.getTipoContratoModel());
                contratoPessoaRequestDTO.setTipoPeriodoModel(contratoModel.getTipoPeriodoModel());
                contratoPessoaRequestDTO.setValorJuros(contratoModel.getValorParcela());
                contratoPessoaRequestDTO.getValorEfetivo(contratoModel.getValorEfetivo());
                contratoPessoaRequestDTO.setQuantidadeParcela(contratoModel.getQuantidadeParcela());
                contratoPessoaRequestDTOList.add(contratoPessoaRequestDTO);
        }
        return contratoPessoaRequestDTOList;
    }

    // TODO -- Implementar Conversao de ContratoRequestOriginDTO para ContratoModel
    private ContratoModel convertContratoRequestOriginDTOToContratoModel(ContratoRequestOriginDTO contratoRequestOriginDTO, ContratoModel contratoModel) {
    	ContratoModel contratoModelResultado = new ContratoModel();
            contratoModelResultado.setTipoContratoModel(this.recuperarTipoContrato(contratoRequestOriginDTO.getCodigoTipoContratoModel()));
            contratoModelResultado.setTipoPeriodoModel(this.recuperarTipoPeriodoFinanceiro(contratoRequestOriginDTO.getCodigoTipoPeriodoModel()));
            contratoModelResultado.setPessoaContratada(this.recuperarPessoa(contratoRequestOriginDTO.getCodigoInstituicaoFinanceira()).getCodigo());
            contratoModelResultado.setPessoaContratante(this.recuperarPessoa(1L).getCodigo());
	    	contratoModelResultado.setDataInicio(contratoRequestOriginDTO.getDataInicio());
            contratoModelResultado.setQuantidadeParcela(contratoRequestOriginDTO.getQuantidadeParcela());
            contratoModelResultado.setValorEfetivo(contratoRequestOriginDTO.getValorEfetivo());
            contratoModelResultado.setValorParcela(contratoRequestOriginDTO.getValorParcela());
	    	contratoModelResultado.setDiaVencimento(contratoRequestOriginDTO.getDiaVencimento());
	    	contratoModelResultado.setIdentificador("CONTRATO_EMPRESTIMO_BANCARIO_11202201");
            contratoModelResultado.setDataFim(this.recuperarDataFimContrato());
        return contratoModelResultado;
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

    private PessoaResponseDTO recuperarPessoa(Long codigo) {
        return this.pessoaService.findOne(codigo);
    }

    private Date recuperarDataFimContrato() {
        return new Date();
    }

    public String recuperarNomePessoa(Long codigo) {
        return this.recuperarPessoa(codigo).getNome();
    }

}
