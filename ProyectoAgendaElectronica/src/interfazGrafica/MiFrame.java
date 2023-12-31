package interfazGrafica;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiFrame extends JFrame {

	//ATRIBUTOS
	private JLabel etiquetaDNI, etiquetaNombre, etiquetaApellido, etiquetaDireccion, etiquetaTel, etiquetaFNacimiento, etiquetaIndice;
	private JTextField txtDNI, txtNombre, txtApellido, txtDireccion, txtTel, txtFNacimiento, txtIndice;
	private JButton botonGuardar, botonNext, botonPrev;
	private JPanel panelSuperior, panelMedio, panelInferior;
	private String[] listaDNI, listaNombre, listaApellido, listaDireccion, listaTel, listaCorreo;
	
	//CONSTRUCTOR
	public MiFrame() {
		//LISTAS: MAXIMO DE 10 CONTACTOS
		this.listaDNI = new String[10];
		this.listaNombre = new String[10];
		this.listaApellido = new String[10];
		this.listaDireccion = new String[10];
		this.listaTel = new String[10];
		this.listaCorreo = new String[10];
		
		//FRAME
		setTitle("Agenda Electronica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(550, 350);
		setLayout(new BorderLayout());
		setResizable(false);
		
		//PANELES
		armarPanelSuperior();
		armarPanelMedio();
		armarPanelInferior();
		
		getContentPane().add(panelSuperior, BorderLayout.NORTH);
		getContentPane().add(panelMedio,BorderLayout.CENTER);
		getContentPane().add(panelInferior, BorderLayout.SOUTH);	
	}
	
	//PANEL SUPERIOR (TITULO):
	private void armarPanelSuperior() {
		this.panelSuperior = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10)); //FLOWLAYOUT POR DEFECTO
		
		JLabel tituloAPP = new JLabel("AGENDA ELECTRONICA");
		tituloAPP.setFont(new Font("Fira Code", Font.BOLD, 30));
		
		this.panelSuperior.add(tituloAPP);
	}
	
	
	//PANEL CENTRAL(DATOS):
	private void armarPanelMedio() {
		this.panelMedio = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		//PANEL INTERNO CON PROPOSITO VISUAL/ESTETICO DE LA APP
		JPanel panelInterno = new JPanel(new GridLayout(6,2,5,5));
		
		//ETIQUETAS
		this.etiquetaDNI = new JLabel("DNI:");
		this.etiquetaNombre = new JLabel("Nombre:");
		this.etiquetaApellido = new JLabel("Apellido:");
		this.etiquetaDireccion = new JLabel("Direccion:");
		this.etiquetaTel = new JLabel("Telefono:");
		this.etiquetaFNacimiento = new JLabel("Fecha Nacimiento:");
		
		//CAMPOS DE TEXTO
		this.txtDNI = new JTextField(20);
		this.txtNombre = new JTextField(20);
		this.txtApellido = new JTextField(20);
		this.txtDireccion = new JTextField(20);
		this.txtTel = new JTextField(20);
		this.txtFNacimiento = new JTextField(20);
		
		//AGREGO ETIQUETAS Y CAMPOS DE TEXTO AL PANEL INTERNO
		panelInterno.add(this.etiquetaDNI);
		panelInterno.add(this.txtDNI);
		panelInterno.add(this.etiquetaNombre);
		panelInterno.add(this.txtNombre);
		panelInterno.add(this.etiquetaApellido);
		panelInterno.add(this.txtApellido);
		panelInterno.add(this.etiquetaDireccion);
		panelInterno.add(this.txtDireccion);
		panelInterno.add(this.etiquetaTel);
		panelInterno.add(this.txtTel);
		panelInterno.add(this.etiquetaFNacimiento);
		panelInterno.add(this.txtFNacimiento);
		
		//AGREGO PANEL INTERNO AL PANEL PRINCIPAL (MEDIO)
		this.panelMedio.add(panelInterno);
	}

	
	//PANEL INFERIOR:
	private void armarPanelInferior() {
		
		this.panelInferior = new JPanel(new GridLayout(2,1));
		
		//PANEL SUPERIOR
		JPanel panelSupDelInf = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 10));
		
		//BOTONES
		this.botonGuardar = new JButton("Guardar");
		this.botonNext = new JButton(">>");
		this.botonPrev = new JButton("<<");
		
		/* AGREGO OYENTES A BOTONES */
		OyenteGuardar oyenteG = new OyenteGuardar();
		OyenteNext oyenteN = new OyenteNext();
		OyentePrev oyenteP = new OyentePrev();
		this.botonGuardar.addActionListener(oyenteG);
		this.botonNext.addActionListener(oyenteN);
		this.botonPrev.addActionListener(oyenteP);
		
		panelSupDelInf.add(this.botonPrev);
		panelSupDelInf.add(this.botonGuardar);
		panelSupDelInf.add(this.botonNext);
		
		//PANEL INFERIOR
		JPanel panelInfDelInf = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		this.etiquetaIndice = new JLabel("Indice");
		this.txtIndice = new JTextField(10);
		this.txtIndice.setText("0");
		this.txtIndice.setEditable(false);
		this.txtIndice.setHorizontalAlignment(SwingConstants.CENTER);
		
		panelInfDelInf.add(this.etiquetaIndice);
		panelInfDelInf.add(this.txtIndice);
		
		//AÑADIMOS LOS PANELES
		this.panelInferior.add(panelSupDelInf);
		this.panelInferior.add(panelInfDelInf);
	}
	
	
	//OYENTES ----------------------------------------------------
	private class OyenteGuardar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//OBTENER INDICE ACTUAL
			String indice = txtIndice.getText();
			int indiceNum = Integer.parseInt(indice);
			
			//GUARDAR/SETEAR CAMPOS INGRESADOS
			listaDNI[indiceNum] = txtDNI.getText();
			listaNombre[indiceNum] = txtNombre.getText();
			listaApellido[indiceNum] = txtApellido.getText();
			listaDireccion[indiceNum] = txtDireccion.getText();
			listaTel[indiceNum] = txtTel.getText();
			listaCorreo[indiceNum] = txtFNacimiento.getText();
		}
	}
	
	private class OyentePrev implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//OBTENER INDICE ACTUAL
			String indice = txtIndice.getText();
			int indiceNum = Integer.parseInt(indice);
			
			//CONTROLAR DESBORDAMIENTO DEL ARRAY
			if(indiceNum > 0) {
				indiceNum -= 1;
				indice = String.valueOf(indiceNum);
				txtIndice.setText(indice);
				
				//MOSTRAR CAMPOS CORRESPONDIENTES
				txtDNI.setText(listaDNI[indiceNum]);
				txtNombre.setText(listaNombre[indiceNum]);
				txtApellido.setText(listaApellido[indiceNum]);
				txtDireccion.setText(listaDireccion[indiceNum]);
				txtTel.setText(listaTel[indiceNum]);
				txtFNacimiento.setText(listaCorreo[indiceNum]);
			}
		}
	}
	
	private class OyenteNext implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//OBTENER INDICE ACTUAL
			String indice = txtIndice.getText();
			int indiceNum = Integer.parseInt(indice);
			
			//CONTROLAR DESBORDAMIENTO DEL ARRAY
			if(indiceNum < 9) {
				indiceNum += 1;
				indice = String.valueOf(indiceNum);
				txtIndice.setText(indice);
				
				//MOSTRAR CAMPOS CORRESPONDIENTES
				txtDNI.setText(listaDNI[indiceNum]);
				txtNombre.setText(listaNombre[indiceNum]);
				txtApellido.setText(listaApellido[indiceNum]);
				txtDireccion.setText(listaDireccion[indiceNum]);
				txtTel.setText(listaTel[indiceNum]);
				txtFNacimiento.setText(listaCorreo[indiceNum]);
			}
		}
	}

}
