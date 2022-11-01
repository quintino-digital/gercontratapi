package quintino.digital.gercontratapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quintino.digital.gercontratapi.dto.ContratoRequestDTO;
import quintino.digital.gercontratapi.dto.ContratoResponseDTO;
import quintino.digital.gercontratapi.model.ContratoModel;
import quintino.digital.gercontratapi.repository.ContratoRepository;

import java.util.List;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private ParcelamentoService parcerParcelamentoService;

    public ContratoResponseDTO saveOne(ContratoRequestDTO contratoRequestDTO) {
        ContratoModel contratoModel = new ContratoModel();
        ContratoResponseDTO contratoResponseDTO = new ContratoResponseDTO();
        convertContratoRequestDTOToContratoModel(contratoRequestDTO, contratoModel);
        contratoModel = this.contratoRepository.save(contratoModel);
        this.criarParcelamento(contratoModel);
        convertContratoModelToContratoResponseDTO(contratoModel, contratoResponseDTO);
        return contratoResponseDTO;
    }

    private void criarParcelamento(ContratoModel contratoModel) {
        this.parcerParcelamentoService.gerarParcelamento(
                contratoModel.getDataInicio(),
                contratoModel.getDiaVencimento(),
                contratoModel.getValorJuros(),
                contratoModel.getQuantidadeParcela());
    }

    public List<ContratoModel> findAll() {
        return this.contratoRepository.findAll();
    }

    private static void convertContratoRequestDTOToContratoModel(ContratoRequestDTO contratoRequestDTO, ContratoModel contratoModel) {
        BeanUtils.copyProperties(contratoRequestDTO, contratoModel);
    }

    private static void convertContratoModelToContratoResponseDTO(ContratoModel contratoModel, ContratoResponseDTO contratoResponseDTO) {
        BeanUtils.copyProperties(contratoModel, contratoResponseDTO);
    }

}
