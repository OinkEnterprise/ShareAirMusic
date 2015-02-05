package gui;

import gui.principal.Inicio;
import gui.principal.Principal;
import gui.sidebar.Conectarse;
import gui.sidebar.SideBar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SideBar sideBar;
	public Principal principal;
	
	private double ratio=0.23;
	public static Dimension screenSize;
	public static Dimension prinSize;
	public static Dimension tracksSize;
	public static double ratioW;
	public static double ratioH;
	private static Random rand = new Random();

	
	public static BufferedImage resize(URL path, int newW, int newH) {
		
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(path);
		    int w = bufferedImage.getWidth();
		    int h = bufferedImage.getHeight();
		    BufferedImage bufim = new BufferedImage(newW, newH, bufferedImage.getType());
		    Graphics2D g2 = bufim.createGraphics();
		    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		    g2.drawImage(bufferedImage, 0, 0, newW, newH, 0, 0, w, h, null);
		    g2.dispose();
		
		    return bufim;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bufferedImage;
		}
	
	public static BufferedImage resize(BufferedImage bufferedImage, int newW, int newH) {
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        BufferedImage bufim = new BufferedImage(newW, newH, bufferedImage.getType());
        Graphics2D g = bufim.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(bufferedImage, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();
        return bufim;
    }
	
	public static BufferedImage loadImage(String pathName) {
        BufferedImage bimage = null;
        try {
            bimage = ImageIO.read(new File(pathName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bimage;
    }
	
	public static int trans(double d, double ratio){
		return (int)Math.round(d*ratio);
	}
	
	
	
	
	
	
	public static BufferedImage colorImage(BufferedImage image, List<int[]> colors, int w, int h) {
		image = resize(image,w,h);
		int[] color = colors.get(rand.nextInt(colors.size()-1));
        int width = image.getWidth();
        int height = image.getHeight();
        WritableRaster raster = image.getRaster();

        for (int xx = 0; xx < width; xx++) {
            for (int yy = 0; yy < height; yy++) {
                int[] pixels = raster.getPixel(xx, yy, (int[]) null);
                pixels[0] = color[0];
                pixels[1] = color[1];
                pixels[2] = color[2];
                raster.setPixel(xx, yy, pixels);
            }
        }
        return image;
    }
	
	public static void changeColorIcon(JLabel image, String file, List<int[]> colors,int w, int h){
		try {
			image.setIcon(new ImageIcon(colorImage(ImageIO.read(GUI.class.getResource(file)), colors,w,h)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	static GUI gui;
	static public GUI getGui(){
		if (gui == null){
			gui = new GUI();
		}
		
		return gui;
	}
	
	
	/**
	 * Create the frame.
	 */
	private GUI() {
		setResizable(false);
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		prinSize = new Dimension((int)Math.round(screenSize.width*(1-ratio)), screenSize.height);
		tracksSize = new Dimension((int)Math.round(screenSize.width*ratio), screenSize.height);
		ratioW = screenSize.width/1920.0;
		ratioH = screenSize.height/1080.0;
		
		setBounds(0, 0, screenSize.width, screenSize.height);
		
		Principal.setBoundsStatic(tracksSize.width, 0, prinSize.width, prinSize.height);
		SideBar.setBoundsStatic(0, 0, tracksSize.width, tracksSize.height);
		
		principal = new Inicio();
		sideBar = new Conectarse();
		
		principal.setVisible(true);
		sideBar.setVisible(true);
		
		
		getContentPane().setLayout(null);
		getContentPane().add(sideBar);
		getContentPane().add(principal);
		
		
		this.setUndecorated(true);
		this.setVisible(true);
		
		/*
		//full screen
		GraphicsDevice device  = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		
		setVisible(false);
        //remove the frame from being displayable.
        dispose();
        //remove borders around the frame
        setUndecorated(true);
        //make the window fullscreen.
        device.setFullScreenWindow(this);
        setResizable(false);
        setAlwaysOnTop(false);
        //show the frame
        setVisible(true);
		*/
	}
	
	
	
}