import java.io.IOException;
import java.util.*;
import java.text.AttributedString;
import java.awt.Font;
import java.awt.font.TextAttribute;

public class Compound {
	Element e1;// pozitif degerlik alan
	Element e2; // negatif degerlik alan
	//coefficients
	int coef1;
	int coef2;
	String name;
	final int EDGE_SIZE = 20;
	//coordinates of this compound - used in DragGame
	int x;
	int y;
	
	public Compound(Element first, Element second,int X,int Y){
		if(first.compareEN(second)){
			e1 = first;
			e2 = second;
		}
		else{
			e2 = first;
			e1 = second;
		}
		
		coef1 = Math.abs(e2.valenceNumber);
		coef2 = Math.abs(e1.valenceNumber);
		int gcd = findGcd(coef1,coef2);
		coef1 = coef1/gcd;
		coef2 = coef2/gcd;
		x = X;
		y = Y;
		//System.out.println(first.toString() + second.toString());
		//System.out.println(x + " " + y);
		
	}
	
	public static boolean compare(Element e1,Element e2){
		
		if(e1.valenceNumber * e2.valenceNumber < 0)// demek ki bag olabilir
			return true;
		if(e1.valenceNumber < 0 &&  e2.valenceNumber < 0)
			return true;
		
		return false;
		
	}
	private int findGcd(int a,int b){
		
		if(a > b){
			int tmp = a;
			a = b;
			b = tmp;
		}
			
		if(a == 0)
			return b;
		return findGcd(b%a,a);
	}
	//returns name of compound with coefficients writed subscript
	//don't print coefficients if they are one
	public AttributedString FancyString(){
		String ret = "";
		AttributedString as = new AttributedString(ret);
		if(e1.symbol.equals(e2.symbol)){
			ret += e1.symbol;
			ret += "2";
			as = new AttributedString(ret);
			as.addAttribute(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUB, e1.symbol.length(), e1.symbol.length()+1);
			
		}
		else{	
			ret += e1.symbol;
			if(coef1 > 1)
				ret += coef1;
			ret += e2.symbol;
			
			if(coef2 > 1)
				ret += coef2;
			//To Do
			as = new AttributedString(ret);
			
			if(coef1 > 1)
				as.addAttribute(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUB, e1.symbol.length(), e1.symbol.length()+1);
			if(coef2 > 1)
				as.addAttribute(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUB, ret.length()-1, ret.length());
		}
		//as.addAttribute(TextAttribute.FONT,new Font("Serif",Font.PLAIN,30));
		return as;
	}
	
	
}
