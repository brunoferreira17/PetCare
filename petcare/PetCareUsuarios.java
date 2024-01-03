package petcare;

import petcare.users.*;

import java.io.*;
import java.util.*;

public class PetCareUsuarios
{
     //Mapa onde vao ficar todos os usuarios.
     private static Map<String, Utilizador> utilizadores = new HashMap<>();
     //Mapa onde vao ficar apenas os usuarios Prestadores de Serviço.
     private static Map<String, PrestadorDeServico> prestadoresdeservico = new HashMap<>();
     //Mapa onde vao ficar apenas os usuarios Funcionarios.
     private static Map<String, Funcionario> funcionarios = new HashMap<>();
     //Mapa onde vao ficar apenas os usuarios Clientes.
     private static Map<String, Cliente> clientes = new HashMap<>();
     //Mapa onde vao ficar apenas os usuarios Clientes.
     private static Map<String, Admin> admins = new HashMap<>();

     //Metodo para obter Utilizadores.
     public static Map<String, Utilizador> getUtilizadores()
     {
          return utilizadores;
     }

     public static Map<String, PrestadorDeServico> getPrestadoresdeServico()
     {
          return prestadoresdeservico;
     }

     public static Map<String, Admin> getAdmins()
     {
          return admins;
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
                         clientes.put(novoUtilizador.getNome(), (Cliente) novoUtilizador);
                         System.out.println("Usuario Registado com Sucesso!");
                    }
                    if (novoUtilizador instanceof PrestadorDeServico)
                    {
                         utilizadores.put(numeroCC, novoUtilizador);
                         prestadoresdeservico.put(novoUtilizador.getNome(), (PrestadorDeServico) novoUtilizador);
                         System.out.println("Usuario Registado com Sucesso!");
                    }
                    if (novoUtilizador instanceof Funcionario)
                    {
                         utilizadores.put(numeroCC, novoUtilizador);
                         funcionarios.put(novoUtilizador.getNome(), (Funcionario) novoUtilizador);
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

     public static void AdicionarUtilizadorAdmin()
     {
          Utilizador novoUtilizador = Recursos.registoAdmin();

         String numeroCC = novoUtilizador.getNumeroCC();

         if (!utilizadores.containsKey(numeroCC)) {
              if (novoUtilizador instanceof Admin)
              {
                   utilizadores.put(numeroCC, novoUtilizador);
                   admins.put(novoUtilizador.getNome(), (Admin) novoUtilizador);
                   System.out.println("Usuario Registado com Sucesso!");
              }
         }
         else
         {
              System.out.println("Ja existe um Utilizador Com Esse Numero de Cartao de Cidadao!");
         }
     }

     //Metodo usado para remmover Utilizadores.
     public static void RemoverUtilizador()
     {
          Scanner scanner = new Scanner(System.in);

          System.out.println("Insira o Numero do Cartao de Cidadao do Utilizador que deseja remover:");
          String numeroCC = scanner.nextLine();

          if(utilizadores.containsKey(numeroCC))
          {
               Utilizador user = utilizadores.get(numeroCC);
               if(user != null)
               {
                    if(user instanceof Cliente)
                    {
                         utilizadores.remove(numeroCC, user);
                         clientes.remove(user.getNome(), (Cliente) user);
                    }
                    if (user instanceof PrestadorDeServico)
                    {
                         utilizadores.remove(numeroCC, user);
                         prestadoresdeservico.remove(user.getNome(), (PrestadorDeServico) user);
                    }
                    if (user instanceof Funcionario)
                    {
                         utilizadores.remove(numeroCC, user);
                         funcionarios.remove(user.getNome(), (Funcionario) user);
                    }
                    System.out.println("Utilizador Removido com Sucesso!");
               }else
               {
                    System.out.println("Erro!A voltar ao Menu...");
               }
          }else
          {
               System.out.println("Nao Existe Utilizador com esse Numero de Cartao de Cidadao!");
          }
     }

     //Metodo usado para Exibir Todos os Usuarios do Sistema.
     public static void ExibirTodosUtilizadores()
     {
          System.out.println("====Clientes no Sistema====");
          for(Cliente cliente : clientes.values())
          {
               System.out.println("Nome: " + cliente.getNome() +  " ,Numero CC: " + cliente.getNumeroCC() + " ,Morada: " + cliente.getMorada());
          }

          System.out.println("====Prestadores de Serviço no Sistema====");
          for(PrestadorDeServico prestador : prestadoresdeservico.values())
          {
               System.out.println("Nome: " + prestador.getNome() +  " ,Numero CC: " + prestador.getNumeroCC() + " ,Morada: " + prestador.getMorada());
          }

          System.out.println("====Funcionarios no Sistema====");
          for(Funcionario funcionario : funcionarios.values())
          {
               System.out.println("Nome: " + funcionario.getNome() +  " ,Numero CC: " + funcionario.getNumeroCC() + " ,Morada: " + funcionario.getMorada());
          }

          System.out.println("====Admins no Sistema====");
          for(Admin admin : admins.values())
          {
               System.out.println("Nome: " + admin.getNome() +  " ,Numero CC: " + admin.getNumeroCC() + " ,Morada: " + admin.getMorada());
          }

     }

     //Metodo usado para Exibir Informaçao dos Utilizadores.
     public static void ExibirUtilizador(Utilizador utilizador)
     {
          System.out.println("===== Informaçao da Pessoa =====");

          System.out.println("Nome: " + utilizador.getNome());

          System.out.println("Número de Cartão de Cidadão: " + utilizador.getNumeroCC());

          System.out.println("Número Fiscal: " + utilizador.getNumeroFiscal());

          System.out.println("Telefone: " + utilizador.getTelefone());

          System.out.println("Morada: " + utilizador.getMorada());

          System.out.println("Localidade: " + utilizador.getMorada());

          System.out.println("================================");
     }

     public static void EditarUtilizador(Utilizador utilizador)
     {

          utilizadores.remove(utilizador.getNumeroCC());

          PetCareUsuarios.ExibirUtilizador(utilizador);

          Utilizador editedutilizador = Recursos.editarUtilizador(utilizador);

          utilizadores.put(editedutilizador.getNumeroCC(),editedutilizador);

          System.out.println("-----Ediçao de Utilizador Completa----");
     }

     public static Utilizador verificarLogin(String numeroCC, String password)
     {
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

     public static void carregarDadosDoArquivo()
     {
          try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("dados")))
          {
               Object obj = inputStream.readObject();
               if (obj instanceof Map<?, ?>)
               {
                    Map<?, ?> data = (Map<?, ?>) obj;

                    // Verifica e atribui os HashMaps específicos
                    if (data.containsKey("utilizadores") && data.get("utilizadores") instanceof Map<?, ?>)
                    {
                         utilizadores = (Map<String, Utilizador>) data.get("utilizadores");
                    } else {
                         utilizadores = new HashMap<>();
                    }

                    if (data.containsKey("prestadoresdeservico") && data.get("prestadoresdeservico") instanceof Map<?, ?>)
                    {
                         prestadoresdeservico = (Map<String, PrestadorDeServico>) data.get("prestadoresdeservico");
                    } else {
                         prestadoresdeservico = new HashMap<>();
                    }

                    if (data.containsKey("funcionarios") && data.get("funcionarios") instanceof Map<?, ?>)
                    {
                         funcionarios = (Map<String, Funcionario>) data.get("funcionarios");
                    } else {
                         funcionarios = new HashMap<>();
                    }

                    if (data.containsKey("clientes") && data.get("clientes") instanceof Map<?, ?>)
                    {
                         clientes = (Map<String, Cliente>) data.get("clientes");
                    } else {
                         clientes = new HashMap<>();
                    }

                    if (data.containsKey("admins") && data.get("admins") instanceof Map<?, ?>)
                    {
                         admins = (Map<String, Admin>) data.get("admins");
                    } else {
                         admins = new HashMap<>();
                    }
               }
          } catch (FileNotFoundException e)
          {
               System.out.println("Arquivo não encontrado. Criando novo arquivo...");
               utilizadores = new HashMap<>();
               prestadoresdeservico = new HashMap<>();
               funcionarios = new HashMap<>();
               clientes = new HashMap<>();
               admins = new HashMap<>();
          } catch (IOException | ClassNotFoundException e)
          {
               e.printStackTrace();
          }
     }

     public static void salvarDadosParaArquivo()
     {
          Map<String, Object> data = new HashMap<>();
          data.put("utilizadores", utilizadores);
          data.put("prestadoresdeservico", prestadoresdeservico);
          data.put("funcionarios", funcionarios);
          data.put("clientes", clientes);
          data.put("admins", admins);

          try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("dados"))) {
               outputStream.writeObject(data);
          } catch (IOException e) {
               e.printStackTrace();
          }
     }
}