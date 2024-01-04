package petcare;

import petcare.users.Funcionario;

import java.io.Serializable;
import java.util.ArrayList;

public class Local implements Serializable
{
    //Atributos do Local
    private String morada;
    private String localidade;
    private String contacto;
    ArrayList<Funcionario> funcionarios;

    //Construtor
    public Local (String morada, String localidade, String contacto)
    {
        this.morada = morada;
        this.localidade = localidade;
        this.contacto = contacto;
        this.funcionarios = new ArrayList<>();
    }

    //Getters e Setters
    public String getMorada()
    {
        return morada;
    }

    public void setMorada(String morada)
    {
        this.morada = morada;
    }

    public String getLocalidade()
    {
        return localidade;
    }

    public void setLocalidade(String localidade)
    {
        this.localidade = localidade;
    }

    public String getContacto()
    {
        return contacto;
    }

    public void setContacto(String contacto)
    {
        this.contacto = contacto;
    }

}
