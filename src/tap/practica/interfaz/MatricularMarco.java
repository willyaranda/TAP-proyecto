package tap.practica.interfaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import tap.practica.estructuras.Asignatura;

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
		this.setTitle(TITLE + " - " + tap.practica.Inicio.getAlumno().getNif());
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
		grabarBtn.setText(SAVE);
		grabarBtn.setActionCommand(SAVE);
		grabarBtn.addActionListener(this);
		panelPrincipal.add(disponiblesList, BorderLayout.WEST);
		panelPrincipal.add(pasarDrchaBtn, BorderLayout.CENTER);
		panelPrincipal.add(pasarIzdaBtn, BorderLayout.SOUTH);
		panelPrincipal.add(matriculadasList, BorderLayout.EAST);
		panelPrincipal.add(grabarBtn, BorderLayout.NORTH);
		disponiblesList.setModel(cargarListaDisponibles());
		matriculadasList.setModel(cargarListaMatriculadas());
	}
	
	private void definirMenu() {
		menuArchivo.setText( this.ITEM_ARCHIVO);
		menuItemSalir.setText( this.ITEM_SALIR);
		menuItemSalir.addActionListener(this);
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
		int curso = tap.practica.Inicio.getAlumno().getCurso()-1;
		System.out.println("\t\tEstudiando" + curso+1);
//		ArrayList<Asignatura> matriculadas = tap.practica.Inicio.getAlumno().getMatricula().getMatriculadas();
		ArrayList<Asignatura> sem1 = tap.practica.Inicio.getAlumno().
							getEstudioCarrera().getCursos().get(curso).getSemestre1();
		ArrayList<Asignatura> sem2 = tap.practica.Inicio.getAlumno().
							getEstudioCarrera().getCursos().get(curso).getSemestre2();
//		for (int i = 0; i < sem1.size(); i++) {
//			for (int j = 0 ; j < matriculadas.size(); j++) {
//				if (sem1.get(i).getCodigo().equals(matriculadas.get(j).getCodigo()));
//				else { modelo.addElement(sem1.get(i).getNombre()); break; }
//			}
//			modelo.addElement(sem1.get(i).getNombre());
//		}
//		for (int i = 0; i < sem2.size(); i++) {
//			for (int j = 0 ; j < matriculadas.size(); j++) {
//				if (sem2.get(i).getCodigo().equals(matriculadas.get(j).getCodigo())) continue;
//				else { modelo.addElement(sem2.get(i).getNombre()); continue; }
//			}
//			modelo.addElement(sem2.get(i).getNombre());
//		}
		for (int i = 0; i < sem1.size(); i++) {
			modelo.addElement(sem1.get(i).getNombre());
		}
		for (int i = 0; i < sem2.size(); i++) {
			modelo.addElement(sem2.get(i).getNombre());
		}
		return modelo;
	}
	
	private DefaultListModel cargarListaMatriculadas() {
		DefaultListModel modelo = new DefaultListModel();
		ArrayList<Asignatura> matr = tap.practica.Inicio.getAlumno().getMatricula().getMatriculadas();
		for (int i = 0; i < matr.size(); i++) {
			modelo.addElement(matr.get(i).getNombre());
		}
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
		
		if ("pulsadoIzda".equals(e.getActionCommand())) {
			int index = matriculadasList.getSelectedIndex();
			if (index != -1) {
				System.out.println("Añadiendo a disponibles, quitando de matriculadas");
				DefaultListModel listaDrcha = (DefaultListModel) matriculadasList.getModel();
				String seleccion = (String) listaDrcha.getElementAt(index);
				DefaultListModel listaIzda = (DefaultListModel) disponiblesList.getModel();
				tap.practica.Inicio.getAlumno().getMatricula().desmatricular(seleccion);
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
				  if (tap.practica.Inicio.getAlumno().getMatricula().matricular(seleccion)) {
					  listaDrcha.addElement(seleccion);
					  listaIzda.removeElementAt( index );
				  }
				  else {
					System.out.println("Te pasaste de 60 créditos");
				}
			}
		}
		
		if (SAVE.equals(e.getActionCommand())) {
			if (tap.practica.Inicio.getAlumno().getMatricula().comprobar()) {
				tap.practica.Inicio.getAlumno().getMatricula().guardar(
					tap.practica.Inicio.getAlumno().getNif());
			}
			else System.out.println("Matrícula no válida");
		}
	}

	/**
	 * @return the disponiblesList
	 */
	public JList getDisponiblesList() {
		return disponiblesList;
	}

	/**
	 * @param disponiblesList the disponiblesList to set
	 */
	public void setDisponiblesList(JList disponiblesList) {
		this.disponiblesList = disponiblesList;
	}

	/**
	 * @return the matriculadasList
	 */
	public JList getMatriculadasList() {
		return matriculadasList;
	}

	/**
	 * @param matriculadasList the matriculadasList to set
	 */
	public void setMatriculadasList(JList matriculadasList) {
		this.matriculadasList = matriculadasList;
	}
}
