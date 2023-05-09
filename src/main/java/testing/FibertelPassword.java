package testing;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.lang.*;
import java.math.BigInteger;
import java.math.BigDecimal;

/*erramientas genericas que
  todas las clases tienen*/
class GenPassAll {
    protected String[] chars = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};


    /*muestra el tipo de de contraseña a generar*/
    protected void print_password_type(int opc) {
	System.out.println("\u001B[34m•[PASSWORD TYPE]•:\u001B[34m");
	switch(opc) {
	case 1:{

	    System.out.println("Fibertel\n");
	    break;
	}
	    case 2:{

	    System.out.println("Telecentro\n");
	    break;
	}
	}
	
    }

   
    protected void loading_proces(long i, long tamanio,String _text) throws IOException {
	/*calculo de porcentaje*/
	double percen = ((double)i / tamanio) * 100;

	System.out.print("\033[1A"); // mueve el cursor una línea hacia arriba
	System.out.print("\033[2K"); // borra toda la línea

	String percenString = String.format("%.2f",percen); 
	
	/*imprecion del porcentaje*/
	System.out.println("\u001B[32m*[LOADING]*\u001B[32m: " + _text + ": " + percenString + "%");
        
    }

    protected void loading_subproces(int i, int tamanio,String _text) throws IOException {
	/*calculo de porcentaje*/
	double percen = ((double)i / tamanio) * 100;

	System.out.print("\033[1A"); // mueve el cursor una línea hacia arriba
	System.out.print("\033[2K"); // borra toda la línea

	String percenString = String.format("%.2f",percen); 
	
	/*imprecion del porcentaje*/
	System.out.println("\u001B[32m*[LOADING]*\u001B[32m: " +_text+ ": " + percenString + "%");
        
    }
   
}


//contraseñas de fibertel
class FibertelPassword extends GenPassAll {

    /*inicio de la contraseñas*/
    private String[] init = {"004","044","014"};
    private int cont = 0;

   
    /*metodo generador de contraseñas*/
    public void gen_fibertel_password(int tam) throws IOException {

	print_password_type(1);
	
	/*creacion de los archivos*/
	FileWriter fwPass = new FileWriter("passwordFile.txt"); 
	PrintWriter pw = new PrintWriter(fwPass);
	String[] second_part = new String[tam];
	/*sistema concatenador de las contraseñas*/
	for(int i =0; i <=tam; i++) {

	    /*concatena la segunda parte con la primera*/
	    second_part[i] = String.format("%08d",i);
	    String pass1 = init[0] + second_part[i];
	    String pass2 = init[1] + second_part[i];
	    String pass3 = init[2] + second_part[i];

	    /*guardamos las clabes en el archivo
	      que se genero*/
	    
	    if (i == 0) pw.println("*[PASSWORDS FIBERTEL]*\n");
	    pw.println(pass1 + "\n" + pass2 + "\n" + pass3);
	    
	    /*porcentage de la carga del proceso*/
	    
	    if ((cont % 170) == 0) loading_proces(cont,tam-1000000,"Passwors Generating");
	    cont++;
	}
	/*cierra el archivo*/
	pw.close();
    }
    
    /*constructor*/
    public FibertelPassword(int tam) throws IOException {

	gen_fibertel_password(tam);
    } 
    
    
}

/*contraseñas de telecentro*/
class TelecentroPasswords extends GenPassAll {

    //partes de la contraseña y contraseña completa
    private String password;
    
    
    /*genera las constraseñas de tipo telecentro*/
    public void gen_telecentro_password() throws IOException {

	print_password_type(2);
	
	/*creacion de los archivos*/
	FileWriter fwPass = new FileWriter("passwordFile.txt"); 
	PrintWriter pw = new PrintWriter(fwPass);
	String[] parts = new String[1679616];
	long cont=0;

	//calcula cadena de 4 caracteres
	System.out.println("\u001B[33m*[PROCESS]*\u001B[33m:•Part of Password•\n");
	for(int e = 0;e < 36;e++) {
	    for(int f = 0;f < 36;f++) {
		for(int g = 0;g < 36;g++) {
		    for(int h = 0;h < 36;h++) {
			//concatenacion

       			parts[(int)cont] = chars[e] + chars[f] + chars[g] + chars[h];		        
			//escribe los datos
			//if (password =="!!!!!!!!" ) pw.println("*[PASSWORDS FIBERTEL]*\n");
			//pw.println(password);

			/*muestra la carga de este proceso
			  cada 250 iteraciones*/
			if ((cont % 250) == 0) loading_proces(cont,1679616,"Creating a four characters parts");
					    
		        
			cont++;
		    }
		}
	    }
	}
	System.out.println("\u001B[33m*[PROCESS]*\u001B[33m:Finished");

	cont=0;
	int cont2 =0;
	System.out.println("\u001B[33m•[PROCESS]•\u001B[33m:Total Passwords\n");
	for(int i=0; i <1679616; i++) {
	   
	    for(int k=0; k<1679616; k++) {

		/*carga del proceso*/
		password = parts[i] + parts[k];
		
		if ((cont % 250) == 0) loading_proces(cont,1679616,"generating passwords of 8 characters");
		cont++;
	    }
	    System.out.println("•[WITH PART]•: " + parts[i] +" •[NUMBER POSSITION]•: " + i +"\n");
	    cont=0;
	    cont2++;
	}
	System.out.println("\u001B[33m*[PROCESS]*\u001B[33m:Finished");
       

	pw.close();
    }

    
    //constructor    
    public TelecentroPasswords() throws IOException {
	
	gen_telecentro_password();
    }
}
