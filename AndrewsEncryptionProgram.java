package andrewsencryptionprogram;

// andrew goldman
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AndrewsEncryptionProgram extends JFrame
{

    JFileChooser a;
    JButton z, p;
    String key, name;
    FileInputStream fis;
    DataInputStream dis;

    public void run()
    {
        a = new JFileChooser();
        z = new JButton("Encrypt");
        p = new JButton("Decrypt");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(300, 300);
        this.setLocation(600, 200);
        this.setTitle("Encryption Program");
        this.add(p);
        this.add(z);

        z.setSize(200, 100);
        z.setLocation(50, 15);

        p.setSize(200, 100);
        p.setLocation(50, 135);

        z.addActionListener(new encryptionbuttonhandler());
        p.addActionListener(new decryptionbuttonhandler());


    }

    public class encryptionbuttonhandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            a.showOpenDialog(null);
            try
            {
                Scanner scan = new Scanner(System.in);
                fis = new FileInputStream(a.getSelectedFile());
                dis = new DataInputStream(fis);

                key = JOptionPane.showInputDialog("Enter Your Key");
                name = JOptionPane.showInputDialog("Enter Your File Name");
                char[] Test = key.toCharArray();

                FileOutputStream fos = new FileOutputStream(name + ".txt");
                DataOutputStream dos = new DataOutputStream(fos);

                try
                {
                    for (int x = 0; true; x++)
                    {
                        byte b = dis.readByte();
                        dos.writeInt(b + Test[x % key.length()]);

                    }
                } catch (Exception a)
                {
                    dis.close();
                }

            } catch (Exception j)
            {
                System.out.println(j);
            }
        }
    }

    public class decryptionbuttonhandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            a.showOpenDialog(null);
            try
            {
                Scanner scan = new Scanner(System.in);
                fis = new FileInputStream(a.getSelectedFile());
                dis = new DataInputStream(fis);

                key = JOptionPane.showInputDialog("Enter Your Key");
                name = JOptionPane.showInputDialog("Enter Your File Name");
                char[] Char = key.toCharArray();

                FileOutputStream fos = new FileOutputStream(name + ".txt");
                DataOutputStream dos = new DataOutputStream(fos);
                int z;
                char n;
                char y;

                try
                {
                    for (int x = 0; true; x++)
                    {
                        z = dis.readInt();
                        n = Char[x % key.length()];
                        dos.writeByte(z - n);
                    }

                } catch (Exception a)
                {
                    dis.close();
                }


            } catch (Exception j)
            {
                System.out.println(j);
            }
        }
    }

    public static void main(String[] args)
    {
        AndrewsEncryptionProgram z = new AndrewsEncryptionProgram();
        z.run();

    }
}
