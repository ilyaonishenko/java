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
	public char[] toPrint;
	private static final char pr = 'X';
	private static final char p = 'P';
	private static final char h = 'h';
	private static final char none = '-';
	public myFrame(String title){
		super(title);
		createBackground();
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
	public void EnvToBackground(char[] array){
		int size = Env.getSize();
		int loc = 0;
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				loc = i+10*j;
				if (Env.field[j][i]==none){
					array[loc] = none;
				}
				else if (Env.field[j][i]==pr){
					array[loc] = pr;
				}
				else if (Env.field[j][i]==p){
					array[loc] = p;
				}
				else {
					array[loc] = h;
				}
			}
		}
		repaint();
	}
	public void changeBackground(char[] array){
		clear();
		this.getContentPane().setLayout(new FlowLayout());
		EnvToBackground(array);
		ImageIcon icon;
		JLabel jLabel;
		for(int i=0;i<100;i++){
			if (array[i]==p){
				icon = new ImageIcon("pic/plant.png");
				icon = resizeImage(WIDTH,HEIGHT,icon);
				jLabel = new JLabel(icon);
				System.out.println("Hello1");
				add(jLabel);
			}
			else if (array[i]==none){
				icon = new ImageIcon("pic/background.png");
				icon = resizeImage(WIDTH,HEIGHT,icon);
				jLabel = new JLabel(icon);
				System.out.println("Hello2");
				add(jLabel);
			}
			else if (array[i]==pr){
				icon = new ImageIcon("pic/predator.png");
				icon = resizeImage(WIDTH,HEIGHT,icon);
				jLabel = new JLabel(icon);
				System.out.println("Hello3");
				add(jLabel);
			}
			else if (array[i]==h){
				icon = new ImageIcon("pic/herbivore.png");
				icon = resizeImage(WIDTH,HEIGHT,icon);
				jLabel = new JLabel(icon);
				System.out.println("Hello4");
				add(jLabel);
			}
		}
		revalidate();
		repaint();
	}
	public void clear(){
		getContentPane().removeAll();
		revalidate();
		repaint();
	}
}
