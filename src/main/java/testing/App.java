package testing;

import testing.FibertelPassword;
import testing.TelecentroPasswords;
import java.io.IOException;

public class App {
    
    public static void main( String[] args ) throws IOException {

	/*determinacion del numerod argumnetos*/
	if(args.length > 0) {
	    int t = Integer.parseInt(args[1]);
	    /*determiandor del generador*/
	    switch(args[0]) {

	    case "-fibertel":{

		FibertelPassword obj = new FibertelPassword(t);
		
		break;}

	    case "-telecentro":{
		TelecentroPasswords obj = new TelecentroPasswords(); 
	    }

	    default:{

		System.out.println("\u001B[31m***[ERROR]***\u001B[31m\n error in the second parameter ");
		
		break;}
		
	    } 
	} else System.out.println("\u001B[31m***[ERROR]***\u001B[31m\n error in the length parameters");
	
    }
}
