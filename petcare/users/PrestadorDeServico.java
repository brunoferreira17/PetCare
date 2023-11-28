package petcare.users;

import petcare.Local;

import java.util.ArrayList;
import java.util.List;

public class PrestadorDeServico extends Utilizador
{
    private List<Local> locais;

    public PrestadorDeServico(String nome, String numeroCC, String numeroFiscal, String telefone, String morada, String localidade, String password)
    {
        super(nome, numeroCC, numeroFiscal, telefone, morada, localidade, password);
        this.locais = new ArrayList<>();
    }

}
