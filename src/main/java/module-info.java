module com.dmd.testinterface {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.dmd.testinterface to javafx.fxml;
    exports com.dmd.testinterface;
}
