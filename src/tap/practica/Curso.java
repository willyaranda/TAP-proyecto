package tap.practica;

import java.util.ArrayList;

public class Curso {
	
	int curso;
	
	ArrayList<Asignatura> semestre1 = new ArrayList<Asignatura>();
	ArrayList<Asignatura> semestre2 = new ArrayList<Asignatura>();

	void anadirAsignatura(int semestre, Asignatura asig) throws Exception {
		if (semestre == 1) {
			semestre1.add(asig);
		}
		else if (semestre == 2) {
			semestre2.add(asig);
		}
		else throw new Exception("Semestre no válido");
	}
	
	public Curso(int curso) {
		this.curso = curso;
	}
	
	public void printCurso() {
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
	
}
