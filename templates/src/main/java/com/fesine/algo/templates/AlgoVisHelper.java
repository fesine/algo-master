package com.fesine.algo.templates;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * @description: 图形绘制工具类
 * @author: Fesine
 * @createTime:2018/2/10
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2018/2/10
 */
public class AlgoVisHelper {

    private AlgoVisHelper(){}

    public static final Color Red = new Color(0xF44336);
    public static final Color Pink = new Color(0xE91E63);
    public static final Color Purple = new Color(0x9C27B0);
    public static final Color DeepPurple = new Color(0x673AB7);
    public static final Color Indigo = new Color(0x3F51B5);
    public static final Color Blue = new Color(0x2196F3);
    public static final Color LightBlue = new Color(0x03A9F4);
    public static final Color Cyan = new Color(0x00BCD4);
    public static final Color Teal = new Color(0x009688);
    public static final Color Green = new Color(0x4CAF50);
    public static final Color LightGreen = new Color(0x8BC34A);
    public static final Color Lime = new Color(0xCDDC39);
    public static final Color Yellow = new Color(0xFFEB3B);
    public static final Color Amber = new Color(0xFFC107);
    public static final Color Orange = new Color(0xFF9800);
    public static final Color DeepOrange = new Color(0xFF5722);
    public static final Color Brown = new Color(0x795548);
    public static final Color Grey = new Color(0x9E9E9E);
    public static final Color BlueGrey = new Color(0x607D8B);
    public static final Color Black = new Color(0x000000);
    public static final Color White = new Color(0xFFFFFF);

    public static void setStrokeWidth(Graphics2D g2d,int w){
        g2d.setStroke(new BasicStroke(w,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
    }

    /**
     * 给定圆心坐标，半径长度绘制空心圆
     * @param g2d
     * @param x 圆心横坐标
     * @param y 圆心纵坐标
     * @param r 半径长度
     */
    public static void strokeCircle(Graphics2D g2d,int x,int y,int r){
        Ellipse2D circle = new Ellipse2D.Double(x-r, y-r, 2*r, 2*r);
        g2d.draw(circle);
    }

    /**
     * 给定圆心坐标，半径长度绘制实心圆
     * @param g2d
     * @param x 圆心横坐标
     * @param y 圆心纵坐标
     * @param r 半径长度
     */
    public static void fillCircle(Graphics2D g2d,int x,int y,int r){
        Ellipse2D circle = new Ellipse2D.Double(x-r, y-r, 2*r, 2*r);
        g2d.fill(circle);
    }

    /**
     * 绘制空心矩形
     * @param g
     * @param x
     * @param y
     * @param w
     * @param h
     */
    public static void strokeRectangle(Graphics2D g, int x, int y, int w, int h) {
        Rectangle2D rectangle = new Rectangle2D.Double(x, y, w, h);
        g.draw(rectangle);
    }

    /**
     * 绘制实心矩形
     * @param g
     * @param x
     * @param y
     * @param w
     * @param h
     */
    public static void fillRectangle(Graphics2D g, int x, int y, int w, int h) {
        Rectangle2D rectangle = new Rectangle2D.Double(x, y, w, h);
        g.fill(rectangle);
    }

    public static void setColor(Graphics2D g2d, Color color) {
        g2d.setColor(color);
    }

    public static void pause(int t){
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            System.out.println("Error in sleeping");
        }
    }

    /**
     * 添加图形
     * @param g
     * @param x
     * @param y
     * @param imageURL
     */
    public static void putImage(Graphics2D g, int x, int y, String imageURL) {

        ImageIcon icon = new ImageIcon(imageURL);
        Image image = icon.getImage();

        g.drawImage(image, x, y, null);
    }

    /**
     * 绘制文字
     * @param g
     * @param text
     * @param centerx
     * @param centery
     */
    public static void drawText(Graphics2D g, String text, int centerx, int centery) {

        if (text == null)
            throw new IllegalArgumentException("Text is null in drawText function!");

        FontMetrics metrics = g.getFontMetrics();
        int w = metrics.stringWidth(text);
        int h = metrics.getDescent();
        g.drawString(text, centerx - w / 2, centery + h);
    }
}
