package com.mycompany.d_java_banco_de_dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao_dois {
    
    public static void main(String[] args) {
        Connection conexao = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // Carregar o driver JDBC do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Estabelecer a conexão com o banco de dados
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/anime_db", "root", "SUASENHA");
            System.out.println("Conexão realizada com sucesso!");

            // Recuperar o nome do banco de dados
            stmt = conexao.createStatement();
            rs = stmt.executeQuery("SELECT DATABASE()");
            if (rs.next()) {
                String nomeBanco = rs.getString(1);
                System.out.println("Banco de dados atual: " + nomeBanco);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver não encontrado: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao acessar o banco: " + ex.getMessage());
        } finally {
            try {
                // Fechar ResultSet
                if (rs != null) {
                    rs.close();
                }
                // Fechar Statement
                if (stmt != null) {
                    stmt.close();
                }
                // Fechar Conexão
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
                System.out.println("Ocorreu um erro ao fechar os recursos: " + ex.getMessage());
            }
        }
    }
}
