package petcare;

import petcare.users.Utilizador;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PetCareUsuarios
{
     //Mapa onde vao ficar todos os usuarios.
     private static Map<String, Utilizador> utilizadores = new HashMap<>();


     //Metodo que Adicionará Utilizador Registado ao Mapa
     public void AdicionarUtilizador()
     {
          Utilizador novoUtilizador = Recursos.registo();

          if(novoUtilizador != null)
          {
               String numeroCC = novoUtilizador.getNumeroCC();
               utilizadores.put(numeroCC, novoUtilizador);
               System.out.println("Usuario Registado com Sucesso!");
          }
     }

     //Metodo usado para remmover Utilizadores.
     public void RemoverUtilizador()
     {
          Scanner scanner = new Scanner(System.in);

          System.out.println("Insira o Numero do Cartao de Cidadao do Utilizador que deseja remover:");
          String numeroCC = scanner.nextLine();
          utilizadores.remove(numeroCC);
          System.out.println("Utilizador Removido com Sucesso!");

     }

     //Metodo usado para Exibir Informaçao dos Utilizadores.
     public void ExibirUtilizador()
     {
          Scanner scanner = new Scanner(System.in);

          System.out.println("Insira o Numero do Cartao de Cidadao do Utilizador que deseja Ver:");
          String numeroCC = scanner.nextLine();
          Utilizador utilizador = utilizadores.get(numeroCC);

          System.out.println("===== Informaçao da Pessoa =====");

          System.out.println("Nome: " + utilizador.getNome());

          System.out.println("Número de Cartão de Cidadão: " + utilizador.getNumeroCC());

          System.out.println("Número Fiscal: " + utilizador.getNumeroFiscal());

          System.out.println("Telefone: " + utilizador.getTelefone());

          System.out.println("Morada: " + utilizador.getMorada());

          System.out.println("Localidade: " + utilizador.getMorada());

          System.out.println("================================");
     }

     public static boolean verificarLogin(String numeroCC, String password)
     {
          Utilizador utilizador = utilizadores.get(numeroCC);

          return utilizador != null && utilizador.getPassword().equals(password);
     }
}
