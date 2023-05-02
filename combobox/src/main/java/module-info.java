module com.example.guiproject {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
                        requires org.kordamp.bootstrapfx.core;
            
    opens com.example.guiproject to javafx.fxml;
    exports com.example.guiproject;
}