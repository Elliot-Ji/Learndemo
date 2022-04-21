package com.example.iText;

import com.deepoove.poi.XWPFTemplate;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class DownLoadWord {
    public static void main(String[] args) throws IOException {
        XWPFTemplate template = XWPFTemplate.compile("D:\\workspace\\Learndemo\\src\\main\\resources\\template.docx").render(
                new HashMap<String, Object>(){{
                    put("title", "Hi,poi-tl Word模板引擎");
                }});
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("D:\\workspace\\Learndemo\\src\\main\\resources\\output.docx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        template.write(out);
        out.flush();
        out.close();
        template.close();
    }
}
