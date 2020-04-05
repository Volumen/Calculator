import javax.swing.*;
//import java.awt.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class Painter extends JComponent
{
    float a=2000,b=2000,c=2000;
    private int x0=390,y0=270;
    private int windowWidth, windowHeight;//size of window which we are drawing (with borders)
    private int xZeroWithoutBorder, yZeroWithoutBorder;// zero in our layout without borders (left up corner)
    private int borderWidth=10;
    private int xAxisPosition , yAxisPosition = windowWidth/2 ;
    Painter(int width, int height, int textFieldsHeight)
    {
        windowWidth = width-20; //it's better
        windowHeight = height-textFieldsHeight;
        setPreferredSize(new Dimension(windowWidth,windowHeight));
        xZeroWithoutBorder = borderWidth/2;
        yZeroWithoutBorder = borderWidth/2;
        
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        System.out.println("Width: "+windowWidth+" Height: "+windowHeight);
        Graphics2D lines = (Graphics2D) g;
        lines.setColor(Color.BLACK);
        lines.setStroke(new BasicStroke(2));

        lines.draw(new Line2D.Float(0,windowHeight/2.0f,windowWidth,windowHeight/2));
        lines.draw(new Line2D.Float(windowWidth/2,windowHeight,windowWidth/2,0));

//        drawArrow(lines,windowWidth-10,windowHeight/2-30,windowWidth,windowHeight/2-30,8);  //vertical
//        drawArrow(lines,windowWidth/2,10,windowWidth/2,0, 8);         //horizontal
//
        drawArrows(lines, 10, 10);
        ////////////////////////
        lines.setColor(Color.RED);
        lines.setStroke(new BasicStroke(2));
        drawTestLine(lines, xZeroWithoutBorder,yZeroWithoutBorder,50,50);
        lines.setStroke(new BasicStroke(borderWidth));
        lines.setColor(Color.BLACK);
        drawBorders(lines);
        lines.setStroke(new BasicStroke(2));
        lines.setColor(Color.BLACK);
        ///////////////////////////////



        drawNumbers(lines);
        drawLines(lines);
        Parabola(lines);
    }
    public void drawArrows(Graphics2D g, int arrowDistanceFromAxisX, int arrowDistance)
    {
        g.draw(new Line2D.Float(windowWidth-arrowDistance,windowHeight/2,windowWidth,windowHeight/2));
    }
    public void drawTestLine(Graphics2D g, int x1, int y1, int x2, int y2){

        g.draw(new Line2D.Float(x1,y1,x2,y2));
    }
    public void drawArrow(Graphics2D g, int x1, int y1, int x2, int y2, int arrowSize)
    {
        if(y1==y2) {
            g.draw(new Line2D.Float(x1, y1 - arrowSize, x2, y2));
            g.draw(new Line2D.Float(x1, y1 + arrowSize, x2, y2));
        }
        else if(x1==x2)
        {
            g.draw(new Line2D.Float(x1-arrowSize, y1 , x2, y2));
            g.draw(new Line2D.Float(x1+arrowSize, y1 , x2, y2));
        }
    }
    public void drawNumbers(Graphics2D g)
    {
        g.setStroke(new BasicStroke(2));
        g.setFont(new Font("TimesRoman", Font.BOLD, 10));
        for(int i =0; i<windowWidth;i++) {
            if(i==400){}
                else
            g.drawString(""+(i-400)%49, i-13, windowHeight/2-10);
            i=i+49;
        }
        for(int i =0; i<windowHeight-20;i++) {
            if(i==300)
            { }
            else
            g.drawString(""+(-(i-300))%49, windowWidth/2+10, i-27);
            i=i+49;
        }
    }
    public void drawBorders(Graphics2D g){
        g.drawLine(0, 0 ,0, windowHeight);
        g.drawLine(0, 0 ,windowWidth, 0);
        g.drawLine(windowWidth-1, 0 ,windowWidth-1, windowHeight);
        g.drawLine(0, windowHeight-1 ,windowWidth, windowHeight-1);
//        g.drawLine(i, windowHeight/2-5 ,i, windowHeight/2+5);
    }
    public void drawLines(Graphics2D g)
    {
        for(int i=0;i<windowWidth;i++)
        {
            g.drawLine(i, windowHeight/2-5 ,i, windowHeight/2+5);
            i=i+9;
        }
        for(int i=10;i<580;i++)
        {
            g.drawLine(windowWidth/2-5, i,windowWidth/2+5, i);
            i=i+9;
        }
        g.setStroke(new BasicStroke(1/2));
        g.setColor(Color.gray);
        for(int i = 0; i<=580-50; i++) {
            g.drawLine(0, i, windowWidth, i);
            i=i+9;
        }
        for(int i = 0; i<windowWidth; i++) {
            g.drawLine(i, 0, i, windowHeight);

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
        double x1,x2;
        for(int i = 1;i<3000;i++) {
            x1=-300+0.25*i;
            x2=-300+0.25*i+1;
            y1 =f(x1)*0.02;
            y2 =f(x2)*0.02;

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
