import javax.swing.*;
import java.awt.*;

public class Fondo extends JPanel {
    public Image image;

    @Override
    public void paint(Graphics g)
    {
        image = new ImageIcon(getClass().getResource("./Imagenes/G.png")).getImage();
        g.drawImage(image,0,0,getWidth(),getHeight(),this);
        setOpaque(false);
        super.paint(g);
    }
}
