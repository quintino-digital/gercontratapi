package quintino.digital.gercontratapi.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_CONTRATO_PARCELAMENTO")
public class ContratoParcelamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", nullable = false)
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "ID_CONTRATO")
    private ContratoModel contratoModel;

    @ManyToOne
    @JoinColumn(name = "ID_PARCELAMENTO")
    private ParcelamentoModel parcelamentoModel;

    @Column(name = "IS_ATIVO", unique = true, nullable = false)
    private Boolean isAtivo;

    public ContratoParcelamentoModel() { }

    public ContratoParcelamentoModel(ContratoModel contratoModel, ParcelamentoModel parcelamentoModel) {
        this.contratoModel = contratoModel;
        this.parcelamentoModel = parcelamentoModel;
        this.isAtivo = true;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public ContratoModel getContratoModel() {
        return contratoModel;
    }

    public void setContratoModel(ContratoModel contratoModel) {
        this.contratoModel = contratoModel;
    }

    public ParcelamentoModel getParcelamentoModel() {
        return parcelamentoModel;
    }

    public void setParcelamentoModel(ParcelamentoModel parcelamentoModel) {
        this.parcelamentoModel = parcelamentoModel;
    }

    public Boolean getAtivo() {
        return isAtivo;
    }

    public void setAtivo(Boolean ativo) {
        isAtivo = ativo;
    }

}
