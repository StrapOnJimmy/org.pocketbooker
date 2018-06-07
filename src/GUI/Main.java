package GUI;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.pocketbooker.entity.DataBase.Init;
import org.pocketbooker.entity.DefaultValues;
import org.pocketbooker.entity.model.Credit;
import org.pocketbooker.entity.model.Debit;

import java.util.List;


public class Main extends Application{

    private Stage primaryStage;
    private BorderPane pocketBookerUI;
    private ObservableList<Debit> debits = FXCollections.observableArrayList();
    private ObservableList<Credit> credits = FXCollections.observableArrayList();
    private ObservableList<Object> commonList = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Pocket Booker");
        initPocketBookerUI();
        showToolBar();
        showTabsLayout();
    }

    @Override
    public void init() throws Exception {
        Init.init();
    }

    public Main() throws Exception {

        ConnectionSource connectionSource = new JdbcConnectionSource(DefaultValues.connectionSource);

        Dao<Debit, Integer> debitDao = DaoManager.createDao(connectionSource,Debit.class);

        List<Debit> debitList = debitDao.queryForAll();
        debits.addAll(debitList);

        Dao<Credit, Integer> creditDao = DaoManager.createDao(connectionSource,Credit.class);

        List<Credit> creditList = creditDao.queryForAll();
        credits.addAll(creditList);

        commonList.addAll(credits);
        commonList.addAll(debits);
    }

    /**
     *initialize a main window of a pocket booker application
     */
    private void initPocketBookerUI() throws  Exception{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Main.class.getResource("pocketBookerUI.fxml"));
            pocketBookerUI = fxmlLoader.load();

            Scene scene = new Scene(pocketBookerUI);
            primaryStage.setScene(scene);
            primaryStage.show();
    }

    /**
     * shows a tool bar on pocket booker UI
     */
    private void showToolBar() throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Main.class.getResource("ToolsBarLayout.fxml"));
        AnchorPane toolsBarLayout = fxmlLoader.load();

        pocketBookerUI.setBottom(toolsBarLayout);
    }

    /**
     *shows a tab panes on pocket booker UI
     */

    private void showTabsLayout() throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Main.class.getResource("TabsLayout.fxml"));
        AnchorPane tabsLayout = fxmlLoader.load();

        pocketBookerUI.setCenter(tabsLayout);
        Controller controller = fxmlLoader.getController();
        controller.setMain(this);
    }

    /**
     * return primary stage
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * return the debit observable list
     * @return
     */
    public ObservableList<Debit> getDebits(){
        return debits;
    }

    /**
     * return the credit observable list
     * @return
     */
    public ObservableList<Credit> getCredits(){
        return credits;
    }

    public ObservableList<Object> getCommonList() {
        return commonList;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
