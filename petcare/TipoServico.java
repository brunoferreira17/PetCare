package petcare;


import java.util.ArrayList;
import java.util.List;

//Class relativa aos serviço das marcaçoes
public class TipoServico
{
    private String descricao;
    private double preco;

    private List<Produto> produtos;

    public TipoServico(String descricao, double preco)
    {
        this.descricao = descricao;
        this.preco = preco;
        this.produtos = new ArrayList<>();
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public double getPreco()
    {
        return preco;
    }

    public void setPreco(double preco)
    {
        this.preco = preco;
    }
}
