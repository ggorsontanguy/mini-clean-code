package zenika.smells.uneffjava.obsol;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class KeyValueStore {
    
    public void importFile(String path) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader(path));
//        try {
//            importFile(br);
//        } finally {
//            br.close();
//        }
    	
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            importFile(br);
        } 
    }

    private void importFile(BufferedReader br) throws IOException {
        String line = null;
        while((line=br.readLine()) != null) {
            importLine(line);
        }    
    }

    private void importLine(String line) {
        
    }

}
