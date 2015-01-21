import java.io.File;
import java.util.Scanner;
import java.util.Arrays;

class Reader {

    Reader() {

        words_ = new String[5000];
        wcount_ = new int[5000];
        nwords_=0;
    }

    public void read( String file ) {
        File fileHandle = new File(file);
        if( !fileHandle.exists() ) {
            System.out.println( "Unable to open file " + file );
            return;
        }
        try {
            Scanner scan = new Scanner(fileHandle);
            while( scan.hasNext() ) {
                String s = scan.next();
                //String orig = s;
                s = removeP(s);
                s = s.toLowerCase();
                update(s);
            }
            scan.close();
        }
        catch ( java.io.FileNotFoundException e) {
            System.out.println(e.toString());
        }
    }

    public void print() {
        for( int i = 0; i < nwords_ ; i++ ) {
            System.out.format( "%20s %5d\n", words_[i],wcount_[i] );
        }
    }

    public void printOrder() {
        int [] ix = new int[nwords_];
        Arrays.fill(ix,0);
        for( int i = 0; i < nwords_ ;i++ ) {
            int maxi = getLargest(ix);
            if ( maxi == -1 ) break;
            ix[maxi]=1;
            System.out.format( "%20s %5d\n", words_[maxi],wcount_[maxi] );
        }
   }

    //
    private int getLargest( int [] ix ) {
        int maxi = -1;
        for( int i = 0; i < nwords_ ; i++ ) {
            if (ix[i]==1) continue;
            if ( maxi == -1 ) maxi = i;
            else if ( wcount_[i] > wcount_[maxi] ) maxi=i;
        }
        return maxi;
    }

    //
    private void update( String aWord ) {
        int ix = hasWord( aWord );
        if ( ix == -1 ) {
            ix = nwords_;
            words_[ix]=aWord;
            wcount_[ix]=1;
            nwords_++;
        }
        else {
            wcount_[ix]++;
        }
    }

    private int hasWord( String aWord ) {
        for( int i = 0; i < nwords_ ; i++ ) {
            if ( words_[i].equals(aWord) )return i;
        }
        return -1;
    }

    // remove puncuation from word
    private String removeP( String s ) {
        String regEx = ".*[\\.|,|;|:]";
        if ( !s.matches(regEx) ) return s;
        char [] last = new char[1];
        last[0]= s.charAt(s.length()-1);
        String rep = new String(last);
        return s.replace(rep,"");
    }

    // data members
    private String [] words_;
    private int    [] wcount_;
    private int       nwords_;
   //-------------------------------------------------------------------
    //
    //-------------------------------------------------------------------
    public static void main( String [] args ) {
        String file = args[0];
        Reader r = new Reader();
        r.read(file);
        r.printOrder();
    }

}

