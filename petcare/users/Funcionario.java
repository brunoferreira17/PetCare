package petcare.users;

import java.io.Serializable;

public class Funcionario extends Utilizador implements Serializable
{
    //Construtor
    public Funcionario(String nome, String numeroCC, String numeroFiscal, String telefone, String morada, String localidade,String password)
    {
        super(nome, numeroCC, numeroFiscal, telefone, morada, localidade, password);
    }

    //Getters e Setters


}
