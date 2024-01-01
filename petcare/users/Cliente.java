package petcare.users;


import petcare.Marcacao;
import petcare.Recursos;

import java.util.ArrayList;
import java.util.List;


public class Cliente extends Utilizador
{
    ArrayList<Marcacao> marcacoes;

    //Construtor
    public Cliente(String nome, String numeroCC, String password, String numeroFiscal, String telefone, String morada, String localidade)
    {
        super(nome, numeroCC, password, numeroFiscal, telefone, morada, localidade);
         this.marcacoes = new ArrayList<>();
    }

    public List<Marcacao> getMarcacoes()
    {
        return marcacoes;
    }

    public void setMarcacoes(List<Marcacao> marcacoes)
    {
        this.marcacoes = (ArrayList<Marcacao>) marcacoes;
    }

    //Metodo para Remover Marcaçao
    public void removerMarcacao(Marcacao marcacao)
    {
        this.marcacoes.remove(marcacao);
    }

    //Metodo para Editar Marcaçao
    public void editarMarcacao(Marcacao velhaMarcacao, Marcacao novaMarcacao)
    {
        int pos = 0;
        for(Marcacao marcacao : marcacoes)
        {
            if(marcacao.equals(velhaMarcacao))
            {
                marcacoes.set(pos,novaMarcacao);
            }
            pos++;
        }
    }

    //Metodo para enviar as Marcaçoes em forma de Array
    public List<Marcacao> getMarcacoes2() {
        return new ArrayList<>(marcacoes); // Retorna uma cópia da lista para evitar modificações externas
    }


    //Metodo para enviar Informaçao Basica da Marcaçao
    public void mostrarMarcacoesSimples()
    {
        ArrayList<Marcacao> listamarcacoes = (ArrayList<Marcacao>) getMarcacoes2();

        if (!listamarcacoes.isEmpty())
        {
            System.out.println("Marcações do Cliente:");
            for (Marcacao marcacao : marcacoes) {
                System.out.println("Data: " + marcacao.getData());
                System.out.println("Estado: " + marcacao.getEstado());
                System.out.println("-----------------------");
            }
        }else
        {
            System.out.println("O Cliente nao tem nenhuma Marcaçao no Registo.");
        }
    }

    //Metodo para Marcar Marcaçoes
    public void marcarMarcacao()
    {
        Marcacao novaMarcacao = Recursos.registomarcacao(this);
        marcacoes.add(novaMarcacao);

        PrestadorDeServico prestador = novaMarcacao.getPrestadordeservico();
        prestador.marcarMarcacaoPrestador(novaMarcacao);

    }

    /*private void inicioProgramaDados()
     {
          try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("dados")))
          {
               Object obj = inputStream.readObject();
               if
          }
     }*/
}
