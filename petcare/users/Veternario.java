package petcare.users;

import petcare.Main;

public class Veternario extends Funcionario
{
    String carteira;

    public Veternario(String nome, String numeroCC, String numeroFiscal, String telefone, String morada, String localidade, String password)
    {
        super(nome, numeroCC, numeroFiscal, telefone, morada, localidade, password);
        this.carteira = carteira;
    }

    public String getCarteira()
    {
        return carteira;
    }

    public void setCarteira(String carteira)
    {
        this.carteira = carteira;
    }
}
