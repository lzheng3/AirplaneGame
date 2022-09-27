package com.obj;

import com.GameWin;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlaneObj extends GameObj{
    public PlaneObj() {
        super();
    }

    public PlaneObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
        this.frame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                PlaneObj.super.x = e.getX() - 11;
                PlaneObj.super.y = e.getY() - 16;
            }
        });
    }

    @Override
    public Image getImg() {
        return super.getImg();
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        if(this.frame.boss !=null && this.getRec().intersects(this.frame.boss.getRec())) {
            GameWin.state =3;
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
