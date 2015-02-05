package gui.sidebar;

import java.awt.Color;
import javax.swing.JPanel;

public class SideBar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static int x;
	private static int y;
	private static int w;
	private static int h;
	
	public static void setBoundsStatic(int x1, int y1, int w1, int h1){
		x=x1;y=y1;w=w1;h=h1;
	}
	
	public SideBar(){
		super(null);
		this.setBackground(new Color(60,60,60));
		setBounds(x,y,w,h);
	}

}
