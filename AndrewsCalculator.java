package andrewscalculator;

// andrew goldman
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class AndrewsCalculator extends JFrame
{

    private JFrame jf;
    private JTextField jtf;
    private JButton dot, plus, minus, divide, multiply, equals, clear, backspace;
    private JButton[] num =
    {
        new JButton("0"), new JButton("1"), new JButton("2"), new JButton("3"), new JButton("4"),
        new JButton("5"), new JButton("6"), new JButton("7"), new JButton("8"), new JButton("9")
    };
    private String a;
    private int adder, subtracter, multiplyer, divider, first, second, equaler, checker, numberpressed, operandpressed,
            calculate, store, firstpressed;
    private double x, z;

    public void run()
    {
        z = 0.0;
        x = 0.0;
        firstpressed = 1;

        jtf = new JTextField();
        dot = new JButton(".");
        plus = new JButton("+");
        minus = new JButton("-");
        divide = new JButton("%");
        multiply = new JButton("*");
        equals = new JButton("=");
        clear = new JButton("Clear");
        backspace = new JButton("<<<");

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(240, 255);
        this.setLocation(600, 200);
        this.setTitle("Calculator");

        jtf.setHorizontalAlignment(JTextField.RIGHT);
        jtf.setSize(215, 30);
        jtf.setLocation(5, 5);
        jtf.setBackground(Color.WHITE);

        for (int x = 0; x < num.length; x++)
        {
            String j = x + "";
            num[x] = new JButton(j);
            this.add(num[x]);
            num[x].addActionListener(new numberbuttonhandler());
        }

        num[1].setSize(50, 30);
        num[1].setLocation(5, 40);
        num[2].setSize(50, 30);
        num[2].setLocation(60, 40);
        num[3].setSize(50, 30);
        num[3].setLocation(115, 40);
        plus.setSize(50, 30);
        plus.setLocation(170, 40);
        num[4].setSize(50, 30);
        num[4].setLocation(5, 75);
        num[5].setSize(50, 30);
        num[5].setLocation(60, 75);
        num[6].setSize(50, 30);
        num[6].setLocation(115, 75);
        minus.setSize(50, 30);
        minus.setLocation(170, 75);
        num[7].setSize(50, 30);
        num[7].setLocation(5, 110);
        num[8].setSize(50, 30);
        num[8].setLocation(60, 110);
        num[9].setSize(50, 30);
        num[9].setLocation(115, 110);
        multiply.setSize(50, 30);
        multiply.setLocation(170, 110);
        dot.setSize(50, 30);
        dot.setLocation(5, 145);
        num[0].setSize(50, 30);
        num[0].setLocation(60, 145);
        equals.setSize(50, 30);
        equals.setLocation(115, 145);
        divide.setSize(50, 30);
        divide.setLocation(170, 145);
        clear.setSize(105, 30);
        clear.setLocation(5, 180);
        backspace.setSize(105, 30);
        backspace.setLocation(115, 180);

        this.add(jtf);
        this.add(dot);
        this.add(plus);
        this.add(minus);
        this.add(multiply);
        this.add(divide);
        this.add(clear);
        this.add(backspace);
        this.add(equals);

        dot.addActionListener(new dotbuttonhandler());
        plus.addActionListener(new plusbuttonhandler());
        minus.addActionListener(new subtractbuttonhandler());
        multiply.addActionListener(new multiplybuttonhandler());
        divide.addActionListener(new dividebuttonhandler());
        clear.addActionListener(new clearbuttonhandler());
        backspace.addActionListener(new backspacebuttonhandler());
        equals.addActionListener(new equalsbuttonhandler());
        jtf.addKeyListener(new ScreeningHandler());



    }

    public class ScreeningHandler implements KeyListener
    {

        @Override
        public void keyPressed(KeyEvent e)
        {
//            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void keyReleased(KeyEvent e)
        {
//            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void keyTyped(KeyEvent e)
        {
            char c = e.getKeyChar();
            if (c >= 48 && c <= 57 || c == 46)
            {
                if (jtf.getText().contains(".") && c == 46)
                {
                    e.consume();
                }
            } else
            {
                e.consume();
            }
        }
    }

    public class numberbuttonhandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            JButton x = (JButton) e.getSource();
            if (checker == 0)
            {
                numCheck();
                jtf.setText(jtf.getText() + x.getText());

            } else
            {
                jtf.setText(jtf.getText() + x.getText());
            }
            numberpressed = 1;
            firstpressed = 0;
        }
    }

    public class plusbuttonhandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {


            if (firstpressed == 0)
            {
                adder = 1;
                if (operandpressed == 1 && numberpressed == 0)
                {
                    multiplyer = 0;
                    subtracter = 0;
                    divider = 0;
                } else
                {
                    if (first == 1)
                    {
                        calculate();
                    }

                    if (second == 0)
                    {
                        storeFirst();
                    }

                    if (equaler == 1)
                    {
                        storeFirst();
                        equaler = 0;
                        z = 0;
                    }
                }
                numberpressed = 0;
                operandpressed = 1;
                equaler = 0;
                jtf.setText(x + "");
            }

        }
    }

    public class subtractbuttonhandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {


            if (firstpressed == 0)
            {
                subtracter = 1;
                if (operandpressed == 1 && numberpressed == 0)
                {
                    multiplyer = 0;
                    adder = 0;
                    divider = 0;

                } else
                {
                    if (first == 1)
                    {
                        calculate();
                    }

                    if (second == 0)
                    {
                        storeFirst();
                    }

                    if (equaler == 1)
                    {
                        storeFirst();
                        equaler = 0;
                        z = 0;
                    }
                }
                numberpressed = 0;
                operandpressed = 1;
                equaler = 0;
                jtf.setText(x + "");
            }



        }
    }

    public class multiplybuttonhandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {


            if (firstpressed == 0)
            {
                multiplyer = 1;
                if (operandpressed == 1 && numberpressed == 0)
                {
                    subtracter = 0;
                    adder = 0;
                    divider = 0;

                } else
                {
                    if (first == 1)
                    {
                        calculate();
                    }

                    if (second == 0)
                    {
                        storeFirst();
                    }

                    if (equaler == 1)
                    {
                        storeFirst();
                        equaler = 0;
                        z = 0;
                    }
                }
                numberpressed = 0;
                operandpressed = 1;
                equaler = 0;
                jtf.setText(x + "");
            }


        }
    }

    public class dividebuttonhandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {


            if (firstpressed == 0)
            {
                divider = 1;
                if (operandpressed == 1 && numberpressed == 0)
                {
                    multiplyer = 0;
                    subtracter = 0;
                    adder = 0;
                } else
                {
                    if (first == 1)
                    {
                        calculate();
                    }

                    if (second == 0)
                    {
                        storeFirst();
                    }

                    if (equaler == 1)
                    {
                        storeFirst();
                        equaler = 0;
                        z = 0;
                    }
                }
                numberpressed = 0;
                operandpressed = 1;
                equaler = 0;
                jtf.setText(x + "");
            }


        }
    }

    public class equalsbuttonhandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {

            if (numberpressed != 0 || operandpressed != 0)
            {
                if (jtf.getText() != null)
                {
                    calculate();
                    equaler = 1;
                    jtf.setText(x + "");
                    numberpressed = 0;
                    operandpressed = 0;
                    multiplyer = 0;
                    adder = 0;
                    divider = 0;
                    subtracter = 0;
                    checker = 0;
                    first = 0;
                    second = 0;
                }
            }
        }
    }

    public class dotbuttonhandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (jtf.getText().contains(".") != true)
            {
                jtf.setText(jtf.getText() + ".");
            }
        }
    }

    public class clearbuttonhandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            clear();
        }
    }

    public class backspacebuttonhandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (jtf.getText().length() > 0)
            {
                jtf.setText(jtf.getText().substring(0, jtf.getText().length() - 1));
            }
        }
    }

    private void calculate()
    {
        storeSecond();
        if (multiplyer == 1)
        {
            x = x * z;
            z = 0.0;
            multiplyer = 0;
        }

        if (divider == 1)
        {
            try
            {
                divide();
            } catch (DivideByZeroException dz)
            {
            }

            z = 0.0;
            divider = 0;
        }

        if (adder == 1)
        {
            x = x + z;
            z = 0.0;
            adder = 0;
        }

        if (subtracter == 1)
        {
            x = x - z;
            z = 0.0;
            subtracter = 0;
        }

        checker = 0;
        numberpressed = 0;
        calculate = 1;

    }

    //this one is used to store values into the two variables x an z respectively. 
    private void storeSecond()
    {
        a = jtf.getText();
        z = Double.parseDouble(a);
        second = 1;
        numberpressed = 0;
    }

    private void storeFirst()
    {
        a = jtf.getText();
        x = Double.parseDouble(a);
        first = 1;
        numberpressed = 0;
        store = 1;
    }

    //ok so the whole point of this method is to see if operators have been pushed. 
    //if they have, clear the text, start a new number and note that you have.
    private void numCheck()
    {
        if (equaler == 1)
        {
            clear();
        }

        if (multiplyer == 1 || divider == 1 || subtracter == 1 || adder == 1 || calculate == 1 || store == 1)
        {
            jtf.setText("");
            checker = 1;
        }

    }

    //this is the reset button. it puts everything back to where it was when you first started the program
    private void clear()
    {
        jtf.setText("");
        x = 0.0;
        z = 0.0;
        subtracter = 0;
        adder = 0;
        multiplyer = 0;
        divider = 0;
        first = 0;
        second = 0;
        equaler = 0;
        checker = 0;
        store = 0;
        calculate = 0;
        firstpressed = 1;
    }

    private void divide() throws DivideByZeroException
    {

        x = x / z;


    }

    public class DivideByZeroException extends Exception
    {

        public DivideByZeroException()
        {
            jtf.setText("you just divided by zero, try a mathmatical expression that exists.");
        }
    }

    public static void main(String[] args)
    {
        AndrewsCalculator ac = new AndrewsCalculator();
        ac.run();

    }
}
