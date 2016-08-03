package example;

import java.io.File;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class TesseractExample {
    
    public static void main(String[] args) {
        
        String file = "src/file/file_example.pdf";
        File imageFile = new File(file);
        Tesseract instance = Tesseract.getInstance(); // JNA Interface Mapping
        // Tesseract1 instance = new Tesseract1(); // JNA Direct Mapping
        // instance.setDatapath("<parentPath>"); // replace <parentPath> with path to parent directory of tessdata
        // instance.setLanguage("eng");
        
        try {
            System.out.println("Processing...\n");
            String result = instance.doOCR(imageFile);
            System.out.println("\nRisultato della conversione del file "+file+" :\n\n"+result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}