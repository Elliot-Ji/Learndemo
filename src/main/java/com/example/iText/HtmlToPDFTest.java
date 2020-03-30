package com.example.iText;


import java.io.*;
import java.nio.charset.Charset;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;



/**
 * 需求:用Java生成PDF文档
 *目前成熟、稳定的第三方包只有iText;而用iText生成PDF有三种方式：
 *调用iText API，用代码“写”出PDF，依赖包：com.itextpdf:itextpdf:5.5.11
 *结合XmlWorker，从HTML模板生成PDF，依赖包：com.itextpdf.tool:xmlworker:5.5.11
 *结合Flying Saucer，从HTML模板生成PDF，依赖包：org.xhtmlrenderer:flying-saucer-pdf-itext5:9.1.6
 *
 * 利用iText 结合XMLWorker 从HTML模板生成PDF
 * Created by Elliot Ji on 2019/3/27.
 */
public class HtmlToPDFTest {

    public static void main(String[] args) throws Exception {
        String htmlFile = "D:/demo/src/main/resources/templates/demo4.html";
        String pdfFile = "D:/htmlToPdf.pdf";
        InputStream htmlFileStream = new FileInputStream(htmlFile);

        //创建一个Document对象实例
        Document document = new Document();
        PdfWriter pdfWriter = PdfWriter.getInstance(document,new FileOutputStream(pdfFile));

        pdfWriter.setViewerPreferences(PdfWriter.HideToolbar);
        // 打开当前的document
        document.open();

        InputStreamReader isr = new InputStreamReader(htmlFileStream,"utf-8");
        XMLWorkerHelper.getInstance().parseXHtml(pdfWriter,document,isr);
        document.close();



    }


}
