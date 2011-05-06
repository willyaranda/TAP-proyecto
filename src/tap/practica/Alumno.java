package tap.practica;

/**
 * Clase Alumno, que contiene los datos del alumno (ver constructor),
 * así como el curso actual, la carrera que está estudiando y las asignaturas
 * matriculadas.
 * 
 * @author willyaranda
 * @author aldo
 *
 */

public class Alumno {
	
	int nif;
	String nombre = new String();
	String apellidos = new String();
	
	/**
	 * Curso que está cursando actualmente
	 */
	int curso;
	
	/**
	 * Carrera actual (tipo Estudio)
	 */
	Estudio estudioCarrera = new Estudio();
	
	/**
	 * Atributo de tipo Matrícula que contiene todas las asignaturas de las
	 * que está matriculado el Alumno
	 */
	Matricula matricula = new Matricula();
	
	/**
	 * Constructor necesario
	 * @param nif		un entero con el NIF del alumno
	 * @param nombre	una cadena con el nombre del alumno
	 * @param apellidos	una cadena con los apellidos del alumno
	 * @param curso		un entero con el curso actual que está cursando
	 */
	public Alumno(int nif, String nombre, String apellidos, int curso) {
		this.nif = nif;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.curso = curso;
	}
	
	/**
	 * Imprime los datos propios del Alumno y además todas las asignaturas
	 * de la carrera.
	 */
	public void print() {
		System.out.print(nif + " - " + nombre + " " + apellidos + " " +
				estudioCarrera.nombre + " - " + curso);
		estudioCarrera.print();
	}
	
	/**
	 * Devuelve la carrera que está cursando
	 * @return el Estudio
	 */
	public Estudio getEstudioCarrera() {
		return estudioCarrera;
	}

	/**
	 * Asigna la carrera actual
	 * @param estudioCarrera Carrera actual que está estudiando
	 */
	public void setEstudioCarrera(Estudio estudioCarrera) {
		this.estudioCarrera = estudioCarrera;
	}

}
