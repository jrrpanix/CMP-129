package gui;

/*
 * Example Bar Chart CMP-129
 * 
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class BarChart extends JPanel {
  private final double[] _values;
  private final String[] _names;
  private final String   _title;
  private final Color    _color;
  private final Font     _titleFont;
  private final Font     _labelFont;
  private FontMetrics    _titleMetrics;
  private FontMetrics    _labelMetrics;
  private double         _minValue;
  private double         _maxValue;
  

  public BarChart(final String title, 
		  	final double[] values, 
		  	final String[] names,
		  	final Color color,
		  	final String fontName , 
		  	final int titleSize, 
		  	final int labelSize ) {
	_title = title;
	_values = values;
	_names = names;
	_color = color;
    _titleFont = new Font(fontName, Font.BOLD, titleSize);
    _labelFont = new Font(fontName, Font.PLAIN, labelSize);
  }
  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
   
    SetParameters(g);
    SetTitle(g);
    SetValues(g);
  }
  
  private void SetParameters( Graphics g) {
	  _minValue = minV(_values);
	  _maxValue = maxV(_values);
	  _titleMetrics = g.getFontMetrics(_titleFont);
	  _labelMetrics = g.getFontMetrics(_labelFont);  
  }
  
  private void SetTitle(Graphics g) {
	  int titleWidth = _titleMetrics.stringWidth(_title);
	  int y = _titleMetrics.getAscent();
	  int x = (getClientWidth() - titleWidth) / 2;
	  g.setFont(_titleFont);
	  g.drawString(_title, x, y);
  }
  
  private void SetValues( Graphics g) {
	  final double Scale = getScale();
	  final int BarWidth = getBarWidth();
	  final int Top = _titleMetrics.getHeight();
	  final int LabelY = getLabelY();
	   
	  g.setFont(_labelFont);
	  for (int i = 0; i < _values.length; i++) {
		  final int X = getX(i,BarWidth);
	      final int Y = getY(Top,i,Scale);
	      final int H = getHeight(i,Scale);
	      g.setColor(_color);
	      g.fillRect(X, Y, BarWidth - 2, H);
	      g.setColor(Color.black);
	      g.drawRect(X, Y, BarWidth - 2, H);
	      g.drawString(_names[i], getLabelX(i,BarWidth), LabelY);
	  }
  }
  
  private int getX( final int i , final int barWidth) {
	  return i * barWidth + 1;
  }
  
  private int getY(final int top , final int i , final double scale ) {
	  return _values[i] > 0 ?
			  top + (int) ((_maxValue - _values[i]) * scale) :
				  top + (int) (_maxValue * scale);
  }
  
  private int getHeight(final int i , final double scale ) {
	  return (int)Math.abs(_values[i]*scale);
  }
  
  private int getLabelX(final int i , final int barWidth) {
	  return i * barWidth + (barWidth - _labelMetrics.stringWidth(_names[i])) / 2;
  }
  
  private int getLabelY() {
	  return getClientHeight() - _labelMetrics.getDescent();
  }
  
  private int getClientHeight() {
	  return getSize().height;
  }
  
  private int getClientWidth() {
	  return getSize().width;
  }
  
  private int getBarWidth() {
	  return getSize().width / _values.length;
  }

  private double getScale() {
	 double range = _maxValue - _minValue;
	 if ( range == 0) return 0;
	 return (getClientHeight() - _titleMetrics.getHeight() - _labelMetrics.getHeight()) / range;
  }
  
  
  
  private static double minV( final double [] V) {
	  double m = V[0];
	  for( int i = 1 ; i < V.length;i++) if ( V[i] < m) m = V[i];
	  return m;
  }
  
  private static double maxV( final double [] V) {
	  double m = V[0];
	  for( int i = 1 ; i < V.length;i++) if ( V[i] > m) m = V[i];
	  return m;
  }
  
  public static void runB(int N,final String fontName ,final Color color , final int titleSize, final int labelSize) {
	  final JFrame frame = new JFrame();
	  frame.setSize(1500,1000);
	  final String [] names = new String[N];
	  final double [] values = new double[N];
	  for( int i =0; i < N ;i++ ) {
		  names[i]=Integer.toString(i);
		  values[i]=i;
	  }

	  final String title = fontName + "_" + color;
	  frame.add(new BarChart(title,values,names,color,fontName,titleSize,labelSize));
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setVisible(true);
  }
  
  public static void main(String[] argv) {
	  runB(25,"Arial",Color.CYAN,25,20);
	  runB(25,"SansSerif",Color.MAGENTA,20,15);
	  runB(25,"Times",Color.GREEN,15,12);
  }
}
