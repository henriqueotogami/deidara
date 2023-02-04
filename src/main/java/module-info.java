module com.otogamidev.deidara {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.otogamidev.deidara.controller to javafx.fxml;
    opens com.otogamidev.deidara.view to javafx.fxml;

    exports com.otogamidev.deidara.controller;
    exports com.otogamidev.deidara.view;
}