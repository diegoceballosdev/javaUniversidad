package logica;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		
		ObraTeatral obra1 = new ObraTeatral();
		Scanner sc = new Scanner(System.in);
		boolean bandera = true;
		int opcion, fila, columna;
		
		while(bandera) {
			System.out.println("--------- MENU ---------\n");
			System.out.println("[0] FINALIZAR PROGRAMA");
			System.out.println("[1] MOSTRAR ASIENTOS");
			System.out.println("[2] VERIFICAR DISPONIBILIDAD DE ASIENTO");
			System.out.println("[3] RESERVAR ASIENTO");
			
			System.out.print("Ingrese una opcion: ");
			opcion = sc.nextInt();
			
			switch(opcion) {
				case 0: 
					bandera = false;
					System.out.println("\n ------------- PROGRAMA FINALIZADO -------------");
					break;
					
				case 1: 
					obra1.mostrarAsientos();
					break;
					
				case 2:
					do{
						System.out.print("\nIngrese fila del asiento (0 a 9):");
						fila = sc.nextInt();
						System.out.print("Ingrese Numero del asiento (0 a 9):");
						columna = sc.nextInt();
					}while((fila < 0 || fila > 9) || (columna < 0 || columna > 9));
					
					if(obra1.verificarAsiento(fila, columna)) {
						System.out.println("\nEl asiento " + columna + " de la fila " + fila + " esta disponible\n");
					}
					else {
						System.out.println("\nEl asiento " + columna + " de la fila " + fila + " NO esta disponible\n");
					}
					break;
				
				case 3:
					do{
						System.out.print("\nIngrese fila del asiento (0 a 9):");
						fila = sc.nextInt();
						System.out.print("Ingrese Numero del asiento (0 a 9):");
						columna = sc.nextInt();
					}while((fila < 0 || fila > 9) || (columna < 0 || columna > 9));
					
					if(obra1.verificarAsiento(fila, columna)) {
						obra1.reservarAsiento(fila, columna);
						System.out.println("\nEl asiento " + columna + " de la fila " + fila + " FUE RESERVADO EXITOSAMENTE\n");
					}
					else {
						System.out.println("\nEl asiento " + columna + " de la fila " + fila + " NO esta disponible\n");
					}
					break;
					
				default:
					System.out.println("\nERROR: Ingrese una opcion valida\n");
					break;
			}
		}
		sc.close();
	}
}
