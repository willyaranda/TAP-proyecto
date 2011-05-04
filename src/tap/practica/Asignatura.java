package tap.practica;

public class Asignatura {
	
	/**
	 * Atributos de la clase
	 */
	String codigo = new String();
	String nombre = new String();
	int creditos;
	
	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	 * @return the creditos
	 */
	public int getCreditos() {
		return creditos;
	}
	/**
	 * @param creditos the creditos to set
	 */
	public void setCreditos(int creditos) throws Exception {
		// Si ponemos créditos mayor que 9 o menor que 3, excepción
		if ((creditos>9) || (creditos<3)) throw new Exception("El número" +
				" de créditos introducido no es válido.");
		this.creditos = creditos;
	}

}
