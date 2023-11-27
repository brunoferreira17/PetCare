package petcare.users;

import petcare.Local;

import java.util.ArrayList;
import java.util.List;

public class PrestadorDeServiço extends Utilizador
{
    private List<Local> locais;

    public PrestadorDeServiço (String nome, String numeroCC, String numeroFiscal, String telefone, String morada, String localidade)
    {
        super(nome, numeroCC, numeroFiscal, telefone, morada, localidade);
        this.locais = new ArrayList<>();
    }

}
