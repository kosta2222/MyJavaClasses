
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegExp{
public boolean test(String testString,String pattern,String erMes){
Pattern p=Pattern.compile(pattern);
Matcher m=p.matcher(testString);


 if(m.matches())  
return true;
 else
        System.out.println("Error["+erMes+"]");
return false;
}
}

/*class Main  {
public static void main(String args[]){
RegExp re=new RegExp();
String s="12357890";
String s2="123.57890";
String s3="0123.57890";
String s4="%MyVar0_1%";
String s5="MyVar0_1%";

System.out.println(re.test(s,"^\\d+$"));
System.out.println(re.test(s2,"^\\d+$"));
System.out.println(re.test(s3,"^\\d+$"));
System.out.println(re.test(s3,"^\\d+\\.\\d+$"));
System.out.println(re.test(s5,"^\\%\\w+\\%$"));
}
}*/
