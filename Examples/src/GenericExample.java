
import java.util.*;

class Stack <T> {

    public Stack() {
	data = new ArrayList<T>();
    }

       public void push( T t ) {
          data.add(t);
       }

       T pop() {
          int i = data.size();
	  return data.remove(i-1);
       }

       boolean isEmpty() {
          return data.isEmpty();
       }


       private ArrayList<T> data;

    
}

public class GenericExample {

    public static < E > void print( E [] A ) {
        for( E x : A ) {
	   System.out.printf("%s\n",x);
	}
    }


    public static void testPrint() {
	Integer [] x = {1,2,3};
	Double  [] y = {1.1,2.01,3.22};
	print(x);
	print(y);
    }


    public static void testStack() {
	Stack<Integer> I = new Stack<Integer>();
	I.push(1);
	I.push(2);
	I.push(3);
	while( !I.isEmpty() ) {
	    System.out.printf("%s\n",I.pop());
	}
    }

    public static void main( String [] args ){
	testStack();
	testPrint();
    }

}