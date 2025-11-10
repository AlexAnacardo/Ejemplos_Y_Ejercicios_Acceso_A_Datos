package EjemploPDF.EjemploPDF;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;


public class EscribirPDF {

	public static void main(String[] args) {
		
		try {
			
			PdfWriter writer = new PdfWriter("quijote.pdf");
			
			PdfDocument documento = new PdfDocument(writer);
			
			Document doc = new Document(documento);
			
			String titulo = "DON QUIJOTE";
			
			Paragraph pTitulo = new Paragraph(titulo);
			
			pTitulo.setFontSize(25);
			pTitulo.setTextAlignment(TextAlignment.CENTER);
			pTitulo.setFont(PdfFontFactory.createFont(StandardFonts.TIMES_BOLD));
			
			
			
			String subtitulo = "Capítulo 1";
			
			Paragraph pSubtitulo = new Paragraph(subtitulo);
			
			pSubtitulo.setFontSize(20);
			pSubtitulo.setTextAlignment(TextAlignment.CENTER);
			
			
			
			
			doc.add(pTitulo);
			doc.add(pSubtitulo);
			doc.add(new Paragraph("En un lugar de la mancha, de cuyo nombre no quiero acordarme"));
			doc.add(new Image(ImageDataFactory.create("quijote.jpg")));
			
			
			
			documento.addNewPage();
			
			//AÑADIR UNA TABLA 
			
			Table tabla = new Table(4);
			
			tabla.addHeaderCell("ID");
			tabla.addHeaderCell("Descr");
			tabla.addHeaderCell("Horas");
			tabla.addHeaderCell("Profesor");
			
			tabla.addCell("1");
			tabla.addCell("ACDA");
			tabla.addCell("5");
			tabla.addCell("Maria");	
			
			tabla.addCell("2");
			tabla.addCell("PSYP");
			tabla.addCell("2");
			tabla.addCell("Carlos");
			
			doc.add(tabla);
			
			doc.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
