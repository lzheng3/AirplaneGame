package com.obj;

import com.GameWin;
import com.utils.GameUtils;

import java.awt.*;

public class BulletObj extends GameObj{
    public BulletObj() {
        super();
    }

    public BulletObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public Image getImg() {
        return super.getImg();
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        y-=speed;
        if(y<0) {
            this.x=-100;
            this.y=100;
            GameUtils.removeList.add(this);
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
