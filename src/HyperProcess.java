import java.util.Map;
import java.util.TreeMap;

/**
 * processing the hyper's with a given lemma.
 *
 * @author Tal Mizrahi.
 * @since 12/06/2022
 */
public class HyperProcess {
    private CreateDataBase dataBase; // the database we use.
    private String lemma; //the lemma.

    /**
     * a constructor for the class.
     *
     * @param createDataBase the database.
     * @param lemma          the lemma.
     */
    public HyperProcess(CreateDataBase createDataBase, String lemma) {
        setDataBase(createDataBase);
        setLemma(lemma);
    }

    /**
     * a getter for the lemma.
     *
     * @return the lemma's string.
     */
    public String getLemma() {
        return this.lemma;
    }

    /**
     * a setter for the lemma.
     *
     * @param lemma the lemma's string.
     */
    public void setLemma(String lemma) {
        this.lemma = lemma;
    }

    /**
     * a getter for the database.
     *
     * @return the database's value.
     */
    public CreateDataBase getDataBase() {
        return this.dataBase;
    }

    /**
     * a setter for the database.
     *
     * @param dataBase the database's value.
     */
    public void setDataBase(CreateDataBase dataBase) {
        this.dataBase = dataBase;
    }

    /**
     * processing the result after constructing a database.
     *
     * @return the result of the database after process.
     */
    public TreeMap<String, Integer> process() {
        //the resulted database.
        TreeMap<String, Integer> result = new TreeMap<>();
        //going over the database.
        for (Map.Entry<String, TreeMap<String, Integer>> entry : getDataBase().getData().entrySet()) {
            if (getDataBase().getData().get(entry.getKey()).containsKey(getLemma())) {
                if (!result.containsKey(entry.getKey())) {
                    result.put(entry.getKey(), getDataBase().getData().get(entry.getKey()).get(lemma));
                }
            }
        }
        return result;
    }

}
