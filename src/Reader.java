import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Reader {
	String fileName;
	Element elements[] = new Element[20];
	int next = 0;
	
	
	public Reader(String aFileName){
		fileName = aFileName;
	
		try ( BufferedReader br = new BufferedReader( new FileReader( fileName)))
		{
 
			String sCurrentLine;
 
			while ((sCurrentLine = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(sCurrentLine);
			
				Element elem = new Element(Integer.parseInt( st.nextToken()), st.nextToken(), st.nextToken() ,st.nextToken());
				
				elements[next] = elem;
			    next++;
				//System.out.println(elem);
		
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	public Element[] getElements(){
		return elements;
	}
	
}
