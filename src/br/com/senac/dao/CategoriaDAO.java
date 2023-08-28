package br.com.senac.dao;

import br.com.senac.infra.ConexaoMySQL;
import br.com.senac.model.CategoriaModel;
import com.mysql.cj.x.protobuf.MysqlxSql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public ArrayList<CategoriaModel> listarTodos (int limite)
    {
        ArrayList<CategoriaModel> listaCategoria = null;

        try
        {
            ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
            Connection conn = null;
            conn = conexaoMySQL.obterConexao();
            PreparedStatement stmt = null;

            stmt = conn.prepareStatement("SELECT id, descricao FROM tb_categoria LIMIT ?");
            stmt.setInt(1, limite);
            stmt.executeUpdate();
            ResultSet rs = stmt.getResultSet();

            while(rs.next())
            {
                CategoriaModel categoriaModel = new CategoriaModel();
                categoriaModel.setId(rs.getInt("id"));
                categoriaModel.setDescricao(rs.getString(("descricao")));
                listaCategoria.add(categoriaModel);
            }
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return listaCategoria;
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

    public ArrayList<CategoriaModel> listarTodosComFiltro (String filtro, int limite)
    {
        ArrayList<CategoriaModel> listaCategoria = null;

        try
        {
            ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
            Connection conn = null;
            conn = conexaoMySQL.obterConexao();
            PreparedStatement stmt = null;

            String sql;
            if(filtro.isEmpty())
            {
                sql = "SELECT id, descricao FROM tb_categoria LIMIT ?";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, limite);
            }
            else
            {
                sql = "SELECT id, descricao FROM tb_categoria LIKE ? LIMIT ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, filtro);
                stmt.setInt(2, limite);
            }

            stmt.executeUpdate();
            ResultSet rs = stmt.getResultSet();

            while(rs.next())
            {
                CategoriaModel categoriaModel = new CategoriaModel();
                categoriaModel.setId(rs.getInt("id"));
                categoriaModel.setDescricao(rs.getString(("descricao")));
                listaCategoria.add(categoriaModel);
            }
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return listaCategoria;
    }
}


/* COM PAGINAÇÂO
public ArrayList<CategoriaModel> listarTodos (int limite, int pagina)
    {
        ArrayList<CategoriaModel> listaCategoria = null;

        try
        {
            ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
            Connection conn = null;
            conn = conexaoMySQL.obterConexao();
            PreparedStatement stmt = null;
            int offset = pagina * limite;

            stmt = conn.prepareStatement("SELECT id, descricao FROM tb_categoria LIMIT ? OFFSET ?");
            stmt.setInt(1, limite);
            stmt.setInt(2, offset);
            stmt.executeUpdate();
            ResultSet rs = stmt.getResultSet();

            while(rs.next())
            {
                CategoriaModel categoriaModel = new CategoriaModel();
                categoriaModel.setId(rs.getInt("id"));
                categoriaModel.setDescricao(rs.getString(("descricao")));
                listaCategoria.add(categoriaModel);
            }
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return listaCategoria;
    }
 */


