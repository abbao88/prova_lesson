package com.titan.travelagent;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.ejb3.annotation.RemoteBinding;

import com.titan.domain.Cabin;

/**
 * Session Bean implementation class TravelAgentBean
 */
@Stateless
@RemoteBinding(jndiBinding="TravelAgentRemote")
public class TravelAgentBean implements TravelAgentRemote {
	@PersistenceContext(unitName="titan") private EntityManager manager;

	@Override
	public void createCabin(Cabin c) {
		
		manager.merge(c);
		
	}

	@Override
	public Cabin findCabin(int id) {
		
		return manager.find(Cabin.class, id);
	}

	@Override
	public void removeAll(Cabin c) {
		manager.remove(c);
		
	}

}
