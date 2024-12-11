
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3307/kaua_sistema_biblioteca";
    private static final String USER = "root";
    private static final String PASS = "senac";
    
    public static Connection conexao(){
        try{
            Class.forName(DRIVER);
            System.out.println("Conexão concluída");
            return DriverManager.getConnection(URL, USER, PASS);
        }catch(SQLException e){
           System.out.println("ERRO NA CONEXÃO DO BANCO DE DADOS: " + e.getMessage());
           e.printStackTrace();
        } catch (ClassNotFoundException ex) {
           System.out.println("ERRO NA CONEXAO DO DRIVER: " + ex.getMessage());
           ex.printStackTrace();
        }
        catch(Exception e){
            System.out.println("OCORREU UM ERRO INESPERADO");
        }
        
        return null;
    }
    public static void main(String []args){
        Conexao.conexao();
    }
}
