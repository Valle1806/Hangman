/**
 * 
 */
package hangman;
import java.util.Scanner;
import java.util.Random;
/**
 * @author CristianV
 *
 */
public class Vista {
	private char[] oracionvacia,arrayAux;
	String[] frases={"VOY A GANAR PI","TEMO A QUEDARME SIN COMPUTADORES","LA PROGRAMACION EN BAJO NIVEL ES BUENA PARA EL ALMA DEL PROGRAMADOR",
			"EL MAYOR MISTERIO DEL MUNDO ES QUE RESULTA COMPRENSIBLE","SI PIENSAS QUE LOS USUARIOS DE TUS PROGRAMAS SON IDIOTAS, SOLO LOS IDIOTAS USARAN TUS PROGRAMAS",
			"CUANTO MAS SABES, MAS TE DAS CUENTA DE QUE NO SABES NADA","TUS CLIENTES MAS DESCONTENTOS SON TU MAYOR FUENTE DE APRENDIZAJE","EL PRIMER PASO DE LA IGNORANCIA ES PRESUMIR DE SABER"
};
	private ControlFrase hangman;
	private int estado,flag,tamanoFrase,ganador;
	Scanner entradaEscaner;
	private String fraseVista,pregunta;
	char entrada;
	boolean fin;
	/**
	 * @param oracionvacia
	 * @param hangman
	 */
	public Vista() {
		super();
		estado=10;
		Random aleatorio= new Random();
		fin= true;
		ganador=0;
		hangman = new ControlFrase(frases[aleatorio.nextInt(8)]);
		tamanoFrase= hangman.getFraseV().length();
		oracionvacia = new char[tamanoFrase];
		arrayAux= new char[tamanoFrase];
		fraseVista= hangman.getFraseV();
		//Se llena el arreglo vacio de ceros en donde deben de ir las letras
		for (int i=0; i<10; i++){
			oracionvacia[i]='0';
			arrayAux[i]='0';
		}
		//en donde van espacios se ponen 1 y 2 en el arreglo auxiliar que sirve para determinar cuando se gana
		for(int i=0; i<tamanoFrase;i++){
			if(fraseVista.charAt(i)==' '){
				oracionvacia[i]='1';
				arrayAux[i]='2';
			}
			if(fraseVista.charAt(i)==','){
				oracionvacia[i]='3';
				arrayAux[i]='2';
			}
		}
		entradaEscaner = new Scanner (System.in);
				
	}
	
	public void seguirJuego(){
		System.out.println("Quieres Volver a Jugar? y/n");
		pregunta=entradaEscaner.nextLine();
		if(pregunta.equals("y")){
			Vista vista1= new Vista();
			vista1.iniciarJuego();
		}
		else{
			System.out.println("Bye!!");
		}
	}
	public void iniciarJuego(){
		
		while(fin){
			dibujarMuneco();//se imprime el muñeco segun el estado
			if(fin){
			dibujarFrase();//se imprime la frase segun el estado
			}
			buscarGanador();//Revisa si ya se gano, con ayuda del arreglo auxiliar
			if(fin){
				System.out.println("\nDigite una letra:\n");
				entrada= entradaEscaner.nextLine().charAt(0);//Se captura la letra
				entrada= Character.toUpperCase(entrada);
				
			verificarLetra(entrada);
			}
		}
		seguirJuego();
		
	}
	public void buscarGanador(){//verifica si ya se gano con ayuda del arreglo auxiliar
		ganador=0;
		for(int i=0; i<tamanoFrase;i++){
				if(arrayAux[i]=='2'){
					ganador+=1;
				}
		}		
		if(ganador==tamanoFrase){
			fin=false;
			System.out.println("\nHAS GANADO\nJuego terminado\nVidas:" + estado);
		}
	}
	
	public void dibujarFrase(){//Dibuja la frase de acuerdo a lo ingresado
		
		
		if(estado!=0){
			for(int i=0; i<fraseVista.length();i++){
				if(oracionvacia[i]=='1'){
					System.out.print("  ");//En caso de tener 1 se imprime un espacio
				}
				else if(oracionvacia[i]=='0'){
						System.out.print("_ ");//En caso de tener una letra se imprime la guia
					 }
					else if(oracionvacia[i]=='3'){
							System.out.print(",");//En caso de tener una coma se imprime 
					 	 }
						else{
							System.out.print(oracionvacia[i]);//En caso de adivinar la letra se imprime la letra 
						}
			}
		}
	}
	public void verificarLetra(char a){
           flag=hangman.comparar(a,oracionvacia,arrayAux);//Recibe la letra que ingreso el usuario y compara si esta 
		
           if(flag==0){//en caso de que la letra no este flag seria 0 y cambiaria el estado
        	   estado-=1;
        	   System.out.println("Error: no existe la letra ingresada\nVidas:" + estado);
		   }
	}
	public void dibujarMuneco(){
		 
		switch (estado) {//De acuerdo al estado se imprime el muñeco
	    	case 10:
		        System.out.println("  _____________________");
		        for (int j = 0; j<16; j++) {
		            System.out.println(" |");
		
		        }
		        System.out.println("__________");
		        break;
	        
		    case 9:
		        System.out.println("  _____________________");
		        System.out.println(" |                     |");
		        System.out.println(" |                    _| _");
		    	System.out.println(" |                   (.)(.)");
		
		        for (int j = 0; j<15; j++) {
		            System.out.println(" |");
		
		        }
		        System.out.println("__________");
		        break;
		
		    case 8:
		    	System.out.println("  _____________________");
		        System.out.println(" |                     |");
		        System.out.println(" |                    _| _");
		    	System.out.println(" |                   (.)(.)");
		    	System.out.println(" |                  /  ()  \\");
		        for (int j = 0; j<14; j++) {
		            System.out.println(" |");
		
		        }
		        System.out.println("__________");
		        break;
		    case 7:
		    	System.out.println("  _____________________");
		        System.out.println(" |                     |");
		        System.out.println(" |                    _| _");
		    	System.out.println(" |                   (.)(.)");
		    	System.out.println(" |                  /  ()  \\");
		    	System.out.println(" |                 _\\ (--) /_");
		        for (int j = 0; j<11; j++) {
		            System.out.println(" |");
		
		        }
		        System.out.println("__________");
		        break;             
		
		    case 6:
		    	System.out.println("  _____________________");
		        System.out.println(" |                     |");
		        System.out.println(" |                    _| _");
		    	System.out.println(" |                   (.)(.)");
		    	System.out.println(" |                  /  ()  \\");
		    	System.out.println(" |                 _\\ (--) /_");
		    	System.out.println(" |                {          }");
		        for (int j = 0; j<10; j++) {
		            System.out.println(" |");
		
		        }
		        System.out.println("__________");
		        break;
		
		    case 5:
		    	System.out.println("  _____________________");
		        System.out.println(" |                     |");
		        System.out.println(" |                    _| _");
		    	System.out.println(" |                   (.)(.)");
		    	System.out.println(" |                  /  ()  \\");
		    	System.out.println(" |                 _\\ (--) /_");
		    	System.out.println(" |                {          }");
		    	System.out.println(" |                 `/      \\`");
		        for (int j = 0; j<9; j++) {
		            System.out.println(" |");
		
		        }
		        System.out.println("__________");
		        break;
		
		    case 4:
		    	System.out.println("  _____________________");
		        System.out.println(" |                     |");
		        System.out.println(" |                    _| _");
		    	System.out.println(" |                   (.)(.)");
		    	System.out.println(" |                  /  ()  \\");
		    	System.out.println(" |                 _\\ (--) /_");
		    	System.out.println(" |                {          }");
		    	System.out.println(" |                 `/      \\`");
		    	System.out.println(" |                  \\      /");
		        for (int j = 0; j<8; j++) {
		            System.out.println(" |");
		
		        }
		        System.out.println("__________");
		        break;
		
		    case 3:
		    	System.out.println("  _____________________");
		        System.out.println(" |                     |");
		        System.out.println(" |                    _| _");
		    	System.out.println(" |                   (.)(.)");
		    	System.out.println(" |                  /  ()  \\");
		    	System.out.println(" |                 _\\ (--) /_");
		    	System.out.println(" |                {          }");
		    	System.out.println(" |                 `/      \\`");
		    	System.out.println(" |                  \\      /");
		    	System.out.println(" |                 _/  /\\  \\_");
		        for (int j = 0; j<7; j++) {
		            System.out.println(" |");
		
		        }
		        System.out.println("__________");
		        break;
		    case 2:
		    	System.out.println("  _____________________");
		        System.out.println(" |                     |");
		        System.out.println(" |                    _| _");
		    	System.out.println(" |                   (.)(.)");
		    	System.out.println(" |                  /  ()  \\");
		    	System.out.println(" |                 _\\ (--) /_");
		    	System.out.println(" |                {          }");
		    	System.out.println(" |                 `/      \\`");
		    	System.out.println(" |                  \\      /");
		    	System.out.println(" |                 _/  /\\  \\_");
		    	System.out.println(" |                {   /  \\   }");
		         for (int j = 0; j<6; j++) {
		             System.out.println(" |");
		         }
		         System.out.println("__________");
		         break;
		    case 1:
		    	System.out.println("  _____________________");
		        System.out.println(" |                     |");
		        System.out.println(" |                    _| _");
		    	System.out.println(" |                   (.)(.)");
		    	System.out.println(" |                  /  ()  \\");
		    	System.out.println(" |                 _\\ (--) /_");
		    	System.out.println(" |                {          }");
		    	System.out.println(" |                 `/      \\`");
		    	System.out.println(" |                  \\      /");
		    	System.out.println(" |                 _/  /\\  \\_");
		    	System.out.println(" |                {   /  \\   }");
		    	System.out.println(" |                 ---     ---");
		         for (int j = 0; j<5; j++) {
		             System.out.println(" |");
		         }
		         System.out.println("__________");
		         break;
		    case 0:
		    	System.out.println("  _____________________");
		        System.out.println(" |                     |");
		        System.out.println(" |                    _| _");
		    	System.out.println(" |                   (_)(_)");
		    	System.out.println(" |                  /  ()  \\");
		    	System.out.println(" |                 _\\   _  /_");
		    	System.out.println(" |                {          }");
		    	System.out.println(" |                 `/  END \\`");
		    	System.out.println(" |                  \\      /");
		    	System.out.println(" |                 _/  /\\  \\_");
		    	System.out.println(" |                {   /  \\    }");
		    	System.out.println(" |                 ---     ---");
		        for (int j = 0; j<5; j++) {
		            System.out.println(" |");
		
		        }
		        System.out.println("__________");
		        System.out.println("GAME OVER\nFrase:");
		        System.out.println(hangman.getFraseV());
		        fin =false;
		        break;	
		        }
			if(estado==0){
				fin =false;
			}
		}
	}
	
