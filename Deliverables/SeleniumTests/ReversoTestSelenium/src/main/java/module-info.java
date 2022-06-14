module reversoseleniumtest.reversotestselenium {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.codeborne.selenide;
    requires selenium.api;
    requires selenium.chrome.driver;
    requires org.junit.jupiter.api;

    opens reversoseleniumtest.reversotestselenium to javafx.fxml;
    exports reversoseleniumtest.reversotestselenium;
}