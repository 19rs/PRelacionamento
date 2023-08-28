package br.com.senac.dao;

import br.com.senac.infra.ConexaoMySQL;
import br.com.senac.model.CategoriaModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriaDAO
{
    public void salvar(CategoriaModel categoria)
    {
        try
        {
            ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
            Connection conn = null;
            conn = conexaoMySQL.obterConexao();
            PreparedStatement stmt = null;

            stmt = conn.prepareStatement("INSERT INTO tb_categoria(descricao) VALUES (?)");
            stmt.setString(1, categoria.getDescricao());
            stmt.executeUpdate();
        }
        catch (Exception e1)
        {
            System.err.println(e1.getMessage());
        }
    }

    public CategoriaModel obterCategoriaPorID(int categoriaID)
    {
        CategoriaModel categoriaModel = null;

        try
        {
            ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
            Connection conn = null;
            conn = conexaoMySQL.obterConexao();
            PreparedStatement stmt = null;

            stmt = conn.prepareStatement("SELECT id, descricao FROM tb_categoria WHERE id = (?)");
            stmt.setInt(1, categoriaID);
            stmt.executeUpdate();
            ResultSet rs = stmt.getResultSet();
            rs.next();

            categoriaModel = new CategoriaModel();
            categoriaModel.setId(rs.getInt("id"));
            categoriaModel.setDescricao(rs.getString("descricao"));
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return categoriaModel;

    }
}
