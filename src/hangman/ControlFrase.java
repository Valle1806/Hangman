/**
 * 
 */
package hangman;

/**
 * @author CristianV
 *
 */
public class ControlFrase {
	private Frase frase1;
	private int flagError;
	
	
	public ControlFrase(String oracion) {
		super();
		this.frase1 = new Frase(oracion);
		this.flagError = 0;
		
		
	}
	
	public int comparar(char a,char[] c,char[] d){
		flagError= 0;
		for(int i=0; i<frase1.getOracion().length();i++){
			String oracion1=frase1.getOracion();
			char b= oracion1.charAt(i);
			if(a==b){
				c[i]= b;
				d[i]='2';
				flagError = 1; 
			}
			
		}
		return flagError;
	}

	public int getFlagError() {
		return flagError;
	}

	
	public String getFraseV(){
		return frase1.getOracion();
	}
	
}
