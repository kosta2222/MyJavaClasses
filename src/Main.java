
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
//import java.util.StringTokenizer;
class ExpParser{
    public void oper(String sIn){
RegExp re=new RegExp();        
StringTokenizer st=new StringTokenizer(sIn,"=",true);
        System.out.println(sIn);
        if(sIn.substring(0,3).equals("set")){
while(st.hasMoreTokens()){
String StringStmp=st.nextToken();

if(re.test(StringStmp,"^\\d+$"))
{
    System.out.println("number int :"+StringStmp);
}
//else if(!re.test(StringStmp,"^\\d+$"))
//{
//    re.message(false,"Eto ne number int");
//}
else if(re.test(StringStmp,"^\\d+\\.\\d+")){
     System.out.println("number float :"+StringStmp);   
        }


    }
    }else
            System.out.println("function:"+sIn);
}
}




class Main  {
public static void main(String args[]){
    File f=new File("D:\\NetBeansProjects\\MyOwnLan\\src\\text.dat");
    ReadBytes rb=new ReadBytes(f,"cp1251");
    ArrayList l=rb.read(']');
    ExpParser ep=new ExpParser();
    Iterator<String> it=l.iterator();
    while(it.hasNext()){
        String str=it.next();
        ep.oper(str);
    }

}
}