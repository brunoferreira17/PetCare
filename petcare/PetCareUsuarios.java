package petcare;

import petcare.users.Cliente;
import petcare.users.PrestadorDeServico;
import petcare.users.Utilizador;

import java.util.*;

public class PetCareUsuarios
{
     //Mapa onde vao ficar todos os usuarios.
     private static Map<String, Utilizador> utilizadores = new HashMap<>();
     //Mapa onde vao ficar apenas os usuarios Prestadores de Serviço.
     private static Map<String, PrestadorDeServico> prestadoresdeservico = new HashMap<>();

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
     public static Map<String, PrestadorDeServico> getPrestadoresdeServico()
     {
          return prestadoresdeservico;
     }


     //Metodo que Adicionará Utilizador Registado ao Mapa
     public static void AdicionarUtilizador()
     {
          Utilizador novoUtilizador = Recursos.registo();

          if(novoUtilizador != null)
          {
               String numeroCC = novoUtilizador.getNumeroCC();
               if(!utilizadores.containsKey(numeroCC))
               {
                    if(novoUtilizador instanceof Cliente)
                    {
                         utilizadores.put(numeroCC, novoUtilizador);
                         System.out.println("Usuario Registado com Sucesso!");
                    } else if (novoUtilizador instanceof PrestadorDeServico)
                    {
                         utilizadores.put(numeroCC, novoUtilizador);
                         prestadoresdeservico.put(novoUtilizador.getNome(), (PrestadorDeServico) novoUtilizador);
                         System.out.println("Usuario Registado com Sucesso!");
                    }
               }else
               {
                    System.out.println("Ja existe um Utilizador Com Esse Numero de Cartao de Cidadao!");
               }
          }else
          {
               System.out.println("Registo Invalido!");
          }
     }

     //Metodo usado para remmover Utilizadores.
     public static void RemoverUtilizador()
     {
          Scanner scanner = new Scanner(System.in);

          System.out.println("Insira o Numero do Cartao de Cidadao do Utilizador que deseja remover:");
          String numeroCC = scanner.nextLine();

          Utilizador user = utilizadores.get(numeroCC);

          if(user instanceof Cliente)
          {
               utilizadores.remove(numeroCC);
          } else if (user instanceof PrestadorDeServico)
          {
               utilizadores.remove(numeroCC);
               prestadoresdeservico.remove(user.getNome());
          }
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
          Utilizador novoCliente = new Cliente("Bruno","12345","123","54321","961231","esp","apl");

          utilizadores.put("12345",novoCliente);

          if(utilizadores.containsKey(numeroCC))
          {

               Utilizador utilizadorlogado = utilizadores.get(numeroCC);
               
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
