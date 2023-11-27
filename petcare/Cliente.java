package petcare;

import java.util.ArrayList;
import java.util.List;


public class Cliente extends Utilizador
{
    private List<Marcaçao> marcaçoes;

    public Cliente(String nome, String numeroCC, String numeroFiscal, String telefone, String morada, String localidade)
    {
        super(nome, numeroCC, numeroFiscal, telefone, morada, localidade);
        this.marcaçoes = new ArrayList<>();
    }



}
