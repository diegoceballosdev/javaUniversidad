package logica;
import java.util.Arrays;

public class ObraTeatral {
	//ATRIBUTOS
	private char[][] asientos;

	//CONSTRUCTOR
	public ObraTeatral() {
		this.asientos = new char[10][10];
		cargarAsientos();
	}

	//METODOS
	private void cargarAsientos() {
		for(int i = 0; i < this.asientos.length; i++) {
			Arrays.fill(this.asientos[i], 'L');
		}
	}
	
	public boolean verificarAsiento(int i, int j) {
		return ((this.asientos[i][j] == 'L') ? true : false);
	}
	
	public void reservarAsiento(int i, int j) {
		this.asientos[i][j] = 'X';
	}
	
	public void mostrarAsientos() {
		System.out.println("\n----- ASIENTOS DE LA OBRA TEATRAL -----\n");
		System.out.print("Num. Asiento:	");
		for(int i = 0; i < this.asientos.length; i++) {
			System.out.print(" " + i + " ");
		}
		for(int i = 0; i < this.asientos.length; i++) {
			System.out.print("\n- FILA " + i + ": 	");
			for(int j = 0; j < this.asientos[0].length; j++) {
				System.out.print("[" + this.asientos[i][j] + "]");

			}
		}
		System.out.println("\n");
	}

}
