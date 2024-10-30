module src {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens src to javafx.fxml;
    exports src;
    
    requires java.sql;
    requires java.base;
}
    

