package petcare;

import petcare.users.Utilizador;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PetCareUsuarios
{
     //Mapa onde vao ficar todos os usuarios.
     private Map<String, Utilizador> utilizadores = new HashMap<>();


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
     public void RemoverUsuario()
     {
          Scanner scanner = new Scanner(System.in);

          System.out.println("Insira o Numero do Cartao de Cidadao do Utilizador que deseja remover:");
          String numeroCC = scanner.nextLine();
          utilizadores.remove(numeroCC);
          System.out.println("Utilizador Removido com Sucesso!");

     }

}
