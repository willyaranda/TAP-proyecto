package tap.practica.estructuras;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase Alumno, que contiene los datos del alumno (ver constructor), así como
 * el curso actual, la carrera que está estudiando y las asignaturas
 * matriculadas.
 * 
 * @author willyaranda
 * @author aldo
 * 
 */

public class Alumno implements Serializable {

	String nif = new String();
	String nombre = new String();
	String apellidos = new String();
	ArrayList<Asignatura> matriculadas = new ArrayList<Asignatura>();
	int numCreditos;

	/**
	 * Curso que está cursando actualmente
	 */
	int curso;

	/**
	 * Carrera actual (tipo Estudio)
	 */
	Estudio estudioCarrera = new Estudio();

	public Alumno() {
	}

	/**
	 * Constructor necesario
	 * 
	 * @param nif
	 *            un entero con el NIF del alumno
	 * @param nombre
	 *            una cadena con el nombre del alumno
	 * @param apellidos
	 *            una cadena con los apellidos del alumno
	 * @param curso
	 *            un entero con el curso actual que está cursando
	 */
	public Alumno(String nif, String nombre, String apellidos, int curso) {
		this.nif = nif;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.curso = curso;
	}

	public Boolean comprobar() {
		return ((numCreditos > 60) || (numCreditos < 12)) ? false : true;
	}

	public void desmatricular(String nombre) {
		Asignatura a = tap.practica.cliente.Inicio.getAlumno()
				.getEstudioCarrera().buscarAsig(nombre);
		numCreditos -= a.getCreditos();
		matriculadas.remove(a);
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @return the curso
	 */
	public int getCurso() {
		return curso;
	}

	/**
	 * Devuelve la carrera que está cursando
	 * 
	 * @return el Estudio
	 */
	public Estudio getEstudioCarrera() {
		return estudioCarrera;
	}

	/**
	 * @return the matricula
	 */
	public ArrayList<Asignatura> getMatricula() {
		return matriculadas;
	}

	public ArrayList<Asignatura> getMatriculadas() {
		return matriculadas;
	}

	/**
	 * @return the nif
	 */
	public String getNif() {
		return nif;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	public void guardar(String nif) {
		System.out.println("Guardando...");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("./" + nif + ".txt");
			Alumno a = tap.practica.cliente.Inicio.getAlumno();
			String write = a.getNif() + " - " + a.getNombre() + " "
					+ a.getApellidos() + ". Estudiando: "
					+ a.getEstudioCarrera().getNombre() + " en " + a.getCurso()
					+ "º. Asignaturas: \n";
			for (Asignatura as : matriculadas) {
				write += (as.getCodigo() + ": " + as.getNombre() + ", "
						+ as.getCreditos() + "\n");
			}
			fos.write(write.getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Añade una Asignatura a la lista de matriculadas.<br />
	 * Comprueba si se puede añadir a la lista de matriculación. No nos podemos
	 * pasar de 60 créditos matriculados, y en ese caso devuelve <b>false</b> En
	 * cualquier otro caso, devuelve <b>true</b>
	 * 
	 * @param nombre
	 *            el nombre de la asignatura
	 * @return si la operación ha sido completada correctamente
	 */
	public Boolean matricular(String nombre) {
		Asignatura a = tap.practica.cliente.Inicio.getAlumno()
				.getEstudioCarrera().buscarAsig(nombre);
		if ((numCreditos + a.getCreditos()) > 60)
			return false;
		numCreditos += a.getCreditos();
		matriculadas.add(a);
		return true;
	}

	/**
	 * Imprime los datos propios del Alumno y además todas las asignaturas de la
	 * carrera.
	 */
	public void print() {
		System.out.print(nif + " - " + nombre + " " + apellidos + " "
				+ estudioCarrera.nombre + " - " + curso);
		estudioCarrera.print();
	}

	/**
	 * @param apellidos
	 *            the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @param curso
	 *            the curso to set
	 */
	public void setCurso(int curso) {
		this.curso = curso;
	}

	/**
	 * Asigna la carrera actual
	 * 
	 * @param estudioCarrera
	 *            Carrera actual que está estudiando
	 */
	public void setEstudioCarrera(Estudio estudioCarrera) {
		this.estudioCarrera = estudioCarrera;
	}

	/**
	 * @param nif
	 *            the nif to set
	 */
	public void setNif(String nif) {
		this.nif = nif;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
