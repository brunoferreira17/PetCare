package petcare;

import petcare.users.Cliente;
import petcare.users.PrestadorDeServico;

import java.io.Serializable;
import java.util.Date;

public class Marcacao implements Serializable
{
    //Atributos das Marcaçoes
    private Cliente cliente;
    private PrestadorDeServico prestadordeservico;
    private Local local;
    private Date data;
    private TipoServico servico;
    private String estado;
    private double precofinal;


    //Construtor
    public Marcacao (Cliente cliente, PrestadorDeServico prestadordeservico, Local local, Date data, TipoServico servico, String estado, double precofinal)
    {
        this.cliente = cliente;
        this.prestadordeservico = prestadordeservico;
        this.local = local;
        this.data = data;
        this.servico = servico;
        this.estado = estado;
        this.precofinal = precofinal;
    }

    public Cliente getCliente()
    {
        return cliente;
    }

    public void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
    }

    public PrestadorDeServico getPrestadordeservico()
    {
        return prestadordeservico;
    }

    public void setPrestadordeservico(PrestadorDeServico prestadordeservico)
    {
        this.prestadordeservico = prestadordeservico;
    }

    public Local getLocal()
    {
        return local;
    }

    public void setLocal(Local local)
    {
        this.local = local;
    }

    public Date getData()
    {
        return data;
    }

    public void setData(Date data)
    {
        this.data = data;
    }

    public TipoServico getServico()
    {
        return  servico;
    }

    public void setServico(TipoServico servico)
    {
        this.servico = servico;
    }

    public String getEstado()
    {
        return estado;
    }

    public  void setEstado(String estado)
    {
        this.estado = estado;
    }

    public double getPrecofinal()
    {
        return precofinal;
    }

    public void setPrecofinal(double precofinal)
    {
        this.precofinal = precofinal;
    }

}
