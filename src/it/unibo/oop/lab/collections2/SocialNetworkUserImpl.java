package it.unibo.oop.lab.collections2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

	final Map<String, List<U>> contact;		//mappa che associa nome gruppo ai suoi partecipanti
    /*
     * 
     * [FIELDS]
     * 
     * Define any necessary field
     * 
     * In order to save the people followed by a user organized in groups, adopt
     * a generic-type Map:
     * 
     * think of what type of keys and values would best suit the requirements
     */

    /*
     * [CONSTRUCTORS]
     * 
     * 1) Complete the definition of the constructor below, for building a user
     * participating in a social network, with 4 parameters, initializing:
     * 
     * - firstName - lastName - username - age and every other necessary field
     * 
     * 2) Define a further constructor where age is defaulted to -1
     */
	public SocialNetworkUserImpl(final String name, final String surname, final String user) {
		super(name, surname, user);
        contact = new HashMap<>();
	}

    /**
     * Builds a new {@link SocialNetworkUserImpl}.
     * 
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user, userAge);
        contact = new HashMap<>();
    }

    @Override
    public boolean addFollowedUser(final String circle, final U user) {
    	
    	boolean exist = true;
    	
    	for(List<U> l : contact.values()) {
    		if(l.contains(user)) {
    			exist = false;
    		}
    	}
    	
    	if(contact.containsKey(circle)) {
    		contact.get(circle).add(user);
    	}else {
    		final List<U> temporalyGroup = new ArrayList();
    		temporalyGroup.add(user);
    		contact.put(circle, temporalyGroup);
    	}
    	
        return exist;
    }

    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
    	
    	if(contact.containsKey(groupName)) {
    		List<U> temporalyList = contact.get(groupName);
    		return new ArrayList<U>(contact.get(groupName));
    	}else {
    		return new ArrayList<>();
    	}
        
    }

    @Override
    public List<U> getFollowedUsers() {
    	
    	List<U> temporalyList = new ArrayList<>();
    	
    	for(List<U> l : contact.values()) {
    		for(U x : l) {
    			if(!temporalyList.contains(x)) {
    				temporalyList.add(x);
    			}
    		}
    	}
    	
        return temporalyList;
    }

}
