package petcare.users;


import petcare.Marcacao;
import petcare.Recursos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Cliente extends Utilizador
{
    ArrayList<Marcacao> marcacoes;

    //Construtor
    public Cliente(String nome, String numeroCC, String password, String numeroFiscal, String telefone, String morada, String localidade)
    {
        super(nome, numeroCC, password, numeroFiscal, telefone, morada, localidade);
         this.marcacoes = new ArrayList<>();
    }

    //Metodo para Remover Marcaçao
    public void removerMarcacao(Marcacao marcacao)
    {
        this.marcacoes.remove(marcacao);
    }

    //Metodo para Editar Marcaçao
    public void editarMarcacaoFinal(Marcacao velhaMarcacao, Marcacao novaMarcacao)
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
            int counter = 1;
            for (Marcacao marcacao : marcacoes)
            {
                System.out.println("====Marcaçao " + counter + "====");
                System.out.println("Data: " + marcacao.getData());
                System.out.println("Estado: " + marcacao.getEstado());
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

        if(novaMarcacao != null)
        {
            marcacoes.add(novaMarcacao);

            PrestadorDeServico prestador = novaMarcacao.getPrestadordeservico();
            prestador.marcarMarcacaoPrestador(novaMarcacao);
        }
    }

    //Metodo para Pagar Marcaçoes
    public void pagarMarcacao()
    {
        Scanner scanner = new Scanner(System.in);

        if(marcacoes == null)
        {
            this.mostrarMarcacoesSimples();
        }else {

            this.mostrarMarcacoesSimples();
            System.out.println("Seleciona a Marcaçao que deseja Pagar:");
            int option = scanner.nextInt();

            if (option == 0 && option > marcacoes.size()) {
                System.out.println("A voltar ao menu...");
            } else {
                Marcacao marcacaoPorPagar = marcacoes.get(option - 1);
                Marcacao marcacaoPaga = marcacaoPorPagar;

                PrestadorDeServico prestador = marcacaoPorPagar.getPrestadordeservico();

                marcacaoPaga.setEstado("Pago!");

                prestador.editarMarcacaoFinal(marcacaoPorPagar, marcacaoPaga);

                marcacoes.set(option - 1, marcacaoPaga);
            }
        }
    }
}
