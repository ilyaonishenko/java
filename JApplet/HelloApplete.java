import javax.swing.JApplet;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import java.applet.*;
import java.awt.*;
public class HelloApplete extends JApplet{
	public void init(){

	}
	public void print(Graphics g){
		g.drawRect(45, 50, 20, 80);
	}
}
