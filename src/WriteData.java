import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * writing data to a file using a database and a sorting abstract class.
 *
 * @author Tal Mizrahi.
 * @since 12/06/2022
 */
public class WriteData extends Sorting {
    private String path;
    private CreateDataBase createDataBase;

    /**
     * a constructor for the class..
     *
     * @param path     the name of the file to write on.
     * @param dataBase the database we use to get info.
     */
    public WriteData(String path, CreateDataBase dataBase) {
        setCreateDataBase(dataBase);
        setPath(path);
    }

    /**
     * a getter for the path.
     *
     * @return the path's string.
     */
    public String getPath() {
        return this.path;
    }

    /**
     * a setter for the path.
     *
     * @param path the path's string.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * a getter for the database.
     *
     * @return the database's value.
     */
    public CreateDataBase getCreateDataBase() {
        return this.createDataBase;
    }

    /**
     * a setter for the database.
     *
     * @param createDataBase the database's new value.
     */
    public void setCreateDataBase(CreateDataBase createDataBase) {
        this.createDataBase = createDataBase;
    }

    /**
     * writing the data to a file.
     */
    public void write() {
        try {
            //creating a new BufferReader.
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(getPath()));
            //going over the database and writing the results to the file.
            for (Map.Entry<String, TreeMap<String, Integer>> entry : getCreateDataBase().getData().entrySet()) {
                String line = null;
                // if there are less than 3 hypo's, don't write the hyper.
                if (!(getCreateDataBase().getData().get(entry.getKey()).size() < 3)) {
                    line = entry.getKey() + ": ";
                    line = sort(getCreateDataBase().getData().get(entry.getKey()), line);
                    line = line.concat("\n");
                    bufferedWriter.write(line);
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
