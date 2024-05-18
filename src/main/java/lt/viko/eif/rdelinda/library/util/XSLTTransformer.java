package lt.viko.eif.rdelinda.library.util;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
/**
 * Utility class for XSLT transformations.
 */
public class XSLTTransformer {
    public static void main(String[] args) {
        try {

            Source htmlXSL = new StreamSource(XSLTTransformer.class.getClassLoader().getResourceAsStream("xsl/library-html.xsl"));
            if (htmlXSL == null) {
                throw new NullPointerException("Failed to load HTML XSL document");
            }


            Source pdfXSL = new StreamSource(XSLTTransformer.class.getClassLoader().getResourceAsStream("xsl/library-pdf.xsl"));
            if (pdfXSL == null) {
                throw new NullPointerException("Failed to load PDF XSL document");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
