package tap.practica.servidor;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Factory extends UnicastRemoteObject implements FactoryIfaz {
	public static XmlBeanFactory factory;

	public static void main(String[] args) throws RemoteException,
			MalformedURLException {
		System.out.println("Servidor: creando factoría...");
		Factory fac = new Factory();
		System.out.println("Servidor: registrando factoría");
		Naming.rebind("obj", fac);
		System.out.println("Servidor: factoría registrada como obj");
	}

	protected Factory() throws RemoteException {
		factory = new XmlBeanFactory(new ClassPathResource(
				"objetos.xml"));
	}

	@Override
	public XmlBeanFactory getFactory() throws RemoteException {
		return factory;
	}
}
