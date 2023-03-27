/**
 * @author XDSSWAR
 * Created on 03/27/2023
 */
module IconsDemo {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.icons;

    exports xss.it.icons.demo.ctrl;
    opens xss.it.icons.demo.ctrl;
    exports xss.it.icons.demo;
    opens xss.it.icons.demo;
}