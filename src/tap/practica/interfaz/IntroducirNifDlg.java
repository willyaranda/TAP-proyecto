package tap.practica.interfaz;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntroducirNifDlg extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	JTextField placeholderNIFTxt = new JTextField();
	JButton continuarBtn = new JButton();
	
	JPanel panelPrincipal = new JPanel();

	final String TXT_PLACEHOLDER = "q1234";
	final String BTN_BUSCAR = "Buscar";
	final String TITLE = "Introducir NIF - Matriculación";
	
	public IntroducirNifDlg(JFrame padre, String titulo, boolean esModal) {
		super( padre, titulo, esModal );
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception  {
		panelPrincipal = (JPanel) this.getContentPane();
		panelPrincipal.setLayout( new FlowLayout( ) );
		this.setTitle(TITLE);
		Dimension tam = new Dimension(200, 100);
		this.setSize(tam);
      	definirElementos();
	}
	
	private void definirElementos() {
		continuarBtn.setText(BTN_BUSCAR);
		placeholderNIFTxt.setText(TXT_PLACEHOLDER);
		continuarBtn.setActionCommand("pulsadoContinuar");
		continuarBtn.addActionListener(this);
		panelPrincipal.add(placeholderNIFTxt);
		panelPrincipal.add(continuarBtn);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if ("pulsadoContinuar".equals(e.getActionCommand())) {
			/*
			 * Hay que devolver el valor del placeholderNIFTxt
			 * o guardarlo en una variable global
			 * 
			 */
			System.out.println("estoy aquí");
			if (tap.practica.Inicio.cargarAlumno(placeholderNIFTxt.getText())) {
				//TODO: Decir al Frame que ha cambiado.
				this.setVisible(false);
			} else {
				System.out.println(placeholderNIFTxt.getText());
			}
		}
	}
}
