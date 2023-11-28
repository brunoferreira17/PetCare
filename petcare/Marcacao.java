package petcare;

import petcare.users.Cliente;
import petcare.users.PrestadorDeServico;

import java.util.Date;

public class Marcacao
{
    private Cliente cliente;
    private PrestadorDeServico prestadordeservico;
    private Local local;
    private Date data;
    private String estado;
    private double precofinal;

    public Marcacao (Cliente cliente, PrestadorDeServico prestadordeservico, Local local, Date data, String estado, double precofinal)
    {
        this.cliente = cliente;
        this.prestadordeservico = prestadordeservico;
        this.local = local;
        this.data = data;
        this.estado = estado;
        this.precofinal = precofinal;
    }

}
