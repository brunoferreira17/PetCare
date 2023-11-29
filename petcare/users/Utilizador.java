package petcare.users;

import java.io.Serializable;

public class Utilizador implements Serializable {
    // Atributos comuns a clientes, prestadores de serviços, Funcionarios e Adminstradores
    private String nome;
    private String numeroCC;
    private String numeroFiscal;
    private String telefone;
    private String morada;
    private String localidade;
    private String password;

    // Construtor
    public Utilizador(String nome, String numeroCC, String numeroFiscal, String telefone, String morada, String localidade,String password)
    {
        this.nome = nome;
        this.numeroCC = numeroCC;
        this.password = password;
        this.numeroFiscal = numeroFiscal;
        this.telefone = telefone;
        this.morada = morada;
        this.localidade = localidade;
    }

    // Getters e Setters
    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getNumeroCC()
    {
        return numeroCC;
    }

    public void setNumeroCC(String numeroCC)
    {
        this.numeroCC = numeroCC;
    }

    public String getNumeroFiscal()
    {
        return numeroFiscal;
    }

    public void setNumeroFiscal(String numeroFiscal)
    {
        this.numeroFiscal = numeroFiscal;
    }

    public String getTelefone()
    {
        return telefone;
    }

    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }

    public String getMorada()
    {
        return morada;
    }

    public void setMorada(String morada)
    {
        this.morada = morada;
    }

    public String getLocalidade()
    {
        return localidade;
    }

    public void setLocalidade(String localidade)
    {
        this.localidade = localidade;
    }

    public String getPassword()
    {
        return password;
    }

    public  void setPassword(String password)
    {
        this.password = password;
    }
}
