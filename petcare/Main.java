package petcare;

import petcare.users.Admin;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {

        PetCareUsuarios.carregarDadosDoArquivo();

        PetCareUsuarios.getUtilizadores().put("admin", new Admin("admin","admin","admin","admin","admin","admin","admin"));
        PetCareUsuarios.getAdmins().put("admin", new Admin("admin","admin","admin","admin","admin","admin","admin"));
        Scanner scanner = new Scanner(System.in);
        boolean programa = false;
        int option;
        //Inicio do Programma..
        do
        {
            Menus.MenuLogin();
            option = scanner.nextInt();
            Recursos.clearScreen();
            Menus.MenuLoginOptions(option);
            if(option == 3)
            {
                programa = true;
            }
        }while (!programa);

        PetCareUsuarios.salvarDadosParaArquivo();
    }

}