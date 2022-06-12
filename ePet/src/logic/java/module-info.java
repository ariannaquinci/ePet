module com.example.epet {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires java.sql.rowset;


    opens com.example.epet to javafx.fxml;
    exports com.example.epet;
    exports view;
    exports viewmobile;
    opens viewmobile to javafx.fxml;
    opens view to javafx.fxml;
    exports utils;
    opens utils to javafx.fxml;
}