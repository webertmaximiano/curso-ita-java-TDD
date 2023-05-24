module com.webert.componentedegamificacao {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.webert.componentedegamificacao to javafx.fxml;
    exports com.webert.componentedegamificacao;
}