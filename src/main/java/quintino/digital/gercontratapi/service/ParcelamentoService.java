package quintino.digital.gercontratapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import quintino.digital.gercontratapi.model.ParcelamentoModel;
import quintino.digital.gercontratapi.repository.ParcelamentoRepository;
import quintino.digital.gercontratapi.utility.DateUtility;

import java.util.Date;
import java.util.List;

@Service
public class ParcelamentoService {

    @Autowired
    private ParcelamentoRepository parcelamentoRepository;

    @GetMapping
    public List<ParcelamentoModel> findAll() {
        return this.parcelamentoRepository.findAll();
    }

    public void gerarParcelamento(Date dataInicio, Integer diaVencimento, Double valorJuros, Integer quantidadeParcela) {
        for( int index = 0 ; index < quantidadeParcela ; index++ ) {
            ParcelamentoModel parcelamentoModel = new ParcelamentoModel();
                parcelamentoModel.setIdentificador("PARCELAEMPRESTIMOBANCARIO0012022");
                parcelamentoModel.setDataVencimento(this.configurarDataVencimentoParcela(diaVencimento-1, index-1));
                parcelamentoModel.setDataPagamento(null);
                this.parcelamentoRepository.save(parcelamentoModel);
        }
    }

    private Date configurarDataVencimentoParcela(Integer diaVencimento, Integer mesVencimento) {
        return DateUtility.gerarData(diaVencimento, mesVencimento);
    }

}
