package tap.practica.interfaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MatricularMarco extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	JMenuBar menuPrincipal = new JMenuBar();  // MenuBar

	//// Menú Archivo
	JMenu menuArchivo = new JMenu();
	JMenuItem menuItemSalir = new JMenuItem();
	JMenuItem menuItemBuscar = new JMenuItem();

	//// Manú Ayuda
	JMenu menuAyuda = new JMenu();
	JMenuItem menuItemAcercaDe = new JMenuItem();

	JPanel panelPrincipal = new JPanel();
	
	JList disponiblesList = new JList();
	JList matriculadasList = new JList();
	JButton pasarIzdaBtn = new JButton();
	JButton pasarDrchaBtn = new JButton();
	JButton grabarBtn = new JButton();

	//// Cadenas de opciones de menú
	final String ITEM_ARCHIVO = "Archivo";
	final String ITEM_CAMBIARNIF = "Cambiar alumno";
	final String ITEM_SALIR = "Salir";
	final String ITEM_AYUDA = "Ayuda";
	final String ITEM_ACERCADE = "Acerca de";
	final String TITLE = "Matricular";
	final String TITLE_DLG = "Introducir NIF";
	final String SAVE = "Grabar";
	
	IntroducirNifDlg dial = new IntroducirNifDlg(this, TITLE_DLG, true);
	
	public MatricularMarco() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception  {
		showDialog();
		panelPrincipal = (JPanel) this.getContentPane();
		panelPrincipal.setLayout( new BorderLayout( ) );
		//this.setTitle(TITLE + " - " + getNif());
		this.setTitle(TITLE + " - ");
      	definirMenu();
      	definirElementos();
	}
	
	private void showDialog() {
		dial.setVisible(true);
	}
	
	private void definirElementos() {
		pasarIzdaBtn.setText("<");
		pasarIzdaBtn.setActionCommand("pulsadoIzda");
		pasarIzdaBtn.addActionListener(this);
		pasarDrchaBtn.setText(">");
		pasarDrchaBtn.setActionCommand("pulsadoDrcha");
		pasarDrchaBtn.addActionListener(this);
		panelPrincipal.add(disponiblesList, BorderLayout.WEST);
		panelPrincipal.add(pasarIzdaBtn, BorderLayout.CENTER);
		panelPrincipal.add(pasarDrchaBtn, BorderLayout.CENTER);
		panelPrincipal.add(matriculadasList, BorderLayout.EAST);
		disponiblesList.setModel(cargarListaDisponibles());
		matriculadasList.setModel(cargarListaMatriculadas());
	}
	
	private void definirMenu() {
		menuArchivo.setText( this.ITEM_ARCHIVO);
		menuItemBuscar.setText(ITEM_CAMBIARNIF);
		menuItemBuscar.addActionListener(this);
		menuItemSalir.setText( this.ITEM_SALIR);
		menuItemSalir.addActionListener(this);
		menuArchivo.add(menuItemBuscar);
		menuArchivo.add(menuItemSalir);

		menuAyuda.setText(this.ITEM_AYUDA);
		menuItemAcercaDe.setText(this.ITEM_ACERCADE);
		menuItemAcercaDe.addActionListener(this);
		menuAyuda.add(menuItemAcercaDe);

		menuPrincipal.add(menuArchivo);
		menuPrincipal.add(menuAyuda);

		this.setJMenuBar(menuPrincipal);
	}
	
	private DefaultListModel cargarListaDisponibles() {
		DefaultListModel modelo = new DefaultListModel();
		modelo.addElement("Aldo");
		modelo.addElement("Willy");
		modelo.addElement("Cajaohyeah");
		modelo.addElement("Manu");
		return modelo;
	}
	
	private DefaultListModel cargarListaMatriculadas() {
		DefaultListModel modelo = new DefaultListModel();
		modelo.addElement("mola");
		modelo.addElement("rules");
		modelo.addElement("trollface");
		modelo.addElement("owned");
		return modelo;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if ( e.getActionCommand().compareTo( ITEM_ACERCADE ) == 0 )
			System.out.println( "Acerca de");

		if ( e.getActionCommand().compareTo( ITEM_SALIR ) == 0 ) {
			System.out.println( "Salimos");
			System.exit(0);
			return;
		}
	      
		if (e.getActionCommand().compareTo(ITEM_CAMBIARNIF) == 0) {
			dial.setVisible(true);
		}
		
		if ("pulsadoIzda".equals(e.getActionCommand())) {
			int index = matriculadasList.getSelectedIndex();
			if (index != -1) {
				System.out.println("Añadiendo a disponibles, quitando de matriculadas");
				  DefaultListModel listaDrcha = (DefaultListModel) matriculadasList.getModel();  
				  String seleccion = (String) listaDrcha.getElementAt(index);
				  DefaultListModel listaIzda = (DefaultListModel) disponiblesList.getModel();
				  listaIzda.addElement(seleccion);
				  listaDrcha.removeElementAt( index );
			}
		}
		
		if ("pulsadoDrcha".equals(e.getActionCommand())) {
			int index = disponiblesList.getSelectedIndex();
			if (index != -1) {
				System.out.println("Añadiendo a matriculadas, quitando de disponibles");
				  DefaultListModel listaIzda = (DefaultListModel) disponiblesList.getModel();  
				  String seleccion = (String) listaIzda.getElementAt(index);
				  DefaultListModel listaDrcha = (DefaultListModel) matriculadasList.getModel();
				  listaDrcha.addElement(seleccion);
				  listaIzda.removeElementAt( index );
			}
		}
		
	}
}
