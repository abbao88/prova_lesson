package com.titan.travelagent;
import javax.ejb.Remote;

import com.titan.domain.Cabin;

@Remote
public interface TravelAgentRemote {
	
	public void createCabin(Cabin c);
	public Cabin findCabin(int id);
	public void removeAll(Cabin c);

}
