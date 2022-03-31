package it.polito.tdp.model;

import java.util.*;

public class Dictionary {

	List<ParolaAliena> dizionario = new ArrayList<ParolaAliena>();
	
	public void aggiungiParola(ParolaAliena p) {
		this.dizionario.add(p);
	}
	
	public List<String> traduzione(String p) {
		List<String> traduzioni = new ArrayList<String>();
		for(ParolaAliena pi:this.dizionario) {
			if(pi.getParola().equals(p))
				traduzioni.add(pi.getTraduzione());
		}
		return traduzioni;
	}
	
	
}
