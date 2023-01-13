import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import java.io.File;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
public class WavOrganizer {

    public static void main(String[] args) {
        File downloadsFolder = new File("C:\\Users\\username\\Downloads");
        File[] files = downloadsFolder.listFiles((dir, name) -> name.endsWith(".wav"));

        for (File file : files) {
            try {
                AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(file);
                String kind = extractKind(fileFormat);
                // Create kind folder if it does not exist
                File kindFolder = new File(downloadsFolder, kind);
                if (!kindFolder.exists()) {
                    kindFolder.mkdir();
                }
                // Extract the key of the sample
                String key = extractKey(file);
                // Create key folder if it does not exist
                File keyFolder = new File(kindFolder, key);
                if (!keyFolder.exists()) {
                    keyFolder.mkdir();
                }
                file.renameTo(new File(keyFolder, file.getName()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    //function to extract the kind of the wav file
    public static String extractKind(AudioFileFormat fileFormat) {
        // code to extract kind of the wav file
        
        try {
            File file = new File("path/to/file.wav");
            AudioFile audioFile = AudioFileIO.read(file);
            String kind = audioFile.getTag().getFirst(FieldKey.GENRE);
            System.out.println("Kind: " + kind);
        } catch (Exception e) {
            e.printStackTrace();
        }    }
    //function to extract the key of the wav file
    public static String extractKey(File file) {
    
       // code to extract the key of the wav file
       
        try {
            String filePath = "path/to/file.wav";
            String command = "sonic-annotator -t tunefinder " + filePath;
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String key = in.readLine();
            System.out.println("Key: " + key);
        } catch (Exception e) {
            e.printStackTrace();
        }
      }
    }
  }
