package quintino.digital.gercontratapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quintino.digital.gercontratapi.dto.PessoaResponseDTO;
import quintino.digital.gercontratapi.service.PessoaService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<PessoaResponseDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.pessoaService.findAll());
    }

}
