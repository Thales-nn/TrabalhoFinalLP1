package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Sessao;
import model.Usuario;

public class CadastroController {

    @FXML
    private TextField txtNovoUsuario;

    @FXML
    private PasswordField txtNovaSenha;

    @FXML
    public void cadastrar() {

        String nome = txtNovoUsuario.getText();

        String senha = txtNovaSenha.getText();

        for(Usuario u : Sessao.usuarios) {

            if(u.getNome().equals(nome)) {

                Alert alert =
                        new Alert(Alert.AlertType.ERROR);

                alert.setTitle("Erro");

                alert.setHeaderText(null);

                alert.setContentText(
                        "Usuário já existe!");

                alert.show();

                return;
            }
        }

        Usuario usuario = new Usuario();

        usuario.setNome(nome);

        usuario.setSenha(senha);

        Sessao.usuarios.add(usuario);

        Alert alert =
                new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Sucesso");

        alert.setHeaderText(null);

        alert.setContentText(
                "Usuário cadastrado!");

        alert.show();

        txtNovoUsuario.clear();

        txtNovaSenha.clear();
    }
}