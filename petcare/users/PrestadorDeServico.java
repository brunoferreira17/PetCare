package petcare.users;


import petcare.Local;
import petcare.Marcacao;
import petcare.PetCareUsuarios;

import java.util.ArrayList;
import java.util.List;

public class PrestadorDeServico extends Utilizador
{
    private List<Local> locais;
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
}
