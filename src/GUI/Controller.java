package GUI;

import javafx.event.Event;
import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.pocketbooker.entity.model.Credit;
import org.pocketbooker.entity.model.CreditTypes;
import org.pocketbooker.entity.model.Debit;
import org.pocketbooker.entity.model.DebitTypes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;


public class Controller {
    @FXML
    private Label totalSumLabel;
    @FXML
    private Label creditTotalSumLabel;
    @FXML
    private Label debitTotalSumLabel;
    @FXML
    private TabPane mainTabPane;
    @FXML
    private Tab commonTab;
    @FXML
    private Tab creditTab;
    @FXML
    private Tab debitTab;
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

    @FXML
    private TableView<Object> commonTableView;
    @FXML
    private TableColumn<Object, Integer> commonIdTableColumn;
    @FXML
    private TableColumn<Object,Date> commonDateTableColumn;
    @FXML
    private TableColumn<Object,BigDecimal> commonSumTableColumn;
    @FXML
    private TableColumn<Object,String> commonCurrencyTableColumn;
    @FXML
    private TableColumn<Object,DebitTypes> commonTypeTableColumn;

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
        creditTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("TypeName"));
        /**
         * debit table initialize
         */
        debitIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        debitDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("dateTime"));
        debitSumTableColumn.setCellValueFactory(new PropertyValueFactory<>("sum"));
        debitCurrencyTableColumn.setCellValueFactory(new PropertyValueFactory<>("currency"));
        debitTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("TypeName"));
        /**
         * common table initialize
         */
        commonIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        commonDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("dateTime"));
        commonSumTableColumn.setCellValueFactory(new PropertyValueFactory<>("sum"));
        commonCurrencyTableColumn.setCellValueFactory(new PropertyValueFactory<>("currency"));
        commonTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("TypeName"));

        commonTab.setOnSelectionChanged(event -> {
            ArrayList sumsList = getTotalSums(commonTableView);
            totalSumLabel.setText(sumsList.get(0).toString());
            creditTotalSumLabel.setText(sumsList.get(1).toString());
            debitTotalSumLabel.setText(sumsList.get(2).toString());
        });

        creditTab.setOnSelectionChanged(event -> {
            ArrayList sumsList = getTotalSums(creditTableView);
            totalSumLabel.setText(sumsList.get(0).toString());
            creditTotalSumLabel.setText(sumsList.get(1).toString());
            debitTotalSumLabel.setText(sumsList.get(2).toString());
        });

        debitTab.setOnSelectionChanged(event -> {
            ArrayList sumsList = getTotalSums(debitTableView);
            totalSumLabel.setText(sumsList.get(0).toString());
            creditTotalSumLabel.setText(sumsList.get(1).toString());
            debitTotalSumLabel.setText(sumsList.get(2).toString());
        });

    }

    private void setCreditTableView(Main main) throws Exception {
        this.creditTableView.setItems(main.getCredits());
    }

    private void setDebitTableView(Main main) throws Exception{
        this.debitTableView.setItems(main.getDebits());
    }

    private void setCommonTableView(Main main) {
        this.commonTableView.setItems(main.getCommonList());
    }

    public void setMain(Main main) throws Exception{
        this.main = main;
        setCreditTableView(this.main);
        setDebitTableView(this.main);
        setCommonTableView(this.main);
        ArrayList sumsList = getTotalSums(commonTableView);
        totalSumLabel.setText(sumsList.get(0).toString());
        creditTotalSumLabel.setText(sumsList.get(1).toString());
        debitTotalSumLabel.setText(sumsList.get(2).toString());
    }

    private ArrayList getTotalSums(TableView tableView){
        ArrayList<BigDecimal> sums = new ArrayList<>();
        BigDecimal totalSum;
        BigDecimal creditTotalSum = BigDecimal.valueOf(0);
        BigDecimal debitTotalSum = BigDecimal.valueOf(0);
        for (Object item: tableView.getItems()
             ) {
            if (item.getClass() == Credit.class){
                Credit creditItem = (Credit) item;
                creditTotalSum = creditTotalSum.add(creditItem.getSum());
            } else if (item.getClass() == Debit.class){
                Debit debitItem = (Debit) item;
                debitTotalSum = debitTotalSum.add(debitItem.getSum());
            }
        }
        totalSum = debitTotalSum.subtract(creditTotalSum);
        sums.add(totalSum);
        sums.add(creditTotalSum);
        sums.add(debitTotalSum);
        return sums;

    }}
