package zenika.smells.uneffjava.obsol;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class KeyValueStore {
    
    public void importFile(String path) throws IOException {
        Files.lines(Paths.get(path)).forEach(KeyValueStore::importLine);
    }

    private static void importLine(String line) {
        
    }

}
