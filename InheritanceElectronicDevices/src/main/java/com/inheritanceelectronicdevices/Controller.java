package com.inheritanceelectronicdevices;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private TabPane generalWindow;
    @FXML private Button laptopButtonAdd;
    @FXML private TextField laptopName;
    @FXML private TextField laptopPrice;
    @FXML private TextField laptopProcessorType;
    @FXML private TextField laptopRamSize;
    @FXML private TextField laptopStatus;
    @FXML private TextField laptopWeight;
    @FXML private Button listButtonDelete;
    @FXML private ListView<Device> listDevices;
    @FXML private ListView<String> listDeviceCharacteristics;
    @FXML private Button smartButtonAdd;
    @FXML private TextField smartCameraResolution;
    @FXML private TextField smartName;
    @FXML private TextField smartPrice;
    @FXML private TextField smartScreenSize;
    @FXML private TextField smartStatus;
    @FXML private TextField smartWeight;
    @FXML private TextField tabletBatteryLife;
    @FXML private Button tabletButtonAdd;
    @FXML private TextField tabletHasStylus;
    @FXML private TextField tabletName;
    @FXML private TextField tabletPrice;
    @FXML private TextField tabletStatus;
    @FXML private TextField tabletWeight;

    private ObservableList<Device> devices = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize ListView
        listDevices.setItems(devices);

        // Setup listeners
        setupButtonListeners();
        setupListViewListener();
    }

    private void setupButtonListeners() {
        // Smartphone Add Button
        smartButtonAdd.setOnAction(e -> {
            try {
                Smartphone smartphone = new Smartphone(
                        smartName.getText(),
                        Double.parseDouble(smartPrice.getText()),
                        Double.parseDouble(smartWeight.getText()),
                        Double.parseDouble(smartScreenSize.getText()),
                        Double.parseDouble(smartCameraResolution.getText())
                );
                devices.add(smartphone);
                clearSmartphoneFields();
                smartStatus.setText("Device was Added");
            } catch (Exception ex) {
                smartStatus.setText("Error!");
            }
        });

        // Laptop Add Button
        laptopButtonAdd.setOnAction(e -> {
            try {
                Laptop laptop = new Laptop(
                        laptopName.getText(),
                        Double.parseDouble(laptopPrice.getText()),
                        Double.parseDouble(laptopWeight.getText()),
                        Integer.parseInt(laptopRamSize.getText()),
                        laptopProcessorType.getText()
                );
                devices.add(laptop);
                clearLaptopFields();
                laptopStatus.setText("Device was Added");
            } catch (Exception ex) {
                laptopStatus.setText("Error!");
            }
        });

        // Tablet Add Button
        tabletButtonAdd.setOnAction(e -> {
            try {
                Tablet tablet = new Tablet(
                        tabletName.getText(),
                        Double.parseDouble(tabletPrice.getText()),
                        Double.parseDouble(tabletWeight.getText()),
                        Double.parseDouble(tabletBatteryLife.getText()),
                        Boolean.parseBoolean(tabletHasStylus.getText())
                );
                devices.add(tablet);
                clearTabletFields();
                tabletStatus.setText("Device was Added");
            } catch (Exception ex) {
                tabletStatus.setText("Error!");
            }
        });

        // Delete Button
        listButtonDelete.setOnAction(e -> {
            Device selectedDevice = listDevices.getSelectionModel().getSelectedItem();
            if (selectedDevice != null) {
                devices.remove(selectedDevice);
                listDeviceCharacteristics.getItems().clear();
            }
        });
    }

    private void setupListViewListener() {
        listDevices.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                updateDeviceCharacteristics(newValue);
            }
        });
    }

    private void updateDeviceCharacteristics(Device device) {
        ObservableList<String> characteristics = FXCollections.observableArrayList();
        characteristics.add("Name: " + device.getDeviceName());
        characteristics.add("Price: $" + device.getDevicePrice());
        characteristics.add("Weight: " + device.getDeviceWeight() + " g");
        characteristics.add("Type: " + device.getDeviceType());

        switch (device.getDeviceType()) {
            case SMARTPHONE:
                Smartphone smartphone = (Smartphone) device;
                characteristics.add("Screen Size: " + smartphone.getDeviceScreenSize() + "\"");
                characteristics.add("Camera: " + smartphone.getDeviceCameraResolution() + " MP");
                break;
            case LAPTOP:
                Laptop laptop = (Laptop) device;
                characteristics.add("RAM: " + laptop.getDeviceRamSize() + " GB");
                characteristics.add("Processor: " + laptop.getDeviceProcessorType());
                break;
            case TABLET:
                Tablet tablet = (Tablet) device;
                characteristics.add("Battery Life: " + tablet.getDeviceBatteryLife() + " hours");
                characteristics.add("Has Stylus: " + tablet.getDeviceHasStylus());
                break;
        }

        listDeviceCharacteristics.setItems(characteristics);
    }

    private void clearSmartphoneFields() {
        smartName.clear();
        smartPrice.clear();
        smartWeight.clear();
        smartScreenSize.clear();
        smartCameraResolution.clear();
    }

    private void clearLaptopFields() {
        laptopName.clear();
        laptopPrice.clear();
        laptopWeight.clear();
        laptopRamSize.clear();
        laptopProcessorType.clear();
    }

    private void clearTabletFields() {
        tabletName.clear();
        tabletPrice.clear();
        tabletWeight.clear();
        tabletBatteryLife.clear();
        tabletHasStylus.clear();
    }
}