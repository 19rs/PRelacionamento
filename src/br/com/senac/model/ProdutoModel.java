package br.com.senac.model;

public class ProdutoModel
{
    private int id;
    private String descricao;
    private float valor;
    private CategoriaModel categoria;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public float getValor()
    {
        return valor;
    }

    public void setValor(float valor)
    {
        this.valor = valor;
    }

    public CategoriaModel getCategoria()
    {
        return categoria;
    }

    public void setCategoria(CategoriaModel categoria)
    {
        this.categoria = categoria;
    }
}
