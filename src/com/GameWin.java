package com;

import com.obj.*;
import com.utils.GameUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWin extends JFrame {

    //Game status: 0 stop; 1 for start; 2 for pause; 3 for game over; 4 for win
    public static int score = 0;
    public static int state = 0;
    BgObj bgObj = new BgObj(GameUtils.bgimg,0,-2000,2);
    public PlaneObj plane = new PlaneObj(GameUtils.planeimg,290,550,20,30,0,this);
    public BossObj boss = null;
    Image offScreenImage = null;
    int width = 600;
    int height = 600;
    int count = 1;
    int enemyCount = 0;


    public void launch() {
        this.setVisible(true);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setTitle("airplane war game");
        GameUtils.gameObjList.add(bgObj);
        GameUtils.gameObjList.add(plane);

        //click functions
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == 1 && state == 0) {
                    state = 1;
                }
            }
        });

        //pause functions
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == 32) {
                    switch (state) {
                        case 1:
                            state=2;
                            break;
                        case 2:
                            state=1;
                            break;
                        default:
                    }
                }
            }
        });

        while (true) {
            if (state == 1) {
                createObj();
                repaint();
            }

            try{
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void paint(Graphics g) {
        if(offScreenImage == null) {
            offScreenImage = createImage(width,height);
        }
        Graphics gImage = offScreenImage.getGraphics();
        gImage.fillRect(0,0,width,height);
        if(state == 0) {
            gImage.drawImage(GameUtils.bgimg,0,0,null);
            gImage.drawImage(GameUtils.bossimg,220,120,null);
            gImage.drawImage(GameUtils.explodeimg,270,350,null);
            GameUtils.draw(gImage,"Press to Start",Color.yellow,40,180,300);

        }
        if(state == 1) {
            GameUtils.gameObjList.addAll(GameUtils.explodeObjList);
            for (int i = 0; i < GameUtils.gameObjList.size(); i++) {
                GameUtils.gameObjList.get(i).paintSelf(gImage);
            }
            GameUtils.gameObjList.removeAll(GameUtils.removeList);
        }
        if(state == 3) {
            gImage.drawImage(GameUtils.explodeimg,plane.getX()-35,plane.getY()-50,this);
            GameUtils.draw(gImage,"Game Over",Color.red,50,180,300);
        }
        if(state == 4) {
            gImage.drawImage(GameUtils.explodeimg,boss.getX()+30,boss.getY(),this);
            GameUtils.draw(gImage,"You Win!",Color.GREEN,50,190,300);
        }

        GameUtils.draw(gImage,score+" points",Color.green,40,30,100);
        g.drawImage(offScreenImage,0,0,null);
        count++;
        System.out.println(GameUtils.gameObjList.size());
    }

    void createObj() {
        //add airplane bullet
        if(count % 15 == 0) {
            GameUtils.bulletObjList.add(new BulletObj(GameUtils.bulletimg, plane.getX() + 3, plane.getY() - 16, 14, 29, 5, this));
            GameUtils.gameObjList.add(GameUtils.bulletObjList.get(GameUtils.bulletObjList.size() - 1));
        }
        //add enemy plane
        if(count % 15 == 0) {
            GameUtils.enemyObjList.add(new EnemyObj(GameUtils.enemyimg,(int) (Math.random()*12)*50,0,49,36,5,this));
            GameUtils.gameObjList.add(GameUtils.enemyObjList.get(GameUtils.enemyObjList.size()-1));
            enemyCount++;
        }
        //add enemy bullet
        if(count % 15 == 0 && boss != null) {
            GameUtils.enemyBulletObjList.add(new EnemyBulletObj(GameUtils.enemybulletimg,boss.getX()+76,boss.getY()+150,15,25,5,this));
            GameUtils.gameObjList.add(GameUtils.enemyBulletObjList.get(GameUtils.enemyBulletObjList.size() - 1));
        }
        if(enemyCount > 50 && boss == null) {
            boss = new BossObj(GameUtils.bossimg,250,35,155,100,5,this);
            GameUtils.gameObjList.add(boss);
        }
    }

    public static void main(String[] args) {
        GameWin gameWin = new GameWin();
        gameWin.launch();
    }
}
