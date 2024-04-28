package com.example.bets_day8;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Catt {

    private Image image;
    private static double x;
    private static double y;
    private double width;
    private double height;
    private static ArrayList<Image> arrayList;
    private static int index;

    public void draw(GraphicsContext graphicsContext){
        if (arrayList.size() == 0){
            graphicsContext.drawImage(this.image, this.x, this.y,
                    this.width, this.height);
        } else {
            graphicsContext.drawImage(this.arrayList.get(this.index),
                    this.x, this.y, this.width, this.height);
            this.index++;
            if(index == arrayList.size()){
                index = 0;
            }
        }
    }

    public Catt() {
    }

    public Catt(Image image, double x, double y, double width, double height, ArrayList<Image> arrayList, int index) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.arrayList = arrayList;
        this.index = index;
    }

    //Конструктор для использования
    public Catt(Image image, double x, double y, double width, double height) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public static double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public static double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public ArrayList<Image> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Image> arrayList) {
        this.arrayList = arrayList;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
