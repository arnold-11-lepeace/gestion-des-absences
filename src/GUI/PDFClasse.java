package GUI;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
public class PDFClasse {
  public static void main(String args[]){
    try 
    {
        //Créer une instance PdfReader.
        PdfReader pdf = new PdfReader("C:\\Users\\ONANA Arnold\\eclipse-workspace\\Gestion absences\\justificatif d'absences\\états deuxième trimestre.pdf");  
   
        //Récupérer le nombre de pages en pdf.
        int nbrPages = pdf.getNumberOfPages(); 
   
        //Itérer le pdf à travers les pages.
        for(int i=1; i <= nbrPages; i++) 
        { 
            //Extraire le contenu de la page à l'aide de PdfTextExtractor.
            String content = PdfTextExtractor.getTextFromPage(pdf, i);
           System.out.println(content); 
   
            //Afficher le contenu de la page sur la console.
            System.out.println("Contenu du page : " + content);
        }
   
        //Fermez le PdfReader.
        pdf.close();
    
    } catch (Exception ex) {
        ex.printStackTrace();
    }
  }
}

