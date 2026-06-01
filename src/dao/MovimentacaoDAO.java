package dao;

import model.Movimentacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class MovimentacaoDAO {

    public void salvar(Movimentacao movimentacao) {

        String sql =
            "INSERT INTO movimentacao(descricao, valor, tipo, data, usuario_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, movimentacao.getDescricao());
            stmt.setDouble(2, movimentacao.getValor());
            stmt.setString(3, movimentacao.getTipo());
            stmt.setString(4, movimentacao.getData().toString());
            stmt.setInt(5, movimentacao.getUsuarioId());
            stmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Movimentacao> listarPorUsuario(int usuarioId) {

    List<Movimentacao> movimentacoes = new ArrayList<>();

    String sql =
        "SELECT * FROM movimentacao WHERE usuario_id = ?";

    try (Connection conn = ConnectionFactory.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, usuarioId);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Movimentacao movimentacao = new Movimentacao();

            movimentacao.setDescricao(
                rs.getString("descricao"));

            movimentacao.setValor(
                rs.getDouble("valor"));

            movimentacao.setTipo(
                rs.getString("tipo"));

            movimentacao.setData(
                LocalDate.parse(rs.getString("data")));

            movimentacao.setUsuarioId(
                rs.getInt("usuario_id")
            );

            movimentacoes.add(movimentacao);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return movimentacoes;
}
}