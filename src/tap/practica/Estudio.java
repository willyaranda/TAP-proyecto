package tap.practica;

import java.util.ArrayList;

public class Estudio {
	
	String nombre = new String();
	
	ArrayList<Curso> cursos = new ArrayList<Curso>();
	
	public void anadirCurso(Curso curso) {
		cursos.add(curso);
	}
	
	public Estudio(String nombre) {
		this.nombre = nombre;
	}
	
	public Estudio() {
	}
	
	public void printCursos() {
		for (Curso curso : cursos) {
			curso.printCurso();
		}
	}
	
}
