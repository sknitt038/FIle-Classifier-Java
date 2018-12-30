import java.awt.*;
import javax.swing.*;
import javax.swing.JPanel;
class TSPanel
{
   /* public TSPanel ()
    {
        //this.setBackground (Color.blue);
        Dimension d1 = new Dimension(250, 150);
        this.setMaximumSize(d1);
    }
    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        g.drawString ("Hello World!", 100, 100);
    }*/

 

    public static void main (String[] argv)
    {
        JFrame frame = new JFrame ();
        frame.setTitle ("Hello World Test");
        //frame.setResizable (true);
        frame.setSize (500, 300);
        JPanel j1=new JPanel();
        JPanel j2=new JPanel();
        j1.setbackground(Color.blue);
        //frame.getContentPane().add (panel);
        frame.setVisible (true);
    }
}