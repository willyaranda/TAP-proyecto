package tap.practica;

import java.util.ArrayList;

/**
 * Clase Estudio (podría ser una clase Carrera), que tiene una
 * lista de cursos (diferentes años de la carrera) y un nombre
 * genérico de la carrera
 * @author willyaranda
 * @author aldo
 *
 */
public class Estudio {
	
	String nombre = new String();
	ArrayList<Curso> cursos = new ArrayList<Curso>();
	
	/**
	 * Devuelve el nombre de la carrera
	 * @return el nombre de la carrera
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Pone el nombre de la carrera al atributo de tipo cadena pasado
	 * @param nombre cadena con el nombre de la carrera
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Devuelve una array de tipo Curso con todos los cursos que pertenecen
	 * a la carrera
	 * @return el array
	 */
	public ArrayList<Curso> getCursos() {
		return cursos;
	}
	/**
	 * Pone el array de cursos en su sitio…
	 * @param cursos el array
	 */
	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
	}
	
	/**
	 * Constructor sobrecargado. Recibe un nombre para ponérselo al estudio
	 * @param nombre el nombre
	 */
	public Estudio(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Constructor por defecto
	 */
	public Estudio() {
	}
	
	/**
	 * Por cada curso, llama a la función print de curso
	 */
	public void print() {
		for (Curso curso : cursos) {
			curso.print();
		}
	}
	
}
