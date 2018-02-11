package com.fesine.algo.getpi;

import javax.swing.*;
import java.awt.*;

/**
 * @description: 类描述
 * @author: Fesine
 * @createTime:2018/2/10
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2018/2/10
 */
public class AlgoFrame extends JFrame {
    private static final long serialVersionUID = -212103718224798470L;

    private int canvasWidth;
    private int canvasHeight;

    public AlgoFrame(String title){
        this(title, 1024, 768);
    }

    public AlgoFrame(String title, int canvasWidth, int canvasHeight){
        super(title);
        this.canvasWidth=canvasWidth;
        this.canvasHeight=canvasHeight;
        AlgoCanvas canvas = new AlgoCanvas();
        setContentPane(canvas);
        pack();
        setSize(canvasWidth, canvasHeight);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public int getCanvasWidth() {
        return canvasWidth;
    }


    public int getCanvasHeight() {
        return canvasHeight;
    }

    //TODO 设置自己的数据
    private Object data;

    public void render(Object data){
        this.data=data;
        repaint();
    }

    private class AlgoCanvas extends JPanel{

        private static final long serialVersionUID = -9105108446016026356L;

        /**
         * 使用双缓存
         */
        public AlgoCanvas() {
            super(true);
        }

        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            //强转
            Graphics2D g2d = (Graphics2D) g;
            //打开抗锯齿
            RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.addRenderingHints(hints);
            //TODO 具体绘制
            //绘制自己的图形
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth,canvasHeight);
        }
    }

}
