package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Draw extends JFrame {

	public Draw() {
		super("Drawing Demo");
		setSize(800,800);
		setLocation(400,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new Inner());
		setVisible(true);
	}
	
	private class Inner extends JPanel {
		
		private Timer _timer;
		private int   _delay;
		private int   _x;
		private int   _y;
		private int   _r;
		private int   _up;
		private int   _bounce;
		private int   _c;
		private int   _radius;
		private double   _radians;
		private double   _rotation;
		
		public Inner() {
			_delay = 250;
			_r=50;
			_bounce = 100;
			_radius = 200;
			_radians = 0;
			_rotation = -Math.PI/16;
			_timer = new Timer( _delay , new TimerFire() );
			_timer.start();
		}
		
		
		private class TimerFire implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				rotate();
			}
			
		}
		
		public void rotate() {
			setXY();
			repaint();
		}
		
		public void bounce() {
			_up = _up * -1;
			_y += _bounce * _up;
			repaint();
		}
		
		public void init() {
			
			Dimension d = getSize();
			_x = d.width/2 - _radius/2;
			_y= d.height/2 + _radius;
			_up= 1;
		}
		
		public void setXY() {
			Dimension d = getSize();
			int x0 = d.width/2;
			int y0 = d.height/2;
			_x = x0 +  (int)(_radius * Math.cos(_radians));
			_y = y0 +  (int)(_radius * Math.sin(_radians));
			_radians += _rotation;
		}
		
		public void paint(Graphics g) {
			super.paint(g);
			drawCross(g);
			drawBounce(g);
			//Dimension d = getSize();
			//drawBall(g,d.width/2,d.height/2,40);
		}
		
		public void drawBounce( Graphics g) {
			g.setColor(Color.BLUE);
			g.drawOval(_x, _y, _r, _r);
			g.fillOval(_x, _y, _r, _r);
		}
		
		public void drawBall(Graphics g, int x , int y , int r) {
			g.setColor(Color.BLUE);
			g.drawOval(x, y, r, r);
			g.fillOval(x, y, r, r);
			
			int bounce = 100;
			g.drawOval(x, y-bounce, r, r);
			g.fillOval(x, y-bounce, r, r);
		}
		
		public void drawCross(Graphics g) {
			g.setColor(Color.green);
			Dimension d = getSize();
			int x1 = d.width/2;
			int y1 = 0;
			int x2 = x1;
			int y2= d.height;
			g.drawLine(x1,y1,x2,y2);
			x1=0;
			y1=d.height/2;
			x2=d.width;
			y2=d.height/2;
			g.drawLine(x1,y1,x2,y2);	
		}
		
		
	}
	
	
	
	
	public static void main(String [] args) {
		new Draw();
	}
	
	
}
