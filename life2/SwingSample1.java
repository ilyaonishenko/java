import javax.swing.*;
public class SwingSample1{
	public static void main(String[] args){
		int width = 2000, height = 1000;
		myFrame mainFrame = new myFrame("Hello SWING!!!");
        mainFrame.setSize(width, height);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
	}
}
