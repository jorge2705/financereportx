package finance;

import java.util.Date;

public class Instruction
{

    private final int code;
    private final String entity;
    private final String operation;
    private final Double agreeFx;
    private final String  currency;
    private final Date  instructionDate;
    private final Date  settlementDate;
    private final int  units;
    private final Double  pricePerUnit;
  
    public Instruction(Integer code, String entity, String operation, Double agreeFx, String currency, Date instructionDate, Date settlementDate, int units, Double pricePerUnit)
    {
        this.code = code;
        this.entity = entity;
        this.operation = operation;
        this.agreeFx = agreeFx;
        this.currency = currency;
        this.instructionDate = instructionDate;
        this.settlementDate = settlementDate;
        this.units = units;
        this.pricePerUnit = pricePerUnit;
    }

    public int getCode() {
        return code;
    }

    public String getEntity() {
        return entity;
    }

    public String getOperation() {
        return operation;
    }

    public Double getAgreeFx() {
        return agreeFx;
    }

    public String getCurrency() {
        return currency;
    }

    public Date getInstructionDate() {
        return instructionDate;
    }

    public Date getSettlementDate() {
        return settlementDate;
    }

    public int getUnits() {
        return units;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

}
