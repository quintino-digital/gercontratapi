package quintino.digital.gercontratapi.model;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "TB_CONTRATO")
public class ContratoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", nullable = false)
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_CONTRATO")
    private TipoContratoModel tipoContratoModel;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_PERIODO")
    private TipoPeriodoModel tipoPeriodoModel;

    @Column(name = "ID_PESSOA_CONTRATANTE", nullable = true)
    private UUID pessoaContratante;

    @Column(name = "ID_PESSOA_CONTRATADA", nullable = true)
    private UUID pessoaContratada;

    @Column(name = "DATA_INICIO", nullable = false)
    private Date dataInicio;

    @Column(name = "DATA_FIM", nullable = false)
    private Date dataFim;

    @Column(name = "DIA_VENCIMENTO", nullable = false)
    private Integer diaVencimento;

    @Column(name = "QUANTIDADE_PARCELA", nullable = false)
    private Integer quantidadeParcela;

    @Column(name = "VALOR_EFETIVO", nullable = false)
    private Double valorEfetivo;

    @Column(name = "VALOR_JUROS", nullable = false)
    private Double valorJuros;

    @Column(name = "IDENTIFICADOR", unique = true, nullable = false)
    private String identificador;

    public TipoContratoModel getTipoContratoModel() {
        return tipoContratoModel;
    }

    public void setTipoContratoModel(TipoContratoModel tipoContratoModel) {
        this.tipoContratoModel = tipoContratoModel;
    }

    public ContratoModel() { }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public TipoPeriodoModel getTipoPeriodoModel() {
        return tipoPeriodoModel;
    }

    public void setTipoPeriodoModel(TipoPeriodoModel tipoPeriodoModel) {
        this.tipoPeriodoModel = tipoPeriodoModel;
    }

    public UUID getPessoaContratante() {
        return pessoaContratante;
    }

    public void setPessoaContratante(UUID pessoaContratante) {
        this.pessoaContratante = pessoaContratante;
    }

    public UUID getPessoaContratada() {
        return pessoaContratada;
    }

    public void setPessoaContratada(UUID pessoaContratada) {
        this.pessoaContratada = pessoaContratada;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Integer getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(Integer diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public Integer getQuantidadeParcela() {
        return quantidadeParcela;
    }

    public void setQuantidadeParcela(Integer quantidadeParcela) {
        this.quantidadeParcela = quantidadeParcela;
    }

    public Double getValorEfetivo() {
        return valorEfetivo;
    }

    public void setValorEfetivo(Double valorEfetivo) {
        this.valorEfetivo = valorEfetivo;
    }

    public Double getValorJuros() {
        return valorJuros;
    }

    public void setValorJuros(Double valorJuros) {
        this.valorJuros = valorJuros;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

}
