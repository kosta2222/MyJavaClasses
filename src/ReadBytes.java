
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ReadBytes{
    FileRider mr;
    BufferedReader bf;
    ArrayList l;

    public ReadBytes(File f,String charset,char delimeter) {
         mr=new FileRider(f,charset);
         l=new ArrayList<String>();
    }
    public ArrayList<String> read(){
   
        int charRead = 0;
char buffer[]=new char[256];//буфер для строки из цикла
char bufferOut[];
int i = 0;
     bf=mr.getBuffered_reader();
    try{
if (bf != null){
while (charRead != -1){
charRead = bf.read();
if ((char)charRead != ';'){
buffer[i] = (char)charRead;
i++;
}
         
        
         
  }

}

}catch(IOException ioEx){
System.err.println("Oshibka chteniya faila["+ioEx+"]");

}
    bufferOut=new char[i];
    for(int j=0;j<i-1;j++){
        bufferOut[j]=buffer[j];
    }
    String str=new String(bufferOut);
    l.add(str);
try{
 mr.getBuffered_reader().close();

}catch(IOException ioEx){
System.err.println("Oshibka zakritiya faila["+ioEx+"]");
   
}
return l;
}
    }

