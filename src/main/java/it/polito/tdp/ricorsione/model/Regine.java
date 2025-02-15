package it.polito.tdp.ricorsione.model;

import java.util.ArrayList;
import java.util.List;

public class Regine {
	
	List<List<Integer>> tutte;
	
	public List<List<Integer>> cercaRegine(int N) {  //serve per avviare la ricorsione
		this.tutte=new ArrayList<List<Integer>>();
		List<Integer> parziale=new ArrayList<Integer>();
		regine_ricorsiva(parziale, 0, N);
		return this.tutte;
	}

	private void regine_ricorsiva(List<Integer> parziale, int livello, int N) {    //serve a gestire caso ricorsivo e caso terminale
		if(livello==N) {      //caso terminale
			this.tutte.add(new ArrayList<Integer>(parziale));
		}else {
			for(int col=0;col<N;col++) {
				if(compatibile(livello,col,parziale)) {
					parziale.add(col);
					regine_ricorsiva(parziale,livello+1,N);
					parziale.remove(parziale.size()-1);    //backtracking: aggiungo qualcosa, uso la lsita e poi tolgo quello che ho aggiunto
				}
			}
		}
	}
	
	private boolean compatibile(int livello, Integer col, List<Integer> parziale) {
		if(parziale.indexOf(col) != -1)
			return false;
		for(int riga=0;riga<parziale.size();riga++) {
			if(riga+parziale.get(riga) == livello+col)
				return false;
			if(riga-parziale.get(riga) == livello-col)
				return false;
		}
		return true;
	}
}
