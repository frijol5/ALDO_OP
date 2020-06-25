import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuitarADN extends JFrame implements ActionListener {

    JPanel panel;
    JButton opcion1;
    JButton opcion2;
    JButton opcion3;
    JLabel gameOver;
    JLabel win;
    JButton retry;
    private int count = 0;
    private int reset = 0;

    MiReproductor m = new MiReproductor();



    public GuitarADN() {
        m.inicializar();
        panel = new Fondo();
        panel.setLayout(null);

        opcion1 = new JButton("C");
        opcion1.setBounds(400,50,100,50);
        opcion2 = new JButton("F");
        opcion2.setBounds(505,50,100,50);
        opcion3 = new JButton("Bb");
        opcion3.setBounds(610,50,100,50);

        retry = new JButton("RETRY");
        retry.setBounds(715,50,100,50);
        retry.setVisible(false);


        gameOver = new JLabel("GAMEOVER");
        gameOver.setBounds(50,50,350,50);
        gameOver.setForeground(Color.decode("0xE0A83D"));
        gameOver.setFont(new Font("SansSerif",Font.ITALIC,49));
        gameOver.setVisible(false);

        win = new JLabel("YOU WIN");
        win.setBounds(500,200,350,100);
        win.setForeground(Color.decode("0xE0A83D"));
        win.setFont(new Font("SansSerif",Font.ITALIC,49));
        win.setVisible(false);



        panel.add(opcion1);
        panel.add(opcion2);
        panel.add(opcion3);
        panel.add(retry);
        panel.add(gameOver);
        panel.add(win);


        this.add(panel);
        this.setTitle("Guitar ADN");
        this.setSize(1000, 600);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        opcion1.addActionListener(this);
        opcion2.addActionListener(this);
        opcion3.addActionListener(this);
        retry.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        m.cambiarInstrumento(0,25);
        if (e.getSource() == opcion1 && reset == 0)
        {

            if (count==6)
            {
              win.setVisible(true);
              retry.setVisible(true);
            }
            if (count==5)
            {
                opcion1.setText("Asus2");
                opcion2.setText("E#maj7");
                opcion3.setText("Bbm9");
                count++;
                repaint();
            }
            if (count==4)
            {
                gameOver.setVisible(true);
                retry.setVisible(true);
                reset = 1;
            }
            if (count==3)
            {
                gameOver.setVisible(true);
                retry.setVisible(true);
                reset = 1;
            }
            if(count==2)
            {
                gameOver.setVisible(true);
                retry.setVisible(true);
                reset = 1;
            }
            if (count==1)
            {
                gameOver.setVisible(true);
                retry.setVisible(true);
                reset = 1;
            }
            if (count==0)
            {
                opcion1.setText("E");
                opcion2.setText("Gb");
                opcion3.setText("Cm");
                count++;
                m.reproducirAcorde(60,64,67,72,0,1000);
                repaint();

            }
        }
        if (e.getSource() == opcion2 && reset == 0)
        {
            if (count==6)
            {
                gameOver.setVisible(true);
                retry.setVisible(true);
                reset = 1;
            }
            if (count==5)
            {
                gameOver.setVisible(true);
                retry.setVisible(true);
                reset = 1;
            }
            if (count==4)
            {
                gameOver.setVisible(true);
                retry.setVisible(true);
                reset = 1;
            }
            if (count==3)
            {
                gameOver.setVisible(true);
                retry.setVisible(true);
                reset = 1;
            }
            if (count==2)
            {
                opcion1.setText("D7");
                opcion2.setText("Gb");
                opcion3.setText("B");
                count++;
                repaint();
            }
            if (count==1)
            {
                gameOver.setVisible(true);
                retry.setVisible(true);
                reset = 1;
            }
           if (count==0)
           {
                gameOver.setVisible(true);
               retry.setVisible(true);
                reset = 1;
           }
        }
        if (e.getSource() == opcion3 && reset == 0)
        {
            if (count==6)
            {
                gameOver.setVisible(true);
                retry.setVisible(true);
                reset = 1;
            }
            if (count==5)
            {
                gameOver.setVisible(true);
                retry.setVisible(true);
                reset = 1;
            }
            if (count==4)
            {
                opcion1.setText("G");
                opcion2.setText("D#m7");
                opcion3.setText("F#m");
                count++;
                repaint();
            }
            if (count==3)
            {
                opcion1.setText("G7");
                opcion2.setText("Bm");
                opcion3.setText("E");
                count++;
                repaint();
            }
            if(count==2)
            {
                gameOver.setVisible(true);
                retry.setVisible(true);
                reset = 1;
            }
            if (count==1)
            {
                opcion1.setText("A#");
                opcion2.setText("A");
                opcion3.setText("CMAj9");
                count++;
                repaint();
            }
            if (count==0)
            {
                gameOver.setVisible(true);
                retry.setVisible(true);
                reset = 1;
            }
        }
        if (e.getSource() == retry)
        {
            opcion1.setText("C");
            opcion2.setText("F");
            opcion3.setText("Bb");
            count = 0;
            reset = 0;
            retry.setVisible(false);
            gameOver.setVisible(false);
            win.setVisible(false);
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.yellow);

        if (count==0)
        {
            g.fillOval(810,468,10,10);//Do
            g.fillOval(875,483,10,10);
            g.fillOval(950,518,10,10);
        }
        if (count==1)
        {
            g.fillOval(810,450,10,10);
            g.fillOval(810,468,10,10);//Cm
            g.fillOval(695,483,10,10);
            g.fillOval(695,500,10,10);
            g.fillOval(750,518,10,10);
            g.fillOval(810,533,10,10);
        }

        if (count==2){
            g.fillOval(875,483,10,10);
            g.fillOval(875,500,10,10);//A
            g.fillOval(875,517,10,10);
        }
        if (count==3)
        {
            g.fillOval(875,467,10,10);
            g.fillOval(750,483,10,10);
            g.fillOval(750,500,10,10);
            g.fillOval(750,517,10,10);
            g.fillOval(875,533,10,10);
        }
        if (count==4)
        {
            g.fillOval(875,467,10,10);
            g.fillOval(875,483,10,10);//E
            g.fillOval(945,500,10,10);
        }

        if (count==5)
        {
            g.fillOval(810,450,10,10);
            g.fillOval(875,467,10,10);//G
            g.fillOval(810,518,10,10);
            g.fillOval(810,533,10,10);
        }
        if (count==6)
        {
            g.fillOval(875,483,10,10);
            g.fillOval(875,500,10,10);
        }
       /* if (count==7)
        {
            g.fillOval(875,500,10,10);
            g.fillOval(810,518,10,10);
            g.fillOval(875,533,10,10);

        }

        */


























    }



}
//C0
//Cm1
//A2
//B3
//E4
//G5
//Asus2 6