import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class myFrame extends JFrame{
	private int count = 0;
	public static final int WIDTH = 100;
	public static final int HEIGHT = 80;
	public myFrame(String title){
		super(title);
		createBackground()
	}
	public void createBackground(){
		this.getContentPane().setLayout(new FlowLayout());
		ImageIcon icon;
		JLabel label1;
		icon = new ImageIcon("pic/background.png");
		for(int i=0;i<100;i++){
			icon = resizeImage(WIDTH,HEIGHT,icon);
			label1 = new JLabel(icon);
			add(label1);
		}
	}
 	private ImageIcon resizeImage(int _width,int _height,ImageIcon imageIcon){
		Image img = imageIcon.getImage().getScaledInstance(_width,_height,java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(img);
	}
}
