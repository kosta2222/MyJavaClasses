import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
class BarChart_AWT extends JFrame{

public BarChart_AWT(String applicationTitle,String chartTitle,CategoryDataset dataset){
super(applicationTitle);

JFreeChart barChart=ChartFactory.createBarChart(
 chartTitle,
 "Date",
 "Price",
  dataset,
  PlotOrientation.VERTICAL,
  true,true,false);
 
ChartPanel chartPanel=new ChartPanel(barChart);
chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );
setContentPane(chartPanel);
}
