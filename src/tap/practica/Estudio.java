package tap.practica;

import java.util.ArrayList;

public class Estudio {
	
	String nombre = new String();
	
	ArrayList<Curso> cursos = new ArrayList<Curso>();
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
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
