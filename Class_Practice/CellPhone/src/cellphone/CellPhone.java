/*
 * The CellPhone class holds data about a cell phone. 
 */
package cellphone;
public class CellPhone {
    
    // Fields
    private String manufact;        // Manufacturer
    private String model;           // Model
    private double retailPrice;     // Retail Price
    
    /** 
     *  Constructor
     * @param man the Phone's manufacturer.
     * @param mod The phone's model number.
     * @param double The phone's retail price.
     */
    
    public CellPhone(String man, String mod, double price){
        
        manufact = man;
        model = mod;
        retailPrice = price;
    }
    
    /**
     * The set Manufact method sets the phone's 
     * manufacturer name.
     * @param man The phone's manufacturer.
     */
    
    public void setManufact(String man){
        manufact = man;
    }
    
    /**
     * The setModel method sets the phone's 
     * manufacturer name.
     * @param mod The phone's manufacturer.
     */
    
    public void setMod(String mod){
        model = mod;
    }
    
    /**
     * The setRetailPrice method sets the phone's 
     * manufacturer name.
     * @param price The phone's manufacturer.
     */
    
    public void setRetailPrice(double price){
        retailPrice = price;
    }
    
    /**
     * getManufact method
     * @return the name of the phone's manufacturer.
     */
    
    public String getManufact(){
        return manufact;
    }
    
    /**
     * getModel method
     * @return the phone's model number
     */
    public String getModel(){
        return model;
    }
    
    /**
     * getRetailPrice method
     * @return the phone's retail price
     */
    
    public double getRetailPrice(){
        return retailPrice;
    }
}
