import java.util.StringTokenizer;
class MyAvt{
char letters[]={'A','B','C','D','E'};
char digit[]={'1','2','3','4','5','6','7','8','9','0'};
public boolean isIndificator(String sIn){
    int i=0;
    while(i<sIn.length()){
        char chTmp=sIn.charAt(i);
        if(isLetter(chTmp))
            return true;
    }
    return false;
}
public boolean isLetter(char sIn){
for(char l:letters){
if(l==sIn) return true;
}
return false;
}
public boolean isInt(String sIn){
    int i=0;
    while(i<sIn.length()){
        char chTmp=sIn.charAt(i);
        if(isDigit(chTmp))
            return true;
    }
    return false;
}
public boolean isDigit(char sIn){
for(char d:digit){
if(d==sIn)return true;
}
return false;
}

public void oper(String sIn){
StringTokenizer st=new StringTokenizer(sIn,"=",false);
while(st.hasMoreTokens()){
String StringStmp=st.nextToken();
if(isIndificator(StringStmp))
  System.out.println("Mi vveli Indificator :"+StringStmp);
 
else if(isInt(StringStmp))
  System.out.println("Mi vveli chislo int:"+StringStmp);
else
  System.out.println("Oshibka-nevernaya stroka :"+StringStmp);
}
}
}
class Main{
public static void main(String args[]){
MyAvt a=new MyAvt();
/*a.oper("A=7");
a.oper("C=9");
a.oper("*=7");*/
a.oper("ACB=8000067");
a.oper("ACB=10009");
}
}