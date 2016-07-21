import java.io.*;
 
....
 
StreamTokenizer tok=new StreamTokenizer(new StringReader("set int MyVar=7;"));
//по умолчанию понимает слова, спецсимволы, пробелы, числа, еолы по правилам java
//правила можно поменять, но нас устраивает что есть
 
for(;;){
  switch(tok.nextToken()){
    case StreamTokenizer.TT_WORD: print("word: "+tok.sval); break;
    case StreamTokenizer.TT_NUMBER: print("number: "+tok.nval); break;
    case '=': print("<equals>"); break;
    case ';': print("<end of expression>"); break;
    case StreamTokenizer.TT_EOF: print("alles"); break;
  }
}