module com.jz {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive java.sql;
    requires transitive javafx.graphics;
    requires atlantafx.base;

    opens com.jz to javafx.fxml;

    exports com.jz;
}
