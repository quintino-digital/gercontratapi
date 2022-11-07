package quintino.digital.gercontratapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quintino.digital.gercontratapi.dto.PessoaResponseDTO;
import quintino.digital.gercontratapi.service.PessoaService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pessoa")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<PessoaResponseDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.pessoaService.findAll());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<PessoaResponseDTO> findOne(@PathVariable("codigo") Long codigo) {
        return ResponseEntity.status(HttpStatus.OK).body(this.pessoaService.findOne(codigo));
    }

}
