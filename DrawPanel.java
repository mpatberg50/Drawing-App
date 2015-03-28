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
import javax.swing.*;
public class DrawPanel extends JPanel 
{
    private MyShape[] shapes = new MyShape[200];
    private int shapeCount, shapeType;  //shape type 0=oval, 1=line, 2=rectangle
    private int lineWidth, dashLength;
    private MyShape currentShape;
    private Color currentCol, secondCol;
    private boolean filledShape, gradientShape, dashedLine;
    private JLabel statusLabel;
    
    public DrawPanel()
    {
        
        super();
        shapeCount=0;
        shapeType=0;
        currentCol = Color.BLACK;
        secondCol = Color.BLACK;
        setBackground(Color.white);
        filledShape=false;
        gradientShape=false;
        dashedLine=false;
        lineWidth=0;
        dashLength=0;
        statusLabel = new JLabel("");
    }
    public void setShapeType(int x)
    {
        shapeType=x;
    }
    public void setCurrentColor(Color c)
    {
        currentCol=c;
    }
    public void setSecondColor(Color c)
    {
        secondCol=c;
    }
    public void setFilledShape(boolean b)
    {
        filledShape=b;
    }
    public void setGradient(boolean b)
    {
        gradientShape=b;
    }
    public void setDashed(boolean b)
    {
        dashedLine=b;
    }
    public void clearLastShape()
    {
          
        if(shapeCount!=0)
        {
            shapes[shapeCount-1] =null;
            shapeCount--;
        }
        super.repaint();
    }
    public void clearDrawing()
    {

        while(shapes[shapeCount]!=null || shapeCount!=0)
        { 
            shapes[shapeCount] = null;
            if(shapeCount!=0)
               shapeCount--;
        }
        
        
        super.repaint();
    }
    public void setLineWidth(int l)
    {
        lineWidth=l;
    }
    public void setDashLength(int d)
    {
        dashLength=d;
    }
    public void nextShape()
    {
        shapeCount++;
    }
    public int getCurShape ()
    {
        return shapeCount;
    }
    public void addShape(int initX, int initY,int curX, int curY)
    {
        if(shapeType==0)    //oval
        {
            shapes[shapeCount]= new MyOval(initX,initY, curX-initX,curY-initY,currentCol);
        }
        else if(shapeType==1)   //line
        {
            shapes[shapeCount]= new MyLine(initX,initY,curX,curY,currentCol);
        }
        else if(shapeType==2) //rectangle
        {
            shapes[shapeCount]= new MyRectangle(initX,initY,curX-initX,curY-initY,currentCol);
        }
        shapes[shapeCount].setFilled(filledShape);
        shapes[shapeCount].setDashed(dashedLine);
        shapes[shapeCount].setGradient(gradientShape,secondCol);
        shapes[shapeCount].setLineWidth(lineWidth);
        shapes[shapeCount].setDashed(dashedLine);
        shapes[shapeCount].setDashedLength(dashLength);
    }
    @Override
    public void paint(Graphics g)
    {        
        super.paint(g);

        
        for(int x=0; x<=shapeCount; x++)
        {
            if(shapes[x]!=null)
                shapes[x].draw(g); 
        }
     }
    

}
