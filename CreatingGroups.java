import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FileGrouping {

    public static void main(String[] args) {
        File folder = new File("path/to/folder");
        File[] listOfFiles = folder.listFiles();

        Map<String, Integer> map = new HashMap<>();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                String name = file.getName();
                String group = name.substring(0, 2);

                if (map.containsKey(group)) {
                    int count = map.get(group);
                    map.put(group, count + 1);
                } else {
                    map.put(group, 1);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Group: " + entry.getKey() + " - Count: " + entry.getValue());
        }
    }
}
