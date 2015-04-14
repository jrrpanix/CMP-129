import java.awt.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
//import java.awt.geom.AffineTransform;
import java.awt.geom.*;


public class JPGLoader {

    //public BufferedImage origImg;
    //public BufferedImage scaledImg;
    

    public static BufferedImage getScaledImage( String fileName , int width , int height ) {
	BufferedImage img = readImage(fileName);
	if ( img == null ) {
	    System.out.println("img null!");
	}
	return getScaledImage(img,width,height);
    }


    public static BufferedImage readImage(String fileName) {	
	System.out.println("reading image " + fileName);
	BufferedImage img = null;
	try {
	    img = ImageIO.read( new File(fileName));
	} catch( IOException e) {
	    System.out.println(e);
	}
	return img;
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
    

}