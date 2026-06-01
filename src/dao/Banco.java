package dao;

import java.sql.Connection;
import java.sql.Statement;

public class Banco {

    public static void criarTabelas() {

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
                    data TEXT NOT NULL,
                    usuario_id INTEGER NOT NULL,
                    FOREIGN KEY(usuario_id) REFERENCES usuario(id)
                )
            """);

            System.out.println("Tabelas verificadas/criadas.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}