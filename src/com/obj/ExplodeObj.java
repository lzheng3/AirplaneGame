package com.obj;

import java.awt.*;

public class ExplodeObj extends GameObj{

    static  Image[] pic = new Image[16];
    int expCount = 0;
    static {
        for (int i = 0; i < pic.length; i++) {
            pic[i] = Toolkit.getDefaultToolkit().getImage("imgs/explode/e"+(i+1)+".gif");
        }
    }

    public ExplodeObj(int x,int y) {
        super(x,y);
    }
    @Override
    public void paintSelf(Graphics g) {
        if(expCount < 16) {
            img = pic[expCount];
            super.paintSelf(g);
            expCount++;
        }
    }
}
