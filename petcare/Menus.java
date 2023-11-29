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
                if(Menus.login()) ;
                break;
            case 2:
                Recursos.registo();
                break;



        }

    }

    //Metodo usado para fazer Login.
    public static boolean login()
    {
        Scanner login = new Scanner(System.in);

        Recursos.clearScreen();
        System.out.println("Insira o seu Numero de Cartao de Cidadao:");
        String numeroCC = login.nextLine();
        System.out.println("Insira o sua Password:");
        String password = login.nextLine();

        if(PetCareUsuarios.verificarLogin(numeroCC,password))
        {
            System.out.println("Login feito com Sucesso!");
            return true;
        }else
        {
            System.out.println("Os Dados que inseriu estao incorretos.");
            return false;
        }

    }

}


