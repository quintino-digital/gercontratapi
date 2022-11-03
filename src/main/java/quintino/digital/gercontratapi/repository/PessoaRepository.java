package quintino.digital.gercontratapi.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import quintino.digital.gercontratapi.dto.PessoaResponseDTO;

import java.util.List;

@FeignClient(name = "gerpessapi", url = "https://gerpessapi.herokuapp.com/v1/pessoa", contextId = "pessoaapiID")
public interface PessoaRepository {

    @GetMapping List<PessoaResponseDTO> findAll();

    @GetMapping("/{codigo}") PessoaResponseDTO findOne(@PathVariable("codigo") Long codigo);

}
