
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Patberg
 */
import java.awt.*;


public abstract class MyBoundedShape extends MyShape {
    private int x, y, height, width;
    
    public MyBoundedShape(int X, int Y, int h, int w, Color col)
    {
        super.setColor(col);
        x=X;
        y=Y;
        height=h;
        width=w;
    }
    public MyBoundedShape()
    {
        super();
        x=0;
        y=0;
        height=0;
        width=0;
    }
    public int getX()
    {
        if(height>=0)
            return x;
        else
            return height +x;
    }
    public int getY()
    {
        if(width>=0)
            return y;
        else
            return width +y;
    }
    public int getHeight()
    {
        if(height>=0)
            return height;
        else
            return height *(-1);
    }
    public int getWidth()
    {
        if(width>=0)
            return width;
        else
            return width*(-1);
    }
    public void setX(int X)
    {
        x=X;
    }
    public void setY(int Y)
    {
        y=Y;
    }
    public void setHeight(int h)
    {
        height=h;
    }
    public void setWidth(int w)
    {
        width=w;
    }

    
    public abstract void draw(Graphics g);
}
