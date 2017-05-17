
public class Element
{
 int atomNo;
 String name;
 String symbol;
 int valenceNumber;
 double atomicWeight;
 
 //this property must considered
 double electroNeg;
 static private int valenceArray[]=  {-1,0,1,2,3,-4,-3,-2,-1,0,1,2,3,4,-3,-2,-1,0,1,2};
 
 //coordinates of this element - used in DragGame
 int x;
 int y;
 public Element( int aNo, String aSymbol, String aName, String aNeg)
 {
  atomNo = aNo;
  name = aName;
  symbol = aSymbol;
  electroNeg = Double.parseDouble(aNeg);
  valenceNumber = valenceArray[aNo - 1];
 }
 public Element(String elementName, int atomNumber, String atomicSymbol, double atomicWeight)
 {
   atomNo = atomNumber;
   symbol = atomicSymbol;
   this.atomicWeight = atomicWeight;
   name = elementName;
 }
 public Element()
 {
  
 }
 public Element(Element e)
 {
  atomNo = e.atomNo;
  name = e.name;
  symbol = e.symbol;
  electroNeg = e.electroNeg;
  valenceNumber = valenceArray[atomNo - 1]; 
 }
 
 public boolean compareEN(Element a)
 {
  return electroNeg < a.electroNeg;
 }
 
 public String toString()
 {
  return "AtomNo:" + atomNo + " Name:" + name + " Valence: " + valenceNumber + " ElectroNegativity:" + electroNeg; 
 } 
 String getDescription()
 {
   String description;
   
   description = name + "\n" + "Atomic Number : " + atomNo + "\n" +"Atomic Symbol : " + symbol + "\n" + "Atomic Weight : " + atomicWeight;
   
   return(description);
 }
}
