package tap.practica.estructuras;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase Matrícula, tiene un atributo matriculadas que guarda un array
 * de las asignaturas matriculadas.
 * Y un atributo entero que guarda el número de créditos matriculados
 * @author willyaranda
 * @author aldo
 */
public class Matricula implements GuardarIfaz {
	
	ArrayList<Asignatura> matriculadas = new ArrayList<Asignatura>();
	int numCreditos;
	
	/**
	 * Añade una Asignatura a la lista de matriculadas.<br />
	 * Comprueba si se puede añadir a la lista de matriculación. No nos 
	 * podemos pasar de 60 créditos matriculados, y en ese caso devuelve <b>false</b>
	 * En cualquier otro caso, devuelve <b>true</b>
	 * @param nombre el nombre de la asignatura
	 * @return si la operación ha sido completada correctamente
	 */
	public Boolean matricular(String nombre) {
		Asignatura a = tap.practica.Inicio.getAlumno().getEstudioCarrera().
						buscarAsig(nombre);
		if ((numCreditos + a.getCreditos()) > 60) return false;
		numCreditos += a.getCreditos();
		matriculadas.add(a);
		return true;
	}
	
	public void desmatricular(String nombre) {
		Asignatura a = tap.practica.Inicio.getAlumno().getEstudioCarrera().
			buscarAsig(nombre);
		numCreditos -= a.getCreditos();
		matriculadas.remove(a);
	}
	
	/**
	 * Comprueba si la matrícula es correcta. Si es menor de 12 o mayor de 60
	 * el número de créditos matriculados, se devuelve <b>false</b> y en
	 * otro caso se devuelve <b>true</b>
	 * @return si la matrícula es correcta
	 */
	public Boolean comprobar() {
		return ((numCreditos > 60) || (numCreditos < 12)) ? false : true;
	}

	/**
	 * @return the matriculadas
	 */
	public ArrayList<Asignatura> getMatriculadas() {
		return matriculadas;
	}

	/**
	 * @param matriculadas the matriculadas to set
	 */
	public void setMatriculadas(ArrayList<Asignatura> matriculadas) {
		this.matriculadas = matriculadas;
	}

	/**
	 * @return the numCreditos
	 */
	public int getNumCreditos() {
		return numCreditos;
	}

	/**
	 * @param numCreditos the numCreditos to set
	 */
	public void setNumCreditos(int numCreditos) {
		this.numCreditos = numCreditos;
	}
	
	@Override
	public void guardar(String nif) {
		System.out.println("Guardando...");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("./"+nif+".txt");
			Alumno a = tap.practica.Inicio.getAlumno();
			String write = a.getNif() + " - " + a.getNombre() + " " + a.getApellidos() +
				 ". Estudiando: " + a.getEstudioCarrera().getNombre() + 
				 " en " + a.getCurso() +"º. Asignaturas: \n";					
			for (Asignatura as : matriculadas) {
				write += (as.getCodigo() + ": " + as.getNombre() + ", " +
						  as.getCreditos() + "\n");
			}
			fos.write(write.getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
