package com.hzauqkainan.ui.ui;

import javax.swing.*;

public class LoginJFrame extends JFrame {
    //创建一个登录界面
    public LoginJFrame(){
        //设置界面宽高
        this.setSize(488 , 430);
        //设置界面标题
        this.setTitle("宇宙超级无敌金刚拼图游戏 登录系统");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);



        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //显示界面
        this.setVisible(true);
    }
}
