package tap.practica.interfaz;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IntroducirNifDlg extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	JTextField placeholderNIFTxt = new JTextField();
	JButton continuarBtn = new JButton();

	JPanel panelPrincipal = new JPanel();

	final String TXT_PLACEHOLDER = "q1234";
	final String BTN_BUSCAR = "Buscar";
	final String TITLE = "Introducir NIF - Matriculación";

	public IntroducirNifDlg(JFrame padre, String titulo, boolean esModal) {
		super(padre, titulo, esModal);
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("pulsadoContinuar".equals(e.getActionCommand())) {
			try {
				if (tap.practica.cliente.Inicio.cargarAlumno(placeholderNIFTxt
						.getText())) {
					this.setVisible(false);
				} else {
					System.out.println(placeholderNIFTxt.getText());
				}
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		}
	}

	private void definirElementos() {
		continuarBtn.setText(BTN_BUSCAR);
		placeholderNIFTxt.setText(TXT_PLACEHOLDER);
		continuarBtn.setActionCommand("pulsadoContinuar");
		continuarBtn.addActionListener(this);
		panelPrincipal.add(placeholderNIFTxt);
		panelPrincipal.add(continuarBtn);
	}

	private void jbInit() throws Exception {
		panelPrincipal = (JPanel) this.getContentPane();
		panelPrincipal.setLayout(new FlowLayout());
		this.setTitle(TITLE);
		Dimension tam = new Dimension(200, 100);
		this.setSize(tam);
		definirElementos();
	}
}
