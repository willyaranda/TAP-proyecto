package tap.practica.estructuras;

import java.util.ArrayList;

/**
 * Clase Matrícula, tiene un atributo matriculadas que guarda un array
 * de las asignaturas matriculadas.
 * Y un atributo entero que guarda el número de créditos matriculados
 * @author willyaranda
 * @author aldo
 */
public class Matricula implements GuardarIfaz {
	
	ArrayList<Asignatura> matriculadas = new ArrayList<Asignatura>();
	int numCreditos;
	
	/**
	 * Añade una Asignatura a la lista de matriculadas.<br />
	 * Comprueba si se puede añadir a la lista de matriculación. No nos 
	 * podemos pasar de 60 créditos matriculados, y en ese caso devuelve <b>false</b>
	 * En cualquier otro caso, devuelve <b>true</b>
	 * @param asig la Asignatura
	 * @return si la operación ha sido completada correctamente
	 */
	public Boolean matricular(String nombre) {
//		int curso = tap.practica.Inicio.getAlumno().getCurso();
//		ArrayList<Asignatura> sem1 = tap.practica.Inicio.getAlumno().
//			getEstudioCarrera().getCursos().get(curso).getSemestre1();
//		ArrayList<Asignatura> sem2 = tap.practica.Inicio.getAlumno().
//			getEstudioCarrera().getCursos().get(curso).getSemestre2();
//		for (int j = 0 ; j < sem1.size(); i++) {
//			if (sem1.get(j).getNombre().equals(nombre)) {
//				matriculadas.add(e);
//		}
//		for (int j = 0 ; j < sem2.size(); i++) {
//				if (matriculadas.get(i).getCodigo().equals(sem2.get(j).getCodigo()));
//				else modelo.addElement(matriculadas.get(i).getNombre());
//			}
//		} 
//		if ((numCreditos + asig.getCreditos()) > 60) return false;
//		matriculadas.add(asig);
//		numCreditos += asig.getCreditos();
		return true;
	}
	
	/**
	 * Comprueba si la matrícula es correcta. Si es menor de 12 o mayor de 60
	 * el número de créditos matriculados, se devuelve <b>false</b> y en
	 * otro caso se devuelve <b>true</b>
	 * @return si la matrícula es correcta
	 */
	public Boolean comprobar() {
		return ((numCreditos > 60) || (numCreditos < 12)) ? false : true;
	}

	/**
	 * @return the matriculadas
	 */
	public ArrayList<Asignatura> getMatriculadas() {
		return matriculadas;
	}

	/**
	 * @param matriculadas the matriculadas to set
	 */
	public void setMatriculadas(ArrayList<Asignatura> matriculadas) {
		this.matriculadas = matriculadas;
	}

	/**
	 * @return the numCreditos
	 */
	public int getNumCreditos() {
		return numCreditos;
	}

	/**
	 * @param numCreditos the numCreditos to set
	 */
	public void setNumCreditos(int numCreditos) {
		this.numCreditos = numCreditos;
	}
	
	@Override
	public void guardar(String nif) {
		System.out.println("Guardando...");	
	}

}
