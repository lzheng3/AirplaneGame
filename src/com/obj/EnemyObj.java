package com.obj;

import com.GameWin;
import com.utils.GameUtils;

import java.awt.*;

public class EnemyObj extends GameObj{
    public EnemyObj() {
        super();
    }

    public EnemyObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        y+=speed;
        //collision detection with enemy airplane
        if(this.getRec().intersects(this.frame.plane.getRec())){
            GameWin.state = 3;
        }
        if(y>600) {
            this.x=-200;
            this.y=200;
            GameUtils.removeList.add(this);
        }
        //move enemy airplane to (-200,200) before disappear
        for (BulletObj bullet:GameUtils.bulletObjList) {
            if(this.getRec().intersects(bullet.getRec())) {
                ExplodeObj explodeObj = new ExplodeObj(x,y);
                GameUtils.explodeObjList.add(explodeObj);
                GameUtils.removeList.add(explodeObj);
                bullet.setX(-100);
                bullet.setY(100);
                this.x=-200;
                this.y=200;
                GameUtils.removeList.add(bullet);
                GameUtils.removeList.add(this);
                GameWin.score++;
            }
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
