
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
char buffer[]=new char[256];//буфер для строки из цикла
char bufferOut[];


     bf=mr.getBuffered_reader();
    try{
if (bf != null){
int i = 0;
while (charRead != -1){
charRead = bf.read();

if ((char)charRead !=delimeter){
    

String s=String.valueOf((char)charRead);
sb.append(s);

}
else if((char)charRead ==delimeter)
    sb.append(';');
       
         
  }
     StringTokenizer st=new StringTokenizer(sb.toString(),";",false);
while(st.hasMoreTokens()){
String StringStmp=st.nextToken();
l.add(StringStmp);

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

/*class Main  {
public static void main(String args[]){
File f=new File("D:\\NetBeansProjects\\MyOwnLan\\src\\text.dat");
    ReadBytes rb=new ReadBytes(f,"cp1251");
     System.out.println(rb.read(']'));
}
}*/

