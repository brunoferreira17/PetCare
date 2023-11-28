package petcare;

import petcare.users.Utilizador;

import java.util.Scanner;
public class Menus
{
    //Metodo do Menu Inicial
    public static void MenuLogin()
    {
        System.out.println("====Menu Login====");
        System.out.println("1-Login");
        System.out.println("2-Registrar Usuario");
        System.out.println("3-Sair do Programa");
        System.out.println("Escolha a sua opção:");
    }

    public static void MenuLoginOptions (int option)
    {
        switch (option)
        {
            case 1:
                Menus.login();
                break;
            case 2:
                Menus.registo();
                break;



        }

    }

    public static void login()
    {
        Scanner login = new Scanner(System.in);

        Recursos.clearScreen();
        System.out.println("Insira o seu NumeroFiscal:");
        String numerofiscal = login.nextLine();
        System.out.println("Insira o sua Password:");
        String password = login.nextLine();

    }

    public static void registo()
    {
        Scanner scanner = new Scanner(System.in);

        Recursos.clearScreen();
        System.out.println("===== Registro de Pessoa =====");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Número de Cartão de Cidadão: ");
        String numeroCC = scanner.nextLine();

        System.out.print("Número Fiscal: ");
        String numeroFiscal = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Morada: ");
        String morada = scanner.nextLine();

        System.out.print("Localidade: ");
        String localidade = scanner.nextLine();

        System.out.print("Localidade: ");
        String localidade = scanner.nextLine();


    }

}
