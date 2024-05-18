<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns:fo="http://www.w3.org/1999/XSL/Format">
  <xsl:template match="/">
    <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
      <fo:layout-master-set>
        <fo:simple-page-master master-name="page">
          <fo:region-body margin="1in"/>
        </fo:simple-page-master>
      </fo:layout-master-set>
      <fo:page-sequence master-reference="page">
        <fo:flow flow-name="xsl-region-body">
          <fo:block font-size="20pt" font-weight="bold" text-align="center">Library Catalog</fo:block>
          <fo:table border="1pt solid black">
            <fo:table-column column-width="auto"/>
            <fo:table-column column-width="auto"/>
            <fo:table-column column-width="auto"/>
            <fo:table-header>
              <fo:table-row>
                <fo:table-cell padding="5pt">
                  <fo:block font-weight="bold">Title</fo:block>
                </fo:table-cell>
                <fo:table-cell padding="5pt">
                  <fo:block font-weight="bold">Author</fo:block>
                </fo:table-cell>
                <fo:table-cell padding="5pt">
                  <fo:block font-weight="bold">ISBN</fo:block>
                </fo:table-cell>
              </fo:table-row>
            </fo:table-header>
            <fo:table-body>
              <!-- Loop through each book -->
              <xsl:for-each select="library/books/book">
                <fo:table-row>
                  <fo:table-cell padding="5pt"><fo:block><xsl:value-of select="title"/></fo:block></fo:table-cell>
                  <fo:table-cell padding="5pt"><fo:block><xsl:value-of select="author"/></fo:block></fo:table-cell>
                  <fo:table-cell padding="5pt"><fo:block><xsl:value-of select="isbn"/></fo:block></fo:table-cell>
                </fo:table-row>
              </xsl:for-each>
            </fo:table-body>
          </fo:table>
        </fo:flow>
      </fo:page-sequence>
    </fo:root>
  </xsl:template>
</xsl:stylesheet>
