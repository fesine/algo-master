package com.fesine.algo.money;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;

/**
 * @description: 类描述
 * @author: Fesine
 * @createTime:2018/2/10
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2018/2/10
 */
public class AlgoVisualizer {

    private static final int DELAY = 10;
    private int[] money;
    private AlgoFrame frame;


    public AlgoVisualizer(int sceneWidth, int sceneHeight) {

        // 初始化数据
        money=new int[100];
        for (int i = 0; i < money.length; i++) {
            money[i]=100;
        }

        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("welcome", sceneWidth, sceneHeight);
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
        //编写自己的动画逻辑
        while (true){
            //渲染之前进行排序
            Arrays.sort(money);
            frame.render(money);
            AlgoVisHelper.pause(DELAY);
            //加快转钱的频率
            for (int k = 0; k < 50; k++) {
                for (int i = 0; i < money.length; i++) {
                    //增加钱为负数的怦
                    //if(money[i]>0){
                        int j = new Random().nextInt(100);
                        while (i == j) {
                            j = new Random().nextInt(100);
                        }
                        money[i] -=1;
                        money[j] +=1;
                    //}
                }
            }
        }

    }

    public static void main(String[] args) {

        int sceneWidth = 1000;
        int sceneHeight = 600;
        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight);
    }
}
