import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class Painter extends JComponent
{
    float a=2000,b=2000,c=2000;
    private int x0Axis, y0Axis;
    private int windowWidth, windowHeight;//size of window which we are drawing

    Painter(int width, int height, int textFieldsHeight)
    {
        //INITIALISATION
        windowWidth = width-20; //it's better if we have some space on sides
        windowHeight = height-textFieldsHeight;
        x0Axis = windowWidth/2;
        y0Axis = windowHeight/2;
        setPreferredSize(new Dimension(windowWidth,windowHeight));
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D lines = (Graphics2D) g;
        lines.setColor(Color.BLACK);
        drawBorders(lines);
        lines.setStroke(new BasicStroke(4f));
        drawAxis(lines);
        drawLines(lines);
        drawArrows(lines, 10);
        drawNumbers(lines);
        parabola(lines);
    }

    private void drawAxis(Graphics2D lines) {
        lines.draw(new Line2D.Float(0,windowHeight/2.0f,windowWidth-1,windowHeight/2.0f));
        lines.draw(new Line2D.Float(windowWidth/2.0f,windowHeight-1,windowWidth/2.0f,0));
    }
    public void drawArrows(Graphics2D g, int arrowSize)
    {
        g.setStroke(new BasicStroke(3f));
        g.draw(new Line2D.Float(windowWidth-1-arrowSize,windowHeight/2f+arrowSize,windowWidth-1,windowHeight/2f));
        g.draw(new Line2D.Float(windowWidth-1-arrowSize,windowHeight/2f-arrowSize,windowWidth-1,windowHeight/2f));
        g.draw(new Line2D.Float(windowWidth/2f-arrowSize, arrowSize,windowWidth/2f,0));
        g.draw(new Line2D.Float(windowWidth/2f+arrowSize, arrowSize,windowWidth/2f,0));
    }

    public void drawNumbers(Graphics2D g)
    {
        g.setStroke(new BasicStroke(2));
        g.setFont(new Font("TimesRoman", Font.BOLD, 12));
        //Vertical
        for(int i = 50; i<windowWidth;i+=50) {
            if(i!=x0Axis){
                g.drawString(String.valueOf((i-x0Axis)/50),i-5,y0Axis-10);
            }
        }
        //Horizontal
        for(int i = 50; i<windowHeight;i+=50) {
            if(i!=y0Axis) {
                g.drawString(String.valueOf(-(i - y0Axis)/50), x0Axis+10, i+5);
            }
        }
    }
    public void drawBorders(Graphics2D g){
        int realWith, realHeight;
        realWith = windowWidth -1;
        realHeight = windowHeight -1;
        g.drawLine(0, 0 ,0, realHeight);
        g.drawLine(0, 0 ,realWith, 0);
        g.drawLine(realWith, 0 ,realWith, realHeight);
        g.drawLine(0, realHeight ,realWith, realHeight);
    }
    public void drawLines(Graphics2D g)
    {
        //Gray lines in background
        g.setStroke(new BasicStroke(1f));
        g.setColor(Color.gray);
        for(int i = 10; i<windowHeight-1; i+=10) {
            g.drawLine(0, i, windowWidth-1, i);
        }
        for(int i = 10; i<windowWidth-1; i+=10) {
            g.drawLine(i, 0, i, windowHeight-1);
        }
        //Short lines every 1 value
        g.setStroke(new BasicStroke(1.5f));
        g.setColor(Color.BLACK);
        //Horizontal
        for(int i=10; i<windowWidth; i+=10)
        {
            g.setStroke(new BasicStroke(1.5f));
            if(i%50==0){
                g.setStroke(new BasicStroke(4f));
            }
            g.drawLine(i, windowHeight/2-5 , i, windowHeight/2+5); //10 px (-5 and +5)
        }
        //Vertical
        for(int i=10; i<windowHeight; i+=10)
        {
            g.setStroke(new BasicStroke(1.5f));
            if(i%50==0){
                g.setStroke(new BasicStroke(4f));
            }
            g.drawLine(windowWidth/2-5, i,windowWidth/2+5, i);
        }
    }
    public double f(double x) {
        return (a*x*x)+(b*x)+c;
    }
    public void parabola(Graphics2D g)
    {
        g.setStroke(new BasicStroke(2));
        double y1,y2,yk1,yk2,xk1,xk2;
        double x1,x2;
        for(int i = 1;i<3000;i++) {
            x1=-y0Axis+0.25*i;
            x2=-y0Axis+0.25*i+1;
            y1 =f(x1)*0.02;
            y2 =f(x2)*0.02;

            float delta;
            delta = (float) (Math.pow(b,2) - (4 * a * c));
            yk1=-y1+y0Axis+(delta/(4*a))*50;                //* 50 because every 50 pixels is one value
            yk2=-y2+y0Axis+(delta/(4*a))*50;
            xk1= x1+x0Axis-(b/(2*a))*50;
            xk2= x2+x0Axis-(b/(2*a))*50;

            g.setColor(Color.RED);
            if(xk1>=0 && yk1>=0 && xk1<=windowWidth && yk1<=windowHeight) { //we don't need to draw parabola if it's outside of our window
                g.draw(new Line2D.Double(xk1, yk1, xk2, yk2));
            }
        }
    }
}
