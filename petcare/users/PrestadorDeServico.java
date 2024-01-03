package petcare.users;


import petcare.Local;
import petcare.Marcacao;
import petcare.Recursos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrestadorDeServico extends Utilizador
{
    private final List<Local> locais;
    ArrayList<Marcacao> marcacoes;

    public PrestadorDeServico(String nome, String numeroCC ,String password ,String numeroFiscal, String telefone, String morada, String localidade)
    {
        super(nome, numeroCC, password, numeroFiscal, telefone, morada, localidade);
        this.locais = new ArrayList<>();
        this.marcacoes = new ArrayList<>();
    }

    public void marcarMarcacaoPrestador(Marcacao novaMarcacao)
    {
        marcacoes.add(novaMarcacao);
    }

    public List<Marcacao> getMarcacoes2()
    {
        return new ArrayList<>(marcacoes); // Retorna uma cópia da lista para evitar modificações externas.
    }

    public List<Local> getLocais2()
    {
        return new ArrayList<>(locais);
    }


    public void mostrarMarcacoesSimples()
    {
        ArrayList<Marcacao> listamarcacoes = (ArrayList<Marcacao>) getMarcacoes2();

        if (!listamarcacoes.isEmpty())
        {
            int counter = 1;
            System.out.println("Marcações do Prestador " + this.getNome() + ":" );
            for (Marcacao marcacao : marcacoes)
            {
                System.out.println("----Marcaçao " + counter + "----");
                System.out.println("Cliente: "+ marcacao.getCliente().getNome());
                System.out.println("Data: " + marcacao.getData());
                System.out.println("Estado: " + marcacao.getEstado());
                System.out.println("Descriçao: " + marcacao.getDescricaoServico());
                counter++;
            }
        }else
        {
            System.out.println("O Prestador nao tem nenhuma Marcaçao no Registo.");
        }
    }

    public void editarMarcacao()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleciona a Marcaçao que deseja selecionar/:");
        int option = scanner.nextInt();

        if(option == 0)
        {
            System.out.println("A voltar ao menu...");
        }else
        {
            Marcacao marcacaoPorEditar = marcacoes.get(option-1);
            Marcacao marcacaoEditada;
            Cliente cliente = marcacaoPorEditar.getCliente();

            marcacaoEditada = Recursos.editarMarcacao(this,marcacaoPorEditar);

            if(marcacaoEditada == null)
            {
                marcacoes.remove(marcacaoPorEditar);
                cliente.removerMarcacao(marcacaoPorEditar);
            }else
            {
                cliente.editarMarcacao(marcacaoPorEditar,marcacaoEditada);

                marcacoes.set(option-1,marcacaoEditada);
            }
        }
    }

    public void mostrarLocaisSimples()
    {
        ArrayList<Local> listalocais = (ArrayList<Local>) getLocais2();

        if (!listalocais.isEmpty())
        {
            int counter = 1;
            System.out.println("Locais do Prestador " + this.getNome() + ":" );
            for (Local local : locais)
            {
                System.out.println("----Local " + counter + "----");
                System.out.println("Morada: "+ local.getMorada());
                System.out.println("Localidade: " + local.getLocalidade());
                System.out.println("Contacto: " + local.getContacto());
                counter++;
            }
        }else
        {
            System.out.println("O Prestador nao tem nenhum Local no Registo.");
        }
    }


    public void adicionarLocal()
    {
        Local local = Recursos.registoLocal();
        locais.add(local);

        System.out.println("Local Registado Com Sucesso!");
    }

    public void editarLocal()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleciona o Local que deseja selecionar/:");
        int option = scanner.nextInt();



        if(option == 0)
        {
            System.out.println("A voltar ao menu...");
        }else
        {
            Local LocalPorEditar = locais.get(option-1);
            Local LocalEditado;


            LocalEditado = Recursos.editarLocal(LocalPorEditar);

            if(LocalEditado == null)
            {
                locais.remove(LocalPorEditar);
            }else
            {
                locais.set(option-1,LocalEditado);
            }
        }
    }

}
