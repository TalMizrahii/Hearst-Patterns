import java.util.TreeMap;

/**
 * a class which compile and store the regexes of the assignment.
 *
 * @author Tal Mizrahi.
 * @since 12/06/2022
 */
public class ValueComparator {
    /**
     * the comparator we use to sort the map by values.
     *
     * @param treemap the treemap we sort.
     * @param <K>     the key's member.
     * @param <V>     the value's member.
     * @return a sorting comparator for treemap by value.
     */
    public <K, V extends Comparable<V>> TreeMap<K, V> valueSort(final TreeMap<K, V> treemap) {
        java.util.Comparator<K> valueComparator = new java.util.Comparator<K>() {
            public int compare(K first, K second) {
                int comp = treemap.get(first).compareTo(treemap.get(second));
                if (comp == 0) {
                    return 1;
                }
                return -comp;
            }
        };
        TreeMap<K, V> sorted = new TreeMap<>(valueComparator);
        sorted.putAll(treemap);
        return sorted;
    }
}
