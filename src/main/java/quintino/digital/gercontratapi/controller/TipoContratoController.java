package quintino.digital.gercontratapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quintino.digital.gercontratapi.model.TipoContratoModel;
import quintino.digital.gercontratapi.service.TipoContratoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tipo-contrato")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TipoContratoController {

    @Autowired
    private TipoContratoService tipoContratoService;

    @GetMapping
    public List<TipoContratoModel> findAll() {
        return this.tipoContratoService.findAll();
    }

}
