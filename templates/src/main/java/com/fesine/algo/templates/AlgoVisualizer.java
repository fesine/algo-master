package com.fesine.algo.templates;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

/**
 * @description: 类描述
 * @author: Fesine
 * @createTime:2018/2/10
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2018/2/10
 */
public class AlgoVisualizer {

    private Object data;
    private AlgoFrame frame;
    private boolean isAnimated = true;


    public AlgoVisualizer(int sceneWidth, int sceneHeight) {

        //TODO 初始化数据


        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("welcome", sceneWidth, sceneHeight);
            frame.addKeyListener(new AlgoKeyListener());
            frame.addMouseListener(new AlgoMouseListener());
            new Thread(() -> {
                run();
                return;
            }).start();
        });
    }

    /**
     * 动画动作
     */
    private void run() {
        //TODO 编写自己的动画逻辑

    }

    //TODO 根据情况决定是否实现键盘鼠标等交互事件监听器类

    private class AlgoKeyListener extends KeyAdapter {}
    private class AlgoMouseListener extends MouseAdapter {}

    public static void main(String[] args) {

        int sceneWidth = 600;
        int sceneHeight = 600;
        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight);
    }
}
