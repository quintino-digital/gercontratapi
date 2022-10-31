package quintino.digital.gercontratapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quintino.digital.gercontratapi.dto.PessoaResponseDTO;
import quintino.digital.gercontratapi.repository.PessoaRepository;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaResponseDTO> findAll() {
        return pessoaRepository.findAll();
    }

}
