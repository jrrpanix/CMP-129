public class CLParser {

    private String ErrorMessage_;
    
    public String getErrorMessage() {
	return ErrorMessage_;
    }
    
    public String[] parseToken( String s) {
	String[] token = s.split("=");
	return token;
    }
    
    public String extractKey( String s ) {
	if (s.length() < 2) return new String();
	return s.substring(2);
    }
    
    public String getCMDLine( String []args) {
	String cmd = new String();
	for( String s : args )
	    cmd += s + " " ;
	return cmd;
    }
    
    public boolean parse(String[] args ) {
	boolean rv = true;
	for( String s : args ) {
	    String[] token = parseToken(s);
	    if ( token.length != 2 ) {
		ErrorMessage_ = "Badly formed token, expecting --somekey=value, got this instead : " + s;
		rv = false;
		break;
	    }
	    String key = extractKey(token[0]);
	    String value = token[1];
	    if ( key.length()==0) {
		rv = false;
		ErrorMessage_ = "Badly formed key value, expecting --somekey, got this instead : " + token[0] + " for this argument " + s;
		break;
	    }
	    System.out.println( "Key="+key+",Value="+value);
	}
	return rv;
    }
    
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	CLParser parser = new CLParser();
	System.out.println("Starting CLParser-1 with command line :" + parser.getCMDLine(args));
	boolean rv = parser.parse(args);
	if ( !rv) {
	    System.out.println("Error parsing arguments : " + parser.getErrorMessage());
	}
    }

}
