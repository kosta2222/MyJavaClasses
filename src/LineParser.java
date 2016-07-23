
import java.util.ArrayList;

class LineParser{
 private ArrayList list;
 private StringBuilder sb;

    public LineParser() {
        list=new ArrayList<String>();
        sb=new StringBuilder();
    }
public   ArrayList<String> oper(String sIn){
    char charRead='\0';
    int i=0;
    while(i<sIn.length()){
        charRead=sIn.charAt(i);
        if(sIn.charAt(i)!=' ' & sIn.charAt(i)!='=' & sIn.charAt(i)!='\"'){
         sb.append(charRead);
                 
        }else if(charRead==' ' || charRead=='=' || charRead=='\"'){
            if(charRead=='\"'){
                System.out.println("Nachinautsya kavichki");  
            }
         list.add(sb.toString()); 
         sb.delete(0, sIn.length());
        }
     i++;   
    }
return list;
}
    
    
    
}

class Main {
public static void main(String args[]){
LineParser lp=new LineParser();
String s="set String i_MyVar=\"Eto moya stroka\"";
    System.out.println(lp.oper(s));

}
}