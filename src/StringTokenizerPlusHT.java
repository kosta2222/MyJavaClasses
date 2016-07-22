
import java.util.HashMap;
import java.util.StringTokenizer;

class StringTokenizerPlusHT{
private HashMap <String,Var> mapForVarClasses=null;
private StringTokenizer st=null;
private StringBuilder sb=null;
private RegExp re=null;
    public StringTokenizerPlusHT(HashMap <String,Var> mapForVarClasses) {
        this.mapForVarClasses=mapForVarClasses;
        sb=new StringBuilder();
        re=new RegExp();
        
    }
    public String getValueString(String sIn,String delimeters){
     st=new StringTokenizer(sIn,delimeters,true);
    
    while(st.hasMoreTokens()){
    String stringTmp=st.nextToken();
    if(!stringTmp.equals("[")&!stringTmp.equals("]")){
    if(re.test(stringTmp,"^%\\w+%$")){//in Used Vars//
           String str=stringTmp.substring(1,stringTmp.length()-1);
                       
            Var myVar=(Var)mapForVarClasses.get(str);
            sb.append(myVar.getValue());
            
        }else{
                    sb.append(stringTmp);
                }
    }
    }

    
return sb.toString();

}
}