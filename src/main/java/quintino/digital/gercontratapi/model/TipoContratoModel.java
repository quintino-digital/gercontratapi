package quintino.digital.gercontratapi.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_TIPO_CONTRATO")
public class TipoContratoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CODIGO", nullable = false)
    private Long codigo;

    @Column(name = "DESCRICAO", unique = true, nullable = false)
    private String descricao;

    public TipoContratoModel() { }

    public TipoContratoModel(String descricao) {
        this.descricao = descricao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
