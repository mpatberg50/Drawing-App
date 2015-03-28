import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class MyRectangle extends MyBoundedShape {
   
    public MyRectangle(int X, int Y, int h, int w, Color col)
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
        

        
        
        
        if(super.isFilled())
            g2d.fillRect(super.getX(), super.getY(), super.getHeight(), super.getWidth());          
        else
            g2d.drawRect(super.getX(), super.getY(), super.getHeight(), super.getWidth());
    }
}