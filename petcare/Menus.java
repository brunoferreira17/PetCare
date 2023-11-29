package petcare;

import petcare.users.*;

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
                Recursos.registo();
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

}


