package finance;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Report 
{
    private final String description;
    private final Map <String, Instruction> inventory;
    
    public Report(String description) 
    {
        this.description = description;
        inventory = new TreeMap<>();
        
    }
    
    public void addItem(String description, Instruction item) 
    {
        inventory.put(description, item);
    }
     
    public String getInstructionList() 
    {
        String returnString = "Inventory:";
        
        DateFormat df = new SimpleDateFormat("dd MMM yyyy");

        System.out.printf("%-12s%-12s%-12s%-12s%-20s%-20s%-12s%s\n","Entity","Buy/Sell","AgreedFx","Currency","InstructionDate", "SettlementDate", "Units", "Price per unit");
        System.out.printf("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        for (Entry<String, Instruction> instruction : inventory.entrySet()){
                String clave = instruction.getKey();
                Instruction valor = instruction.getValue();
                System.out.printf("%-12s%-12s%-12s%-12s%-20s%-20s%-12s%s\n",valor.getEntity(),valor.getOperation(),valor.getAgreeFx(), valor.getCurrency(), df.format(valor.getInstructionDate()),df.format(valor.getSettlementDate()),valor.getUnits(),valor.getPricePerUnit());
                
        }

        return "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++";
    }    

    public Double getTotalIncome() 
    {
        //String returnString = "Inventory:";
        Double total = 0.0;
        
        for (Entry<String, Instruction> instruction : inventory.entrySet()){
                String clave = instruction.getKey();
                Instruction valor = instruction.getValue();
                if (valor.getOperation() == "B") total = total + (valor.getUnits()*valor.getPricePerUnit()*valor.getAgreeFx()) ;
        }

        return total;
    }    
    
    public Double getTotalOutcome() 
    {
        //String returnString = "Inventory:";
        Double total = 0.0;
        
        for (Entry<String, Instruction> instruction : inventory.entrySet()){
                String clave = instruction.getKey();
                Instruction valor = instruction.getValue();
                if (valor.getOperation() == "S") total = total + (valor.getUnits()*valor.getPricePerUnit()*valor.getAgreeFx()) ;
        }

        return total;
    }    

}
