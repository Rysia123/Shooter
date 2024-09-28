import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.awt.*;


public class Main extends Application {
    static AnchorPane root = new AnchorPane();

    static final int WIDTH = 1200;
    static final int HEIGHT = 800;
    static final int STEP = 10;
    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();


       /* Image image = new javafx.scene.image.Image();
        ImageView iv1 = new ImageView();
        iv1.setImage(image);
*/
    }
}