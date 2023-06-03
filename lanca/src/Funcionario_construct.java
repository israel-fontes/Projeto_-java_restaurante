import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;

public class Funcionario_construct extends JFrame {
    Funcionario_construct() {
        this.setTitle("JFrame title goes here");// sets title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(420, 420);// sets the x and y dimension
        this.setVisible(true);
        ImageIcon image = new ImageIcon("key.png");// cria o icone do frame
        this.setIconImage(image.getImage());// muda o icon pela imagen que criamos
        this.getContentPane().setBackground(Color.blue);
    }
}
