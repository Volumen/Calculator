import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    JButton b1,b2,b3,b4;
    JPanel newPanel;
    JLabel l1;

    public static void main(String[] args)
    {
        new Main();
    }
    public Main()
    {
        this.setSize(300,280);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Kalkulator");

        newPanel = new JPanel();
        newPanel.setBackground(new Color(70 ,130, 180));
        newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.Y_AXIS));
        newPanel.setBorder(new EmptyBorder(new Insets(30,0,0,0)));

        l1 = new JLabel("UNIWERSALNY KALKULATOR");
        l1.setFont(new Font("TimesRoman",Font.BOLD,15));
        l1.setForeground(Color.WHITE);
        l1.setAlignmentX(Component.CENTER_ALIGNMENT);
        l1.setIcon(ScaledImage());

        newPanel.add(l1);
        newPanel.add(Box.createRigidArea(new Dimension(0,20)));
        ListenerForBut lfb = new ListenerForBut();
        b1 = new JButton("Decybele");
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);
        b1.addActionListener(lfb);
        b2 = new JButton("Funkcja kwadratowa");
        b2.setBounds(100,60,300,60);
        b2.setAlignmentX(Component.CENTER_ALIGNMENT);
        b2.addActionListener(lfb);
        b3 = new JButton("Systemy liczbowe");
        b3.setAlignmentX(Component.CENTER_ALIGNMENT);
        b3.addActionListener(lfb);
        b4 = new JButton("Inne");
        b4.setAlignmentX(Component.CENTER_ALIGNMENT);
        b4.addActionListener(lfb);

        newPanel.add(b1);
        newPanel.add(Box.createRigidArea(new Dimension(0,10))); //przestrzeń pomiędzy przyciskami
        newPanel.add(b2);
        newPanel.add(Box.createRigidArea(new Dimension(0,10)));
        newPanel.add(b3);
        newPanel.add(Box.createRigidArea(new Dimension(0,10)));
        newPanel.add(b4);

        this.add(newPanel);
        this.setVisible(true);
        this.setResizable(false);
    }
    private class ListenerForBut implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==b1)
            {
                Decybele d1 = new Decybele();
            }
            else if(e.getSource()==b2)
            {
                Funkcja_Kwadratowa fk = new Funkcja_Kwadratowa();
            }
            else if(e.getSource()==b3)
            {
                SystemyLiczbowe sl1= new SystemyLiczbowe();
            }
            else if(e.getSource()==b4)
            {
                Inne i1 = new Inne();
            }
        }
    }
    public ImageIcon ScaledImage()
    {
        ImageIcon ic = new ImageIcon("images/kalkulator.png");
        Image img = ic.getImage();
        Image newimg = img.getScaledInstance(30,30, Image.SCALE_SMOOTH);
        ic = new ImageIcon(newimg);
        return ic;
    }


}
