package gui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class FunctionGraph extends JPanel{
    public final int PAD = 20;
    private DataGen data;
    

    FunctionGraph() {
	data=null;
    }

    FunctionGraph( DataGen data ) {
	this.data=data;
    }

    void setData( DataGen d ) {
	data = d;
    }

    public void paint( Graphics g) {
	super.paintComponent(g);
	Graphics2D g2 = (Graphics2D)g;
	
        plotData(g);
    }
    

    private void plotData(Graphics g) {
	Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        drawXLabel(g);
        drawYLabel(g);
	
        Scale sX = new Scale();
        Scale sY = new Scale();
        
        sY.gMax = PAD;
        sY.gMin = getHeight() - PAD;
        sY.dMax = data.maxY;
        sY.dMin = data.minY;
        sY.setZero();
        
        sX.gMax = getWidth() - PAD;
        sX.gMin = PAD;
        sX.dMax = data.maxX;
        sX.dMin = data.minX;
        sX.setZero();
        
        g2.draw(new Line2D.Double(sX.gMin,sY.gMax,sX.gMax,sY.gMax));
        g2.draw(new Line2D.Double(sX.gMin,sY.gMin,sX.gMax,sY.gMin));
        g2.draw(new Line2D.Double(sX.gMin,sY.gMin,sX.gMin,sY.gMax));
        g2.draw(new Line2D.Double(sX.gMax,sY.gMin,sX.gMax,sY.gMax));
        
        g2.draw(new Line2D.Double(sX.zero,sY.gMin,sX.zero,sY.gMax));
        g2.draw(new Line2D.Double(sX.gMin,sY.zero,sX.gMax,sY.zero));
        
        
        int N = data.size();
        for( int i = 0; i < N-1 ; i++ ) {
	    double x0 = data.X[i];
	    double x1 = data.X[i+1];
	    double y0 = data.Y[i];
	    double y1 = data.Y[i+1];
	    double x0t = sX.scale(x0);
	    double y0t = sY.scale(y0);
	    g2.draw(new Line2D.Double(sX.scale(x0),
				      sY.scale(y0),
				      sX.scale(x1),
				      sY.scale(y1)));	
        }
    }

    private void drawXLabel( Graphics g) {
	Graphics2D g2 = (Graphics2D)g;
	String xlabel = "X-Axis";
        Font font = g2.getFont();
        FontRenderContext frc = g2.getFontRenderContext();
        int w = getWidth();
        int h = getHeight();
        double wgt = 0.9f;
        double sx = wgt * w;
        double sw,sy;
        for( int i =0 ; i < xlabel.length();i++){
	    String l = String.valueOf(xlabel.charAt(i));
	    sw = (double)font.getStringBounds(l, frc).getWidth();
	    sy = h/2 - 4;
	    g2.drawString(l, (float)sx, (float)sy);
	    sx += sw;
	    
        }
    }
    
    private void drawYLabel( Graphics g) {
	Graphics2D g2 = (Graphics2D)g;
	int w = getWidth();
        int h = getHeight();
	double wgt = 0.08f;
        double sy = wgt * h - PAD;
        double sx = w/2 - 10;
        double sw;
        String ylabel= "Y-Axis";
        Font font = g2.getFont();
        FontRenderContext frc = g2.getFontRenderContext();
        for( int i =0 ; i < ylabel.length();i++){
	    String l = String.valueOf(ylabel.charAt(i));
	    sw = (double)font.getStringBounds(l, frc).getWidth();
	    g2.drawString(l, (float)sx, (float)sy);
	    sx += sw;
        }
	
    }
    
    //-----------------------------------------------------------
    // scale data onto graph
    //-----------------------------------------------------------
    private class Scale {
	double dMin;
	double dMax;
	double gMin;
	double gMax;
	double zero;
	
	double ratio() {
	    return (gMax-gMin)/(dMax-dMin);
	}
	
	void setZero() {
	    double r = dMax - dMin;
	    double z = Math.max(0, dMin);
	    double p = (z-dMin)/r;
	    zero = gMin + (gMax-gMin)*p;
	}
	
	double scale( double p ) {
	    return zero + p*ratio();
	}
    }
    

    //-------------------------------------------------------
    // main
    //-------------------------------------------------------
    public static void main( String [] args ){
	JFrame frame = new JFrame( "Graphics");
	frame.setSize(650,650);
	frame.add( new FunctionGraph(new DataGen(Math.PI*-2,Math.PI*2,2000,new XSquared())));
	frame.setLocation(1700,200);
	frame.setVisible(true);
    }
	
}

class XSquared implements FuncInterface {

    public double calc( double x ) {
    	return (Math.sin(x) - Math.cos(4*x))/(Math.PI/4+Math.cos(8*x));
    }
}

