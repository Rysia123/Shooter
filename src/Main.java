import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.sound.sampled.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main extends Application {
    static AnchorPane root = new AnchorPane();

    List<ImageView> water = new ArrayList<>();





    static final int WIDTH = 1200;
    static final int HEIGHT = 800;

    static final int SIZE = 100;
   // Circle shooter = new Circle(100, HEIGHT - 100, 70);
    Image enemyImage = new Image("file:enemy-removebg-preview.png");
    Image enemyImage2 = new Image("file:enemy-removebg-preview2.png");
    Image shooterImage = new Image("file:shooter-removebg-preview.png");
    ImageView shooter = new ImageView(shooterImage);
    //Circle enemy = new Circle(WIDTH - 100, 100, 70);
    ImageView enemy = new ImageView(enemyImage);
    Rectangle healthBarSmall = new Rectangle(WIDTH - 300, HEIGHT - 100, SIZE, 20);
    Rectangle healthBarBig = new Rectangle(WIDTH - 310, HEIGHT - 110, SIZE+20, 40);
    Rectangle angerBarSmall = new Rectangle(WIDTH - 500, HEIGHT - 100, SIZE, 20);
    Rectangle angerBarBig = new Rectangle(WIDTH - 510, HEIGHT - 110, SIZE + 20, 40);

    static Image droplets = new Image("file:sweat-droplets-fotor-bg-remover-20240928124641.png");
    Rectangle rectangleSmall = new Rectangle(WIDTH - 300, HEIGHT - 100, 90, 20);
    Rectangle rectangleBig = new Rectangle(WIDTH - 310, HEIGHT - 110, 110, 40);

    AudioClip plonkSound = new AudioClip("file:videoplayback_y6EZG5Z.mp3");



    int points = 0;
    int enemyTime = 100;
    boolean turned = false;
    int calmingTime = 50;
    Text score = new Text(WIDTH - 100, HEIGHT - 60, points + "");




    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene scene = new Scene(root, WIDTH, HEIGHT);
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.SPACE) {
                shoot();
            }
        } );

        primaryStage.setScene(scene);
        primaryStage.show();
        scene.setFill(Color.FLORALWHITE);

        ImageView background = new ImageView("file:hotel.png");
        background.setFitHeight(HEIGHT);
        background.setFitWidth(WIDTH);

        enemy.setLayoutY(100);
        enemy.setLayoutX(WIDTH - 150);

        root.getChildren().addAll(background,shooter, enemy, score, healthBarBig, healthBarSmall, angerBarBig, angerBarSmall);
        score.setFont(Font.font(30));
        shooter.setLayoutY(HEIGHT - 250);
        shooter.setLayoutX(10);

        healthBarBig.setFill(Color.WHITE);
        angerBarBig.setFill(Color.WHITE);
        healthBarSmall.setFill(Color.GREEN);
        angerBarSmall.setFill(Color.RED);

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), event -> {
            if (enemyTime == 0) {
                enemy.setImage(enemyImage2);
                enemy.setLayoutY(100);
                enemy.setLayoutX(WIDTH - 200);
                turned = true;
                enemyTime = 100;
                angerBarSmall.setWidth(SIZE);

                plonkSound.play();
            }
            if (calmingTime == 0) {
                enemy.setImage(enemyImage);
                enemy.setLayoutY(100);
                enemy.setLayoutX(WIDTH - 150);
                calmingTime = 50;
                turned = false;


            }
            if(!turned){
                enemyTime--;
                angerBarSmall.setWidth(angerBarSmall.getWidth() - SIZE/100);
            }

            else{
                calmingTime--;


            }
            //movement
            for (int i = 0; i < water.size(); i++) {
                ImageView droplet = water.get(i);
                droplet.setLayoutX(droplet.getLayoutX() + 10);
                droplet.setLayoutY(droplet.getLayoutX() - 10);


            }


        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void shoot() {
        ImageView droplet = new ImageView(droplets);
        root.getChildren().add(droplet);
        water.add(droplet);
    }


    public static boolean detectCollision(ImageView enemy, ImageView droplet){
        double[] center1 = {enemy.getX() + enemy.getFitWidth()/2,enemy.getY() + enemy.getFitHeight()/2};
        double[] center2 = {droplet.getX() + droplet.getFitWidth()/2,droplet.getY() + droplet.getFitHeight()/2};
        double radious1 = enemy.getFitWidth()/2;
        double radious2 = enemy.getFitWidth()/2;
        if(radious1 + radious2 < Math.sqrt(Math.pow(center1[0] - center2[0],2) + Math.pow(center1[1] - center2[1],2))){
           return true;

         }


        return false;
    }


}

