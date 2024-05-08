module AimsProject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.swing;
    requires java.naming;

    opens hust.soict.dsai.aims.screen;
    opens hust.soict.dsai.aims.media to javafx.base;
    opens hust.soict.dsai.aims.screen.controller;
}