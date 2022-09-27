package com.obj;

import com.GameWin;
import com.utils.GameUtils;

import java.awt.*;

public class EnemyBulletObj extends GameObj{
    public EnemyBulletObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        y += speed;
        if(this.getRec().intersects(this.frame.plane.getRec())) {
            GameWin.state = 3;
        }
        if(y>600) {
            this.x=-300;
            this.y=300;
            GameUtils.removeList.add(this);
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
