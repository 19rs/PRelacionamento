package br.com.senac.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL
{
    private String nomeServidor = "127.0.0.1";
    private String usuario = "root";
    private String senha = "senac";
    private String nomeBancoDados = "relacionamentodb";

    public Connection obterConexao() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); //instancia na memória a classe mySQL

        String url = "jdbc:mysql://" + this.nomeServidor + ":3306/" + this.nomeBancoDados;

        Connection connection = null;

        connection = DriverManager.getConnection(url, usuario, senha);
        return connection;
    }
}
