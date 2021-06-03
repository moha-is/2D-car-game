package carproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CarProject extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //======= main pane =======
        BorderPane bPane = new BorderPane();

        //======= car image =======
        Pane pane = new Pane();
        ImageView imageview = new ImageView("car.png");
        imageview.setX(230);
        imageview.setY(200);
        pane.getChildren().add(imageview);

        //======= button groub =======
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);

        Button up = new Button("UP");
        //======= Hbox pane =======
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(30);

        Button reset = new Button("RESET");
        Button rotatL = new Button("rotatL");
        Button left = new Button("LEFT");
        Button right = new Button("RIGHT");
        Button rotatR = new Button("rotatR");
        hbox.getChildren().addAll(rotatL, left, right, rotatR);

        Button down = new Button("DOWN");
        vbox.getChildren().addAll(up, hbox, down, reset);

        //======= add img and Pane to main BorderPane =======
        bPane.setCenter(pane);
        bPane.setBottom(vbox);
        bPane.setAlignment(pane, Pos.CENTER);
        bPane.setAlignment(vbox, Pos.BOTTOM_CENTER);

        //======= stage and scene =======
        Scene scene = new Scene(bPane, 500, 500);
        primaryStage.setTitle("car game");
        primaryStage.setScene(scene);
        primaryStage.show();

        //======= Actions =======
        //button
        up.setOnAction(e -> {
            imageview.setY(imageview.getY() - 10);
        });

        left.setOnAction(e -> {
            imageview.setX(imageview.getX() - 10);
        });

        right.setOnAction(e -> {
            imageview.setX(imageview.getX() + 10);
        });

        down.setOnAction(e -> {
            imageview.setY(imageview.getY() + 10);
        });

        reset.setOnAction(e -> {
            imageview.setX(230);
            imageview.setY(200);
            imageview.setRotate(0);
        });

        rotatL.setOnAction(e -> {
            imageview.setRotate(imageview.getRotate() - 10);
        });

        rotatR.setOnAction(e -> {
            imageview.setRotate(imageview.getRotate() + 10);
        });

        //drag
        imageview.setOnMouseDragged(e -> {
            imageview.setX(e.getX());
            imageview.setY(e.getY());
        });

        //key
        bPane.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case W:
                    imageview.setY(imageview.getY() - 10);
                    break;
                case A:
                    imageview.setX(imageview.getX() - 10);
                    break;
                case D:
                    imageview.setX(imageview.getX() + 10);
                    break;
                case S:
                    imageview.setY(imageview.getY() + 10);
                    break;
                case LEFT:
                    imageview.setRotate(imageview.getRotate() - 10);
                    break;
                case RIGHT:
                    imageview.setRotate(imageview.getRotate() + 10);
                    break;
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
