package gui;

import java.awt.Color;
import java.util.Random;
import javax.swing.JFrame;


public class VisualSorting extends JFrame{
	final String _font = "Arial";
	final Color _color = Color.GREEN;
	final int _headerSize = 15;
	final int _labelSize =8;
	final double [] _values;
	final String [] _names;
	final int       _delayms;
	final SortAlgo  _algo;
	boolean         _isdone;
	
	public VisualSorting(int N , int delayms , String algo ) {
		setSize(800,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		_delayms=delayms;
		_values = GetRandomDouble(N);
		_names = new String[N];
		for(int i =0; i < N ;i++) {
			_names[i]=Integer.toString(i);
		}
		BarChart bar = new BarChart(algo,_values,_names,_color,_font,_headerSize,_labelSize);
		add(bar);
		_isdone=false;
		if (algo.equals("merge"))
			_algo = new Merge();
		else
			_algo = new Selection();
		_algo.init(_values, _delayms);
		setVisible(true);
		_algo.start();
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
	
	public interface SortAlgo {
		
		void init( double [] values , int delayms );
		void start();
	}
	
	private class Selection implements SortAlgo {
		private double [] _values;
		private int       _delayms;
		private int       _i;
		
		@Override
		public void init(double[] values, int delayms) {
			_values=values;
			_delayms=delayms;
			_i=0;
		}

		@Override
		public void start() {
			while(!_isdone) {
				nextSort();
				repaint();
				try {
					Thread.sleep(_delayms);
				} catch (Exception ex) {
					
				}
			}
			
		}
		
		private void nextSort() {
			if ( _i >= _values.length-1) {
				_isdone=true;
				return;
			}
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


	}
	

	private class Merge  implements SortAlgo {
		
		private double   [] _buffer;
		private double   [] _values;
		private int         _delayms;
		
		@Override
		public void init(double[] values, int delayms) {
			_values=values;
			_buffer = new double [_values.length];
			_delayms = delayms;
		}

		@Override
		public void start() {
			_sort(_values,0,_values.length-1,_buffer);
		}
		
		private void _sort(double [] A , int b , int e, double [] buffer) {
			int mid =(b+e)/2;
			if ( b == e) return;
			_sort(A,b,mid,buffer);
			_sort(A,mid+1,e,buffer);
			_merge(A,b,mid,e,buffer);
			repaint();
			try {
				Thread.sleep(_delayms);
			} catch( Exception ex) {
			}
		}
		
		private void _merge( double [] A , int b , int m , int e, double [] X) {
			int i = b;
			int j =m+1;
			int k=0;
			int XL = e-b+1;
			while( i <= m && j <= e) {
				if ( A[i] < A[j]) {
					X[k++]=A[i++];
				} else {
					X[k++]=A[j++];
				}
			}
			while( i <= m) X[k++]=A[i++];
			while( j<=e) X[k++]=A[j++];
			for( int l =0; l < XL; l++) {
				A[b++]=X[l];
			}	
		}

	
	}
	
	static public void main(String [] args ) {
		new VisualSorting(128,50,"merge");
		new VisualSorting(128,50,"selection");
	}
}
