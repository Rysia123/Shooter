import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;




public class Main extends Application {
    static AnchorPane root = new AnchorPane();

    static final int WIDTH = 1200;
    static final int HEIGHT = 800;
    Circle shooter = new Circle(100, HEIGHT - 100, 70);
    Image enemyImage = new Image("file:enemy-removebg-preview.png");
    Image enemyImage2 = new Image("file:enemy-removebg-preview2.png");
    //Circle enemy = new Circle(WIDTH - 100, 100, 70);
    ImageView enemy = new ImageView(enemyImage);
    Rectangle rectangleSmall = new Rectangle(WIDTH - 300, HEIGHT - 100, 90, 20);
    Rectangle rectangleBig = new Rectangle(WIDTH - 310, HEIGHT - 110, 110, 40);


    int points = 0;
    Text score = new Text(WIDTH - 100, HEIGHT - 60, points + "");


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
        scene.setFill(Color.FLORALWHITE);

        enemy.setLayoutY(100);
        enemy.setLayoutX(WIDTH - 150);

        root.getChildren().addAll(shooter, enemy, score, rectangleBig, rectangleSmall);
        score.setFont(Font.font(30));

        rectangleBig.setFill(Color.WHITE);

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), event -> {
            if (enemyTime == 0) {

            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}

