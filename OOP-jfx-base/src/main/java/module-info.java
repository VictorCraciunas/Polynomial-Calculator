module com.jfxbase.oopjfxbase {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.jfxbase.oopjfxbase to javafx.fxml;
    exports com.jfxbase.oopjfxbase;
    exports com.jfxbase.oopjfxbase.utils;
    opens com.jfxbase.oopjfxbase.utils to javafx.fxml;
    exports com.jfxbase.oopjfxbase.utils.enums;
    opens com.jfxbase.oopjfxbase.utils.enums to javafx.fxml;
    exports com.jfxbase.oopjfxbase.controllers;
    opens com.jfxbase.oopjfxbase.controllers to javafx.fxml;
    exports com.jfxbase.oopjfxbase.AppLogic;
    opens com.jfxbase.oopjfxbase.AppLogic to javafx.fxml;
}