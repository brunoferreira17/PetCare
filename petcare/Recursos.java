package petcare;

import petcare.users.*;

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

        System.out.println("Nome: ");
        String nome = scanner.nextLine();

        System.out.println("Número de Cartão de Cidadão: ");
        String numeroCC = scanner.nextLine();

        System.out.println("Password para o Login: ");
        String password = scanner.nextLine();

        System.out.println("Número Fiscal: ");
        String numeroFiscal = scanner.nextLine();

        System.out.println("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.println("Morada: ");
        String morada = scanner.nextLine();

        System.out.print("Localidade: ");
        String localidade = scanner.nextLine();

        //Escolha de tipo de utilizador
        do{

            System.out.println("Seleciona o Tipo de Utilizador:");
            System.out.println("1-Cliente");
            System.out.println("2-Prestador de Serviço");
            System.out.println("3-Funcionario");
            System.out.println("Escolha o Tipo:");
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
            case 3:

                //Caso o Utilizador selecione o Registo de Funcionario.
                int tipofuncionario = Recursos.EscolhaFuncionario();

                switch (tipousario)
                {
                    case 1:
                        novoUtilizador = new Funcionario(nome, numeroCC, password, numeroFiscal, telefone, morada, localidade, TipoFuncionario.Veterinario);
                        break;
                    case 2:
                        novoUtilizador = new Funcionario(nome, numeroCC, password, numeroFiscal, telefone, morada, localidade, TipoFuncionario.EducadorDeAnimais);
                        break;
                    case 3:
                        novoUtilizador = new Funcionario(nome, numeroCC, password, numeroFiscal, telefone, morada, localidade, TipoFuncionario.Auxiliares);
                        break;
                    case 4:
                        novoUtilizador = new Funcionario(nome, numeroCC, password, numeroFiscal, telefone, morada, localidade, TipoFuncionario.Secretaria);
                        break;
                    default:
                        System.out.println("Registo Cancelado.");
                        return null;
                }
                break;

            default:
                System.out.println("Registo Cancelado.");
                return null;
        }

        return novoUtilizador;
    }
}


