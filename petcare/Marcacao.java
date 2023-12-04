package petcare;

import petcare.users.Cliente;
import petcare.users.PrestadorDeServico;

import javax.swing.*;
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
    public Marcacao (Cliente cliente, PrestadorDeServico prestadordeservico, Local local, Date data,TipoServico servico, String estado, double precofinal)
    {
        this.cliente = cliente;
        this.prestadordeservico = prestadordeservico;
        this.local = local;
        this.data = data;
        this.servico = servico;
        this.estado = estado;
        this.precofinal = precofinal;
    }

}
