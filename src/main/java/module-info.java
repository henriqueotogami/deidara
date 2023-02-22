module com.otogamidev.deidara {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.otogamidev.deidara.app to javafx.fxml;
    opens com.otogamidev.deidara.controllers to javafx.fxml;
    opens com.otogamidev.deidara.models to javafx.fxml;
    opens com.otogamidev.deidara.views to javafx.fxml;

    exports com.otogamidev.deidara.app;
    exports com.otogamidev.deidara.controllers;
    exports com.otogamidev.deidara.models;
    exports com.otogamidev.deidara.views;
}