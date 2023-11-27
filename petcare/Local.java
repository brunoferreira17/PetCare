package petcare;

public class Local
{
    private String morada;
    private String localidade;
    private String contacto;
    private TipoServiço tiposerviço;

    public Local (String morada, String localidade, String contacto, TipoServiço tiposerviço)
    {
        this.morada = morada;
        this.localidade = localidade;
        this.contacto = contacto;
    }

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
