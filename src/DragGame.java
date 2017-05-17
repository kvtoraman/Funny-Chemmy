//change name of this class

import java.io.IOException;
import java.util.*;

public class DragGame {
	public ArrayList<Element> allElements ;
	ArrayList<Element> destElements ;
	ArrayList<Compound> compound;
	
	final int EDGE_SIZE = 20;
	final int BOND_LIMIT = 500;
	
	public DragGame(){
		
		allElements = new ArrayList<Element>();
		destElements = new  ArrayList<Element>();
		compound = new ArrayList<Compound>();
		
		Reader oku = new Reader("test.txt");
		Element ar[] = oku.getElements();
		for(int i = 0; i < 20; i++)
			allElements.add(ar[i]);
		
		System.out.println("Game created.");
		
	}
	boolean compareDistance(Element e){
		
		Element pair = new Element();
		pair = null;
		
		//finds first element on the playground which can make bond
		for(Element dest: destElements){
			if(pair==null && BOND_LIMIT > (dest.x - e.x) * (dest.x - e.x) + (dest.y - e.y) * (dest.y - e.y)){
				if(Compound.compare(e,dest)){
					pair = dest;
				}	
			}
		}
		if(pair == null)
			return false;
		
		destElements.remove(pair);
		compound.add(new Compound(e, pair, e.x, e.y + EDGE_SIZE));
		return true;
	}
	
}
