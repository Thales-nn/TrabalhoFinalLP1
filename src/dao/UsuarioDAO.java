package dao;

import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    public void salvar(Usuario usuario) {

        String sql =
                "INSERT INTO usuario(nome, senha) VALUES (?, ?)";

        try (Connection conn = ConnectionFactory.conectar();
             PreparedStatement stmt =
                     conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSenha());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Usuario validarLogin(Usuario usuario) {

    String sql =
        "SELECT * FROM usuario WHERE nome = ? AND senha = ?";

    try (Connection conn = ConnectionFactory.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getSenha());

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            Usuario usuarioBanco = new Usuario();

            usuarioBanco.setId(
                rs.getInt("id"));

            usuarioBanco.setNome(
                rs.getString("nome"));

            usuarioBanco.setSenha(
                rs.getString("senha"));

            return usuarioBanco;
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;
}

    public boolean usuarioExiste(String nome) {

        String sql =
                "SELECT * FROM usuario WHERE nome = ?";

        try (Connection conn = ConnectionFactory.conectar();
             PreparedStatement stmt =
                     conn.prepareStatement(sql)) {

            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}