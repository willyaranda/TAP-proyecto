package tap.practica.servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.springframework.beans.factory.xml.XmlBeanFactory;

public interface FactoryIfaz extends Remote {
	public XmlBeanFactory getFactory() throws RemoteException;
}
