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
                 Utilizador useron  = Menus.login();

                 if(useron == null)
                 {
                     break;
                 }else
                 {
                     Recursos.clearScreen();
                     //Verificar que Tipo de User é
                     if(useron instanceof Cliente)
                     {

                         int optionCliente = Menus.Clientepage();

                         switch (optionCliente)
                         {
                             case 1:((Cliente) useron).mostrarMarcacoesSimples();
                         }
                     }


                 }

            case 2:
                PetCareUsuarios.AdicionarUtilizador();
                break;



        }

    }


    //Metodo usado para fazer Login.
    public static Utilizador login()
    {

        Scanner login = new Scanner(System.in);

        Recursos.clearScreen();
        System.out.println("Insira o seu Numero de Cartao de Cidadao:");
        String numeroCC = login.nextLine();
        System.out.println("Insira o sua Password:");
        String password = login.nextLine();

        Utilizador user = PetCareUsuarios.verificarLogin(numeroCC,password);

        if(user != null)
        {
            System.out.println("Login feito com Sucesso!");
            return user;
        }else
        {
            System.out.println("Os Dados que inseriu estao incorretos.");
            return null;
        }

    }

    public static int Clientepage()
    {
        Scanner scanner = new Scanner(System.in);

        int option;
        do
        {
            System.out.println("====Menu Cliente====");
            System.out.println("1-Ver Marcaçoes.");
            System.out.println("2-Marcar Marcaçoes.");
            System.out.println("3-Editar Conta Pessoal.");
            System.out.println("4-Sair da Conta.");
            System.out.print("Escolha a sua opção:");
            option = scanner.nextInt();

        }while (option  > 4 || option < 0);

        return option;
    }

}


