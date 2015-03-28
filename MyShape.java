/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Patberg
 */
import javax.swing.*;
import java.awt.*;

public abstract class MyShape {
    private Color color, secColor;
    private boolean dashed, gradient, filled;
    private int lineWidth, dashLength;
    
    public void setColor(Color c)
    {
        color =c;
    }
    public Color getColor()
    {
        return color;
    }
    public Color getSecondColor()
    {
        return secColor;
    }
    public boolean isDashed()
    {
        return dashed;
    }
    public void setDashed(boolean d)
    {
        dashed = d;
    }
    public int getlineWidth()
    {
        return lineWidth;
    }
    public void setLineWidth (int l)
    {
        lineWidth = l;
    }
    public boolean isGradient()
    {
        return gradient;
    }
    public void setGradient (boolean g, Color col)
    {
        secColor=col;
        gradient = g;
    }
    public boolean isFilled()
    {
        return filled;
    }
    public void setFilled(boolean f)
    {
        filled=f;
    }
    public void setDashedLength (int dl)
    {
        dashLength= dl;
    }
    public int getDashedLength()
    {
        return dashLength;
    }
    
        
    public MyShape()
    {
        color=Color.BLACK;
        secColor = Color.BLACK;
        dashed=false;
        gradient=false;
        filled = false;
        lineWidth=5;
        dashLength=10;
    }
    public abstract void draw(Graphics g);
}
