import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import com.titan.domain.Cabin;
import com.titan.travelagent.TravelAgentRemote;


public class Client {
	public static void main(String[] args) {
		
		
		
		try {
			Context jndiContext = getInitialContext();
			//Object ref = jndiContext.lookup("java:comp/env/ejb/TravelAgentRemote");
			Object ref = jndiContext.lookup("TravelAgentRemote");
			TravelAgentRemote dao = (TravelAgentRemote) PortableRemoteObject.narrow(ref, TravelAgentRemote.class);
			//TravelAgentRemote dao = (TravelAgentRemote) ref;
		
			Cabin cabin_1= new Cabin();
			cabin_1.setId((int)(Math.random()*10));
			cabin_1.setName("MasterSuite");
			cabin_1.setDeckLevel(1);
			cabin_1.setShipId(1);
			cabin_1.setBedCount(3);
			
			dao.createCabin(cabin_1);
			
			Cabin cabin_2 = dao.findCabin(1);
			
			System.out.println(cabin_2.getName());
			System.out.println(cabin_2.getDeckLevel());
			System.out.println(cabin_2.getShipId());
			System.out.println(cabin_2.getBedCount());
			
			
			
			
			/*System.out.println("\nClearing Database...");
			dao.removeAll(cabin_2);*/
			
		} catch (NamingException e) {
			
			System.out.println("Exception handled\n"+e.getExplanation());
		}
	}//fine main

	
	public static Context getInitialContext() throws javax.naming.NamingException{
		
		Properties env = new Properties();
		env.put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
		env.put(javax.naming.Context.PROVIDER_URL, "jnp://127.0.0.1:1099");
		env.put(javax.naming.Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
		//javax.naming.Context i = new InitialContext(env);*/
		
		return new InitialContext(env);
		//return i;
	}
	
	
}