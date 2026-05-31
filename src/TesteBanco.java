import dao.ConnectionFactory;
import java.sql.Connection;

public class TesteBanco {

    public static void main(String[] args) {

        try {
            Connection conn = ConnectionFactory.conectar();

            if (conn != null) {
                System.out.println("Banco conectado!");
                conn.close();
            } else {
                System.out.println("Falha ao conectar!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}