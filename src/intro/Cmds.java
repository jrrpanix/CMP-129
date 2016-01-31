package lecture1;

public class Cmds {

	
	public static void showResult(String input, int result) {
		System.out.format("%s = %d\n", input,result);
	}
	
	public static void showError( String error, String [] args) {
		System.out.format("%s %s\n", error,args);
	}
	
	public static String toInput(String [] args) {
		String input = new String();
		for (String a : args ) input = input + " " + a;
		return input;
	}
	
	public static boolean cmdOk( String [] args) {
		if ( args.length != 3 ) {
			showError("expecting cmd <x1> <x2> instead got:", args);
			return false;
		}
		return true;
	}
	
	public static void controller(String [] args) {
		int i =0;
		String cmd=args[i++];
		if ( cmd.equals("add") && cmdOk( args)) {
			showResult(toInput(args),Calcs.add(args[1],args[2]));
		} else if (cmd.equals("sub") && cmdOk(args)) {
			showResult(toInput(args),Calcs.sub(args[1],args[2]));
		} else if (cmd.equals("sum")) {
			int [] V = Calcs.toInts(args,1);
			showResult(toInput(args),Calcs.sum(V));
		}
	}
	
	public static void printArgs(String [] args) {
		for( String s : args)
			System.out.format("%20s\n", s);
	}
	
	
	
	public static void main(String [] args ) {
		System.out.format("starting ...\n");
		printArgs(args);
		controller(args);
	}
}
