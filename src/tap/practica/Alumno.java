package tap.practica;

public class Alumno {
	
	int nif;
	String nombre = new String();
	String apellidos = new String();
	
	/*
	 * curso = curso actual (número)
	 * estudioCarrera = carrera que está estudiando
	 */
	int curso;
	Estudio estudioCarrera = new Estudio();
	
	Matricula matricula = new Matricula();
	
	public Alumno(int nif, String nombre, String apellidos, Estudio estudio,
			int curso) {
		this.nif = nif;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.estudioCarrera = estudio;
		this.curso = curso;
	}
	
	public void print() {
		System.out.print(nif + " - " + nombre + " " + apellidos + " " +
				estudioCarrera.nombre + " - " + curso);
		estudioCarrera.printCursos();
	}

}
