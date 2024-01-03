package petcare;

import petcare.users.*;

import java.util.Scanner;
import java.util.InputMismatchException;


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

    //Metodo que executará as os Opçoes no Menu do Utilizador
    public static void MenuLoginOptions (int option)
    {

        switch (option)
        {
            case 1:
                Utilizador useron  = Menus.login();

                if (useron != null) {
                    Recursos.clearScreen();
                    //Verificar que Tipo de User é
                    if (useron instanceof Cliente) {
                        do {
                            Recursos.clearScreen();
                            int optionCliente = Menus.Clientepage();

                            switch (optionCliente) {
                                case 1:
                                    ((Cliente) useron).mostrarMarcacoesSimples();
                                    break;
                                case 2:
                                    ((Cliente) useron).marcarMarcacao();
                                    break;
                                case 3:
                                    PetCareUsuarios.EditarUtilizador(useron);
                                    break;
                                case 4:
                                    useron = null;
                                    break;
                            }
                        } while (useron != null);
                    }
                    if (useron instanceof PrestadorDeServico)
                    {
                        do {
                            Recursos.clearScreen();
                            int optionPrestador = Menus.Prestadorpage();

                            switch (optionPrestador) {
                                case 1:
                                    ((PrestadorDeServico) useron).mostrarMarcacoesSimples();
                                    break;
                                case 2:
                                    ((PrestadorDeServico) useron).mostrarMarcacoesSimples();
                                    ((PrestadorDeServico) useron).editarMarcacao();
                                    break;
                                case 3:
                                    ((PrestadorDeServico) useron).adicionarLocal();
                                    break;
                                case 4:
                                    ((PrestadorDeServico) useron).mostrarLocaisSimples();
                                    ((PrestadorDeServico) useron).editarLocal();
                                    break;
                                case 5:
                                    PetCareUsuarios.EditarUtilizador(useron);
                                case 6:
                                    useron = null;
                                    break;
                            }
                        } while (useron != null);
                    }
                    if (useron instanceof Admin)
                    {
                        do {
                            Recursos.clearScreen();
                            int optionAdmin = Menus.Funcionariopage();

                            switch (optionAdmin)
                            {
                                case 1:
                                    PetCareUsuarios.ExibirTodosUtilizadores();
                                    break;
                                case 2:
                                    PetCareUsuarios.RemoverUtilizador();
                                case 3:
                                    PetCareUsuarios.AdicionarUtilizadorAdmin();
                                    break;
                                case 4:
                                    useron = null;
                                    break;
                            }
                        } while (useron != null);
                    }
                    if(useron instanceof Funcionario)
                    {
                        do {
                            Recursos.clearScreen();
                            int optionFuncionario = Menus.Adminpage();

                            switch (optionFuncionario)
                            {
                                case 1:
                                    System.out.println("Operaçao Nao Funcional!");
                                    break;
                                case 2:
                                    useron = null;
                                    break;
                            }
                        } while (useron != null);

                    }

                }
                break;

            case 2:
                PetCareUsuarios.AdicionarUtilizador();
                break;

            case 3:
                System.out.println("Encerando o Programa...");
                break;

            default:
                System.out.println("Opçao Invalida Tente Outra vez!");
                break;
        }

    }

    //Metodo que Mostrará as Opçoes do Utilizador Cliente
    public static int Clientepage()
    {
        Scanner scanner = new Scanner(System.in);

        int option;
        do
        {
            System.out.println("====Menu Cliente====");
            System.out.println("1-Ver Marcaçoes.");
            System.out.println("2-Marcar Marcaçoes.");
            System.out.println("3-Alterar Informaçoes da Conta Pessoal.");
            System.out.println("4-Sair da Conta");
            System.out.print("Escolha a sua opção:");
            do {
                try {
                    option = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Tente novamente.");
                    scanner.nextLine(); // Limpar o buffer do scanner
                }
            } while (true);

        }while (option  > 4 || option < 0);

        return option;
    }

    //Metodo que Mostrará as Opçoes do Utilizador Prestador de Serviço
    public static int Prestadorpage()
    {
        Scanner scanner = new Scanner(System.in);

        int option;
        do
        {
            System.out.println("====Menu Prestador De Serviço====");
            System.out.println("1-Ver Marcaçoes.");
            System.out.println("2-Editar Marcaçoes.");
            System.out.println("3-Adicionar Local.");
            System.out.println("4-Alterar Informaçoes do Local.");
            System.out.println("5-Alterar Informaçoes da Conta Pessoal.");
            System.out.println("6-Sair da Conta.");
            System.out.print("Escolha a sua opção:");
            do {
                try {
                    option = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Tente novamente.");
                    scanner.nextLine(); // Limpar o buffer do scanner
                }
            } while (true);

        }while (option  > 6 || option < 0);

        return option;
    }

    public static int Adminpage()
    {
        Scanner scanner = new Scanner(System.in);

        int option;
        do
        {
            System.out.println("====Menu Admin====");
            System.out.println("1-Ver Usuarios.");
            System.out.println("2-Eliminar Usuarios.");
            System.out.println("3-Adicionar Utilizador Admin.");
            System.out.println("4-Sair da Conta.");
            System.out.print("Escolha a sua opção:");
            do {
                try {
                    option = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Tente novamente.");
                    scanner.nextLine(); // Limpar o buffer do scanner
                }
            } while (true);

        }while (option  > 4 || option < 0);

        return option;
    }

    public static int Funcionariopage()
    {
        Scanner scanner = new Scanner(System.in);

        int option;
        do
        {
            System.out.println("====Menu Funcionario====");
            System.out.println("1-Ver Marcaçoes.");
            System.out.println("2-Sair da Conta.");
            System.out.print("Escolha a sua opção:");
            do {
                try {
                    option = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Tente novamente.");
                    scanner.nextLine(); // Limpar o buffer do scanner
                }
            } while (true);

        }while (option  > 2 || option < 0);

        return option;
    }
    public static int editarPage()
    {
        Scanner scanner = new Scanner(System.in);

        int option;
        do
        {
            System.out.println("-----Ediçao de Utilizador----");
            System.out.println("1-Nome");
            System.out.println("2-Numero Do Cartao de Cidadao");
            System.out.println("3-Numero Fiscal");
            System.out.println("4-Telefone");
            System.out.println("5-Morada");
            System.out.println("6-Localidade");
            System.out.println("7-Nao alterar Nada");
            System.out.println("O que deseja mudar:");
            do {
                try {
                    option = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Tente novamente.");
                    scanner.nextLine(); // Limpar o buffer do scanner
                }
            } while (true);
        }while (option  > 7 || option < 0);

        return option;
    }

    public static int editarMarcacaoPage()
    {
        Scanner scanner = new Scanner(System.in);

        int option;
        do
        {
            System.out.println("-----Ediçao de Marcaçao----");
            System.out.println("1-Definir ou Alterar Estado da Marcaçao.");
            System.out.println("2-Definir ou Alterar Local da Marcaçao.");
            System.out.println("3-Adicionar Produto ao Serviço");
            System.out.println("4-Definir ou Alterar Preço do Serviço");
            System.out.println("5-Cancelar Marcaçao");
            System.out.println("6-Eliminar Marcaçao");
            System.out.println("7-Nao alterar Nada.");
            System.out.println("O que deseja mudar:");
            do {
                try {
                    option = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Tente novamente.");
                    scanner.nextLine(); // Limpar o buffer do scanner
                }
            } while (true);
        }while (option  > 7 || option < 0);

        return option;
    }

    public static int definirEstadoDaMarcacao()
    {
        Scanner scanner = new Scanner(System.in);

        int option;
        do
        {
            System.out.println("-----Definir Marcaçao como:----");
            System.out.println("1-Aguardando Pagamento");
            System.out.println("2-Confirmada");
            System.out.println("3-Realizada");
            System.out.println("4-Cancelada");
            System.out.println("5-Manter o mesmo estado");
            System.out.println("O que deseja mudar:");
            do {
                try {
                    option = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Tente novamente.");
                    scanner.nextLine(); // Limpar o buffer do scanner
                }
            } while (true);
        }while (option  > 5 || option < 0);

        return option;
    }

    public static int editarLocalPage()
    {
        Scanner scanner = new Scanner(System.in);

        int option;
        do
        {
            System.out.println("-----Ediçao de Local----");
            System.out.println("1-Definir ou Alterar Morada do Local.");
            System.out.println("2-Definir ou Alterar Localidade do Local.");
            System.out.println("3-Definir ou Alterar Contacto do Local.");
            System.out.println("4-Definir ou Alterar Funcionarios do Local");
            System.out.println("5-Eliminar Local");
            System.out.println("6-Nao alterar Nada");
            System.out.println("O que deseja mudar:");
            do {
                try {
                    option = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Tente novamente.");
                    scanner.nextLine(); // Limpar o buffer do scanner
                }
            } while (true);
        }while (option  > 6 || option < 0);

        return option;
    }
}


