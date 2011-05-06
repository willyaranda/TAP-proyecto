package tap.practica;

import java.util.ArrayList;

public class Curso {
	
	int curso;
	
	ArrayList<Asignatura> semestre1 = new ArrayList<Asignatura>();
	public ArrayList<Asignatura> getSemestre1() {
		return semestre1;
	}

	public void setSemestre1(ArrayList<Asignatura> semestre1) {
		this.semestre1 = semestre1;
	}

	public ArrayList<Asignatura> getSemestre2() {
		return semestre2;
	}

	public void setSemestre2(ArrayList<Asignatura> semestre2) {
		this.semestre2 = semestre2;
	}

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
