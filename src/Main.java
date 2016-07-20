
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
class Var{
private String type;
private String indificator;
private String value;

    public void setType(String type) {
        this.type = type;
    }

    public void setIndificator(String indificator) {
        this.indificator = indificator;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getIndificator() {
        return indificator;
    }

    public String getValue() {
        return value;
    }
    

}
class ExpParser{
    public void oper(String sIn,String osNewLine,int substringOffset){//substringOffset depends of osNewLine
RegExp re=new RegExp();        
StringTokenizer st=new StringTokenizer(sIn,"= ",true);
        System.out.println(sIn);
        if(sIn.substring(0,3).equals("set")||(sIn.substring(0,substringOffset).equals(osNewLine+"set"))){
            Var var=new Var();
while(st.hasMoreTokens()){
String StringStmp=st.nextToken();

if(re.test(StringStmp,"^\\d+$") || re.test(StringStmp,"^\\d+\\.\\d+$"))
{
    System.out.println("number int or float :"+StringStmp);//<<< isSet
    var.setValue(StringStmp);//<<< set int/float
}
else if(re.test(StringStmp,"^i_\\w+$")){
            System.out.println("Indificator:"+StringStmp);//<<< isSet
            var.setIndificator(StringStmp);//<<< set Indificator
        }
else if(re.test(StringStmp,"^<\\w+>$")){
            System.out.println("String:"+StringStmp);//<<<  isSet
            var.setValue(StringStmp); //<<< set String
        }

    }

    }
        else if(re.test(sIn,"^%\\w+%$")|| re.test(sIn,"^"+osNewLine+"%\\w+%$")){
            System.out.println("Use Var:"+sIn);
        }else{
            System.out.println("function:"+sIn);
            StringTokenizer st_w=new StringTokenizer(sIn,"()",true);
            while(st_w.hasMoreTokens()){
String StringStmp=st_w.nextToken();
if(re.test(StringStmp,"^\\%\\w+\\%$")){
            System.out.println("Use Var:"+StringStmp);
}

              


        }
}
}
}




class Main  {
public static void main(String args[]){
    File f=new File("D:\\NetBeansProjects\\MyOwnLan\\src\\text.dat");
    ReadBytes rb=new ReadBytes(f,"cp1251");
    ArrayList l=rb.read(';');
    ExpParser ep=new ExpParser();
    Iterator<String> it=l.iterator();
    while(it.hasNext()){
        String str=it.next();
        ep.oper(str,"\r\n",5);
    }

}
}