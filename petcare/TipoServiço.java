package petcare;

public class TipoServiço
{
    private String descriçao;
    private double preço;

    public TipoServiço(String descriçao,double preço)
    {
        this.descriçao = descriçao;
        this.preço = preço;
    }

    public String getDescriçao()
    {
        return descriçao;
    }

    public void setDescriçao(String descriçao)
    {
        this.descriçao = descriçao;
    }

    public double getPreço()
    {
        return preço;
    }

    public void setPreço(double preço)
    {
        this.preço = preço;
    }
}
