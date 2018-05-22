package GUI;


import javafx.fxml.FXML;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.pocketbooker.entity.model.Credit;
import org.pocketbooker.entity.model.CreditTypes;
import org.pocketbooker.entity.model.Debit;
import org.pocketbooker.entity.model.DebitTypes;

import java.math.BigDecimal;
import java.util.Date;


public class Controller {

    @FXML
    private TableView<Credit> creditTableView;
    @FXML
    private TableColumn<Credit, Integer> idTableColumn;
    @FXML
    private TableColumn<Credit,Date> dateTableColumn;
    @FXML
    private TableColumn<Credit,BigDecimal> sumTableColumn;
    @FXML
    private TableColumn<Credit,String> currencyTableColumn;
    @FXML
    private TableColumn<Credit,CreditTypes> creditTypeTableColumn;

    @FXML
    private TableView<Debit> debitTableView;
    @FXML
    private TableColumn<Debit, Integer> debitIdTableColumn;
    @FXML
    private TableColumn<Debit,Date> debitDateTableColumn;
    @FXML
    private TableColumn<Debit,BigDecimal> debitSumTableColumn;
    @FXML
    private TableColumn<Debit,String> debitCurrencyTableColumn;
    @FXML
    private TableColumn<Debit,DebitTypes> debitTypeTableColumn;

    private Main main;

    public Controller() {
    }

    @FXML
    private void initialize(){
        /**
         * credit table initialize
         */
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("dateTime"));
        sumTableColumn.setCellValueFactory(new PropertyValueFactory<>("sum"));
        currencyTableColumn.setCellValueFactory(new PropertyValueFactory<>("currency"));
        creditTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("creditTypeName"));
        /**
         * dredit table initialize
         */
        debitIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        debitDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("dateTime"));
        debitSumTableColumn.setCellValueFactory(new PropertyValueFactory<>("sum"));
        debitCurrencyTableColumn.setCellValueFactory(new PropertyValueFactory<>("currency"));
        debitTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("debitTypeName"));
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) throws Exception{
        this.main = main;

        creditTableView.setItems(this.main.getCredits());
        debitTableView.setItems(this.main.getDebits());
    }
}
