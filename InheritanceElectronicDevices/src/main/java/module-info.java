module com.inheritanceelectronicdevices {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.inheritanceelectronicdevices to javafx.fxml;
    exports com.inheritanceelectronicdevices;
}