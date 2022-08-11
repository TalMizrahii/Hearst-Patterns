import java.util.TreeMap;

/**
 * a class who runs the search after the hypos in each hyper's database.
 *
 * @author Tal Mizrahi.
 * @since 12/06/2022
 */
public class DiscoverHypernym {
    /**
     * the main method. runs the related methods by order.
     *
     * @param args receives two arguments, a file directory and a lemma.
     */
    public static void main(String[] args) {

        //get the arguments.
        String directCorpus = args[0]; //the file directory.
        String lemma = args[1]; // the lemma.
        // create a database.
        CreateDataBase createDataBase = new CreateDataBase(new TreeMap<>());
        createDataBase.read(createDataBase, directCorpus);
        //process it.
        HyperProcess hyperProcess = new HyperProcess(createDataBase, lemma);
        TreeMap<String, Integer> map = hyperProcess.process();
        //if no results, print a massage.
        if (map.isEmpty()) {
            System.out.println("The lemma doesn't appear in the corpus.");
            return;
        }
        //print all the results.
        PrintLemma printLemma = new PrintLemma(map);
        printLemma.printAll();
    }
}
