package controller;

import model.Usuario;
import model.Sessao;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtSenha;

    @FXML
    public void entrar() {

        Usuario usuario = new Usuario();

        usuario.setNome(txtUsuario.getText());

        usuario.setSenha(txtSenha.getText());

        boolean encontrado = false;

        for(Usuario u : Sessao.usuarios) {

            if(u.getNome().equals(usuario.getNome()) &&
               u.getSenha().equals(usuario.getSenha())) {

                encontrado = true;

                break;
            }
        }

        if(encontrado) {

            try {

                FXMLLoader loader =
                        new FXMLLoader(getClass()
                        .getResource("/view/dashboard.fxml"));

                Scene scene =
                        new Scene(loader.load());

                Stage stage =
                        (Stage) txtUsuario
                        .getScene()
                        .getWindow();

                stage.setScene(scene);

                stage.show();

            } catch (Exception e) {

                e.printStackTrace();
            }

        } else {

            Alert alert =
                    new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Erro");

            alert.setHeaderText(null);

            alert.setContentText(
                    "Usuário ou senha inválidos!");

            alert.show();
        }
    }

    @FXML
    public void abrirCadastro() {

        try {

            FXMLLoader loader =
                    new FXMLLoader(getClass()
                    .getResource("/view/cadastro.fxml"));

            Scene scene =
                    new Scene(loader.load());

            Stage stage = new Stage();

            stage.setScene(scene);

            stage.setTitle("Cadastro");

            stage.show();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}