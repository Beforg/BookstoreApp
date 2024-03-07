package br.com.alura.app.bookstore;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Objects;


@SpringBootApplication
public class ScreenSoundsApplication extends Application {

    private ConfigurableApplicationContext applicationContext;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        String[] args = getParameters().getRaw().toArray(new String[0]);

        this.applicationContext = new SpringApplicationBuilder()
                .sources(ScreenSoundsApplication.class)
                .run(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/book-stack.png")));
        FXMLLoader loader =  new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        loader.setControllerFactory(this.applicationContext::getBean);
        Scene scene = new Scene(loader.load());
        primaryStage.setScene(scene);
        primaryStage.setTitle("BookStoreApp");
        primaryStage.getIcons().add(image);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    @Override
    public void stop() throws Exception {
        this.applicationContext.close();
    }

}
