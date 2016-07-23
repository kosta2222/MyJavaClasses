
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;





/*class Main  {
public static void main(String args[]){
File f=new File("D:\\NetBeansProjects\\MyOwnLan\\src\\text.dat");
    ReadBytes rb=new ReadBytes(f,"cp1251");
     //rb.read(']');
     System.out.println(rb.read(']'));
}
}*/

class ReadBytes{
    FileRider mr;
    BufferedReader bf;
    ArrayList <String> l;
    StringBuilder sb;		

    public ReadBytes(File f,String charset) {
         mr=new FileRider(f,charset);
         l=new ArrayList<String>();
	sb=new StringBuilder();
    }
    public ArrayList<String> read(char delimeter){
   
        int charRead = 0;



     bf=mr.getBuffered_reader();
    try{
if (bf != null){
//int i = 0;
StringBuilder sTmp=null;
while (charRead != -1 ){
charRead = bf.read();

/*if ((char)charRead !=delimeter){
    

String s=String.valueOf((char)charRead);
sb.append(s);

}*/

 if((char)charRead !=delimeter &((char)charRead!='\n' & (char)charRead!='\r')){
    String s=String.valueOf((char)charRead);
   sTmp=sb.append(s);
   
       
        }else if((char)charRead ==delimeter ){
            l.add(sTmp.toString());
            sTmp.delete(0,sTmp.length());
        }
       
 
  }

     



}

}catch(IOException ioEx){
System.err.println("Oshibka chteniya faila["+ioEx+"]");

}
        
try{
 mr.getBuffered_reader().close();

}catch(IOException ioEx){
System.err.println("Oshibka zakritiya faila["+ioEx+"]");
   
}
//l.remove(l.size()-1);

return l;
}
    }

    



class Main  {
public static void main(String args[]){
File f=new File("D:\\NetBeansProjects\\MyOwnLan\\src\\text.dat");
    ReadBytes rb=new ReadBytes(f,"cp1251");
     //rb.read(']');
     System.out.println(rb.read(';'));
}
}


