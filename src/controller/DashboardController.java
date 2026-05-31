package controller;

import dao.MovimentacaoDAO;
import model.Movimentacao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class DashboardController {

    @FXML
    private TextField txtDescricao;

    @FXML
    private TextField txtValor;

    @FXML
    private ComboBox<String> cbTipo;

    @FXML
    private DatePicker dpData;

    @FXML
    private TableView<Movimentacao> tableMovimentacoes;

    @FXML
    private TableColumn<Movimentacao, String> colDescricao;

    @FXML
    private TableColumn<Movimentacao, Double> colValor;

    @FXML
    private TableColumn<Movimentacao, String> colTipo;

    @FXML
    private TableColumn<Movimentacao, LocalDate> colData;

    private ObservableList<Movimentacao> lista =
            FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        cbTipo.getItems().addAll("Lucro", "Prejuízo");

        dpData.setValue(LocalDate.now());

        colDescricao.setCellValueFactory(
                new PropertyValueFactory<>("descricao"));

        colValor.setCellValueFactory(
                new PropertyValueFactory<>("valor"));

        colTipo.setCellValueFactory(
                new PropertyValueFactory<>("tipo"));

        colData.setCellValueFactory(
                new PropertyValueFactory<>("data"));

        MovimentacaoDAO dao = new MovimentacaoDAO();

        lista.addAll(dao.listar());

        tableMovimentacoes.setItems(lista);
    }

    @FXML
    public void salvarMovimentacao() {

        try {

            Movimentacao movimentacao = new Movimentacao();

            movimentacao.setDescricao(txtDescricao.getText());

            movimentacao.setValor(
                    Double.parseDouble(txtValor.getText()));

            movimentacao.setTipo(cbTipo.getValue());

            movimentacao.setData(dpData.getValue());

            MovimentacaoDAO dao = new MovimentacaoDAO();

            dao.salvar(movimentacao);

            lista.add(movimentacao);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Sucesso");

            alert.setHeaderText(null);

            alert.setContentText("Movimentação adicionada!");

            alert.show();

            limparCampos();

        } catch (Exception e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Erro");

            alert.setHeaderText(null);

            alert.setContentText("Preencha os campos corretamente!");

            alert.show();
        }
    }

    private void limparCampos() {

        txtDescricao.clear();

        txtValor.clear();

        cbTipo.setValue(null);

        dpData.setValue(LocalDate.now());
    }
}