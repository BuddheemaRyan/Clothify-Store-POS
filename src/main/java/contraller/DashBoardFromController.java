package contraller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import model.dto.*;
import service.DashBoardService;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class DashBoardFromController implements Initializable {

    DashBoardService dashBoardService = new DashBoardService();
    ObservableList<Item> orderObservableList = dashBoardService.getAllItem();
    ObservableList<Customer> customerObservableList = dashBoardService.getAllCustomer();
    ObservableList<Supplier> supplierObservableList = dashBoardService.getAllSupplier();
    ObservableList<Employee> employeeObservableList = dashBoardService.getAllEmployee();
    ObservableList<Item> itemObservableList = dashBoardService.getAllNewItem();
    ObservableList<Report> hitoryObservableList = FXCollections.observableArrayList();
    ObservableList<Order> hitoryItemObservableList = FXCollections.observableArrayList();
    String[] titleArray = {"Mr", "Mrs", "Miss", "Ms"};

    @FXML
    private Button btnCustomer;

    @FXML
    private Button btnHistory;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnItem;

    @FXML
    private Button btnOrder;

    @FXML
    private Button btnReport;

    @FXML
    private Button btnSetting;

    @FXML
    private Button btnSupplier;

    @FXML
    private TableColumn<?, ?> colCustomerAddress;

    @FXML
    private TableColumn<?, ?> colCustomerCity;

    @FXML
    private TableColumn<?, ?> colCustomerDOB;

    @FXML
    private TableColumn<?, ?> colCustomerId;

    @FXML
    private TableColumn<?, ?> colCustomerName;

    @FXML
    private TableColumn<?, ?> colCustomerPostalCode;

    @FXML
    private TableColumn<?, ?> colCustomerProvince;

    @FXML
    private TableColumn<?, ?> colCustomerTitle;

    @FXML
    private TableColumn<?, ?> colEmployeeAddress;

    @FXML
    private TableColumn<?, ?> colEmployeeDOB;

    @FXML
    private TableColumn<?, ?> colEmployeeId;

    @FXML
    private TableColumn<?, ?> colEmployeeJoinedDate;

    @FXML
    private TableColumn<?, ?> colEmployeeNIC;

    @FXML
    private TableColumn<?, ?> colEmployeeName;

    @FXML
    private TableColumn<?, ?> colEmployeePhone;

    @FXML
    private TableColumn<?, ?> colEmployeePosition;

    @FXML
    private TableColumn<?, ?> colEmployeeSalary;

    @FXML
    private TableColumn<?, ?> colEmployeeStatus;

    @FXML
    private TableColumn<?, ?> colOrderId;

    @FXML
    private TableColumn<?, ?> colOrderName;

    @FXML
    private TableColumn<?, ?> colOrderName1;

    @FXML
    private TableColumn<?, ?> colOrderPrice;

    @FXML
    private TableColumn<?, ?> colOrderPrice1;

    @FXML
    private TableColumn<?, ?> colOrderQty;

    @FXML
    private TableColumn<?, ?> colOrderQty1;

    @FXML
    private TableColumn<?, ?> colOrderSize;

    @FXML
    private TableColumn<?, ?> colOrderSize1;

    @FXML
    private TableColumn<?, ?> colOrderTotalPrice1;

    @FXML
    private TableColumn<?, ?> colSupplierAddress;

    @FXML
    private TableColumn<?, ?> colSupplierCity;

    @FXML
    private TableColumn<?, ?> colSupplierCompanyName;

    @FXML
    private TableColumn<?, ?> colSupplierEmail;

    @FXML
    private TableColumn<?, ?> colSupplierId;

    @FXML
    private TableColumn<?, ?> colSupplierName;

    @FXML
    private TableColumn<?, ?> colSupplierPhone;

    @FXML
    private TableColumn<?, ?> colSupplierPostalCode;

    @FXML
    private TableColumn<?, ?> colSupplierProvince;

    @FXML
    private TableColumn<?, ?> colItemCategory;

    @FXML
    private TableColumn<?, ?> colItemId;

    @FXML
    private TableColumn<?, ?> colItemIsAvailable;

    @FXML
    private TableColumn<?, ?> colItemName;

    @FXML
    private TableColumn<?, ?> colItemPrice;

    @FXML
    private TableColumn<?, ?> colItemQty;

    @FXML
    private TableColumn<?, ?> colItemSize;

    @FXML
    private TableColumn<?, ?> colOrderCustomerAddress;

    @FXML
    private TableColumn<?, ?> colOrderCustomerCity;

    @FXML
    private TableColumn<?, ?> colOrderCustomerDOB;

    @FXML
    private TableColumn<?, ?> colOrderCustomerId;

    @FXML
    private TableColumn<?, ?> colOrderCustomerName;

    @FXML
    private TableColumn<?, ?> colOrderCustomerPostalCode;

    @FXML
    private TableColumn<?, ?> colOrderCustomerProvince;

    @FXML
    private TableColumn<?, ?> colOrderCustomerTitle;

    @FXML
    private AnchorPane customerPane;

    @FXML
    private AnchorPane employeePane;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblOrderDiscount;

    @FXML
    private Label lblOrderItem;

    @FXML
    private Label lblOrderSubTotal;

    @FXML
    private Label lblOrderTotal;

    @FXML
    private Label lblTime;

    @FXML
    private AnchorPane orderPane;

    @FXML
    private AnchorPane supplierPane;

    @FXML
    private TableView<Customer> tblCustomer;

    @FXML
    private TableView<Employee> tblEmployee;

    @FXML
    private TableView<Item> tblOrder;

    @FXML
    private TableView<Item> tblOrder1;

    @FXML
    private TableView<Supplier> tblSupplier;

    @FXML
    private TableView<Customer> tblOrderCustomer;

    @FXML
    private TextField txtCustomerAddress;

    @FXML
    private TextField txtCustomerCity;

    @FXML
    private TextField txtCustomerId;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private TextField txtCustomerPostalCode;

    @FXML
    private TextField txtCustomerProvince;

    @FXML
    private TextField txtEmployeeAddress;

    @FXML
    private TextField txtEmployeeId;

    @FXML
    private TextField txtEmployeeName;

    @FXML
    private TextField txtEmployeeNic;

    @FXML
    private TextField txtEmployeePhone;

    @FXML
    private TextField txtEmployeePosition;

    @FXML
    private TextField txtEmployeeSalary;

    @FXML
    private TextField txtEmployeeStatus;

    @FXML
    private TextField txtOrderName;

    @FXML
    private TextField txtOrderPrice;

    @FXML
    private TextField txtOrderQty;

    @FXML
    private TextField txtOrderSearch;

    @FXML
    private TextField txtSupplierAddress;

    @FXML
    private TextField txtSupplierCity;

    @FXML
    private TextField txtSupplierCompanyName;

    @FXML
    private TextField txtSupplierEmail;

    @FXML
    private TextField txtSupplierId;

    @FXML
    private TextField txtSupplierName;

    @FXML
    private TextField txtSupplierPhone;

    @FXML
    private TextField txtSupplierPostalCode;

    @FXML
    private TextField txtSupplierProvince;

    @FXML
    private ChoiceBox<String> txtCustomerTitle;

    @FXML
    private DatePicker txtCustomerDate;

    @FXML
    private DatePicker txtEmployeeDOB;

    @FXML
    private DatePicker txtEmployeeJoinedDate;

    @FXML
    private AnchorPane itemPane;

    @FXML
    private TableView<Item> tblItem;

    @FXML
    private TextField txtItemCategory;

    @FXML
    private TextField txtItemId;

    @FXML
    private CheckBox txtItemIsAvailable;

    @FXML
    private TextField txtItemName;

    @FXML
    private TextField txtItemPrice;

    @FXML
    private TextField txtItemQty;

    @FXML
    private TextField txtItemSize;

    @FXML
    private Button btnEmployee;

    @FXML
    private Label lblDateName;

    @FXML
    private TextField txtDiscountField;

    @FXML
    private AnchorPane orderCustomerPane;

    @FXML
    private Label lblOrderCustomerId;

    @FXML
    private Label lblOrderCustomerName;

    @FXML
    private AnchorPane loginPane;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    private AnchorPane reportPane;

    @FXML
    private AnchorPane settingPane;

    @FXML
    private AnchorPane historyPane;

    @FXML
    private AnchorPane homePane;

    @FXML
    private TableColumn<?, ?> colHistoryCustomerId;

    @FXML
    private TableColumn<?, ?> colHistoryName;

    @FXML
    private TableColumn<?, ?> colHistoryOrderId;

    @FXML
    private TableView<Report> tblHistory;

    @FXML
    private DatePicker dateHistory;

    @FXML
    private TableColumn<?, ?> colHistoryItemDiscountPrice;

    @FXML
    private TableColumn<?, ?> colHistoryItemName;

    @FXML
    private TableColumn<?, ?> colHistoryItemPrice;

    @FXML
    private TableColumn<?, ?> colHistoryItemQty;

    @FXML
    private TableColumn<?, ?> colHistoryItemTotalPrice;

    @FXML
    private TableView<Order> tblHistoryItem;



    @FXML
    void btnCancelOrder(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "Do you want to cancel the order?",
                ButtonType.YES, ButtonType.NO);

        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            orderObservableList = dashBoardService.cancelOrder();
            orderPane.setVisible(false);
            orderCustomerPane.setVisible(true);
            btnCustomer.setDisable(false);
            btnHome.setDisable(false);
            btnEmployee.setDisable(false);
            btnHistory.setDisable(false);
            btnItem.setDisable(false);
            btnOrder.setDisable(false);
            btnReport.setDisable(false);
            btnSetting.setDisable(false);
            btnSupplier.setDisable(false);
        }
    }

    @FXML
    void btnCustomerAction(ActionEvent event) {
        customerPane.setVisible(true);
        employeePane.setVisible(false);
        supplierPane.setVisible(false);
        orderPane.setVisible(false);
        itemPane.setVisible(false);
        orderCustomerPane.setVisible(false);
        historyPane.setVisible(false);
        reportPane.setVisible(false);
        settingPane.setVisible(false);
        homePane.setVisible(false);
        btnCustomer.setStyle("-fx-background-color: #1e1e2f; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnHome.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnEmployee.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnHistory.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnItem.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnOrder.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnReport.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnSetting.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnSupplier.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
    }

    @FXML
    void btnEmployeeAction(ActionEvent event) {
        customerPane.setVisible(false);
        employeePane.setVisible(true);
        supplierPane.setVisible(false);
        orderPane.setVisible(false);
        itemPane.setVisible(false);
        orderCustomerPane.setVisible(false);
        historyPane.setVisible(false);
        reportPane.setVisible(false);
        settingPane.setVisible(false);
        homePane.setVisible(false);
        btnCustomer.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnHome.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnEmployee.setStyle("-fx-background-color: #1e1e2f; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnHistory.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnItem.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnOrder.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnReport.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnSetting.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnSupplier.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
    }

    @FXML
    void btnHomeAction(ActionEvent event) {
        customerPane.setVisible(false);
        employeePane.setVisible(false);
        supplierPane.setVisible(false);
        orderPane.setVisible(false);
        itemPane.setVisible(false);
        orderCustomerPane.setVisible(false);
        historyPane.setVisible(false);
        reportPane.setVisible(false);
        settingPane.setVisible(false);
        homePane.setVisible(true);
        btnCustomer.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnHome.setStyle("-fx-background-color: #1e1e2f; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnEmployee.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnHistory.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnItem.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnOrder.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnReport.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnSetting.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnSupplier.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
    }

    @FXML
    void btnItemAction(ActionEvent event) {
        tblOrder.refresh();
        customerPane.setVisible(false);
        employeePane.setVisible(false);
        supplierPane.setVisible(false);
        orderPane.setVisible(false);
        itemPane.setVisible(true);
        orderCustomerPane.setVisible(false);
        historyPane.setVisible(false);
        reportPane.setVisible(false);
        settingPane.setVisible(false);
        homePane.setVisible(false);
        btnCustomer.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnHome.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnEmployee.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnHistory.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnItem.setStyle("-fx-background-color: #1e1e2f; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnOrder.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnReport.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnSetting.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnSupplier.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
    }

    @FXML
    void btnOrderAction(ActionEvent event) {
        tblOrder.refresh();
        tblOrderCustomer.refresh();
        customerPane.setVisible(false);
        employeePane.setVisible(false);
        supplierPane.setVisible(false);
        orderPane.setVisible(false);
        itemPane.setVisible(false);
        orderCustomerPane.setVisible(true);
        historyPane.setVisible(false);
        reportPane.setVisible(false);
        settingPane.setVisible(false);
        homePane.setVisible(false);
        btnCustomer.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnHome.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnEmployee.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnHistory.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnItem.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnOrder.setStyle("-fx-background-color: #1e1e2f; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnReport.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnSetting.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnSupplier.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
    }

    @FXML
    void btnReportAction(ActionEvent event) {
        customerPane.setVisible(false);
        employeePane.setVisible(false);
        supplierPane.setVisible(false);
        orderPane.setVisible(false);
        itemPane.setVisible(false);
        orderCustomerPane.setVisible(false);
        historyPane.setVisible(false);
        reportPane.setVisible(true);
        settingPane.setVisible(false);
        homePane.setVisible(false);
        btnCustomer.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnHome.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnEmployee.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnHistory.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnItem.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnOrder.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnReport.setStyle("-fx-background-color: #1e1e2f; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnSetting.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnSupplier.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
    }

    @FXML
    void btnSettingAction(ActionEvent event) {
        customerPane.setVisible(false);
        employeePane.setVisible(false);
        supplierPane.setVisible(false);
        orderPane.setVisible(false);
        itemPane.setVisible(false);
        orderCustomerPane.setVisible(false);
        historyPane.setVisible(false);
        reportPane.setVisible(false);
        settingPane.setVisible(true);
        homePane.setVisible(false);
        btnCustomer.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnHome.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnEmployee.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnHistory.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnItem.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnOrder.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnReport.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnSetting.setStyle("-fx-background-color: #1e1e2f; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnSupplier.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
    }

    @FXML
    void btnSupplierAction(ActionEvent event) {
        customerPane.setVisible(false);
        employeePane.setVisible(false);
        supplierPane.setVisible(true);
        orderPane.setVisible(false);
        itemPane.setVisible(false);
        orderCustomerPane.setVisible(false);
        historyPane.setVisible(false);
        reportPane.setVisible(false);
        settingPane.setVisible(false);
        homePane.setVisible(false);
        btnCustomer.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnHome.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnEmployee.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnHistory.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnItem.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnOrder.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnReport.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnSetting.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnSupplier.setStyle("-fx-background-color: #1e1e2f; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
    }

    @FXML
    void bthHistoryAction(ActionEvent event) {
        customerPane.setVisible(false);
        employeePane.setVisible(false);
        supplierPane.setVisible(false);
        orderPane.setVisible(false);
        itemPane.setVisible(false);
        orderCustomerPane.setVisible(false);
        historyPane.setVisible(true);
        reportPane.setVisible(false);
        settingPane.setVisible(false);
        homePane.setVisible(false);
        btnCustomer.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnHome.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnEmployee.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnHistory.setStyle("-fx-background-color: #1e1e2f; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnItem.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnOrder.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnReport.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnSetting.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
        btnSupplier.setStyle("-fx-background-color: #2d3e50; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
    }

    @FXML
    void btnOrderSearchAction(ActionEvent event) {

    }

    @FXML
    void txtOrderSearchAction(ActionEvent event) {

    }

    @FXML
    void btnResetOrderAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Set current date
        lblDate.setText(LocalDate.now().toString());

        DateTimeFormatter dayFormat = DateTimeFormatter.ofPattern("EEEE");
        String dayName = LocalDate.now().format(dayFormat);
        lblDateName.setText(dayName);

        // Auto-updating time
        Timeline clock = new Timeline(
                new KeyFrame(Duration.ZERO, e -> {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                    lblTime.setText(LocalTime.now().format(formatter));
                }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();


        //-------------------------------------Order---------------------------------------------->
        colOrderId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colOrderName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colOrderSize.setCellValueFactory(new PropertyValueFactory<>("size"));
        colOrderPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colOrderQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblOrder.setItems(itemObservableList);
        tblOrder.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtOrderName.setText(newValue.getName());
            txtOrderPrice.setText(String.valueOf(newValue.getPrice()));
            txtOrderQty.setText("1");
        });

        tblOrder1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtOrderName.setText(newValue.getName());
            txtOrderPrice.setText(String.valueOf(newValue.getPrice()));
            txtOrderQty.setText(String.valueOf(newValue.getQty()));
        });

        //-------------------------------------------------customer--------------------------------------------->
        txtCustomerTitle.getItems().addAll(titleArray);
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCustomerTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCustomerDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colCustomerAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCustomerCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colCustomerProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colCustomerPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        tblCustomer.setItems(customerObservableList);

        tblCustomer.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtCustomerId.setText(newValue.getId());
            txtCustomerName.setText(newValue.getName());
            txtCustomerAddress.setText(newValue.getAddress());
            txtCustomerProvince.setText(newValue.getProvince());
            txtCustomerPostalCode.setText(newValue.getPostalCode());
            txtCustomerCity.setText(newValue.getCity());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(newValue.getDob(), formatter);
            txtCustomerDate.setValue(localDate);
            if (newValue.getTitle().equals("Mr")) {
                txtCustomerTitle.setValue(txtCustomerTitle.getItems().get(0));
            } else if (newValue.getTitle().equals("Mrs")) {
                txtCustomerTitle.setValue(txtCustomerTitle.getItems().get(1));
            } else if (newValue.getTitle().equals("Miss")) {
                txtCustomerTitle.setValue(txtCustomerTitle.getItems().get(2));
            } else if (newValue.getTitle().equals("Ms")) {
                txtCustomerTitle.setValue(txtCustomerTitle.getItems().get(3));
            }
        });

        //---------------------------------------Supplier---------------------------------------------->
        colSupplierId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colSupplierName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colSupplierCompanyName.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        colSupplierAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSupplierCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colSupplierProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colSupplierPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        colSupplierPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colSupplierEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        tblSupplier.setItems(supplierObservableList);

        tblSupplier.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtSupplierId.setText(newValue.getId());
            txtSupplierName.setText(newValue.getName());
            txtSupplierCompanyName.setText(newValue.getCompanyName());
            txtSupplierAddress.setText(newValue.getAddress());
            txtSupplierCity.setText(newValue.getCity());
            txtSupplierProvince.setText(newValue.getProvince());
            txtSupplierPostalCode.setText(newValue.getPostalCode());
            txtSupplierPhone.setText(newValue.getPhone());
            txtSupplierEmail.setText(newValue.getEmail());
        });

        //---------------------------------------Employee---------------------------------------------->
        colEmployeeId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colEmployeeName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmployeeNIC.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colEmployeeDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colEmployeePosition.setCellValueFactory(new PropertyValueFactory<>("position"));
        colEmployeeSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colEmployeePhone.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        colEmployeeAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colEmployeeStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colEmployeeJoinedDate.setCellValueFactory(new PropertyValueFactory<>("joinedDate"));
        tblEmployee.setItems(employeeObservableList);
        tblEmployee.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtEmployeeId.setText(newValue.getId());
            txtEmployeeName.setText(newValue.getName());
            txtEmployeeNic.setText(newValue.getNic());
            txtEmployeeDOB.setValue(LocalDate.parse(newValue.getDob()));
            txtEmployeePosition.setText(newValue.getPosition());
            txtEmployeeSalary.setText(String.valueOf(newValue.getSalary()));
            txtEmployeePhone.setText(newValue.getContactNumber());
            txtEmployeeAddress.setText(newValue.getAddress());
            txtEmployeeJoinedDate.setValue(LocalDate.parse(newValue.getJoinedDate()));
            txtEmployeeStatus.setText(newValue.getStatus());
        });

        //-------------------------------------------Item--------------------------------------------------->
        colItemId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colItemName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colItemCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colItemSize.setCellValueFactory(new PropertyValueFactory<>("size"));
        colItemPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colItemQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colItemIsAvailable.setCellValueFactory(new PropertyValueFactory<>("available"));
        tblItem.setItems(itemObservableList);
        tblItem.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtItemId.setText(newValue.getId());
            txtItemName.setText(newValue.getName());
            txtItemCategory.setText(newValue.getCategory());
            txtItemSize.setText(newValue.getSize());
            txtItemPrice.setText(String.valueOf(newValue.getPrice()));
            txtItemQty.setText(String.valueOf(newValue.getQty()));
            if (newValue.getAvailable()) {
                txtItemIsAvailable.setSelected(true);
            } else {
                txtItemIsAvailable.setSelected(false);
            }
        });

        //-------------------------------------------Order Customer-------------------------------------------->
        colOrderCustomerId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colOrderCustomerTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colOrderCustomerName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colOrderCustomerDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colOrderCustomerAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colOrderCustomerCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colOrderCustomerProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colOrderCustomerPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        tblOrderCustomer.setItems(customerObservableList);


    }

    //------------------------------------Update Total Summary------------------------------------------>
    public void updateTotalSummary() {
        lblOrderItem.setText((tblOrder1.getItems().size()) + " Items");
        double subTotal = 0.0;
        for (Item item : tblOrder1.getItems()) {
            subTotal += item.getTotal();
        }
        lblOrderSubTotal.setText("Rs." + String.format("%.2f", subTotal));
        double netTotal = subTotal - ((subTotal * Integer.parseInt(txtDiscountField.getText())) / 100);
        lblOrderTotal.setText("Rs." + String.format("%.2f", netTotal));

    }

    @FXML
    void txtDiscountFieldAction(ActionEvent event) {
        updateTotalSummary();
    }


    //-------------------------Select Customer-------------------------------------->
    @FXML
    void btnCustomerSelectOrderAction(ActionEvent event) {
        Customer selectedItem = tblOrderCustomer.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            lblOrderCustomerId.setText(selectedItem.getId());
            lblOrderCustomerName.setText(selectedItem.getName());
            orderCustomerPane.setVisible(false);
            orderPane.setVisible(true);
            btnCustomer.setDisable(true);
            btnHome.setDisable(true);
            btnEmployee.setDisable(true);
            btnHistory.setDisable(true);
            btnItem.setDisable(true);
            btnOrder.setDisable(true);
            btnReport.setDisable(true);
            btnSetting.setDisable(true);
            btnSupplier.setDisable(true);

        } else {
            new Alert(Alert.AlertType.INFORMATION, "Select Customer for Order").show();
        }
    }


    //------------------------------------------OrderPane----------------------------------------------->
    //------------------------------------------Add Order----------------------------------------------->
    @FXML
    void btnAddOrderAction(ActionEvent event) {
        Item selectedItem = tblOrder.getSelectionModel().getSelectedItem();
        int OrderQty = Integer.parseInt(txtOrderQty.getText());
        orderObservableList = dashBoardService.addItem(selectedItem, OrderQty);
        colOrderName1.setCellValueFactory(new PropertyValueFactory<>("name"));
        colOrderSize1.setCellValueFactory(new PropertyValueFactory<>("size"));
        colOrderQty1.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colOrderPrice1.setCellValueFactory(new PropertyValueFactory<>("price"));
        colOrderTotalPrice1.setCellValueFactory(new PropertyValueFactory<>("total"));
        tblOrder1.setItems(orderObservableList);
        updateTotalSummary();
        tblOrder1.refresh();
    }

    //--------------------------------------------Delete Order-------------------------------------------->
    @FXML
    void btnDeleteOrderAction(ActionEvent event) {
        dashBoardService.deleteOrder(tblOrder1.getSelectionModel().getSelectedItem());
        tblOrder1.refresh();
        updateTotalSummary();
    }

    //------------------------------------------update Order---------------------------------------------->
    @FXML
    void btnUpdateOrderAction(ActionEvent event) {
        int qty = Integer.parseInt(txtOrderQty.getText());
        dashBoardService.updateOrder(tblOrder1.getSelectionModel().getSelectedItem(), qty);
        tblOrder1.refresh();
        updateTotalSummary();
    }


    //--------------------------------------------Place Order---------------------------------------->
    @FXML
    void btnPlaceOrder(ActionEvent event) {
        ObservableList<Item> placeOrders = tblOrder1.getItems();
        String cusId = lblOrderCustomerId.getText();
        double discount = Double.parseDouble(txtDiscountField.getText());
        String date = lblDate.getText();
        dashBoardService.placeOrder(placeOrders, cusId, discount, date);
    }

    //-------------------------------------------Customer--------------------------------------------------->
    //----------------------------------------Add Customer-------------------------------------------------->
    @FXML
    void btnCustomerAddAction(ActionEvent event) {
        if (
                txtCustomerId.getText().isEmpty() ||
                        txtCustomerTitle.getValue() == null ||
                        txtCustomerName.getText().isEmpty() ||
                        txtCustomerDate.getValue() == null ||
                        txtCustomerCity.getText().isEmpty() ||
                        txtCustomerProvince.getText().isEmpty() ||
                        txtCustomerPostalCode.getText().isEmpty() ||
                        txtCustomerAddress.getText().isEmpty()
        ) {
            new Alert(Alert.AlertType.WARNING, "Please fill all fields before proceeding!").show();
        } else {
            Customer customer = new Customer(
                    txtCustomerId.getText(),
                    txtCustomerTitle.getValue(),
                    txtCustomerName.getText(),
                    String.valueOf(txtCustomerDate.getValue()),
                    txtCustomerAddress.getText(),
                    txtCustomerCity.getText(),
                    txtCustomerProvince.getText(),
                    txtCustomerPostalCode.getText()
            );
            dashBoardService.addCustomer(customer);
            tblCustomer.refresh();
        }
    }

    //----------------------------------------Delete Customer-------------------------------------------------->
    @FXML
    void btnCustomerDeleteAction(ActionEvent event) {
        dashBoardService.deleteCustomer(tblCustomer.getSelectionModel().getSelectedItem());
        tblCustomer.refresh();
    }

    //----------------------------------------Reset Customer-------------------------------------------------->
    @FXML
    void btnCustomerResetAction(ActionEvent event) {
        txtCustomerId.clear();
        txtCustomerName.clear();
        txtCustomerCity.clear();
        txtCustomerProvince.clear();
        txtCustomerPostalCode.clear();
        txtCustomerAddress.clear();
        txtCustomerTitle.setValue(null);
        txtCustomerDate.setValue(null);
    }

    //----------------------------------------Update Customer-------------------------------------------------->
    @FXML
    void btnCustomerUpdateAction(ActionEvent event) {
        if (
                txtCustomerId.getText().isEmpty() ||
                        txtCustomerTitle.getValue() == null ||
                        txtCustomerName.getText().isEmpty() ||
                        txtCustomerDate.getValue() == null ||
                        txtCustomerCity.getText().isEmpty() ||
                        txtCustomerProvince.getText().isEmpty() ||
                        txtCustomerPostalCode.getText().isEmpty() ||
                        txtCustomerAddress.getText().isEmpty()
        ) {
            new Alert(Alert.AlertType.WARNING, "Please fill all fields before proceeding!").show();
        } else {
            Customer customer = new Customer(
                    txtCustomerId.getText(),
                    txtCustomerTitle.getValue(),
                    txtCustomerName.getText(),
                    String.valueOf(txtCustomerDate.getValue()),
                    txtCustomerAddress.getText(),
                    txtCustomerCity.getText(),
                    txtCustomerProvince.getText(),
                    txtCustomerPostalCode.getText()
            );
            dashBoardService.updateCustomer(customer);
            tblCustomer.refresh();
        }
    }

    //--------------------------------------------Supplier---------------------------------------------->
    //--------------------------------------Add Supplier------------------------------------------------>
    @FXML
    void btnSupplierAddAction(ActionEvent event) {
        Supplier supplier = new Supplier(
                txtSupplierId.getText(),
                txtSupplierName.getText(),
                txtSupplierCompanyName.getText(),
                txtSupplierAddress.getText(),
                txtSupplierCity.getText(),
                txtSupplierProvince.getText(),
                txtSupplierPostalCode.getText(),
                txtSupplierPhone.getText(),
                txtSupplierEmail.getText()
        );
        dashBoardService.addSupplier(supplier);
    }

    //--------------------------------------Delete Supplier------------------------------------------------>
    @FXML
    void btnSupplierDeleteAction(ActionEvent event) {
        dashBoardService.deleteSupplier(tblSupplier.getSelectionModel().getSelectedItem().getId());
        tblSupplier.refresh();
    }

    //---------------------------------------Reset Supplier------------------------------------------------>
    @FXML
    void btnSupplierResetAction(ActionEvent event) {
        txtSupplierId.setText("");
        txtSupplierName.setText("");
        txtSupplierCompanyName.setText("");
        txtSupplierAddress.setText("");
        txtSupplierCity.setText("");
        txtSupplierProvince.setText("");
        txtSupplierPostalCode.setText("");
        txtSupplierPhone.setText("");
        txtSupplierEmail.setText("");
    }

    //---------------------------------------Update Supplier------------------------------------------------>
    @FXML
    void btnSupplierUpdateAction(ActionEvent event) {
        Supplier supplier = new Supplier(
                tblSupplier.getSelectionModel().getSelectedItem().getId(),
                txtSupplierName.getText(),
                txtSupplierCompanyName.getText(),
                txtSupplierAddress.getText(),
                txtSupplierCity.getText(),
                txtSupplierProvince.getText(),
                txtSupplierPostalCode.getText(),
                txtSupplierPhone.getText(),
                txtSupplierEmail.getText()
        );
        dashBoardService.updateSupplier(supplier);
        tblSupplier.refresh();
    }

    //--------------------------------------------Employee---------------------------------------------->
    //--------------------------------------Add Employee------------------------------------------------>
    @FXML
    void btnEmployeeAddAction(ActionEvent event) {
        dashBoardService.addEmployee(new Employee(
                txtEmployeeId.getText(),
                txtEmployeeName.getText(),
                txtEmployeeNic.getText(),
                txtEmployeeDOB.getValue().toString(),
                txtEmployeePosition.getText(),
                Double.parseDouble(txtEmployeeSalary.getText()),
                txtEmployeePhone.getText(),
                txtEmployeeAddress.getText(),
                txtEmployeeJoinedDate.getValue().toString(),
                txtEmployeeStatus.getText()
        ));


    }

    //--------------------------------------Delete Employee------------------------------------------------>
    @FXML
    void btnEmployeeDeleteAction(ActionEvent event) {
        dashBoardService.deleteEmployee(tblEmployee.getSelectionModel().getSelectedItem());
        tblEmployee.refresh();
    }

    //--------------------------------------Reset Employee------------------------------------------------>
    @FXML
    void btnEmployeeResetAction(ActionEvent event) {
        txtEmployeeId.clear();
        txtEmployeeName.clear();
        txtEmployeeNic.clear();
        txtEmployeeDOB.setValue(null);
        txtEmployeePosition.clear();
        txtEmployeeSalary.clear();
        txtEmployeePhone.clear();
        txtEmployeeAddress.clear();
        txtEmployeeJoinedDate.setValue(null);
        txtEmployeeStatus.clear();
    }

    //--------------------------------------Update Employee------------------------------------------------>
    @FXML
    void btnEmployeeUpdateAction(ActionEvent event) {
        dashBoardService.updateEmployee(new Employee(
                tblEmployee.getSelectionModel().getSelectedItem().getId(),
                txtEmployeeName.getText(),
                txtEmployeeNic.getText(),
                txtEmployeeDOB.getValue().toString(),
                txtEmployeePosition.getText(),
                Double.parseDouble(txtEmployeeSalary.getText()),
                txtEmployeePhone.getText(),
                txtEmployeeAddress.getText(),
                txtEmployeeJoinedDate.getValue().toString(),
                txtEmployeeStatus.getText()
        ));
        tblEmployee.refresh();
    }

    //-------------------------------------Item------------------------------------------------------------->
    //----------------------------Add Item------------------------------------------------------------------>
    @FXML
    void btnItemAddAction(ActionEvent event) {
        dashBoardService.addNewItem(
                new Item(
                        txtItemId.getText(),
                        txtItemName.getText(),
                        txtItemCategory.getText(),
                        txtItemSize.getText(),
                        Double.parseDouble(txtItemPrice.getText()),
                        Integer.parseInt(txtItemQty.getText()),
                        txtItemIsAvailable.isSelected(),
                        0.1
                )

        );
        tblItem.refresh();

    }

    @FXML
    void btnItemDeleteAction(ActionEvent event) {
        dashBoardService.deleteItem(tblItem.getSelectionModel().getSelectedItem());
        tblItem.refresh();
    }

    @FXML
    void btnItemResetAction(ActionEvent event) {
        txtItemId.clear();
        txtItemName.clear();
        txtItemCategory.clear();
        txtItemSize.clear();
        txtItemPrice.clear();
        txtItemQty.clear();
        txtItemIsAvailable.setSelected(false);

    }

    @FXML
    void btnItemUpdateAction(ActionEvent event) {
        dashBoardService.updateItem(new Item(
                tblItem.getSelectionModel().getSelectedItem().getId(),
                txtItemName.getText(),
                txtItemCategory.getText(),
                txtItemSize.getText(),
                Double.parseDouble(txtItemPrice.getText()),
                Integer.parseInt(txtItemQty.getText()),
                txtItemIsAvailable.isSelected(),
                0.1
        ));
        tblItem.refresh();
    }

    //---------------------------------------------Login Action--------------------------------------------------->
    @FXML
    void btnLoginAction(ActionEvent event) {
        String userName = txtUserName.getText();
        String password = txtPassword.getText();
        if (dashBoardService.login(userName, password)) {
            btnCustomer.setDisable(false);
            btnHome.setDisable(false);
            btnEmployee.setDisable(false);
            btnHistory.setDisable(false);
            btnItem.setDisable(false);
            btnOrder.setDisable(false);
            btnReport.setDisable(false);
            btnSetting.setDisable(false);
            btnSupplier.setDisable(false);
            btnHome.setStyle("-fx-background-color: #1e1e2f; " + "-fx-text-fill: white; " + "-fx-font-size: 21px;");
            loginPane.setVisible(false);
            homePane.setVisible(true);
        }
    }

    @FXML
    void btnpasswordAction(ActionEvent actionEvent) {
        if (txtPassword.getText().isEmpty()) {
            txtUserName.requestFocus();
        } else {
            btnLoginAction(actionEvent);
        }
    }

    @FXML
    void btnuserName(ActionEvent event) {
        txtPassword.requestFocus();
    }

    //------------------------------------------------------------------------------------------------------------->


    //--------------------------------------------History---------------------------------------------------------->
    @FXML
    void btnSearchDataHistoryAction(ActionEvent event) {
        LocalDate value = dateHistory.getValue();
        hitoryObservableList = dashBoardService.getAllHistory(value);
        for(Report report : hitoryObservableList){
            System.out.println(report);
        }
        colHistoryOrderId.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        colHistoryCustomerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colHistoryName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblHistory.setItems(hitoryObservableList);

        tblHistory.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            hitoryItemObservableList = dashBoardService.getAllOrderItem(tblHistory.getSelectionModel().getSelectedItem().getOrderId());
            colHistoryItemName.setCellValueFactory(new PropertyValueFactory<>("name"));
            colHistoryItemQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
            colHistoryItemPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
            colHistoryItemDiscountPrice.setCellValueFactory(new PropertyValueFactory<>("discountPrice"));
            colHistoryItemTotalPrice.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
            tblHistoryItem.setItems(hitoryItemObservableList);
        });
    }
}