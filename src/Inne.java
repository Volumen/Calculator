import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inne extends JFrame{
    private  JButton but[], butAdd, butMinus, butMultiply, butDivide, butEqual, butCancel,
            butSquareRoot, butSquare, butOneDevidedBy, butCos, butSin, butTan, butXpowerofY,
            butLog, butrate;
    private JPanel newPanel;
    private JTextArea text;
    private String[] buttonValue = {"0","1","2","3","4","5","6","7","8","9"};
    InneCalculations calc;
    public Inne()
    {
        this.setSize(300   ,250);
        this.setLocationRelativeTo(null);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Tradycjyny Kalkulator");
        newPanel = new JPanel(new FlowLayout());
        newPanel.setBackground(new Color(70 ,130, 180));
        but = new JButton[10];
        text = new JTextArea(2,25);

        buttons();

        calc = new InneCalculations();

        this.add(newPanel);
        this.setVisible(true);
        this.setResizable(false);
    }
    public void buttons()
    {

        ListenerForButtons lfb = new ListenerForButtons();
        newPanel.add(text);
        for(int i =0; i<10;i++)
        {
            but[i] = new JButton(String.valueOf(i));
            newPanel.add(but[i]);
            but[i].addActionListener(lfb);
        }

        butAdd = new JButton("+");
        butAdd.addActionListener(lfb);
        newPanel.add(butAdd);

        butMinus = new JButton("-");
        butMinus.addActionListener(lfb);
        newPanel.add(butMinus);

        butMultiply = new JButton("*");
        butMultiply.addActionListener(lfb);
        newPanel.add(butMultiply);

        butDivide = new JButton("/");
        butDivide.addActionListener(lfb);
        newPanel.add(butDivide);

        butEqual = new JButton("=");
        butEqual.addActionListener(lfb);
        newPanel.add(butEqual);

        butSquareRoot = new JButton("√");
        butSquareRoot.addActionListener(lfb);
        newPanel.add(butSquareRoot);

        butSquare = new JButton("x*x");
        butSquare.addActionListener(lfb);
        newPanel.add(butSquare);

        butOneDevidedBy = new JButton("1/x");
        butOneDevidedBy.addActionListener(lfb);
        newPanel.add(butOneDevidedBy);

        butCos = new JButton("Cos");
        butCos.addActionListener(lfb);
        newPanel.add(butCos);

        butSin = new JButton("Sin");
        butSin.addActionListener(lfb);
        newPanel.add(butSin);

        butTan = new JButton("Tan");
        butTan.addActionListener(lfb);
        newPanel.add(butTan);

        butXpowerofY = new JButton("x^y");
        butXpowerofY.addActionListener(lfb);
        newPanel.add(butXpowerofY);

        butLog = new JButton("log10(x)");
        butLog.addActionListener(lfb);
        newPanel.add(butLog);

        butrate = new JButton("x%");
        butrate.addActionListener(lfb);
        newPanel.add(butrate);


        butCancel = new JButton("C");
        butCancel.addActionListener(lfb);
        newPanel.add(butCancel);
    }
    private class ListenerForButtons implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {

            Object source = e.getSource();
            for(int i = 0; i<10; i++)
            {
                if(source == but[i])
                {
                    text.replaceSelection(buttonValue[i]);
                    return;
                }
            }
            if(source == butAdd)
            {
                writer(calc.calculateBi(InneCalculations.BiOperations.add,reader()));
            }
            else if(source == butMinus)
            {
                writer(calc.calculateBi(InneCalculations.BiOperations.minus,reader()));
            }
            else if(source == butMultiply)
            {
                writer(calc.calculateBi(InneCalculations.BiOperations.multiply,reader()));
            }
            else if(source == butDivide)
            {
                writer(calc.calculateBi(InneCalculations.BiOperations.divide,reader()));
            }
            else if(source == butXpowerofY)
            {
                writer(calc.calculateBi(InneCalculations.BiOperations.XpowerofY,reader()));
            }
            else if(source == butSquare)
            {
                writer(calc.calculateMono(InneCalculations.MonoOperations.square,reader()));
            }
            else if(source == butSquareRoot)
            {
                writer(calc.calculateMono(InneCalculations.MonoOperations.squareRoot,reader()));
            }
            else if(source == butOneDevidedBy)
            {
                writer(calc.calculateMono(InneCalculations.MonoOperations.oneDevidedBy,reader()));
            }
            else if(source == butCos)
            {
                writer(calc.calculateMono(InneCalculations.MonoOperations.cos,reader()));
            }
            else if(source == butSin)
            {
                writer(calc.calculateMono(InneCalculations.MonoOperations.sin,reader()));
            }
            else if(source == butTan)
            {
                writer(calc.calculateMono(InneCalculations.MonoOperations.tan,reader()));
            }
            else if(source == butLog)
            {
                writer(calc.calculateMono(InneCalculations.MonoOperations.log,reader()));
            }
            else if(source == butrate)
            {
                writer(calc.calculateMono(InneCalculations.MonoOperations.rate,reader()));
            }
            else if(source == butEqual)
            {
                writer(calc.calculateEqual(reader()));
            }
            else if(source == butCancel)
            {
                writer(calc.reset());
            }
            text.selectAll();
        }
    }
    public double reader()
    {
        double number;
        String str;
        str=text.getText();
        number = Double.valueOf(str);
        return number;
    }
    public void writer(double number)
    {
        if(Double.isNaN(number))
        {
            text.setText("");
        }
        else
        {
            text.setText(Double.toString(number));
        }

    }
}
