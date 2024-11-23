/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.d_java_banco_de_dados;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author kauan
 */
public class Conexao {

    // Constante para o driver JDBC do MySQL
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    
    // URL de conexão com o banco de dados "login"
    private static final String URL = "jdbc:mysql://localhost:3306/login";
    
    // Nome de usuário do banco de dados
    private static final String USER = "root";
    
    // Senha do banco de dados
    private static final String PASSWORD = "SUASENHA";

    // Método estático que retorna uma conexão com o banco de dados
    public static Connection conexaoBanco() throws SQLException {
        try {
            // Carrega a classe do driver JDBC
            Class.forName(DRIVER);
            // Imprime uma mensagem no console indicando que a conexão foi feita
            System.out.println("Conexão feita");
            // Retorna uma conexão estabelecida com o banco de dados usando as credenciais fornecidas
            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException ex) {
            // Caso o driver JDBC não seja encontrado, lança uma RuntimeException com a mensagem de erro
            throw new RuntimeException("Erro de banco de dados", ex);
        }
    }
}

