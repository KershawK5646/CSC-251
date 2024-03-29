/*
 * Kyler Kershaw
 * This class holds data about a cube. 
 */
package hw_03_kershawkyler;
public class Cube extends Rectangle{
    private double height; // The cubes height.
    
    /**
     * The constructor sets the cube's length,
     * width, and height.
     * @param len The cube's length.
     * @param w The cube's width.
     * @param h The cube's height.
     */
    
    public Cube(double len, double w, double h){
        // Call the superclass constructor
        super(len, w);
        
        // Set the height
        height = h;
    }
    
    /** 
     * The getHeight method returns the cube's height.
     * @return The value in the height field.
     */
    public double getHeight(){
        return height;
    }
    
    /**
     * The getSurfaceArea method returns the cube's 
     * surface area.
     * @return The surface area of the cube.
     */
    public double getSurfaceArea(){
        return getArea()*6;
    }
    
    /**
     * The getVolume method returns the cube's
     * volume.
     * @return the volume of the cube.
     */
    public double getVolume(){
        return getArea()*height;
    }
    
}
