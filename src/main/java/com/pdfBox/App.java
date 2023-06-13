package com.pdfBox;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 * Hello world!
 *
 */
public class App {
	public static void main( String[] args ) throws IOException{
		/*String filename = "D:/VJD/FOOMatic/TemplateTest/sample.pdf";
		String message = "This is a sample PDF document created using PDFBox.";*/

		File file = new File("D:/VJD/FOOMatic/TemplateTest/FOO_869_CCN002_test1.pdf");
		PDDocument doc = PDDocument.load(file);
		try {
			//List<PDPage> pageList = doc.getPages();
			PDPage page = doc.getPage(0);  
			PDPageContentStream contentStream = new PDPageContentStream(doc, page, 
					PDPageContentStream.AppendMode.APPEND, true);  

			contentStream.beginText(); 

			//Setting the font to the Content stream    
			contentStream.setFont(PDType1Font.HELVETICA, 10);  

			//Setting the position for the line   
			contentStream.newLineAtOffset(270, 280);  

			String text = "25-Jan-2021";  

			//Adding text in the form of string   
			contentStream.showText(text);        

			//Ending the content stream  
			contentStream.endText();
			
			contentStream.close();
			/* PDPage page = new PDPage();
            doc.addPage(page);

            PDFont font = PDType1Font.HELVETICA_BOLD;

            PDPageContentStream contents = new PDPageContentStream(doc, page);
            contents.beginText();
            contents.setFont(font, 30);
            contents.newLineAtOffset(50, 700);
            contents.showText(message);
            contents.endText();
            contents.close();*/

			doc.save(new File("D:/VJD/FOOMatic/TemplateTest/FOO_869_CCN002_test3.pdf"));
		}
		finally {
			doc.close();
		}
	}
}
