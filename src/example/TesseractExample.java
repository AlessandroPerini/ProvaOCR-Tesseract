package example;

import java.io.File;
import tess4j.Tesseract;
import tess4j.TesseractException;
import utils.Supporto;

public class TesseractExample {
    
    public static void main(String[] args) {
        
        Supporto prova = new Supporto("Prova");
        prova.timerStart();
        int i;
        String estensione[] = {"","png","jpg","tif","tif","tif","tif","png",
                                  "jpg","jpg","png","jpg","jpg","jpg","tif",
                                  "tif","png","gif","gif","png","png"};
        
        for (i = 1; i < 21; i++) {
   
            String file = "C:\\Users\\aless\\Desktop\\scanned_doc\\dir"+i+"\\img"+i+"."+estensione[i];
            File imageFile = new File(file);
            Tesseract instance = Tesseract.getInstance();
            instance.setLanguage("eng");
            
            /* Tesseract1 instance = new Tesseract1();
            instance.setDatapath("<parentPath>");
            instance.setLanguage("eng"); */
            
            try {
                //System.out.println("Processing...\n\n");
                
                Supporto supporto = new Supporto("Tesseract");
                
                supporto.timerStart();
                String result = instance.doOCR(imageFile);
                supporto.timerStop();
                
                System.out.println("\n - "+file);
                supporto.fileOut(file, result);
                
            } catch (TesseractException e) {
                System.err.println(e.getMessage());
            }
            
        }
        
        System.out.println("\nTempo totale: "+prova.timerStop());
    }
}