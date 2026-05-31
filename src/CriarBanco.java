import dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.Statement;

public class CriarBanco {

    public static void main(String[] args) {

        try (
            Connection conn = ConnectionFactory.conectar();
            Statement stmt = conn.createStatement()
        ) {

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS usuario (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nome TEXT NOT NULL,
                    senha TEXT NOT NULL
                )
            """);

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS movimentacao (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    descricao TEXT NOT NULL,
                    valor REAL NOT NULL,
                    tipo TEXT NOT NULL,
                    data TEXT NOT NULL
                )
            """);

            System.out.println("Tabelas criadas com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}