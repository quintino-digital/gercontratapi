package quintino.digital.gercontratapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quintino.digital.gercontratapi.model.ParcelamentoModel;
import quintino.digital.gercontratapi.service.ParcelamentoService;

@RestController
@RequestMapping("/api/v1/parcelamento")
@CrossOrigin(origins = "*", allowedHeaders = "*")
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
