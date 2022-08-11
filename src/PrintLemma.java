import java.util.TreeMap;

/**
 * a class who prints the result to the console.
 *
 * @author Tal Mizrahi.
 * @since 12/06/2022
 */
public class PrintLemma extends Sorting {
    private TreeMap<String, Integer> map; //the map (sorted).

    /**
     * a constructor for the class.
     *
     * @param map the sorted map.
     */
    public PrintLemma(TreeMap<String, Integer> map) {
        setMap(map);
    }

    /**
     * a getter for the map.
     *
     * @return the map.
     */
    public TreeMap<String, Integer> getMap() {
        return this.map;
    }

    /**
     * a setter for the map.
     *
     * @param map the map.
     */
    public void setMap(TreeMap<String, Integer> map) {
        this.map = map;
    }

    /**
     * printing all the result.
     */
    public void printAll() {
        sort(getMap(), null);
    }
}
