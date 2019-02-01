import javax.naming.BinaryRefAddr;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.function.BinaryOperator;

public class SystemyLiczbowe extends JFrame {
    JPanel newPanel;
    JLabel l1,l2,l3,l4;
    JButton b1,b2,b3,b4;
    JTextField t1,t2,t3,t4;

    public SystemyLiczbowe()
    {
        this.setSize(350,200);
        this.setLocationRelativeTo(null);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Systemy liczbowe");
        newPanel = new JPanel();
        newPanel.setBackground(new Color(70 ,130, 180));
        SystemyLiczbowe.ListenerForB lfb = new SystemyLiczbowe.ListenerForB();

        l1 = new JLabel("Dziesiętny: ");
        t1 = new JTextField("",15);
        b1 = new JButton("Oblicz  ");
        b1.addActionListener(lfb);

        l2 = new JLabel("Binarny: ");
        t2 = new JTextField("",15);
        b2 = new JButton("Oblicz  ");
        b2.addActionListener(lfb);

        l3 = new JLabel("Szesnastkowy: ");
        t3 = new JTextField("",15);
        b3 = new JButton("Oblicz  ");
        b3.addActionListener(lfb);

        l4 = new JLabel("Ósemkowy: ");
        t4 = new JTextField("",15);
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
            if(e.getSource()==b1)
            {
                try {
                    int w = Integer.parseInt(t1.getText());
                    t2.setText(Integer.toBinaryString(w));
                    t3.setText(Integer.toHexString(w));
                    t4.setText(Integer.toOctalString(w));
                }
                catch (NumberFormatException excep)
                {
                    JOptionPane.showMessageDialog(SystemyLiczbowe.this,"Wpisz poprawne wartości! od 0 do 9","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
            else if(e.getSource()==b2)
            {
                try {
                    int w = Integer.parseInt(t2.getText(), 2);
                    t1.setText(String.valueOf(w));
                    t3.setText(Integer.toHexString(w));
                    t4.setText(Integer.toOctalString(w));
                }
                catch (NumberFormatException excep)
                {
                    JOptionPane.showMessageDialog(SystemyLiczbowe.this,"Wpisz poprawne wartości! 0 lub 1","Error",JOptionPane.ERROR_MESSAGE);
                }

            }
            else if(e.getSource()==b3)
            {
                try {
                    int w = Integer.parseInt(t3.getText(), 16);
                    t1.setText(String.valueOf(w));
                    t2.setText(Integer.toBinaryString(w));
                    t4.setText(Integer.toOctalString(w));
                }
                catch (NumberFormatException excep)
                {
                    JOptionPane.showMessageDialog(SystemyLiczbowe.this,"Wpisz poprawne wartości! od 0 do F","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
            else if(e.getSource()==b4)
            {
                try {
                    int w = Integer.parseInt(t4.getText(), 8);
                    t1.setText(String.valueOf(w));
                    t2.setText(Integer.toBinaryString(w));
                    t3.setText(Integer.toHexString(w));
                }
                catch (NumberFormatException excep)
                {
                    JOptionPane.showMessageDialog(SystemyLiczbowe.this,"Wpisz poprawne wartości! od 0 do 8 ","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
