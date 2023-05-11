import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {
    public static void main(String[] args) {
        String dbURL = "jdbc:derby:/path/to/database;create=true";
        try (Connection conn = DriverManager.getConnection(dbURL);
             Statement statement = conn.createStatement()) {
            // Crie uma tabela no banco de dados
            statement.executeUpdate("CREATE TABLE minha_tabela (id INT PRIMARY KEY, nome VARCHAR(255))");
            System.out.println("Banco de dados criado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
