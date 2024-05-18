package lt.viko.eif.rdelinda.library;

import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.xml.sax.SAXException;

import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
/**
 * Main application class for the library system.
 */
public class LibraryApp {
    public static void main(String[] args) {
        try {

            InputStream xmlInputStream = LibraryApp.class.getClassLoader().getResourceAsStream("library.xml");
            if (xmlInputStream == null) {
                throw new FileNotFoundException("XML file not found");
            }


            Source htmlXSL = new StreamSource(LibraryApp.class.getClassLoader().getResourceAsStream("xsl/library-html.xsl"));
            if (htmlXSL == null) {
                throw new NullPointerException("HTML XSL document not found");
            }


            transformXML(xmlInputStream, htmlXSL, "output.html");


            xmlInputStream = LibraryApp.class.getClassLoader().getResourceAsStream("library.xml");


            Source pdfXSL = new StreamSource(LibraryApp.class.getClassLoader().getResourceAsStream("xsl/library-pdf.xsl"));
            if (pdfXSL == null) {
                throw new NullPointerException("PDF XSL document not found");
            }


            transformXMLToPDF(xmlInputStream, pdfXSL, "output.pdf");
        } catch (IOException | TransformerException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void transformXML(InputStream xml, Source xsl, String outputFilename) throws TransformerException, IOException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(xsl);

        Source xmlSource = new StreamSource(xml);
        Result result = new StreamResult(new File(outputFilename));
        transformer.transform(xmlSource, result);

        System.out.println("Output saved to " + outputFilename);
    }

    private static void transformXMLToPDF(InputStream xml, Source xsl, String outputFilename) throws IOException, TransformerException, SAXException {
        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());

        OutputStream out = new BufferedOutputStream(new FileOutputStream(new File(outputFilename)));

        try {
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, out);

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(xsl);

            Source xmlSource = new StreamSource(xml);
            Result res = new SAXResult(fop.getDefaultHandler());

            transformer.transform(xmlSource, res);
        } finally {
            out.close();
        }

        System.out.println("PDF Output saved to " + outputFilename);
    }
}
