package quintino.digital.gercontratapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quintino.digital.gercontratapi.dto.ContratoPessoaRequestDTO;
import quintino.digital.gercontratapi.dto.ContratoRequestOriginDTO;
import quintino.digital.gercontratapi.service.ContratoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contrato")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @PostMapping
    public ResponseEntity<Object> saveOne(@RequestBody ContratoRequestOriginDTO contratoRequestOriginDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.contratoService.saveOne(contratoRequestOriginDTO));
    }

    @GetMapping
    public List<ContratoPessoaRequestDTO> findAll() {
        return this.contratoService.findAll();
    }

}
