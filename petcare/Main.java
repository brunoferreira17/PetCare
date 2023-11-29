package petcare;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    private static PetCareUsuarios petcareusuarios = new PetCareUsuarios();
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        //Inicio do Programma.
        do
        {
            Menus.MenuLogin();
            option = scanner.nextInt();
            Recursos.clearScreen();
            Menus.MenuLoginOptions(option);
        }while (option != 3);

    }

}
