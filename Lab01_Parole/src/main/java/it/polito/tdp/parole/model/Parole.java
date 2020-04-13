package it.polito.tdp.parole.model;

import java.util.*;

public class Parole {
	
	private LinkedList <String> parole = new LinkedList <String> ();
		
	public Parole() {
		//TODO
		
	}
	
	public void addParola(String p) {
		//TODO
		parole.add(p);
	}
	
	public List<String> getElenco() {
		//TODO
		LinkedList <String> paroleOrdinate = new LinkedList <String> (parole);
		Collections.sort(paroleOrdinate, new Parole.paroleCompartor());
		return paroleOrdinate;
	}
	
	public void delParola (String s) {
		String parola = null;
		while (parole.contains(s)) {
			parole.remove(parole.indexOf(s));
		}
	}
	
	public void reset() {
		// TODO
		parole.clear();
	}
	
	static public class paroleCompartor implements Comparator <String> {
		@Override
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			return o1.compareToIgnoreCase(o2);
		}
		
	}
}
