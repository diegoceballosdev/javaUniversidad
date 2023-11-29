package conceptosBasico;

public class Array {

	public static void main(String[] args) {
		
		//DECLARACION E INICIALIZACION EN UNA LINEA (NO CONOZCO ELEMENTOS)
		int numeros [] = new int [5];
		
		for(int i=0; i<numeros.length; i++){
			numeros[i] = i+2;
			System.out.println(numeros[i]);
		}
		System.out.println("El tamaño del array es " + numeros.length);
		
		//DECLARACION E INICIALIZACION EN UNA LINEA (CONOZCO ELEMENTOS)
		String [] hermanos = {"Diego", "Mateo", "Andres"};
		//CICLO FOREACH
		for( String nombres : hermanos) {
			System.out.println(nombres);
		}
		
		//MATRIZ
		double[][] matriz={{1,2,3,4},{5,6},{7,8,9,10,11,12},{13}};
		System.out.println(matriz[0][0]);
		
	    for (int i = 0; i < matriz.length; i++) {
	        for (int j = 0; j < matriz[i].length; j++) {
	            System.out.print(matriz[i][j]+"\t");
	        }
	        System.out.println("");
	    }
	}
}
