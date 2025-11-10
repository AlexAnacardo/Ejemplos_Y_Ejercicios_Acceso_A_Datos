package EjemploPDF.EjemploPDF;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.canvas.parser.PdfTextExtractor;

public class LeerPDF {

	public static void main(String[] args) {
		
		try {
			
			PdfReader reader = new PdfReader("prueba.pdf");
			
			PdfDocument documento = new PdfDocument(reader);
					
			for(int i=1; i<=documento.getNumberOfPages(); i++) {
				String text = PdfTextExtractor.getTextFromPage(documento.getPage(i));
				
				System.out.println(text);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
