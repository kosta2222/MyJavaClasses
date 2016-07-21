class Exec{
String c1="";
String c2="";
String c3="";
String c4="";
String cmd[]={};
public Exec(String batFolder,String batFile){
 c1="cmd.exe";
 c2="/C";
 c3="cd "+batFolder;
 c4="&& start "+batFile;


   }
public int myExec(){
int exitCode=1;
String cmd[]={c1,c2,c3,c4};
Runtime r=Runtime.getRuntime();
Process p=null;
try{
p=r.exec(cmd);
exitCode=p.waitFor();
}
catch (Exception e) {
System.out.println("Oshibka zapuska progi["+e+"]");
   }
return exitCode;
}

}

