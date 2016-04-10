package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

public class VisalSort extends JFrame {
	final String font = "Times";
	final Color color = Color.GREEN;
	final int headerSize = 15;
	final int labelSize =12;
	final double [] _values;
	final String [] _names;
	final Timer     _timer;
	final int       _delayms;
	int _i;
	
	public VisalSort(int N , int delayms ) {
		setSize(800,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		_delayms=delayms;
		
		_values = GetRandomDouble(N);
		_names = new String[N];
		for(int i =0; i < N ;i++) {
			_names[i]=Integer.toString(i);
		}
		BarChart bar = new BarChart("Sort",_values,_names,color,font,headerSize,labelSize);
		add(bar);
		_timer=new Timer(_delayms,new OnTimer());
		_timer.start();
		setVisible(true);
	}
	
	public static double [] GetRandomDouble(int N) {
		double [] X = new double[N];
		for( int i =0; i < N ;i++) X[i]=i;
		int len = X.length;
		Random r = new Random();
		for( int i =0; i < 3*len/2 ; i++) {
			int k = r.nextInt(len);
			int j = r.nextInt(len);
			double tmp = X[k];
			X[k]=X[j];
			X[j]=tmp;
		}		
		return X;
	}
	
	private class OnTimer  implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			nextSort();
			repaint();
		}
		
	}
	
	private void nextSort() {
		if ( _i >= _values.length-1) return;
		swap(getMinIx(_i),_i);
		++_i;
	}
	
	private void swap( int i , int j) {
		double tmp = _values[i];
		_values[i]=_values[j];
		_values[j]=tmp;
	}
	
	private int getMinIx(int k) {
		int ix = k;
		for( int i=k ; i < _values.length;i++) {
			if (_values[i] < _values[ix] ) ix=i;
		}
		return ix;
	}
	
	
	static public void main(String [] args ) {
		new VisalSort(200,100);
	}
	
}
