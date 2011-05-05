package tap.practica;

public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Asignatura a11 = new Asignatura("COD-C1-A1", "C1-A1", 5);
		Asignatura a12 = new Asignatura("COD-C1-A2", "C1-A2", 4);
		Asignatura a13 = new Asignatura("COD-C1-A3", "C1-A3", 6);
		Asignatura a14 = new Asignatura("COD-C1-A4", "C1-A4", 6);
		Asignatura a21 = new Asignatura("COD-C2-A1", "C2-A1", 3);
		Asignatura a22 = new Asignatura("COD-C2-A2", "C2-A2", 8);
		Asignatura a23 = new Asignatura("COD-C2-A3", "C2-A3", 7);
		Asignatura a24 = new Asignatura("COD-C2-A4", "C2-A4", 7);
		Asignatura a31 = new Asignatura("COD-C3-A1", "C3-A1", 5);
		Asignatura a32 = new Asignatura("COD-C3-A2", "C3-A2", 7);
		Asignatura a33 = new Asignatura("COD-C3-A3", "C3-A3", 9);
		Asignatura a34 = new Asignatura("COD-C3-A4", "C3-A4", 7);
		
		Curso c1 = new Curso(1);
		c1.anadirAsignatura(1, a11);
		c1.anadirAsignatura(1, a12);
		c1.anadirAsignatura(2, a13);
		c1.anadirAsignatura(2, a14);
		
		Curso c2 = new Curso(2);
		c2.anadirAsignatura(1, a21);
		c2.anadirAsignatura(1, a22);
		c2.anadirAsignatura(2, a23);
		c2.anadirAsignatura(2, a24);
		
		Curso c3 = new Curso(3);
		c3.anadirAsignatura(1, a31);
		c3.anadirAsignatura(1, a32);
		c3.anadirAsignatura(2, a33);
		c3.anadirAsignatura(2, a34);
		
		Estudio e = new Estudio("Ing.Informatica");
		e.anadirCurso(c1);
		e.anadirCurso(c2);
		e.anadirCurso(c3);
		
		Alumno a = new Alumno(777, "Guillermo", "López", e, 2);
		
		a.print();
		
	}

}
