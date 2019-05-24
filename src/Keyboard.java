package intro;

import java.util.Scanner;

public class Keyboard {

	public static String getLine( Scanner scan) {
		return scan.nextLine();
	}
	
	public static String [] getArgs(String line) {
		return line.split(" ");
	}
	
	public static String [] getFromKeyboard( Scanner scan) {
		String line = scan.nextLine().trim();
		String [] lineArgs=getArgs(line);
		return lineArgs;
	}
	
	public static Scanner createScanner() {
		Scanner scan = new Scanner(System.in);
		return scan;
	}
	
	public static boolean isDone( String [] args) {
		return args.length == 0 || args[0].length() == 0 || args[0].equals("end");
	}
	
	public static void run() {
		System.out.println("enter data");
		Scanner scan = createScanner();
		boolean more = true;
		while( more) {
			String [] data = getFromKeyboard(scan);
			if ( isDone(data)) break;
			Cmds.printArgs(data);
		}
		System.out.println("ended");
	}
	
	
	public static void main(String [] args) {
		run();
	}
	
}
