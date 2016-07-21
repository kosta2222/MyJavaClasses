
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

class ExpParser{
    Map  mapForVarClasses=null;

    public ExpParser() {
        mapForVarClasses=new HashMap<String,Var>();
    }
    
    public void oper(String sIn){
RegExp re=new RegExp(); 
 StringTokenizer st=new StringTokenizer(sIn,"= ",true);
        System.out.println(sIn);
        if(sIn.substring(0,3).equals("set")){
            Var var=new Var();
            while(st.hasMoreTokens()){
String StringStmp=st.nextToken();

if(re.test(StringStmp,"^\\d+$") || re.test(StringStmp,"^\\d+\\.\\d+$"))
{
    //***System.out.println("number int or float :"+StringStmp);//<<< isSet
    var.setValue(StringStmp);//<<< set int/float
}
else if(re.test(StringStmp,"^i_\\w+$")){
            //***System.out.println("Indificator:"+StringStmp);//<<< isSet
            var.setIndificator(StringStmp);//<<< set Indificator
        }else if(re.test(StringStmp,"^s_\\w+$")){
            //***System.out.println("Indificator:"+StringStmp);//<<< isSet
            var.setValue(StringStmp);//<<< set String
        }

else if(StringStmp.equals("int") || StringStmp.equals("float")|| StringStmp.equals("double")|| StringStmp.equals("String")|| StringStmp.equals("char")|| StringStmp.equals("boolean")){
            //****System.out.println("Type:"+StringStmp);//<<<  isSet
            var.setType(StringStmp); //<<< set Type<<<
        }


    }
            mapForVarClasses.put(var.getIndificator(), var);
            

    }
        else if(re.test(sIn,"mat_op\\(%\\w+?%([-+*/^]%\\w+?%)+\\)")){//<<<Mat expression
            System.out.println("mat op: "+sIn);
            String stringTmp="";
            String stringS=sIn.substring(6,sIn.length());
            StringTokenizer st_mat_op=new StringTokenizer(stringS,"()+-*/^",true);
            StringBuilder  sb_mat_op=new StringBuilder();
            while(st_mat_op.hasMoreTokens()){
                stringTmp=st_mat_op.nextToken();
                if(re.test(stringTmp,"^%\\w+%$")){//in Used Vars//
            ///***System.out.println("Use Var:"+sIn);
            String str=stringTmp.substring(1,stringTmp.length()-1);
            //System.out.println("***********");
            //System.out.println(str);//get Vars
            //System.out.println("***********");
            
            Var myVar=(Var)mapForVarClasses.get(str);
            sb_mat_op.append(myVar.getValue());
            //System.out.println("))))))))))))))");
            //System.out.println(sIn+"="+myVar.getValue());
            //System.out.println(")))))))))))))))");
        }else{
                    sb_mat_op.append(stringTmp);
                }
                //sb_mat_op.append(stringTmp);
                //System.out.println("..........");
                //System.out.println(sb_mat_op.toString());
                //System.out.println("..........");
                
            }
          
                System.out.println("..........");
                System.out.println(sb_mat_op.toString());
                System.out.println("..........");
            
    }
        else if(re.test(sIn,"^%\\w+%$")){//in Used Vars//
            ///***System.out.println("Use Var:"+sIn);
            String str=sIn.substring(1,sIn.length()-1);
            System.out.println("***********");
            System.out.println(str);//get Vars
            System.out.println("***********");
            
            Var myVar=(Var)mapForVarClasses.get(str);
            System.out.println("))))))))))))))");
            System.out.println(sIn+"="+myVar.getValue());
            System.out.println(")))))))))))))))");
        }else{                              //<<<in Function:this is arguments in Function//
            System.out.println("function:"+sIn);
            StringTokenizer st_w=new StringTokenizer(sIn,"()",true);
            while(st_w.hasMoreTokens()){
String StringStmp=st_w.nextToken();
if(re.test(StringStmp,"^\\%\\w+\\%$")){
            ///***System.out.println("Use Var:"+StringStmp);
            String str=StringStmp.substring(1,StringStmp.length()-1);
            System.out.println("***********");
            System.out.println(str); //get Vars
            System.out.println("***********");
            
            Var myVar=(Var)mapForVarClasses.get(str);
            System.out.println("))))))))))))))");
            System.out.println(StringStmp+"="+myVar.getValue());
            System.out.println("))))))))))))))");
            
}

              


        }
}
        
}

    @Override
    public String toString() {
        return "ExpParser{" + "mapForVarClasses=" + mapForVarClasses + '}';
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
        ep.oper(str);////// esli eto \r\n t e 2 to 1arg=2+3 2arg=2+1/////////
    }
    //System.out.println(ep);

}
}