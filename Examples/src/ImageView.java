import java.awt.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import java.awt.geom.AffineTransform;

public class ImageView extends JFrame {
	public BufferedImage img;
	public BufferedImage simg;
	
	public ImageView(String fileName ) {
		readImage(fileName);
		simg = getScaledImage(img,24*20,32*20);
		ImageIcon icon = new ImageIcon(simg);
		JLabel label = new JLabel();
		label.setIcon(icon);
		getContentPane().add(label);
		pack();
		setVisible(true);
	}
	
	public static BufferedImage getScaledImage(BufferedImage image, int width, int height) { 
	    int imageWidth  = image.getWidth();
	    int imageHeight = image.getHeight();

	    double scaleX = (double)width/imageWidth;
	    double scaleY = (double)height/imageHeight;
	    AffineTransform scaleTransform = AffineTransform.getScaleInstance(scaleX, scaleY);
	    AffineTransformOp bilinearScaleOp = new AffineTransformOp(scaleTransform, 
								      AffineTransformOp.TYPE_BILINEAR);

	    return bilinearScaleOp.filter(image,
					  new BufferedImage(width, height, image.getType()));
	}

	public void readImage(String fileName) {	
		try {
			img = ImageIO.read( new File(fileName));
			System.out.println( img.getWidth() + " " + img.getHeight() );
		} catch( IOException e) {
			System.out.println(e);
		}
	}
	
	public void scale() {
		int type = (img.getTransparency() == Transparency.OPAQUE) ?
			    BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
		int iw = img.getWidth();
		int ih =img.getHeight();
		simg = new BufferedImage(400,400,type);
		Graphics2D g2 = img.createGraphics();
		AffineTransform at = AffineTransform.getScaleInstance(iw, ih);
		g2.drawRenderedImage(simg,at);
	}
	
	
	public static void main(String [] args ) {
		String fileName = "C:/Users/John/Pictures/2013-02-17 phone/phone 400.jpg";
		ImageView iview = new ImageView( fileName);
	}
	
}
