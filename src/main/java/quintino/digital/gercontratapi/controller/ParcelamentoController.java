package quintino.digital.gercontratapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quintino.digital.gercontratapi.dto.ContratoRequestDTO;
import quintino.digital.gercontratapi.model.ContratoModel;
import quintino.digital.gercontratapi.model.ParcelamentoModel;
import quintino.digital.gercontratapi.service.ContratoService;
import quintino.digital.gercontratapi.service.ParcelamentoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/parcelamento")
public class ParcelamentoController {

    @Autowired
    private ParcelamentoService parcelamentoService;

    @GetMapping
    public List<ParcelamentoModel> findAll() {
        return this.parcelamentoService.findAll();
    }

    @GetMapping("/parcelamento-mes-corrente")
    public List<ParcelamentoModel> recuperarParcelamentoMesCorrente() {
        return this.parcelamentoService.recuperarParcelamentoMesCorrente();
    }

}
