package petcare.users;


import petcare.Marcacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Cliente extends Utilizador
{
    List<Marcacao> marcacoes;

    //Construtor
    public Cliente(String nome, String numeroCC, String numeroFiscal, String telefone, String morada, String localidade, String password)
    {
        super(nome, numeroCC, numeroFiscal, telefone, morada, localidade, password);
         this.marcacoes = new ArrayList<>();
    }

    public List<Marcacao> getMarcacoes()
    {
        return marcacoes;
    }

    public void setMarcacoes(List<Marcacao> marcacoes)
    {
        this.marcacoes = marcacoes;
    }

    //Metodo para Adicionar Marcaçao
    public void adicionarMarcacao(Marcacao marcacao)
    {
        this.marcacoes.add(marcacao);
    }

    //Metodo para Remover Marcaçao
    public void removerMarcacao(Marcacao marcacao)
    {
        this.marcacoes.remove(marcacao);
    }

    //Metodo para Editar Marcaçao
    public void editarMarcacao(Marcacao marcacao)
    {

    }

    //Metodo para enviar as Marcaçoes em forma de Array
    public List<Marcacao> getMarcacoes2() {
        return new ArrayList<>(marcacoes); // Retorna uma cópia da lista para evitar modificações externas
    }

    //Metodo para enviar Informaçao Basica da Marcaçao
    public void mostrarMarcacoesSimples()
    {
        if (!marcacoes.isEmpty())
        System.out.println("Marcações do Cliente:");
        for (Marcacao marcacao : marcacoes) {
            System.out.println("Data: " + marcacao.getData());
            System.out.println("Estado: " + marcacao.getEstado());
            System.out.println("-----------------------");
        }
    }
}
