package com.utils;

import com.obj.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class GameUtils {

    public static Image bgimg = Toolkit.getDefaultToolkit().getImage("imgs/bg.jpg");
    public static Image bossimg = Toolkit.getDefaultToolkit().getImage("imgs/boss.png");
    public static Image explodeimg = Toolkit.getDefaultToolkit().getImage("imgs/explode/e6.gif");
    public static Image planeimg = Toolkit.getDefaultToolkit().getImage("imgs/plane.png");
    public static Image bulletimg = Toolkit.getDefaultToolkit().getImage("imgs/shell.png");
    public static Image enemyimg = Toolkit.getDefaultToolkit().getImage("imgs/enemy.png");
    public static Image enemybulletimg = Toolkit.getDefaultToolkit().getImage("imgs/bullet.png");

    //create collection of all object
    public static List<GameObj> gameObjList = new ArrayList<>();

    //create collection of bullet
    public static List<BulletObj> bulletObjList = new ArrayList<>();

    //create collection of enemy
    public static List<EnemyObj> enemyObjList = new ArrayList<>();

    //create collection of remove object
    public static List<GameObj> removeList = new ArrayList<>();

    //create collection of enemy bullet
    public static List<EnemyBulletObj> enemyBulletObjList = new ArrayList<>();

    //create collection of explode object
    public static List<ExplodeObj> explodeObjList = new ArrayList<>();

    public static void draw(Graphics gImage, String str,Color color, int size,int x, int y) {
        gImage.setColor(color);
        gImage.setFont(new Font("TimesRoman",Font.BOLD,size));
        gImage.drawString(str,x,y);
    }

}
