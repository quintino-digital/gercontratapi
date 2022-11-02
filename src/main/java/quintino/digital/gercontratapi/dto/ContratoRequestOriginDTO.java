package quintino.digital.gercontratapi.dto;

import java.util.Date;

public class ContratoRequestOriginDTO {
	
	private Integer codigoInstituicaoFinanceira;
	
	private Integer codigoTipoContratoModel;
	
	private Integer codigoTipoPeriodoModel;
	
	private Date dataInicio;
	
	private Double valorEfetivo;
	
	private Double valorParcela;
	
	private Integer diaVencimento;
	
	private Integer quantidadeParcela;

    public ContratoRequestOriginDTO() { }

	public Integer getCodigoInstituicaoFinanceira() {
		return codigoInstituicaoFinanceira;
	}

	public void setCodigoInstituicaoFinanceira(Integer codigoInstituicaoFinanceira) {
		this.codigoInstituicaoFinanceira = codigoInstituicaoFinanceira;
	}

	public Integer getCodigoTipoContratoModel() {
		return codigoTipoContratoModel;
	}

	public void setCodigoTipoContratoModel(Integer codigoTipoContratoModel) {
		this.codigoTipoContratoModel = codigoTipoContratoModel;
	}

	public Integer getCodigoTipoPeriodoModel() {
		return codigoTipoPeriodoModel;
	}

	public void setCodigoTipoPeriodoModel(Integer codigoTipoPeriodoModel) {
		this.codigoTipoPeriodoModel = codigoTipoPeriodoModel;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Double getValorEfetivo() {
		return valorEfetivo;
	}

	public void setValorEfetivo(Double valorEfetivo) {
		this.valorEfetivo = valorEfetivo;
	}

	public Double getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(Double valorParcela) {
		this.valorParcela = valorParcela;
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

}
