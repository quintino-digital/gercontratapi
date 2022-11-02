package quintino.digital.gercontratapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quintino.digital.gercontratapi.model.TipoPeriodoFinanceiroModel;
import quintino.digital.gercontratapi.service.TipoPeriodoFinanceiroService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tipo-periodo-financeiro")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TipoPeriodoFinanceiroController {

    @Autowired
    private TipoPeriodoFinanceiroService tipoPeriodoFinanceiroService;

    @GetMapping
    public List<TipoPeriodoFinanceiroModel> findAll() {
        return this.tipoPeriodoFinanceiroService.findAll();
    }

}
