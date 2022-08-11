import java.util.TreeMap;

/**
 * a class who runs the search after the hypos and hypers to create a database.
 *
 * @author Tal Mizrahi.
 * @since 12/06/2022
 */
public class CreateHypernymDatabase {
    /**
     * the main method. runs the related methods by order.
     *
     * @param args receives two arguments, a file directory of the cropus and to the result file.
     */
    public static void main(String[] args) {
        //get the arguments.
        String directCorpus = args[0];
        String directOutput = args[1];
        //create new database.
        CreateDataBase createDataBase = new CreateDataBase(new TreeMap<>());
        createDataBase.read(createDataBase, directCorpus);
        //write it to a file.
        WriteData writeData = new WriteData(directOutput, createDataBase);
        writeData.write();
    }
}