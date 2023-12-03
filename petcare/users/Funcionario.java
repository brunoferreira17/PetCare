package petcare.users;

import java.io.Serializable;

public class Funcionario extends Utilizador implements Serializable
{
    //Atributos apenas do Funcionario
    private TipoFuncionario tipofuncionario;

    //Construtor
    public Funcionario(String nome, String numeroCC, String numeroFiscal, String telefone, String morada, String localidade,String password)
    {
        super(nome, numeroCC, numeroFiscal, telefone, morada, localidade, password);
        this.tipofuncionario = tipofuncionario;
    }

    //Getters e Setters
    public TipoFuncionario getTipofuncionario()
    {
        return tipofuncionario;
    }

    public void setTipofuncionario(TipoFuncionario tipofuncionario)
    {
        this.tipofuncionario = tipofuncionario;
    }


}
