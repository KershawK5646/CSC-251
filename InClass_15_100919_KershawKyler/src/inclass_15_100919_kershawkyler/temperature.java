package inclass_15_100919_kershawkyler;

public class temperature {
    // Fields
    private double fahrenheit;
    
    /**
     * 
     * @param ftemp 
     */
    public temperature(double ftemp){
        fahrenheit = ftemp;
    }
    
    public void setFahrenheit(double ftemp){
        fahrenheit = ftemp;
    }
    
    public double getFahrenheit(){
        return fahrenheit;
    }
    
    public double getCelsius(double fahrenheit){
        // Celsius convert
        double celsius = 0.0;
        celsius = (5.0/9.0)*(fahrenheit-32);
        return celsius;
    }
    
    public double getKelvin(double fahrenheit){
        // Kelvin convert
        double kelvin = 0.0;
        kelvin = ((5.0/9.0)*(fahrenheit-32))+273;
        return kelvin;
    }
    
}
