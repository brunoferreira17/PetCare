package petcare;

import petcare.users.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Recursos
{
    //Metodo usado para Limpar o Terminal.
    public static void clearScreen()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int EscolhaFuncionario()
    {
        Scanner scanner = new Scanner(System.in);

        int tipofuncionario = 0;

        do{
            System.out.println("Seleciona o Tipo de Funcionario:");
            System.out.println("1-Veterinario");
            System.out.println("2-Educador De Animais");
            System.out.println("3-Auxiliares");
            System.out.println("4-Secretaria");
            System.out.println("5-Nenhuma Opçao");
            System.out.println("Escolha o Tipo:");
            tipofuncionario = scanner.nextInt();

        }while (tipofuncionario  > 5 || tipofuncionario < 1);

        return tipofuncionario;
    }

    public static Utilizador registo()
    {
        Scanner scanner = new Scanner(System.in);

        int tipousario;

        //Recolha da informaçao para Registo
        Recursos.clearScreen();
        System.out.println("===== Registro de Pessoa =====");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Número de Cartão de Cidadão: ");
        String numeroCC = scanner.nextLine();

        System.out.print("Password para o Login: ");
        String password = scanner.nextLine();

        System.out.print("Número Fiscal: ");
        String numeroFiscal = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Morada: ");
        String morada = scanner.nextLine();

        System.out.print("Localidade: ");
        String localidade = scanner.nextLine();

        //Escolha de tipo de utilizador
        do{

            System.out.println("Seleciona o Tipo de Utilizador:");
            System.out.println("1-Cliente");
            System.out.println("2-Prestador de Serviço");
            System.out.println("3-Sair do Registo");
            System.out.print("Escolha o Tipo:");
            tipousario = scanner.nextInt();

        }while (tipousario  > 4 || tipousario < 0);

        Utilizador novoUtilizador = null;

        switch (tipousario)
        {
            case 1:
                novoUtilizador = new Cliente(nome, numeroCC, password, numeroFiscal, telefone, morada, localidade);
                break;
            case 2:
                novoUtilizador = new PrestadorDeServico(nome, numeroCC, password, numeroFiscal, telefone, morada, localidade);
                break;
            default:
                System.out.println("Registo Cancelado.");
                return null;
        }

        return novoUtilizador;
    }

    public static Utilizador editarUtilizador(Utilizador utilizador)
    {
        Scanner scanner = new Scanner(System.in);

        String alterar;

        boolean validacao = false;

        do {
            int option = Menus.editarPage();
            switch (option)
            {
                case 1:
                    System.out.println("Qual Nome voce deseja:");
                    alterar = scanner.nextLine();

                    utilizador.setNome(alterar);
                    break;
                case 2:
                    System.out.println("Qual Numero do Cartao de Cidadao voce deseja:");
                    alterar = scanner.nextLine();

                    utilizador.setNumeroCC(alterar);
                    break;
                case 3:
                    System.out.println("Qual Numero Fiscal voce deseja:");
                    alterar = scanner.nextLine();

                    utilizador.setNumeroFiscal(alterar);
                    break;
                case 4:
                    System.out.println("Qual Numero de Telefone voce deseja:");
                    alterar = scanner.nextLine();

                    utilizador.setTelefone(alterar);
                    break;
                case 5:
                    System.out.println("Qual Morada voce deseja:");
                    alterar = scanner.nextLine();

                    utilizador.setMorada(alterar);
                    break;
                case 6:
                    System.out.println("Qual Localidade voce deseja:");
                    alterar = scanner.nextLine();

                    utilizador.setLocalidade(alterar);
                    break;
                case 7:
                    validacao = true;
                    break;
                default:
                    System.out.println("Opçao Invalida. Tente outra vez!");
                    break;
            }
        }while (!validacao);

        return utilizador;
    }

    public static Marcacao registomarcacao(Cliente Cliente)
    {
        Scanner scanner = new Scanner(System.in);

        LocalDate data = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        int tipousario;

        //Recolha da informaçao para Registo
        Recursos.clearScreen();
        System.out.println("===== Registro da Marcaçao =====");

        Map<String,PrestadorDeServico> prestadores = new HashMap<>();
        
        prestadores = PetCareUsuarios.getPrestadoresdeServico();

        if(prestadores.isEmpty())
        {
          System.out.println("Nao há Prestadores de Serviço Disponiveis!");
          return null;
        }

        boolean validacao = false;

        String prestadorescolhido;

       do
       {
           for (String prestador : prestadores.keySet()) {
               System.out.println("->" + prestador);
           }

           System.out.println("Escolha o Prestador de Serviço(Nome) para o Serviço ou escreva 'Cancelar' para cancelar a marcaçao:");
           prestadorescolhido = scanner.nextLine();

           if (prestadorescolhido.equalsIgnoreCase("cancelar")) {
               System.out.println("Marcaçao Cancelada");
               return null;
           }

           if(prestadores.containsKey(prestadorescolhido))
           {
               validacao = true;
           }else
           {
               System.out.println("Nao Existe Prestador com esse Nome!");
           }
       }while (!validacao);


       validacao = false;

       do
       {
           try {
               System.out.println("Escolha o Dia da Marcaçao(dd-MM-yyyy)");
               String dataescolhida = scanner.nextLine();

               data = LocalDate.parse(dataescolhida,formatter);

               validacao = true;
           } catch (Exception e) {
               System.out.println("Formato de data inválido.");
           }
       }while (!validacao);

       System.out.println("Escreva o Serviço que quer:");
       String servico = scanner.nextLine();

       TipoServico servicoescolhido = new TipoServico(servico, 0);

       System.out.println("Marcaçao Feita!");

       Marcacao novaMarcacao = new Marcacao(Cliente,prestadores.get(prestadorescolhido), null ,data ,servicoescolhido ,"Pendente", 0);

        return novaMarcacao;
    }
}


