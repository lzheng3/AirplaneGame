package com.obj;

import com.GameWin;
import com.utils.GameUtils;

import java.awt.*;

public class BossObj extends GameObj{

    int hp = 20;
    public BossObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        if(x > 550 || x < -50) {
            speed = - speed;
        }
        x+= speed;
        for (BulletObj bullet: GameUtils.bulletObjList) {
            if(this.getRec().intersects(bullet.getRec())) {
                bullet.setX(-100);
                bullet.setY(100);
                GameUtils.removeList.add(bullet);
                hp--;
            }
            if (hp <= 0) {
                GameWin.state = 4;
            }
        }
        //create boss health bar
        g.setColor(Color.white);
        g.fillRect(20,40,200,10);
        g.setColor(Color.red);
        g.fillRect(20,40,hp*100/10,10);
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
