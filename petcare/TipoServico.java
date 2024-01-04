package petcare;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//Class relativa aos serviço das marcaçoes
public class TipoServico implements Serializable
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

    public double getPrecoProdutos()
    {
        double precoProdutos = 0;

        for(Produto produto : produtos)
        {
            precoProdutos += produto.getPreco();
        }

        return  precoProdutos;
    }

    public void setPreco(double preco)
    {
        this.preco = preco;
    }

    public void adicionarProduto(Produto produto)
    {
        produtos.add(produto);
    }

}
