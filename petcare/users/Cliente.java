package petcare.users;

import petcare.Marcacao;

import java.util.ArrayList;
import java.util.List;


public class Cliente extends Utilizador
{


    //Construtor
    public Cliente(String nome, String numeroCC, String numeroFiscal, String telefone, String morada, String localidade)
    {
        super(nome, numeroCC, numeroFiscal, telefone, morada, localidade);
        List<Marcacao> marcacoes = new ArrayList<>();
    }

    // Getters e Setters e Adiçao


}
