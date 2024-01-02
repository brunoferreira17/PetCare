package petcare;

import petcare.users.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
            System.out.println("3-Funcionario");
            System.out.println("4-Sair do Registo");
            System.out.print("Escolha o Tipo:");
            tipousario = scanner.nextInt();

        }while (tipousario  > 5 || tipousario < 1);

        int tipofuncionario = 0;
        String carteira = null;

        if(tipousario == 3)
        {
            do{
                System.out.println("Seleciona o Tipo de Funcionario:");
                System.out.println("1-Educador");
                System.out.println("2-Auxilar");
                System.out.println("3-Secretariado");
                System.out.println("4-Veternario");
                System.out.println("5-Sair do Registo");
                System.out.print("Escolha o Tipo:");
                tipofuncionario = scanner.nextInt();

            }while (tipofuncionario  > 5 || tipofuncionario < 1);
        }

        if(tipofuncionario == 4)
        {
            System.out.println("Insira a numero da Sua Carteira Profissional.");
            carteira = scanner.next();

            System.out.println(carteira);
        }

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
                switch (tipofuncionario)
                {
                    case 1:
                        novoUtilizador = new Educador(nome, numeroCC, password, numeroFiscal, telefone, morada, localidade);
                        break;
                    case 2:
                        novoUtilizador = new Auxiliar(nome, numeroCC, password, numeroFiscal, telefone, morada, localidade);
                        break;
                    case 3:
                        novoUtilizador = new Secretariado(nome, numeroCC, password, numeroFiscal, telefone, morada, localidade);
                        break;
                    case 4:
                        novoUtilizador = new Veternario(nome, numeroCC, password, numeroFiscal, telefone, morada, localidade,carteira);
                        break;
                    case 5:
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

    public static Utilizador registoAdmin()
    {
        Scanner scanner = new Scanner(System.in);

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

        Utilizador novoUtilizador = new Admin(nome,numeroCC,password,numeroFiscal,telefone,morada,localidade);

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

        //Recolha da informaçao para Registo
        Recursos.clearScreen();
        System.out.println("===== Registro da Marcaçao =====");

        Map<String,PrestadorDeServico> prestadores;
        
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

        return new Marcacao(Cliente,prestadores.get(prestadorescolhido), null ,data ,servicoescolhido ,"Pendente de Confirmaçao", 0);
    }

    public static Marcacao editarMarcacao(PrestadorDeServico prestador,Marcacao marcacao)
    {
        Scanner scanner = new Scanner(System.in);

        int option = Menus.editarMarcacaoPage();

        switch (option)
        {
            case 1:
                System.out.println("Estado Atual: " + marcacao.getEstado());
                int edicao = Menus.definirEstadoDaMarcacao();
                switch (edicao)
                {
                    case 1:
                        marcacao.setEstado("Aguardando Pagamento");
                        System.out.println("Estado Alterado com Sucesso!");
                        break;
                    case 2:
                        marcacao.setEstado("Confirmada");
                        System.out.println("Estado Alterado com Sucesso!");
                        break;
                    case 3:
                        marcacao.setEstado("Realizada");
                        System.out.println("Estado Alterado com Sucesso!");
                        break;
                    case 4:
                        marcacao.setEstado("Cancelada");
                        System.out.println("Estado Alterado com Sucesso!");
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Opçao Invalida");
                        break;
                }
                break;
            case 2:
                ArrayList<Local> locaisprestador;

                locaisprestador = (ArrayList<Local>) prestador.getLocais2();

                if (!locaisprestador.isEmpty())
                {
                    int counter = 1;
                    System.out.println("Locais do Prestador:");
                    for (Local local : locaisprestador)
                    {
                        System.out.println("----Local " + counter + " ----");
                        System.out.println("Morada: " + local.getMorada());
                        System.out.println("Localidade: " + local.getLocalidade());
                        System.out.println("-----------------------");
                        counter++;
                    }
                }else
                {
                    System.out.println("O Prestador nao tem nenhum Local no Programa.");
                    break;
                }

                System.out.println("Qual local deseja selecionar o Serviço");
                int localescolhido = scanner.nextInt();

                marcacao.setLocal(locaisprestador.get(localescolhido-1));
                System.out.println("Local Definido Com Sucesso!");
                break;
            case 3:
                System.out.println("Qual o nome do produto que deseja Adicionar:");
                String nomeproduto = scanner.next();

                System.out.println("Qual o Valor do Produto:");
                double precoproduto = scanner.nextDouble();

                if(nomeproduto != null)
                {
                    Produto produtousado = null;
                    produtousado.setNome(nomeproduto);
                    produtousado.setPreco(precoproduto);

                    TipoServico servicousado = marcacao.getServico();
                    servicousado.adicionarProduto(produtousado);
                    marcacao.setServico(servicousado);
                }
                break;
            case 4:

                TipoServico servicousado = marcacao.getServico();

                System.out.println("O preço Atual da Marcaçao é de " + marcacao.getPrecofinal() + " euros.");
                System.out.println("Que valor deseja o Serviço " + servicousado.getDescricao() + " : ");
                double precoServico = scanner.nextDouble();

                servicousado.setPreco(precoServico);

                marcacao.setServico(servicousado);
                System.out.println("Preço Atualizado com Sucesso!");
                break;
            case 5:
                marcacao.setEstado("Cancelada");
                System.out.println("Marcaçao Cancelada com Sucesso!");
                break;
            case 6:
                return null;
            case 7:
                System.out.println("A voltar ao Menu....");
                break;
        }

        return marcacao;
    }

    public static Local registoLocal()
    {
        Scanner scanner = new Scanner(System.in);

        Recursos.clearScreen();
        System.out.println("----Registo De Local----");
        System.out.println("Morada:");
        String morada = scanner.nextLine();

        System.out.println("Localidade:");
        String localidade = scanner.nextLine();

        System.out.println("Contacto:");
        String contacto = scanner.nextLine();

        return new Local(morada,localidade,contacto);

    }

    public static Local editarLocal(Local local)
    {
        Scanner scanner = new Scanner(System.in);

        int option = Menus.editarLocalPage();

        switch (option)
        {
            case 1:
                System.out.println("Morada Atual: " + local.getMorada());
                String Morada = scanner.nextLine();

                local.setMorada(Morada);
                System.out.println("Morada Alterada Com Sucesso!");
                break;
            case 2:
                System.out.println("Localidade Atual: " + local.getLocalidade());
                String Localidade = scanner.nextLine();

                local.setLocalidade(Localidade);
                System.out.println("Localidade Alterada Com Sucesso!");
                break;
            case 3:
                System.out.println("Contacto Atual: " + local.getContacto());
                String Contacto = scanner.nextLine();

                local.setContacto(Contacto);
                System.out.println("Contacto Alterado Com Sucesso!");
                break;
            case 4:
                //Alterar Funcionarios do Locao ...Por Fazer..
                break;
            case 5:
               return null;
            case 6:
                System.out.println("A voltar ao Menu....");
                break;
        }

        return local;
    }




}


