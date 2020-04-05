import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Funkcja_Kwadratowa extends JFrame {
    JPanel newPanel;
    JLabel la,lb,lc;
    JButton b1;
    JTextField ta,tb,tc;
    int a,b,c;
    Painter p1;
    private int width = 820;
    private int height = 620;
    private int textFieldsHeight = 80;
    public Funkcja_Kwadratowa()
    {
        this.setSize(width,height);
        this.setLocationRelativeTo(null);
        this.setTitle("Funkcja Kwadratowa");
        newPanel = new JPanel();
        la = new JLabel("A:");
        ta = new JTextField("1",5);

        lb = new JLabel("B:");
        tb = new JTextField("0",5);

        lc = new JLabel("C:");
        tc = new JTextField("0",5);

        b1 = new JButton("Oblicz");
        ActionListenerfob1 alfb1 = new ActionListenerfob1();
        b1.addActionListener(alfb1);
        p1 = new Painter(width,height,textFieldsHeight);

        newPanel.add(la);
        newPanel.add(ta);
        newPanel.add(lb);
        newPanel.add(tb);
        newPanel.add(lc);
        newPanel.add(tc);
        newPanel.add(b1);
        newPanel.add(p1);

        this.add(newPanel);
        this.setVisible(true);
        this.setResizable(false);
    }
    private class ActionListenerfob1 implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==b1)
            {
                a=Integer.parseInt(ta.getText());
                b=Integer.parseInt(tb.getText());
                c=Integer.parseInt(tc.getText());
                ZeroPlaces(a,b,c);
                p1.a=a;
                p1.b=b;
                p1.c=c;

                p1.repaint();
            }

        }
    }
    private void ZeroPlaces(int a, int b, int c)
    {
        float delta,x1,x2;
        delta = (float) (Math.pow(b,2) - (4 * a * c));
        if(delta>0)
        {
            x1= (float) (-b-Math.sqrt(delta))/(2*a);
            x2= (float) (-b+Math.sqrt(delta))/(2*a);
            String info ="Miejsca zerowe funkcji: "+ x1+" i "+x2;
            JOptionPane.showMessageDialog(Funkcja_Kwadratowa.this, info, "Wynik", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(delta==0)
        {
            x1= (float)(-b)/(2*a);
            String info ="Funkcja ma jedno miejsce zerowe: "+x1;
            JOptionPane.showMessageDialog(Funkcja_Kwadratowa.this, info, "Wynik", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            String info ="Funkcja nie ma miejsc zerowych!";
            JOptionPane.showMessageDialog(Funkcja_Kwadratowa.this, info, "Wynik", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
