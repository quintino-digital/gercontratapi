package quintino.digital.gercontratapi.dto;

import quintino.digital.gercontratapi.model.TipoContratoModel;
import quintino.digital.gercontratapi.model.TipoPeriodoFinanceiroModel;

import java.util.Date;
import java.util.UUID;

public class ContratoResponseDTO {

    private Long codigo;

    private TipoContratoModel tipoContratoModel;

    private TipoPeriodoFinanceiroModel tipoPeriodoModel;

    private UUID pessoaContratante;

    private UUID pessoaContratada;

    private Date dataInicio;

    private Date dataFim;

    private Integer diaVencimento;

    private Integer quantidadeParcela;

    private Double valorEfetivo;

    private Double valorJuros;

    private String identificador;

    public ContratoResponseDTO() { }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public TipoContratoModel getTipoContratoModel() {
        return tipoContratoModel;
    }

    public void setTipoContratoModel(TipoContratoModel tipoContratoModel) {
        this.tipoContratoModel = tipoContratoModel;
    }

    public TipoPeriodoFinanceiroModel getTipoPeriodoModel() {
        return tipoPeriodoModel;
    }

    public void setTipoPeriodoModel(TipoPeriodoFinanceiroModel tipoPeriodoModel) {
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
