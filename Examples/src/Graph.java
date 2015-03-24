
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.Line2D;

public class Graph extends JPanel{
	final int PAD = 20;
	
	private class Data {
		float [] x;
		float [] y;
		Data() {
			gen();
		}
		
		void gen() {
			int size = 100;
			x = new float[size];
			y = new float[size];
			float x0 = -10;
			for( int i = 0; i < x.length ; i++ ) {
				x[i]=x0;
				y[i]=-x0*x0*x0;
				x0 += 0.2;
			}
		}
		
		int size() {
			return x.length;
		}
		
		float maxX() {
			return getMax(x);
		}
		
		float maxY() {
			return getMax(y);
		}
		
		float getMax( float [] X ) {
			float m = Math.abs(X[0]);
			for( int i = 1 ; i < x.length;i++ )
				if ( Math.abs(X[i]) > m ) m = Math.abs(X[i]) ;
			return m;
		}
	}

	public void paint( Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
       
        drawAxis(g);
        drawXLabel(g);
        drawYLabel(g);
        plotData(g);
	}
	
	private void plotData( Graphics g) {
		int algo = 2;
		if ( algo == 1) plotAlgo1(g);
		if ( algo == 2) plotAlgo2(g);
				
		
	}
	
	private float trans( float rangeData , float rangePlot , float start , float maxData , float pt) {
		float r = rangePlot / rangeData;
		return start + (maxData - pt ) * r;
	}
	
	
	private void plotAlgo2( Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		int w = getWidth();
        int h = getHeight();
        //float y0 = h/2;
        //float x0 = w/2;
        float yMax = PAD;
        float yMin = h - PAD;
        float xMin = PAD;
        float xMax = w - PAD;
        
        // y - upper bound line 
        g2.setPaint( Color.green.darker());
        //g2.
        g2.draw(new Line2D.Double(xMin,yMax,xMax,yMax));
        
        // y -- lower bound line 
        g2.setPaint(Color.black);
        g2.draw(new Line2D.Double(xMin,yMin,xMax,yMin));
        
        // x -- lower bound line 
        g2.draw(new Line2D.Double(xMin,yMin,xMin,yMax));
        
        // x -- upper bound line 
        g2.draw(new Line2D.Double(xMax,yMin,xMax,yMax));
        
        float [] dataX = new float[100];
        float [] dataY = new float[100];
        float start = -100;
        float step = 2;
        for ( int i = 0 ; i < dataX.length ; i++) {
        	dataX[i] = start + i*step;
        	dataY[i] = dataX[i]*dataX[i];
        }
        
        float lbx = dataX[0];
        float ubx = dataX[dataX.length-1];
        float rdatax = ubx - lbx;
        float lby = 0;
        float uby = 10000;
        float rdatay = uby-lby;
        float ry = yMax - yMin;
        float rx = xMax - xMin;
        float ystart = yMin;
        float xstart = xMin;
        
        for( int i = 0; i < dataX.length -1 ; i++ ){
        	float x0 = dataX[i];
        	float x1 = dataX[i+1];
        	float y0 = dataY[i];
        	float y1 = dataY[i+1];
        	System.out.println(x0 + " " + y0 + " " +xMin + " " + xMax + " " +yMin + " " +yMax );
        	if ( i > 5) break;
        	//float x0T = trans(rdatax,rx,xstart,ubx,x0);
        	//float x1T = trans(rdatax,rx,xstart,ubx,x1);
        	//float y0T = trans(rdatay,ry,ystart,uby,y0);
        	//float y1T = trans(rdatay,ry,ystart,uby,y1);
        	//g2.draw(new Line2D.Double(x0T,y0T,x1T,y1T));
        	
        }
        		
        
        
	}
	
	private void plotAlgo1( Graphics g) {
		
		int w = getWidth();
        int h = getHeight();
		Data d = new Data();
		float maxX = d.maxX();
		float maxY = d.maxY();
		float xscale = (w/2)/maxX;
		float yscale = (h/2)/maxY;
		Graphics2D g2 = (Graphics2D)g;
		for( int i = 0; i < d.size()-1; i++) {
			float x0 = w/2 - d.x[i]*xscale;
			float y0 = h/2 - d.y[i]*yscale;
			float x1 = w/2 - d.x[i+1]*xscale;
			float y1 = h/2 - d.y[i+1]*yscale;
			g2.draw(new Line2D.Double(x0,y0,x1,y1));
			
		}
	}
	
	private void drawAxis( Graphics g) {
		int w = getWidth();
        int h = getHeight();
        Graphics2D g2 = (Graphics2D)g;
		g2.draw( new Line2D.Double(w/2, PAD, w/2, h-PAD));
        g2.draw( new Line2D.Double(PAD,h/2,w-PAD,h/2));
	}
	
	private void drawXLabel( Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		String xlabel = "X-Axis";
        Font font = g2.getFont();
        FontRenderContext frc = g2.getFontRenderContext();
        int w = getWidth();
        int h = getHeight();
        float wgt = 0.9f;
        float sx = wgt * w;
        float sw,sy;
        for( int i =0 ; i < xlabel.length();i++){
        	String l = String.valueOf(xlabel.charAt(i));
        	sw = (float)font.getStringBounds(l, frc).getWidth();
        	sy = h/2 - 4;
        	g2.drawString(l, sx, sy);
        	sx += sw;
        	
        }
	}
	
	private void drawYLabel( Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		int w = getWidth();
        int h = getHeight();
		float wgt = 0.08f;
        float sy = wgt * h - PAD;
        float sx = w/2 - 10;
        float sw;
        String ylabel= "Y-Axis";
        Font font = g2.getFont();
        FontRenderContext frc = g2.getFontRenderContext();
        for( int i =0 ; i < ylabel.length();i++){
        	String l = String.valueOf(ylabel.charAt(i));
        	sw = (float)font.getStringBounds(l, frc).getWidth();
        	g2.drawString(l, sx, sy);
        	sx += sw;
        }
        
	}
	
	public static void main( String [] args ){
		JFrame frame = new JFrame( "Graphics");
		frame.setSize(650,650);
		frame.add( new Graph());
		frame.setLocation(1700,200);
		frame.setVisible(true);
		
	}
	
}
