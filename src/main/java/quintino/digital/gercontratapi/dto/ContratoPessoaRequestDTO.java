package quintino.digital.gercontratapi.dto;

import quintino.digital.gercontratapi.model.TipoContratoModel;
import quintino.digital.gercontratapi.model.TipoPeriodoFinanceiroModel;

import java.util.Date;

public class ContratoPessoaRequestDTO {

    private Long codigo;

    private TipoContratoModel tipoContratoModel;

    private TipoPeriodoFinanceiroModel tipoPeriodoModel;

    private String nomePessoaContratante;

    private String nomePessoaContratada;

    private Date dataInicio;

    private Date dataFim;

    private Integer diaVencimento;

    private Integer quantidadeParcela;

    private Double valorEfetivo;

    private Double valorJuros;

    private String identificador;

    public ContratoPessoaRequestDTO() { }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNomePessoaContratante() {
        return nomePessoaContratante;
    }

    public String getNomePessoaContratada() {
        return nomePessoaContratada;
    }

    public Double getValorEfetivo() {
        return valorEfetivo;
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

    public String getNomePessoaContratante(String s) {
        return nomePessoaContratante;
    }

    public void setNomePessoaContratante(String nomePessoaContratante) {
        this.nomePessoaContratante = nomePessoaContratante;
    }

    public String getNomePessoaContratada(String s) {
        return nomePessoaContratada;
    }

    public void setNomePessoaContratada(String nomePessoaContratada) {
        this.nomePessoaContratada = nomePessoaContratada;
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

    public Double getValorEfetivo(Double valorEfetivo) {
        return this.valorEfetivo;
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
