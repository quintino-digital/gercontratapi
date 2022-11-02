package quintino.digital.gercontratapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quintino.digital.gercontratapi.dto.ContratoRequestOriginDTO;
import quintino.digital.gercontratapi.model.ContratoModel;
import quintino.digital.gercontratapi.service.ContratoService;

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
    public List<ContratoModel> findAll() {
        return this.contratoService.findAll();
    }

}
