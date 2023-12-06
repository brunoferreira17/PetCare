package petcare;

import petcare.users.Cliente;
import petcare.users.Utilizador;

import java.util.*;

import static java.util.Collections.sort;

public class PetCareUsuarios
{
     //Mapa onde vao ficar todos os usuarios.
     private static Map<String, Utilizador> utilizadores = new HashMap<>();


     //Criaçao do Unico Mapa de Utilizadores
     private  static PetCareUsuarios users;

     //Metodo para ser Criado apenas e so um Mapa de Utilizadores.
     public static PetCareUsuarios getUsers()
     {
          if(users == null)
          {
               users = new PetCareUsuarios();
          }

          return users;
     }

     //Metodo para obter Utilizadores.
     public Map<String, Utilizador> getUtilizadores()
     {
          return utilizadores;
     }


     //Metodo que Adicionará Utilizador Registado ao Mapa
     public static void AdicionarUtilizador()
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
     public static void RemoverUtilizador()
     {
          Scanner scanner = new Scanner(System.in);

          System.out.println("Insira o Numero do Cartao de Cidadao do Utilizador que deseja remover:");
          String numeroCC = scanner.nextLine();
          utilizadores.remove(numeroCC);
          System.out.println("Utilizador Removido com Sucesso!");

     }

     //Metodo usado para Exibir Informaçao dos Utilizadores.
     public static void ExibirUtilizador(Utilizador utilizador)
     {
          Scanner scanner = new Scanner(System.in);

          /*System.out.println("Insira o Numero do Cartao de Cidadao do Utilizador que deseja Ver:");
          String numeroCC = scanner.nextLine();
          Utilizador utilizador = utilizadores.get(numeroCC);*/

          System.out.println("===== Informaçao da Pessoa =====");

          System.out.println("Nome: " + utilizador.getNome());

          System.out.println("Número de Cartão de Cidadão: " + utilizador.getNumeroCC());

          System.out.println("Número Fiscal: " + utilizador.getNumeroFiscal());

          System.out.println("Telefone: " + utilizador.getTelefone());

          System.out.println("Morada: " + utilizador.getMorada());

          System.out.println("Localidade: " + utilizador.getMorada());

          System.out.println("================================");
     }

     public static Utilizador verificarLogin(String numeroCC, String password)
     {

          if(utilizadores.containsKey(numeroCC))
          {

               Utilizador utilizadorlogado = utilizadores.get(numeroCC);

               String teste = utilizadorlogado.getPassword();
               System.out.println("Teste:" + teste );
               if (utilizadorlogado.getPassword().equals(password))
               {
                    return  utilizadorlogado;
               }else
               {
                    return null;
               }
          }else
          {
               return null;
          }
     }

}
