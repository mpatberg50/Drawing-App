/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Patberg
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.*;
import javax.swing.*;
public class MyOval extends MyBoundedShape {
    
    public MyOval(int X, int Y, int h, int w, Color col)
    {
        super(X,Y,h,w,col);
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
        
        int tempX=super.getX(), tempY=super.getY(), tempWidth=super.getHeight(), tempHeight=super.getWidth();
        
                
        if(super.isFilled())
            g2d.fillOval(super.getX(), super.getY(), super.getHeight(), super.getWidth());
        else
            g2d.drawOval(super.getX(), super.getY(), super.getHeight(), super.getWidth());
        
        
    }
}
