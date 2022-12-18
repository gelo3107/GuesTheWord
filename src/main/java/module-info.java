module com.example.guestheword {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.guestheword.gui to javafx.fxml;
    exports com.guestheword.gui;
    exports com.guestheword.controllers;
    opens com.guestheword.controllers to javafx.fxml;
    exports tests;
    opens tests to javafx.fxml;
}