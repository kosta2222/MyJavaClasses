
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


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
StringBuilder sTmp=null;
while (charRead != -1 ){
charRead = bf.read();



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


return l;
}
    }

