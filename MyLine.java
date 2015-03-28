/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Patberg
 */
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.GradientPaint;

public class MyLine extends MyShape{
    private int x1, x2, y1, y2;
    
    public MyLine(int X1, int Y1, int X2, int Y2, Color col)
    {
        super.setColor(col);
        x1=X1;
        x2=X2;
        y1=Y1;
        y2=Y2;
    }
    public MyLine()
    {
        super();
        x1=0;
        y1=0;
        x2=0;
        y2=0;
    }
    
    @Override
    public void draw(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)g;
        if(super.isGradient())
        {
            g2d.setPaint(new GradientPaint(0 , 0 , super.getColor() , 50 , 50 , super.getSecondColor() , true));
        }
        else
            g2d.setColor(super.getColor());
        
        if(super.isDashed())
            g2d.setStroke(new BasicStroke(super.getlineWidth(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{super.getDashedLength()}, 0));
        else
            g2d.setStroke(new BasicStroke(super.getlineWidth()));
        
        
        g2d.drawLine(x1, y1, x2, y2);
    }
    
    public int getX1()
    {
        return x1;
    }
    public int getY1()
    {
        return y1;
    }
    public int getX2()
    {
        return x2;
    }
    public int getY2()
    {
        return y2;
    }
    public void setX1(int X)
    {
        x1=X;
    }
    public void setY1(int Y)
    {
        y1=Y;
    }
    public void setX2(int x)
    {
        x2=x;
    }
    public void setY2(int y)
    {
        y2=y;
    }

}
