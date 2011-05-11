package tap.practica.estructuras;

import java.util.ArrayList;

/**
 * Clase Curso, que contiene dos semestres que son listas de Asignaturas y el
 * curso (entero) actual al que pertenece.
 * 
 * @author willyaranda
 * @author aldo
 * 
 */
public class Curso {

	int curso;

	ArrayList<Asignatura> semestre1 = new ArrayList<Asignatura>();
	ArrayList<Asignatura> semestre2 = new ArrayList<Asignatura>();

	/**
	 * Constructor por defecto, sólo recibe un entero con el curso actual al que
	 * se está identificando
	 * 
	 * @param curso
	 *            el curso actual
	 */
	public Curso(int curso) {
		this.curso = curso;
	}

	/**
	 * Devuelve un array de Asignaturas pertenecientes al primer cuatrimestre
	 * 
	 * @return el array
	 */
	public ArrayList<Asignatura> getSemestre1() {
		return semestre1;
	}

	/**
	 * Devuelve un array de Asignaturas pertenecientes al segundo cuatrimestre
	 * 
	 * @return el array
	 */
	public ArrayList<Asignatura> getSemestre2() {
		return semestre2;
	}

	/**
	 * Muestra el curso actual junto una lista asignaturas para ambos
	 * cuatrimestres
	 */
	public void print() {
		System.out.println("Curso " + curso);
		System.out.println("Semestre 1");
		for (Asignatura asig : semestre1) {
			asig.printAsignatura();
		}
		System.out.println("Semestre 2");
		for (Asignatura asig : semestre2) {
			asig.printAsignatura();
		}
		System.out.println();
	}

	/**
	 * Pone el atributo de semestre1 con un array de Asignatura
	 * 
	 * @param semestre1
	 *            array de Asignatura
	 */
	public void setSemestre1(ArrayList<Asignatura> semestre1) {
		this.semestre1 = semestre1;
	}

	/**
	 * Pone el atributo de semestre2 con un array de Asignatura
	 * 
	 * @param semestre1
	 *            array de Asignatura
	 */
	public void setSemestre2(ArrayList<Asignatura> semestre2) {
		this.semestre2 = semestre2;
	}

}
