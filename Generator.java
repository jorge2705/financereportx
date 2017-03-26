package finance;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Generator 
{
    private Report currentReport;
    private ArrayList<Report> reportList;
    public Generator(boolean matrix) throws ParseException 
    {
        createReport();
        generator();
    }
    
    public static void main(String[] args) throws ParseException {
        new Generator(false);
    }

    private void createReport() throws ParseException
    {
        reportList = new ArrayList<Report>();
        
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        
        Report report01;
        Instruction i01, i02, i03, i04, i05;
        
        i01 = new Instruction(1,"foo","B",0.50,"SGP",df.parse("01-01-2017"),df.parse("05-01-2017"),20,100.23);
        i02 = new Instruction(2,"bar","S",0.80,"AED",df.parse("02-01-2017"),df.parse("05-01-2017"),30,180.57);
        i03 = new Instruction(3,"bar","S",0.60,"SGP",df.parse("04-01-2017"),df.parse("10-01-2017"),50,120.77);
        i04 = new Instruction(4,"foo","B",1.20,"SGP",df.parse("02-01-2017"),df.parse("05-01-2017"),30,170.45);        
        i05 = new Instruction(5,"exon","S",0.60,"SGP",df.parse("06-01-2017"),df.parse("10-01-2017"),10,120.72);
        
        report01 = new Report("report01");
        report01.addItem("i01",i01);
        report01.addItem("i02",i02);
        report01.addItem("i03",i03);
        report01.addItem("i04",i04);
        report01.addItem("i05",i05);
        
        currentReport = report01;  
    }


    private void generator()
    {
        System.out.println();
        System.out.println(currentReport.getInstructionList());
        System.out.printf("%-18s","Total Income : ");
        System.out.printf("%.2f \n",currentReport.getTotalIncome());
        System.out.printf("%-18s","Total Outcome : ");
        System.out.printf("%.2f \n",currentReport.getTotalOutcome());

    }
    
}
