package dao;

import model.Movimentacao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MovimentacaoDAO {

    public void salvar(Movimentacao movimentacao) {

        String sql = "INSERT INTO movimentacao(descricao, valor, tipo, data) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, movimentacao.getDescricao());
            stmt.setDouble(2, movimentacao.getValor());
            stmt.setString(3, movimentacao.getTipo());
            stmt.setString(4, movimentacao.getData().toString());

            stmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}