package com.hzauqkainan.ui.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test2 {
    //创建一个界面用于演示“事件”
    public static void main(String[] args) {
        //创建一个界面
        JFrame jFrame = new JFrame();
        //设置界面的宽高
        jFrame.setSize(608,608);
        //设置界面置顶
        jFrame.setAlwaysOnTop(true);
        //设置界面居中
        jFrame.setLocationRelativeTo(null);
        //取消默认的界面内部的居中放置
        jFrame.setLayout(null);
        //设置界面的关闭方式
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //创建一个按钮对象
        JButton jButton =new JButton("点击");
        //设置按钮出现在界面的位置
        jFrame.add(jButton);
        jButton.setBounds(0,0,100,50);
        //给jButton添加动作监听
        jButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按钮被点击了" );
            }
        });




        //设置界面显示
        jFrame.setVisible(true);
    }
}
