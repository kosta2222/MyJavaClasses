/*
Thread Ч поток в смысле "исполн€емый поток"
Stream Ч поток байтов
—читывать можно разными способами:
InputStream Ч интерфейс дл€ считывани€ данные побайтно
Reader Ч интрефейс дл€ считывани€ данных посимвольно. ћожно использовать как обЄртку вокруг InputStream, задав кодировку
BufferedReader Ч Reader, который умеет считываеть ещЄ и построчно. »з джавадока к readLine()
* Reads a line of text. A line is considered to be terminated by any one
* of a line feed ('\n'), a carriage return ('\r'), or a carriage return
* followed immediately by a linefeed.
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

class FileRider{
    FileInputStream stream;
    InputStreamReader reader;
    BufferedReader buffered_reader;

    public FileRider(File fileToRead,String fileCharset) {
        
	try{
         stream = new FileInputStream (fileToRead);
         reader = new InputStreamReader ( stream,fileCharset );
         buffered_reader = new BufferedReader ( reader );
         

	}catch(FileNotFoundException ex){
System.err.println("Ne mogu naiti fail["+ex+"]");}
catch(UnsupportedEncodingException ex){
System.err.println("Oshika Encoding faila["+ex+"]");

	}
    }

    public BufferedReader getBuffered_reader() {
        return buffered_reader;
    }
    
}