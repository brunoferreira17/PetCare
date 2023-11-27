package petcare;

import java.io.Serializable;

public class Funcionario extends Utilizador implements Serializable
{
    private TipoFuncionario tipofuncionario;

    public Funcionario(String nome, String numeroCC, String numeroFiscal, String telefone, String morada, String localidade,TipoFuncionario tipofuncionario)
    {
        super(nome, numeroCC, numeroFiscal, telefone, morada, localidade);
        this.tipofuncionario = tipofuncionario;
    }

    public TipoFuncionario getTipofuncionario()
    {
        return tipofuncionario;
    }

    public void setTipofuncionario(TipoFuncionario tipofuncionario)
    {
        this.tipofuncionario = tipofuncionario;
    }

}
