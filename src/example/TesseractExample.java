package example;

import java.io.File;
import tess4j.Tesseract;
import tess4j.TesseractException;

public class TesseractExample {
    
    public static void main(String[] args) {
        
        String file = "src/file/image1.jpg";
        File imageFile = new File(file);
        Tesseract instance = Tesseract.getInstance(); 
        
        /* Tesseract1 instance = new Tesseract1();
           instance.setDatapath("<parentPath>");
           instance.setLanguage("eng"); */
        
        try {
            System.out.println("Processing...\n");
            long inizio = System.currentTimeMillis();
            String result = instance.doOCR(imageFile);
            System.out.println("\nRisultato della conversione del file "+file+" :\n\n"+result);
            long fine = System.currentTimeMillis(); 
            long tempo = (long) ((fine - inizio) * 0.001);
            System.out.println("Tempo impegato: " + tempo + " secondi\n\n");
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}