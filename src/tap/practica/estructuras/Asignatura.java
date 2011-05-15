package tap.practica.estructuras;

import java.io.Serializable;

/**
 * Clase Asignatura, contiene atributos como una cadena con el código de la
 * asignatura, otra cadena con el nombre y un entero con los créditos
 * 
 * @author willyaranda
 * @author aldo
 */
public class Asignatura implements Serializable {

	String codigo = new String();
	String nombre = new String();
	int creditos;

	/**
	 * Constructor por defecto de Asignatura
	 * 
	 * @param codigo
	 *            cadena con el código
	 * @param nombre
	 *            cadena con el nombre
	 * @param creditos
	 *            entero con el número de créditos
	 * @throws Exception
	 *             si el número de créditos no es válido
	 */
	public Asignatura(String codigo, String nombre, int creditos)
			throws Exception {
		this.codigo = codigo;
		this.nombre = nombre;
		setCreditos(creditos);
	}

	/**
	 * Devuelve una cadena con el código identificativo único de la asignatura
	 * 
	 * @return el código identificativo único
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Devuelve un entero con los créditos de la asignatura
	 * 
	 * @return el entero con el número de créditos
	 */
	public int getCreditos() {
		return creditos;
	}

	/**
	 * Devuelve una cadena con el nombre de la Asignatura
	 * 
	 * @return el nombre de la asignatura
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Muestra por la salida estándar el código, el nombre y el número de
	 * créditos de la Asignatura
	 */
	public void printAsignatura() {
		System.out.println(getCodigo() + " - " + getNombre() + ", "
				+ getCreditos());
	}

	/**
	 * Pone el atributo codigo con la cadena pasada
	 * 
	 * @param codigo
	 *            cadena con el código
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Pone el número de créditos de la asignatura Tiene que estar entre 3 y 9
	 * (incluidos). Si no lo está esta función lanza una excepción que es
	 * recogida por ella misma y se muestra en la salida estándar
	 * 
	 * @param creditos
	 *            un entero con el número de créditos
	 * @throws Exception
	 *             número de créditos inválido
	 */
	public void setCreditos(int creditos) throws Exception {
		// Si ponemos créditos mayor que 9 o menor que 3, excepción
		try {
			if ((creditos > 9) || (creditos < 3))
				throw new Exception("Son " + creditos
						+ " créditos, el máximo es 9 y el mínimo 3");
			this.creditos = creditos;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	/**
	 * Pone el nombre de la asignatura con la cadena pasada
	 * 
	 * @param nombre
	 *            cadena del nombre a poner
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
