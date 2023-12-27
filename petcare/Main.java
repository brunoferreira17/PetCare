package petcare;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {

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

    }

}
