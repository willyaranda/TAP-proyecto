package tap.practica.estructuras;

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
	
	String nif = new String();
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
	public Alumno(String nif, String nombre, String apellidos, int curso) {
		this.nif = nif;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.curso = curso;
	}
	
	public Alumno() {
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

	/**
	 * @return the nif
	 */
	public String getNif() {
		return nif;
	}

	/**
	 * @param nif the nif to set
	 */
	public void setNif(String nif) {
		this.nif = nif;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the curso
	 */
	public int getCurso() {
		return curso;
	}

	/**
	 * @param curso the curso to set
	 */
	public void setCurso(int curso) {
		this.curso = curso;
	}

	/**
	 * @return the matricula
	 */
	public Matricula getMatricula() {
		return matricula;
	}

	/**
	 * @param matricula the matricula to set
	 */
	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
}
