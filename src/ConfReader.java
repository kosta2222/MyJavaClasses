
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

class ConfReader{
private FileInputStream fin;
private Properties ht;

    public ConfReader(String pathToConfig) {
ht=new Properties();
 try{
fin=new FileInputStream(pathToConfig);
if(fin!=null){
ht.load(fin);
fin.close();
}

}catch(FileNotFoundException e){
System.out.println("Ne mogu naiti conf fail ["+e+"]");
}
catch(IOException e){
System.out.println("Oshibka chteniya conf faila ["+e+"]");
}

    }
public String getProp(String whatKey){
String valueOfProp=(String)ht.get(whatKey);
return valueOfProp;
}
    
}


/*class Main  {
public static void main(String args[]){
ConfReader cr=new ConfReader(".\\config\\conf.dat");
System.out.println(cr.getProp("path"));
}
}*/