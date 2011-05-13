package tap.practica.servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

import tap.practica.estructuras.Alumno;

public interface AlumnoServerIfaz extends Remote {
	public Alumno getAlumno(String nif) throws RemoteException;
}
