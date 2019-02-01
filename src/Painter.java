import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import javax.swing.*;

public class Painter extends JComponent
{
    float a=2000,b=2000,c=2000;
    int x0=390,y0=270;
    Painter()
    {
        setPreferredSize(new Dimension(800-20,600));
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D lines = (Graphics2D) g;
        lines.setColor(Color.BLACK);
        lines.setStroke(new BasicStroke(2));
        lines.draw(new Line2D.Float(0,getHeight()/2-30,getWidth(),getHeight()/2-30));
        lines.draw(new Line2D.Float(getWidth()/2,getHeight(),getWidth()/2,0));
        drawArrow(lines,getWidth()-10,getHeight()/2-30,getWidth(),getHeight()/2-30);
        drawArrow(lines,getWidth()/2,10,getWidth()/2,0);
        drawNumbers(lines);
        drawLines(lines);
        Parabola(lines);
    }
    public void drawArrow(Graphics2D g, int x1, int y1, int x2, int y2)
    {
        if(y1==y2) {
            g.draw(new Line2D.Float(x1, y1 - 8, x2, y2));
            g.draw(new Line2D.Float(x1, y1 + 8, x2, y2));
        }
        else if(x1==x2)
        {
            g.draw(new Line2D.Float(x1-8, y1 , x2, y2));
            g.draw(new Line2D.Float(x1+8, y1 , x2, y2));
        }
    }
    public void drawNumbers(Graphics2D g)
    {
        g.setStroke(new BasicStroke(2));
        g.setFont(new Font("TimesRoman", Font.BOLD, 10));
        for(int i =0; i<getWidth();i++) {
            if(i==400){}
                else
            g.drawString(""+(i-400)%49, i-13, getHeight()/2-10);
            i=i+49;
        }
        for(int i =0; i<getHeight()-20;i++) {
            if(i==300)
            { }
            else
            g.drawString(""+(-(i-300))%49, getWidth()/2+10, i-27);
            i=i+49;
        }
    }
    public void drawLines(Graphics2D g)
    {
        for(int i=0;i<getWidth();i++)
        {
            g.drawLine(i, getHeight()/2-30-5 ,i, getHeight()/2-30+5);
            i=i+9;
        }
        for(int i=10;i<580;i++)
        {
            g.drawLine(getWidth()/2-5, i,getWidth()/2+5, i);
            i=i+9;
        }
        g.setStroke(new BasicStroke(1/2));
        g.setColor(Color.gray);
        for(int i = 0; i<580; i++) {
            g.drawLine(0, i, getWidth(), i);
            i=i+9;
        }
        for(int i = 0; i<getWidth(); i++) {
            g.drawLine(i, 0, i, getHeight());

            i=i+9;
        }
    }
    public double f(double x) {
        return (a*x*x)+(b*x)+c;
    }
    public void Parabola(Graphics2D g)
    {
        g.setStroke(new BasicStroke(2));
        double y1,y2,yk1,yk2,xk1,xk2;
        double x1=0,x2=0;
        for(int i = 1;i<3000;i++) {
            x1=-300+0.25*i;
            x2=-300+0.25*i+1;
            y1 = (double) f(x1)*0.02;
            y2 = (double) f(x2)*0.02;

            float delta;
            delta = (float) (Math.pow(b,2) - (4 * a * c));
            yk1=-y1+y0+(delta/(4*a))*50;
            yk2=-y2+y0+(delta/(4*a))*50;
            xk1= x1+x0-(b/(2*a))*50;
            xk2= x2+x0-(b/(2*a))*50;

            g.setColor(Color.RED);
            g.draw(new Line2D.Double(xk1,yk1,xk2,yk2));
        }
    }
}
