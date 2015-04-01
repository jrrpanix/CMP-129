// Course      : CMP-129
// Instructor  : JReynolds
// Title       : Example showing usage of HashMap

import java.util.*;

public class MapExample {

    Map<String,Integer> wordCount;

    public MapExample() {
	wordCount = new HashMap<String,Integer>();
    }

    public void addWords( String text ) {
	String [] words = text.split(" ");
	for( String word : words ) {
	    Integer freq = wordCount.get(word);
	    wordCount.put( word , freq == null ? 1 : freq + 1 );
	}
    }

    public void report() {
	for( Map.Entry<String,Integer> entry : wordCount.entrySet() ) {
	    System.out.println( entry.getKey() + " " + entry.getValue());
	}
    }

    public static void main( String [] args ) {
	String text = "Banana is a fruit , Apple is a fruit , so are Pears , but Carrots are not . Carrots are healty so is an Apple";
	MapExample ex = new MapExample();
	ex.addWords(text);
	ex.report();
    }

}
