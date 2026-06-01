package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import dao.Banco;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Banco.criarTabelas();

        FXMLLoader loader =
            new FXMLLoader(getClass().getResource("/view/login.fxml"));

        Scene scene = new Scene(loader.load());

        scene.getStylesheets().add(
            getClass().getResource("/view/style.css").toExternalForm()
        );
        
        stage.setTitle("Gerenciador Financeiro");
        stage.setScene(scene);
        stage.show();
        
    }
}