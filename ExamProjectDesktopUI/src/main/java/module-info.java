module com.example.cli {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.xml;
    requires exp4j;
    requires com.fasterxml.jackson.databind;

    opens com.application to javafx.fxml;
    exports com.application;
}