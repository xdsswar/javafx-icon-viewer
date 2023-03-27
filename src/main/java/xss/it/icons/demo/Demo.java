package xss.it.icons.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import xss.it.icons.demo.ctrl.Controller;

import java.io.IOException;
import java.util.Objects;

/**
 * @author XDSSWAR
 * Created on 03/27/2023
 */
public final class Demo extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Font Icons");
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResource("/xss/it/icons/demo/icon.png")).toExternalForm()));
        Parent parent=load("/xss/it/icons/demo/main.fxml",new Controller(stage));
        Scene scene=new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }


    /**
     * Load fxml
     * @param location String
     * @param controller Object
     * @return Parent
     * @throws IOException Err
     */
    private Parent load(final String location, Object controller) throws IOException {
        FXMLLoader loader=new FXMLLoader(Demo.class.getResource(location));
        loader.setController(controller);
        return loader.load();
    }
}
