

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 *
 * @author Patberg
 */
public class TopFrame extends JFrame{
    private final JButton  undoBut, clearBut, color1But,color2But;
    private final JCheckBox gradientBox, dashedBox, filledBox;
    private final JLabel shapeText, lineWidthText, dashLengthText, coordText;
    private final JTextField lineWidthField, dashLengthField;
    private final JComboBox<String> shapeComboBox;
    private final JPanel topPanel;
    private final DrawPanel drawPanel;
    private static final String[] shapes = {"Oval","Line","Rectangle"};
    
    public TopFrame()
    {
        super("Drawing Shapes");
        drawPanel = new DrawPanel();
        MouseHandler mouseHandler = new MouseHandler();
        drawPanel.addMouseListener(mouseHandler);
        drawPanel.addMouseMotionListener(mouseHandler);
        
        
        
        //create buttons and what happens when pressed
        undoBut = new JButton("Undo");
        clearBut = new JButton("Clear");
        color1But = new JButton("Color 1");
        color2But = new JButton ("Color 2");
        ButtonHandler handler = new ButtonHandler();
        undoBut.addActionListener(handler);
        clearBut.addActionListener(handler);
        color1But.addActionListener(handler);
        color2But.addActionListener(handler);
        
        //create check boxes and checked and unchecked settings
        gradientBox = new JCheckBox("Use Gradient");
        dashedBox = new JCheckBox("Dashed");
        filledBox = new JCheckBox("Filled");
        CheckBoxHandler boxHandler = new CheckBoxHandler();
        gradientBox.addItemListener(boxHandler);
        dashedBox.addItemListener(boxHandler);
        filledBox.addItemListener(boxHandler);
        
        //create text needed outside elements
        shapeText = new JLabel("Shape: ");
        lineWidthText = new JLabel ("Line Width");
        dashLengthText = new JLabel ("Dash Length: ");
        
        
        //create input boxes
        lineWidthField = new JTextField(3);
        lineWidthField.setText("10");
        dashLengthField = new JTextField(3);
        dashLengthField.setText("10");
        
        
        //create drop down menu
        shapeComboBox = new JComboBox<String>(shapes);
        shapeComboBox.setMaximumRowCount(3);
        shapeComboBox.addItemListener(
                new ItemListener()
                {
                    @Override
                    public void itemStateChanged(ItemEvent event)
                    {
                        if(event.getStateChange()==ItemEvent.SELECTED)
                        {
                            drawPanel.setShapeType(shapeComboBox.getSelectedIndex());
                        }
                    }
                }
        
        );
        
        
        //create the panel with elements
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2,8,5,5));
        
        //adds all the buttons to the top
        topPanel.add(undoBut);
        topPanel.add(clearBut);
        topPanel.add(shapeText);
        topPanel.add(shapeComboBox);
        topPanel.add(gradientBox);
        topPanel.add(dashedBox);
        topPanel.add(filledBox);
        topPanel.add(color1But);
        topPanel.add(color2But);
        topPanel.add(lineWidthText);
        topPanel.add(lineWidthField);
        topPanel.add(dashLengthText);
        topPanel.add(dashLengthField);
        
        
        add(topPanel,BorderLayout.NORTH);
        
        add(drawPanel);
        
        coordText = new JLabel();
        
        add(coordText,BorderLayout.SOUTH);
    }
    
    private class ButtonHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource()==undoBut)
                drawPanel.clearLastShape();
            else if(event.getSource()==clearBut)
                drawPanel.clearDrawing();
            else if(event.getSource()==color1But)
            {
                drawPanel.setCurrentColor( JColorChooser.showDialog(TopFrame.this, "Choose a color",Color.black ));
            }
            else if(event.getSource()== color2But)
            {
                drawPanel.setSecondColor( JColorChooser.showDialog(TopFrame.this, "Choose a color",Color.black ));
            }
        }
    }
    private class CheckBoxHandler implements ItemListener
    {
        @Override
        public void itemStateChanged(ItemEvent event)
        {
            if(gradientBox.isSelected())
                drawPanel.setGradient(true);
            else
                drawPanel.setGradient(false);
            
            if(dashedBox.isSelected())
                drawPanel.setDashed(true);
            else
                drawPanel.setDashed(false);
            
            if(filledBox.isSelected())
                drawPanel.setFilledShape(true);
            else
                drawPanel.setFilledShape(false);
            
        }
    }
  
    private class MouseHandler implements MouseListener, MouseMotionListener
    {
        int beginX, beginY;
        @Override
        public void mouseClicked(MouseEvent event)
        {
            
        }
        @Override
        public void mousePressed(MouseEvent event)
        {
            beginX = event.getX();
            beginY = event.getY();
            drawPanel.setLineWidth(Integer.parseInt(lineWidthField.getText()));
            drawPanel.setDashLength(Integer.parseInt(dashLengthField.getText()));
        }
        @Override
        public void mouseReleased(MouseEvent event)
        {
            drawPanel.addShape(beginX, beginY, event.getX(), event.getY());
            drawPanel.nextShape();

            
            drawPanel.repaint();
          //  drawPanel.setBackground(Color.yellow);
        }
        @Override
        public void mouseEntered(MouseEvent event)
        {

        }
        @Override
        public void mouseExited(MouseEvent event)
        {
             coordText.setText("( - , - )");           
        }
        @Override
        public void mouseDragged(MouseEvent event)
        {
           drawPanel.addShape(beginX, beginY, event.getX(), event.getY());
           drawPanel.repaint();
        }
        @Override
        public void mouseMoved(MouseEvent event)
        {
            coordText.setText("(" + event.getX()+ "," + event.getY()+")");
        }
        
        
        
        
    }
    
}
