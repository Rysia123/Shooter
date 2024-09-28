import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {
    static AnchorPane root = new AnchorPane();

    static final int WIDTH = 1200;
    static final int HEIGHT = 800;
    int enemyTime = 10;
    Circle shooter = new Circle(100, HEIGHT - 100, 70);

    Circle enemy = new Circle(WIDTH - 100, 100, 70);
    int points = 0;
    Text score = new Text(WIDTH - 100, HEIGHT - 100, points + "");





    public static void main(String[] args) {
        launch(args);

    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();

        ImageView background = new ImageView(new Image("file:hotel.png"));

        background.setFitWidth(WIDTH);
        background.setFitHeight(HEIGHT);

        root.getChildren().addAll(background,shooter, enemy, score);

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), event -> {
            if (enemyTime == 0) {

            }
        }));
    }
}

