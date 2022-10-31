package quintino.digital.gercontratapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quintino.digital.gercontratapi.dto.ContratoRequestDTO;
import quintino.digital.gercontratapi.model.ContratoModel;
import quintino.digital.gercontratapi.service.ContratoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contrato")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @PostMapping
    public ResponseEntity<Object> saveOne(@RequestBody ContratoRequestDTO contratoRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.contratoService.saveOne(contratoRequestDTO));
    }

    @GetMapping
    public List<ContratoModel> findAll() {
        return this.contratoService.findAll();
    }

}
