import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Decybele extends JFrame {
    JPanel newPanel;
    JLabel l1,l2,l3,l4;
    JButton b1,b2,b3,b4;
    JTextField t1,t2,t3,t4;

    public Decybele()
    {
        this.setSize(230,200);
        this.setLocationRelativeTo(null);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("dB");
        newPanel = new JPanel();
        newPanel.setBackground(new Color(70 ,130, 180));
        ListenerForB lfb = new ListenerForB();

        l1 = new JLabel("mWaty: ");
        t1 = new JTextField("",5);
        b1 = new JButton("Oblicz  ");
        b1.addActionListener(lfb);

        l2 = new JLabel("Waty: ");
        t2 = new JTextField("",5);
        b2 = new JButton("Oblicz  ");
        b2.addActionListener(lfb);

        l3 = new JLabel("dBm: ");
        t3 = new JTextField("",5);
        b3 = new JButton("Oblicz  ");
        b3.addActionListener(lfb);

        l4 = new JLabel("dBW: ");
        t4 = new JTextField("",5);
        b4 = new JButton("Oblicz  ");
        b4.addActionListener(lfb);

        newPanel.add(l1);
        newPanel.add(t1);
        newPanel.add(b1);
        newPanel.add(l2);
        newPanel.add(t2);
        newPanel.add(b2);
        newPanel.add(l3);
        newPanel.add(t3);
        newPanel.add(b3);
        newPanel.add(l4);
        newPanel.add(t4);
        newPanel.add(b4);

        this.add(newPanel);
        this.setVisible(true);
        this.setResizable(false);
    }
    private class ListenerForB implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            DecimalFormat df = new DecimalFormat("#.####");
            df.setRoundingMode(RoundingMode.CEILING); //tryb zaokraglania
            if(e.getSource()==b1)
            {
                double w =Double.parseDouble(t1.getText());
                t2.setText(String.valueOf(df.format(w/1000)));
                t3.setText(String.valueOf(df.format(dB(w))));
                t4.setText(String.valueOf(df.format(dB(w/1000))));
            }
            else if(e.getSource()==b2)
            {
                double w =Double.parseDouble(t2.getText());
                t1.setText(String.valueOf(df.format(w*1000)));
                t3.setText(String.valueOf(df.format(dB(w*1000))));
                t4.setText(String.valueOf(df.format(dB(w))));
            }
            else if(e.getSource()==b3)
            {
                double w =Double.parseDouble(t3.getText());
                t1.setText(String.valueOf(df.format(Math.pow(10,w/10))));
                t2.setText(String.valueOf(df.format(Math.pow(10,w/10)/1000)));
                t4.setText(String.valueOf(df.format(w-30)));
            }
            else if(e.getSource()==b4)
            {
                double w =Double.parseDouble(t4.getText());
                t1.setText(String.valueOf(df.format(Math.pow(10,w/10)*1000)));
                t2.setText(String.valueOf(df.format(Math.pow(10,w/10))));
                t3.setText(String.valueOf(df.format(w+30)));
            }
        }
    }
    private double dB(double a)
    {
        double w;
        w= 10*Math.log10(a);
        return w ;
    }
}
