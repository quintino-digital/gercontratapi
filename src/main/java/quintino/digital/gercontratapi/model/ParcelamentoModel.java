package quintino.digital.gercontratapi.model;

import javax.persistence.*;
import java.util.Date;

// TODO -- Mapear campo TB_PARCELAMENTO.QUANTIDADE_DIA_ATRASO
@Entity
@Table(name = "TB_PARCELAMENTO")
public class ParcelamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", nullable = false)
    private Long codigo;

    @Column(name = "DATA_VENCIMENTO", nullable = false)
    private Date dataVencimento;

    @Column(name = "DATA_PAGAMENTO")
    private Date dataPagamento;

    @Column(name = "IDENTIFICADOR", nullable = false)
    private String identificador;

    public ParcelamentoModel() { }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

}
