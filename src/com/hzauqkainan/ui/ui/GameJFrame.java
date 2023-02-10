package com.hzauqkainan.ui.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Vector;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    //创建一个二位数组，用于管理数据
    int [][] date = new int[3][3];

    //用于记录“空白方块”在二维数组中的索引
    int x = 0;
    int y = 0;

    //方便更换图片
    String path = "..\\puzzleGame\\image\\view\\";

    //定义一个二维数组，用于存储正确的数据
    int [][] win = new int[][]{
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 0},
    };

    //计数器
    int step = 0;

    //创建一个游戏主界面
    public GameJFrame() {
        //初始化界面
        initJFrame();

        //初始化菜单
        initJMenuBar();

        //初始化数据(打乱图片顺序)
        initDate();

        //初始化图片(根据打乱后的结果去加载图片)
        initImage();

        //显示界面
        this.setVisible(true);
    }

    private void initDate() {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8,};
        Random r = new Random();

        //将数组内元素打乱后，遍历数组
        for (int i = 0; i < arr.length; i++) {
            //获取随即索引
            int temp = r.nextInt(arr.length);
            //记录正常顺序下数组中的元素
            int num = arr[i];
            //将随机索引与正常索引进行交换
            arr[i] = arr[temp];
            //将之前记录的”正常顺序下数组中的元素“赋值给随机索引，从而实现打乱顺序
            arr[temp]  = num;
        }

        //给二维数组添加数据
        int count = 0;
        for (int i = 0; i < date.length; i++) {
            for (int j = 0; j < date[i].length; j++) {
                //记录数组arr中的元素0的索引
                if (arr[count] == 0){
                    x = i;
                    y = j;
                }
                date [i][j] = arr[count];
                count++;
            }
        }
    }

    private void initImage() {
        //清空原本存在的所有图片
        this.getContentPane().removeAll();

        //显示胜利图标
        if (victory()){
            JLabel winJLabel = new JLabel(new ImageIcon("F:\\jerbrains\\idea\\idea projects\\puzzleGame\\image\\win.jpg"));
            winJLabel.setBounds(235,283,120,73);
            this.getContentPane().add(winJLabel);
        }

        //显示计数器
        JLabel stepCount = new JLabel("步数:" + step);
        stepCount.setBounds(50,30,100,20);
        this.getContentPane().add(stepCount);

        //添加拼图图片
        //外循环，表示在添加3张图片之后换行
        for (int i = 0; i < 3; i++) {
            //内循环，表示在一行里逐一添加3张图片
            for (int j = 0; j < 3; j++) {
                //创建一个“容器”的对象,同时创建一个图片的对象，并将图片添加到容器中
                JLabel jLabel = new JLabel(new ImageIcon( path + date[i][j] + ".jpg"));
                //设置图片的位置
                jLabel.setBounds(105 * j + 137, 105 * i + 185,105,105);
                //给图片添加边框
                jLabel.setBorder(new BevelBorder(0));
                //将图片和容器放入界面当中
                //getContentPane的作用是获取界面的隐藏容器
                this.getContentPane().add(jLabel);
            }
        }

        //添加背景图片
        //创建一个“容器”的对象,同时创建一个图片的对象，并将背景图片添加到容器中
        JLabel background = new JLabel(new ImageIcon("..\\puzzleGame\\image\\background.png"));
        //设置背景图片位置
        background.setBounds(40,40,508,560);
        //将背景图片添加到界面当中
        this.getContentPane().add(background);

        //刷新一次界面
        this.getContentPane().repaint();
    }

    private void initJMenuBar() {
        //初始化菜单
        JMenuBar jMenuBar = new JMenuBar();

        //在菜单中展示“功能、关于我们、充值入口”
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");
        JMenu rechargeJMenu = new JMenu("充值入口");

        //设置item
        JMenuItem replayItem = new JMenuItem("重新游戏");
        JMenuItem reLoginItem = new JMenuItem("重新登陆");
        JMenuItem closeItem = new JMenuItem("关闭游戏");

        JMenuItem accountItem = new JMenuItem("联系方式");

        JMenuItem rechargeItem = new JMenuItem("充值入口");

        //将item归入JMenu中
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);

        rechargeJMenu.add(rechargeItem);

        //给item绑定时间
        //重新游戏
        replayItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                step =0;
                initDate();
                initImage();
            }
        });
        //重新登录
        reLoginItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //关闭当前界面
                setVisible(false);
                //打开一个新的登陆界面
                new LoginJFrame();
            }
        });
        //关闭游戏
        closeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        //联系方式
        accountItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //创建一个弹窗对象
                JDialog jDialog = new JDialog();
                //设置弹窗宽、高
                jDialog.setSize(1000,1000);
                //创建一个容器保存联系方式图片
                JLabel jLabel = new JLabel(new ImageIcon("..\\puzzleGame\\image\\联系方式.jpg"));
                //设置图片位置
                jLabel.setBounds(0,0,258,258);
                //将图片加入弹窗中
                jDialog.getContentPane().add(jLabel);
                //让弹窗置顶
                jDialog.setAlwaysOnTop(true);
                //让弹窗居中
                jDialog.setLocationRelativeTo(null);
                //不关闭弹窗无法进行其他操作
                jDialog.setModal(true);
                //显示弹窗
                jDialog.setVisible(true);

            }
        });
        //充值入口
        rechargeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //创建一个弹窗对象
                JDialog jDialog = new JDialog();
                //设置弹窗宽、高
                jDialog.setSize(1000,1000);
                //创建一个容器保存联系方式图片
                JLabel jLabel = new JLabel(new ImageIcon("..\\puzzleGame\\image\\充值入口.jpg"));
                //设置图片位置
                jLabel.setBounds(0,0,258,258);
                //将图片加入弹窗中
                jDialog.getContentPane().add(jLabel);
                //让弹窗置顶
                jDialog.setAlwaysOnTop(true);
                //让弹窗居中
                jDialog.setLocationRelativeTo(null);
                //不关闭弹窗无法进行其他操作
                jDialog.setModal(true);
                //显示弹窗
                jDialog.setVisible(true);
            }
        });

        //将JMenu归入JMenubar中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);
        jMenuBar.add(rechargeJMenu);

        //给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        //设置界面宽高
        this.setSize(608, 680);
        //设置界面标题
        this.setTitle("宇宙超级无敌金刚拼图游戏 1.0测试版");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默认界面内部的居中放置
        this.setLayout(null);
        //给整个界面添加键盘监听时间
        this.addKeyListener(GameJFrame.this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //按下"a"键不松时，显示全部图片
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65){
        this.getContentPane().removeAll();
        //加载完整图片
        JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
        all.setBounds(83,134,420,420);
        this.getContentPane().add(all);
        //加载背景图片
        JLabel bg = new JLabel(new ImageIcon("..\\puzzleGame\\image\\background.png"));
        bg.setBounds(40,40,508,560);
        this.getContentPane().add(bg);
        //刷新一次
        this.getContentPane().repaint();
        }else {
            return;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        /*
        System.out.println(code);
        */

        //如果游戏胜利，则不能再继续移动图片
        if (victory()){
            return;
        }

        //左移：37；上移：38；右移：39；下移：40。
        if (code == 37){
            if (y == 0){
                return;
            }
            date[x][y] = date[x][y - 1];
            date[x][y - 1] = 0;
            y--;
            step++;
        }else if (code == 38){
             if (x ==0){
                return;
            }
            date[x][y] = date[x - 1][y];
            date[x - 1][y] = 0;
            x--;
            step++;
        }else if (code == 39){
            if (y == 2){
                return;
            }
            date[x][y] = date[x][y + 1];
            date[x][y + 1] = 0;
            y++;
            step++;
        }else if (code == 40){
            if (x == 2){
                return;
            }
            date[x][y] = date[x + 1][y];
            date[x + 1][y] = 0;
            x++;
            step++;
        } else if (code == 87) {
            date = new int[][]{
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 0},
                };
        }
        initImage();
    }

    //胜利条件
    public boolean victory(){
        for (int i = 0; i < date.length; i++) {
            for (int j = 0; j < date[i].length; j++) {
                if (date[i][j] != win[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}