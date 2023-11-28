package petcare;

public class Local
{
    //Atributos do Local
    private String morada;
    private String localidade;
    private String contacto;
    private TipoServiço tiposerviço;

    //Construtor
    public Local (String morada, String localidade, String contacto, TipoServiço tiposerviço)
    {
        this.morada = morada;
        this.localidade = localidade;
        this.contacto = contacto;
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
