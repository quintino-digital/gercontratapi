package quintino.digital.gercontratapi.dto;

public class PessoaResponseDTO {

    private Long codigo;

    private String nome;

    public PessoaResponseDTO() { }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
