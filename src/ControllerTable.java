import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

class MyFrame extends JFrame{
JTable jtable;
    public MyFrame(Object[][] arr,String[] s) {
        setTitle("Вывод база");
        setLayout(new FlowLayout());
        
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(700,500));
        setVisible(true);
        
//String s[]={"id","tovar","cena","date"};	
jtable=new JTable(arr,s);
JScrollPane jscrlp=new JScrollPane(jtable);
add(jscrlp);
        jtable.setPreferredScrollableViewportSize(new Dimension(500,500));
    
    }  
} 
      
        
        
        
        
    


    class Rider {
 Connection conn;   
Object arr[][]=null;
ResultSet rs1,rs2;
//Gui element;
String table_name="";
String[] s;
String[] typesOfColumn;
String query="";

    public Rider(Connection conn,String table_name,String query,String[]s, String ... typesOfColumn) {
        this.conn = conn;
        this.table_name=table_name;
        this.s=s;
        this.typesOfColumn = typesOfColumn;
        this.query=query;
    }


    public void ControllerTable() {
        int n=0;
        //Date date=new Date(0,0,0);
        
try{
      Statement  st1=conn.createStatement();
      Statement  st2=conn.createStatement();
      //String queryFirst=query;
      String querySecond="select count(*) from "+this.table_name;
       rs1=st1.executeQuery(query);
       rs2=st2.executeQuery(querySecond);
      
      
    }catch(SQLException e){
          System.err.println("Error statement ["+e+"]");  
    }
      
        try{
        rs2.next();
         n=rs2.getInt(1);
        rs2.close();
        arr=new Object[n][s.length];
        int i=0;
        while(rs1.next()){
        int j=0;
       
        while(j<typesOfColumn.length){
            
            if(typesOfColumn[j].equals("int")){
                int column1=rs1.getInt(j+1);
                arr[i][j]=column1;
            }
            else if(typesOfColumn[j].equals("String")){
                String column2=rs1.getString(j+1);
                arr[i][j]=column2;
            }
            else if(typesOfColumn[j].equals("double")){
                double column3=rs1.getDouble(j+1);
                arr[i][j]=column3;
            }
            else if(typesOfColumn[j].equals("float")){
                double column4=rs1.getFloat(j+1);
                arr[i][j]=column4;
            }
            else if(typesOfColumn[j].equals("Date")){
                Date column5=rs1.getDate(j+1);
                arr[i][j]=column5;
            }
            
            j++;
        }
        
         
         /*if(o instanceof Date){
              date=(Date)o;
         }*/
              
         i++;  }
        }catch(SQLException e){
            System.out.println("Oshibka resset["+e+"]");
        }
     new MyFrame(arr,s);
     try{
     rs1.close();
     rs2.close();
     
     }catch(SQLException e){
         System.out.println("Oshibka zakritiya resursov ["+e+"]");
     }

    }
}
    
      
        

  
    


