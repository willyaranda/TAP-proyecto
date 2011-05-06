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
	
	public Alumno(int nif, String nombre, String apellidos, int curso) {
		this.nif = nif;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.curso = curso;
	}
	
	public void print() {
		System.out.print(nif + " - " + nombre + " " + apellidos + " " +
				estudioCarrera.nombre + " - " + curso);
		estudioCarrera.printCursos();
	}

	public Estudio getEstudioCarrera() {
		return estudioCarrera;
	}

	public void setEstudioCarrera(Estudio estudioCarrera) {
		this.estudioCarrera = estudioCarrera;
	}

}
