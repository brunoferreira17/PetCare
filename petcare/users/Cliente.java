package petcare.users;

import petcare.Marcacao;

import java.util.ArrayList;
import java.util.List;


public class Cliente extends Utilizador
{
    List<Marcacao> marcacoes;

    //Construtor
    public Cliente(String nome, String numeroCC, String numeroFiscal, String telefone, String morada, String localidade,String password)
    {
        super(nome, numeroCC, numeroFiscal, telefone, morada, localidade, password);
         this.marcacoes = new ArrayList<>();
    }

    //Metodo para Adicionar Marcaçao
    public void adicionarMarcacao(Marcacao marcacao)
    {
        this.marcacoes.add(marcacao);
    }


}
