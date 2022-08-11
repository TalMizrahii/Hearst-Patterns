import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * an abstract sorting class for the use of the two parts of the assignment.
 *
 * @author Tal Mizrahi.
 * @since 12/06/2022
 */
public abstract class Sorting {
    /**
     * the sorting method.
     *
     * @param map  the map we want to sort
     * @param line if existed, the line represent the key, in addition to the result string after the sort.
     * @return a sting of hypers and hypos sorted by value.
     */
    public String sort(TreeMap<String, Integer> map, String line) {
        //create a new comparator, and sort the map into a new map.
        ValueComparator valueComparator = new ValueComparator();
        TreeMap sortedMap = valueComparator.valueSort(map);
        //create a set and an iterator to run on.
        Set set = sortedMap.entrySet();
        Iterator i = set.iterator();

        //go over the set.
        while (i.hasNext()) {

            Map.Entry mp = (Map.Entry) i.next();
            //if the sort is used by part 1.
            if (line != null) {
                line = line.concat(mp.getKey() + "(");
                line = line.concat(mp.getValue() + ")");

                if (i.hasNext()) {
                    line = line.concat(", ");
                }
                // if the sort is used by part two.
            } else if (mp.getKey() != null) {
                System.out.println((mp.getKey() + ": (" + mp.getValue() + ")"));
            }
        }
        return line;
    }
}
