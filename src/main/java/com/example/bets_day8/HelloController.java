package com.example.bets_day8;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Canvas Canv;

    @FXML
    private Button Bum;

    private Thread thread;

    private GraphicsContext graphicsContext;

    private void start(){
        //Прибулець
        Image image3 = new Image(String.valueOf(HelloController.class.getResource("Cat/Cat1.png")));
        Catt catt = new Catt(image3, 50, 50, 200, 200);
        ArrayList<Image> arrayListAl = new ArrayList<>();
        arrayListAl.add(image3);
        arrayListAl.add(new Image(String.valueOf(HelloController.class.getResource("Cat/Cat2.png"))));
        arrayListAl.add(new Image(String.valueOf(HelloController.class.getResource("Cat/Cat3.png"))));
        arrayListAl.add(new Image(String.valueOf(HelloController.class.getResource("Cat/Cat4.png"))));
        arrayListAl.add(new Image(String.valueOf(HelloController.class.getResource("Cat/Cat5.png"))));
        arrayListAl.add(new Image(String.valueOf(HelloController.class.getResource("Cat/Cat6.png"))));
        catt.setArrayList(arrayListAl);
        //Керування персонажем
        Platform.runLater(()->{
            Canv.getScene().addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
                System.out.println(keyEvent);
                if (keyEvent.getCode() == KeyCode.W){
                    catt.setY(catt.getY()-5);
                } else {
                    if (keyEvent.getCode() == KeyCode.S){
                        catt.setY(catt.getY()+5);
                    } else {
                        if (keyEvent.getCode() == KeyCode.D){
                            catt.setX(catt.getX()+5);
                        } else {
                            if (keyEvent.getCode() == KeyCode.A){
                                catt.setX(catt.getX()-5);
                            }
                        }
                    }
                }
            });
        });

        thread = new Thread(() -> {
            graphicsContext = Canv.getGraphicsContext2D();
            graphicsContext.setFill((Color.GREEN));
            //Виконувати поки потік не буде закритий
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(300); //Частота зміни кадрів
                } catch (InterruptedException e) {
                    return;
                }

                // Проверка выхода кота за границы холста
                if (catt.getX() < 0 || catt.getX() + catt.getWidth() > Canv.getWidth() ||
                        catt.getY() < 0 || catt.getY() + catt.getHeight() > Canv.getHeight()) {
                    // Установка координат кота в середину холста
                    catt.setX((Canv.getWidth() - catt.getWidth()) / 2);
                    catt.setY((Canv.getHeight() - catt.getHeight()) / 2);
                }

                // Очистка холста
                graphicsContext.clearRect(0, 0, Canv.getWidth(), Canv.getHeight());

                // Обновление изображения персонажа
                Platform.runLater(() -> {
                    catt.draw(graphicsContext);
                });
            }
        });



    }

    private boolean isThreadRunning = false;

    @FXML
    void initialize() {
        start();
        Bum.setOnAction(actionEvent -> {
            if (!isThreadRunning) {
                thread.start();
                isThreadRunning = true;
            }
        });
    }
}