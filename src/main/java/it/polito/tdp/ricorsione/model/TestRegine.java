package it.polito.tdp.ricorsione.model;

import java.util.List;

public class TestRegine {

	public static void main(String[] args) {
		ReginePrimaSoluzione r=new ReginePrimaSoluzione();
		List<Integer> soluzioni=r.cercaRegine(4);
		System.out.println(soluzioni);

	}

}
