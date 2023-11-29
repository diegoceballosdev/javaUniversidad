package contenedores;
import recursos.*;

public abstract class ArbolBinario implements operacionesArbolB{
	protected NodoArbolBinario root;
	public abstract void imprimir(Object nodoInfo);
	public abstract void meter(Object nodoInfo);
	public abstract boolean esta(Object nodoInfo);
	public abstract void sacar(Object nodoInfo);
	public abstract NodoArbolBinario devuelve(Object nodoInfo);
	
	//METODOS DE INTERFAZ
	public boolean estaVacio(){
		return (this.root==null);
	}		
	public void limpiar(){
		this.root=null;
	}	
	public void muestraInOrder(){
		inOrder(this.root);	
	}
	public void muestraPreOrder(){
		preOrder(this.root);
	}	
	public void muestraPostOrder(){
		postOrder(this.root);
	}

	//METODOS PARA MUESTRAS
	private void inOrder(NodoArbolBinario nodo){
		if (nodo!=null){
			inOrder(nodo.getLeftChild());
			imprimir(nodo.getNodoInfo());
			inOrder(nodo.getRightChild());
		}
	}	
	private void preOrder(NodoArbolBinario nodo){
		if (nodo!=null){
			imprimir(nodo.getNodoInfo());
			preOrder(nodo.getLeftChild());
			preOrder(nodo.getRightChild());	
		}		
	}
	private void postOrder(NodoArbolBinario nodo){
		if (nodo!=null){
			postOrder(nodo.getLeftChild());
			postOrder(nodo.getRightChild());
			imprimir(nodo.getNodoInfo());	
		}
	}	
	
	//ADICIONAL: HOJAS
	public int cantHojas(NodoArbolBinario nodo){
   		if (nodo==null){
			return 0;
		}else {
			if (nodo.getLeftChild()==null && nodo.getRightChild()==null){
				return 1; //ES HOJA
			}
			else {
				return cantHojas(nodo.getLeftChild()) + cantHojas(nodo.getRightChild());
			}
		}       		
	}	
	public int cuentaHojas(){			
		return cantHojas(this.root);		
	}
	
	//ADICIONAL: ALTURA
	public int alturaArbol(NodoArbolBinario nodo){
	    int alturaIzq, alturaDer;
	    if(nodo==null){
	    	return -1;
	    } 
	    else {
	        alturaIzq = alturaArbol(nodo.getLeftChild());
	        alturaDer = alturaArbol(nodo.getRightChild());
	        if(alturaIzq>alturaDer)
	            return alturaIzq +1;
	        else
	            return alturaDer+1;
	    }
	}		
	public int altura(){
		return alturaArbol(this.root);
	}
	
	//ADICIONAL: NODOS
	public int cantNodos(NodoArbolBinario nodo){
   		if (nodo==null){
			return 0;
		}else {
				return 1 + cantNodos(nodo.getLeftChild()) + cantNodos(nodo.getRightChild());			
		}		
	}
	public int cuentaNodos(){
		return cantNodos(this.root);
	}
		
}
