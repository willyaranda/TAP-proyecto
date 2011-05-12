package tap.practica.estructuras;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase Estudio (podría ser una clase Carrera), que tiene una lista de cursos
 * (diferentes años de la carrera) y un nombre genérico de la carrera
 * 
 * @author willyaranda
 * @author aldo
 * 
 */
public class Estudio implements Serializable {

	String nombre = new String();
	ArrayList<Curso> cursos = new ArrayList<Curso>();

	/**
	 * Constructor por defecto
	 */
	public Estudio() {
	}

	/**
	 * Constructor sobrecargado. Recibe un nombre para ponérselo al estudio
	 * 
	 * @param nombre
	 *            el nombre
	 */
	public Estudio(String nombre) {
		this.nombre = nombre;
	}

	public Asignatura buscarAsig(String nom) {
		for (Curso c : cursos) {
			ArrayList<Asignatura> sem1 = c.getSemestre1();
			ArrayList<Asignatura> sem2 = c.getSemestre2();
			for (Asignatura a : sem1) {
				if (a.getNombre().equals(nom))
					return a;
			}
			for (Asignatura a : sem2) {
				if (a.getNombre().equals(nom))
					return a;
			}
		}
		return null;
	}

	/**
	 * Devuelve una array de tipo Curso con todos los cursos que pertenecen a la
	 * carrera
	 * 
	 * @return el array
	 */
	public ArrayList<Curso> getCursos() {
		return cursos;
	}

	/**
	 * Devuelve el nombre de la carrera
	 * 
	 * @return el nombre de la carrera
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Por cada curso, llama a la función print de curso
	 */
	public void print() {
		for (Curso curso : cursos) {
			curso.print();
		}
	}

	/**
	 * Pone el array de cursos en su sitio…
	 * 
	 * @param cursos
	 *            el array
	 */
	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
	}

	/**
	 * Pone el nombre de la carrera al atributo de tipo cadena pasado
	 * 
	 * @param nombre
	 *            cadena con el nombre de la carrera
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
