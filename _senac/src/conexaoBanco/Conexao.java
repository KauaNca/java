/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexaoBanco;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Kaua33500476
 */
public class Conexao {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3307/kaua_sistema_biblioteca";
    private static final String USER = "root";
    private static final String PASS = "senac";

    public static Connection conexaoBanco() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados: " + e.getMessage());
            System.out.println("ERRO: " + e);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro no DRIVER");
            System.out.println("ERRO: " + e);

        }
        return null;
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
       
    }

    

}
