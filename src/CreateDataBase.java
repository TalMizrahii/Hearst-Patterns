import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * creating  a database using a treemap as a data structure, also reading from a file to create it.
 *
 * @author Tal Mizrahi.
 * @since 12/06/2022
 */
public class CreateDataBase {
    private TreeMap<String, TreeMap<String, Integer>> data; //the database.

    /**
     * a constructor for the class.
     *
     * @param data the data structure that we will use.
     */
    public CreateDataBase(TreeMap<String, TreeMap<String, Integer>> data) {
        setData(data);
    }

    /**
     * setter for the data member.
     *
     * @param data the data member.
     */
    public void setData(TreeMap<String, TreeMap<String, Integer>> data) {
        this.data = data;
    }

    /**
     * a getter for the data member.
     *
     * @return the database's value.
     */
    public TreeMap<String, TreeMap<String, Integer>> getData() {
        return this.data;
    }

    /**
     * building the database.
     *
     * @param matcher the matcher we use to find the wanted string.
     * @param general the general unsorted map.
     */
    public void buildDataBase(Matcher matcher, TreeMap<String, TreeMap<String, Integer>> general) {
        RegIncluding reg = new RegIncluding(); //getting the larger regex from the regex class.
        Pattern pattern = reg.getHypo(); //getting the smaller regex who catches the hyper/hypo in the larger regex.
        Matcher hypoMatch = pattern.matcher(matcher.group()); //creating the pattern for it.

        String hyperS = null;

        //dealing with the "which is" because the order of the hyper and hypo is different.
        if (matcher.group(19) != null && general.containsKey(matcher.group(24))) {
            hyperS = matcher.group(24); //the hyper
            String hypo = matcher.group(19); // the hypo
            if (!general.get(hyperS).containsKey(hypo.toLowerCase())) {
                general.get(hyperS).put(hypo.toLowerCase(), 1);
                //else, increase the counter (the value of the nested map) by one.
            } else {
                general.get(hyperS).put(hypo.toLowerCase(),
                        general.get(hyperS).get(hypo.toLowerCase()) + 1);
            }
            return;
        }

        hypoMatch.find(); //moving the "find" the fist NP.
        hyperS = hypoMatch.group(1).toLowerCase(); // setting the hyper.

        //if no such hyper exist, create new one.
        if (!general.containsKey(hyperS)) {
            general.put(hyperS, new TreeMap<>());
        }

        //finding all hypo's and putting them in the map.
        while (hypoMatch.find()) {
            // if it is a new hypo, create new key.
            if (!general.get(hyperS).containsKey(hypoMatch.group(1).toLowerCase())) {
                general.get(hyperS).put(hypoMatch.group(1).toLowerCase(), 1);
                //else, increase the counter (the value of the nested map) by one.
            } else {
                general.get(hyperS).put(hypoMatch.group(1).toLowerCase(),
                        general.get(hyperS).get(hypoMatch.group(1).toLowerCase()) + 1);
            }
        }

    }

    /**
     * the method reads all the files 'ine by line using BufferReader.
     *
     * @param createDataBase the database.
     * @param directCorpus   the path to the corpus.
     */
    public void read(CreateDataBase createDataBase, String directCorpus) {
        RegIncluding reg = new RegIncluding(); //get the regex.
        File direct = new File(directCorpus); //get to the files.
        File[] files = direct.listFiles(); // create a list of the files.
        //if no files exist, return.
        if (files == null) {
            return;
        }
        //go over each file.
        for (File file : files) {
            try {
                String s = null;
                //create a reader and a pattern.
                BufferedReader br = new BufferedReader(
                        new FileReader(file));
                Pattern pattern = reg.getPattern();
                //go over the file and search for the regex. if found, go to create database and process it.
                while ((s = br.readLine()) != null) {
                    //if no such templates, no need to check.
                    if (!(s.contains("which is")
                            || s.contains("such")
                            || s.contains("including")
                            || s.contains("especially"))) {
                        continue;
                    }
                    Matcher matcher = pattern.matcher(s);
                    //if found any, process.
                    if (matcher.find()) {
                        createDataBase.buildDataBase(matcher, createDataBase.getData());
                    }
                }
                br.close();

            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
