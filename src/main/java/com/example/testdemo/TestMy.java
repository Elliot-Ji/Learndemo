package com.example.testdemo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.nio.charset.StandardCharsets;


/**
 * @author: Elliot Ji
 * @createDate: 2022-07-28
 **/
public class TestMy {
    public static void main(String[] args) {
       String text = "<p>一种增压器轴端螺母的防脱落结构，包括增压器转轴和设于增压器转轴上的叶轮，所述增压器转轴的端" +
               "部从叶轮中伸出，该伸出部上设有螺纹配合的轴端螺母，所述增压器转轴从轴端螺母中伸出，该伸出部上设有防止轴端螺" +
               "母脱离的销轴。本实用新型具有以下有益效果：本实用新型中通过设于增压器转轴端部上的销轴，有效的避免了增压器叶轮突" +
               "然卡死时轴端螺母的脱落，防止叶轮受<img src=\"http://api.szpt.baiten.cn/opc/oss/user/getFile/155427626597" +
               "3182465/user/szpt/100100101/All/2022/8/2/jpg/6e203aeea99e4a718dd8c9efe2e81832.jpg\" />损，避免了大量的经济损失。</p>" +
               "<p>一种增压器轴端螺母的防脱落结构，包括增压器转轴和设于增压器转轴上的叶轮，所述增压器转轴的端\" +\n" +
               "               \"部从叶轮中伸出，该伸出部上设有螺纹配合的轴端螺母，所述增压器转轴从轴端螺母中伸出，该伸出部上设有防止轴端螺\" +\n" +
               "               \"母脱离的销轴。本实用新型具有以下有益效果：本实用新型中通过设于增压器转轴端部上的销轴，有效的避免了增压器叶轮突\" +\n" +
               "               \"然卡死时轴端螺母的脱落，防止叶轮受<img src=\\\"http://api.szpt.baiten.cn/opc/oss/user/getFile/155427626597\" +\n" +
               "               \"3182465/user/szpt/100100101/All/2022/8/2/jpg/6e203aeea99e4a718dd8c9efe2e81832.jpg\\\" />损，避免了大量的经济损失。</p>" +
               "<p>一种增压器轴端螺母的防脱落结构，包括增压器转轴和设于增压器转轴上的叶轮，所述增压器转轴的端\" +\n" +
               "               \"部从叶轮中伸出，该伸出部上设有螺纹配合的轴端螺母，所述增压器转轴从轴端螺母中伸出，该伸出部上设有防止轴端螺\" +\n" +
               "               \"母脱离的销轴。本实用新型具有以下有益效果：本实用新型中通过设于增压器转轴端部上的销轴，有效的避免了增压器叶轮突\" +\n" +
               "               \"然卡死时轴端螺母的脱落，防止叶轮受<img src=\\\"http://api.szpt.baiten.cn/opc/oss/user/getFile/155427626597\" +\n" +
               "               \"3182465/user/szpt/100100101/All/2022/8/2/jpg/6e203aeea99e4a718dd8c9efe2e81832.jpg\\\" />损，避免了大量的经济损失。</p>" +
               "<p>一种增压器轴端螺母的防脱落结构，包括增压器转轴和设于增压器转轴上的叶轮，所述增压器转轴的端\" +\n" +
               "               \"部从叶轮中伸出，该伸出部上设有螺纹配合的轴端螺母，所述增压器转轴从轴端螺母中伸出，该伸出部上设有防止轴端螺\" +\n" +
               "               \"母脱离的销轴。本实用新型具有以下有益效果：本实用新型中通过设于增压器转轴端部上的销轴，有效的避免了增压器叶轮突\" +\n" +
               "               \"然卡死时轴端螺母的脱落，防止叶轮受<img src=\\\"http://api.szpt.baiten.cn/opc/oss/user/getFile/155427626597\" +\n" +
               "               \"3182465/user/szpt/100100101/All/2022/8/2/jpg/6e203aeea99e4a718dd8c9efe2e81832.jpg\\\" />损，避免了大量的经济损失。</p>" +
               "<p>一种增压器轴端螺母的防脱落结构，包括增压器转轴和设于增压器转轴上的叶轮，所述增压器转轴的端\" +\n" +
               "               \"部从叶轮中伸出，该伸出部上设有螺纹配合的轴端螺母，所述增压器转轴从轴端螺母中伸出，该伸出部上设有防止轴端螺\" +\n" +
               "               \"母脱离的销轴。本实用新型具有以下有益效果：本实用新型中通过设于增压器转轴端部上的销轴，有效的避免了增压器叶轮突\" +\n" +
               "               \"然卡死时轴端螺母的脱落，防止叶轮受<img src=\\\"http://api.szpt.baiten.cn/opc/oss/user/getFile/155427626597\" +\n" +
               "               \"3182465/user/szpt/100100101/All/2022/8/2/jpg/6e203aeea99e4a718dd8c9efe2e81832.jpg\\\" />损，避免了大量的经济损失。</p>" +
               "<p>一种增压器轴端螺母的防脱落结构，包括增压器转轴和设于增压器转轴上的叶轮，所述增压器转轴的端\" +\n" +
               "               \"部从叶轮中伸出，该伸出部上设有螺纹配合的轴端螺母，所述增压器转轴从轴端螺母中伸出，该伸出部上设有防止轴端螺\" +\n" +
               "               \"母脱离的销轴。本实用新型具有以下有益效果：本实用新型中通过设于增压器转轴端部上的销轴，有效的避免了增压器叶轮突\" +\n" +
               "               \"然卡死时轴端螺母的脱落，防止叶轮受<img src=\\\"http://api.szpt.baiten.cn/opc/oss/user/getFile/155427626597\" +\n" +
               "               \"3182465/user/szpt/100100101/All/2022/8/2/jpg/6e203aeea99e4a718dd8c9efe2e81832.jpg\\\" />损，避免了大量的经济损失。</p>" +
               "<p>一种增压器轴端螺母的防脱落结构，包括增压器转轴和设于增压器转轴上的叶轮，所述增压器转轴的端\" +\n" +
               "               \"部从叶轮中伸出，该伸出部上设有螺纹配合的轴端螺母，所述增压器转轴从轴端螺母中伸出，该伸出部上设有防止轴端螺\" +\n" +
               "               \"母脱离的销轴。本实用新型具有以下有益效果：本实用新型中通过设于增压器转轴端部上的销轴，有效的避免了增压器叶轮突\" +\n" +
               "               \"然卡死时轴端螺母的脱落，防止叶轮受<img src=\\\"http://api.szpt.baiten.cn/opc/oss/user/getFile/155427626597\" +\n" +
               "               \"3182465/user/szpt/100100101/All/2022/8/2/jpg/6e203aeea99e4a718dd8c9efe2e81832.jpg\\\" />损，避免了大量的经济损失。</p>" +
               "<p>一种增压器轴端螺母的防脱落结构，包括增压器转轴和设于增压器转轴上的叶轮，所述增压器转轴的端\" +\n" +
               "               \"部从叶轮中伸出，该伸出部上设有螺纹配合的轴端螺母，所述增压器转轴从轴端螺母中伸出，该伸出部上设有防止轴端螺\" +\n" +
               "               \"母脱离的销轴。本实用新型具有以下有益效果：本实用新型中通过设于增压器转轴端部上的销轴，有效的避免了增压器叶轮突\" +\n" +
               "               \"然卡死时轴端螺母的脱落，防止叶轮受<img src=\\\"http://api.szpt.baiten.cn/opc/oss/user/getFile/155427626597\" +\n" +
               "               \"3182465/user/szpt/100100101/All/2022/8/2/jpg/6e203aeea99e4a718dd8c9efe2e81832.jpg\\\" />损，避免了大量的经济损失。</p>";
//        System.out.println(text.length());
//       System.out.println(text.length()>>1);
//        int length = getLength(text);
//        System.out.println("当前字节数为: " + length);
//        String substring = text.substring(0, text.length() >> 3);
//        System.out.println(substring);
//        System.out.println(substring.length());
//        System.out.println("当前字节数为: " + getLength(substring));


        String s = "<p class=\"p_text_indent_2\" style=\"font-size: 16px; line-height: 1.5em;\">近年来，过渡金属氧化物以其可变的氧化价态，成本低廉，易于制备而引起广泛关注。此外，鉴于过渡金属氧化物的理论比电容较高且电活性较好，故而在储能领域具有重要地位。在本工作中，课题组提出了一种双缺陷工艺构建富含氧空位和Mo掺杂的NiCo2O4(R-Mo-NiCo2O4)。通过NaBH4还原在NiCo2O4晶格中产生氧空位缺陷，在材料中产生更多的载流子，使更多活性物质参与电化学氧化还原反应过程。此外，氧空位和Mo掺杂的协同作用不仅提高了材料的导电性，而且丰富了氧化还原动力学。将通过氧空位和Mo掺杂双缺陷工艺制备得到的R-Mo-NiCo2O4用做超级电容器电极，在电流密度1 A g&minus;1下比容量高达285.8 mAh g&minus;1，且具有较好的倍率性能及循环稳定性。该电极材料优异的性能可归因于R-Mo-NiCo2O4较大的比表面积可增加其与电解质的接触面积，实现电解质充分扩散的同时缩短了电荷转移的扩散路径；Mo元素的引入促进了电荷转移，提高了R-Mo-NiCo2O4的导电性，同时Mo元素的引入有助于形成氧空位缺陷，促进离子在电极中的扩散；经NaBH4还原后，氧空位缺陷的数量可进一步增加，提升了该电极材料的电化学性能。该成果于近日发表于化学领域著名期刊Chemical Communications (2022, 58, 5120&ndash;5123)。</p>\n" +
                "<p class=\"p_text_indent_2\" style=\"font-size: 16px; line-height: 1.5em;\">近年来，课题组围绕基于过渡金属氧化物和硫化物的超级电容器电极材料开展了系统研究，并取得一系列成果(Chem. Commun. 2021, 57, 4019&minus;4022; Chem. Commun. 2020, 56, 4003&minus;4006; Chem. Commun. 2019, 55, 1738&minus;1741)。</p>\n" +
                "<p class=\"p_text_indent_2\" style=\"font-size: 16px; line-height: 1.5em;\">近年来，过渡金属氧化物以其可变的氧化价态，成本低廉，易于制备而引起广泛关注。此外，鉴于过渡金属氧化物的理论比电容较高且电活性较好，故而在储能领域具有重要地位。在本工作中，课题组提出了一种双缺陷工艺构建富含氧空位和Mo掺杂的NiCo2O4(R-Mo-NiCo2O4)。通过NaBH4还原在NiCo2O4晶格中产生氧空位缺陷，在材料中产生更多的载流子，使更多活性物质参与电化学氧化还原反应过程。此外，氧空位和Mo掺杂的协同作用不仅提高了材料的导电性，而且丰富了氧化还原动力学。将通过氧空位和Mo掺杂双缺陷工艺制备得到的R-Mo-NiCo2O4用做超级电容器电极，在电流密度1 A g&minus;1下比容量高达285.8 mAh g&minus;1，且具有较好的倍率性能及循环稳定性。该电极材料优异的性能可归因于R-Mo-NiCo2O4较大的比表面积可增加其与电解质的接触面积，实现电解质充分扩散的同时缩短了电荷转移的扩散路径；Mo元素的引入促进了电荷转移，提高了R-Mo-NiCo2O4的导电性，同时Mo元素的引入有助于形成氧空位缺陷，促进离子在电极中的扩散；经NaBH4还原后，氧空位缺陷的数量可进一步增加，提升了该电极材料的电化学性能。该成果于近日发表于化学领域著名期刊Chemical Communications (2022, 58, 5120&ndash;5123)。</p>\n" +
                "<p class=\"p_text_indent_2\" style=\"font-size: 16px; line-height: 1.5em;\">近年来，课题组围绕基于过渡金属氧化物和硫化物的超级电容器电极材料开展了系统研究，并取得一系列成果(Chem. Commun. 2021, 57, 4019&minus;4022; Chem.</p>\n" +
                "<p class=\"p_text_indent_2\" style=\"font-size: 16px; line-height: 1.5em;\">近年来，过渡金属氧化物以其可变的氧化价态，成本低廉，易于制备而引起广泛关注。此外，鉴于过渡金属氧化物的理论比电容较高且电活性较好，故而在储能领域具有重要地位。在本工作中，课题组提出了一种双缺陷工艺构建富含氧空位和Mo掺杂的NiCo2O4(R-Mo-NiCo2O4)。通过NaBH4还原在NiCo2O4晶格中产生氧空位缺陷，在材料中产生更多的载流子，使更多活性物质参与电化学氧化还原反应过程。此外，氧空位和Mo掺杂的协同作用不仅提高了材料的导电性，而且丰富了氧化还原动力学。将通过氧空位和Mo掺杂双缺陷工艺制备得到的R-Mo-NiCo2O4用做超级电容器电极，在电流密度1 A g&minus;1下比容量高达285.8 mAh g&minus;1，且具有较好的倍率性能及循环稳定性。该电极材料优异的性能可归因于R-Mo-NiCo2O4较大的比表面积可增加其与电解质的接触面积，实现电解质充分扩散的同时缩短了电荷转移的扩散路径；Mo元素的引入促进了电荷转移，提高了R-Mo-NiCo2O4的导电性，同时Mo元素的引入有助于形成氧空位缺陷，促进离子在电极中的扩散；经NaBH4还原后，氧空位缺陷的数量可进一步增加，提升了该电极材料的电化学性能。该成果于近日发表于化学领域著名期刊Chemical Communications (2022, 58, 5120&ndash;5123)。</p>\n" +
                "<p class=\"p_text_indent_2\" style=\"font-size: 16px; line-height: 1.5em;\">近年来，课题组围绕基于过渡金属氧化物和硫化物的超级电容器电极材料开展了系统研究，并取得一系列成果(Chem. Commun. 2021, 57, 4019&minus;4022; Chem.</p>\n" +
                "<p class=\"p_text_indent_2\" style=\"font-size: 16px; line-height: 1.5em;\">测试</p>\n" +
                "<p style=\"text-align: center;\">&nbsp;</p>";
        System.out.println(getTextFromTHML(s));


//        String textFromTHML = getTextFromTHML(text);
//        System.out.println(textFromTHML);
    }

    public static String getTextFromTHML(String htmlStr) {
        Document doc = Jsoup.parse(htmlStr);
        String text = doc.text();
        // remove extra white space
        StringBuilder builder = new StringBuilder(text);
        int index = 0;
        while(builder.length()>index){
            char tmp = builder.charAt(index);
            if(Character.isSpaceChar(tmp) || Character.isWhitespace(tmp)){
                builder.setCharAt(index, ' ');
            }
            index++;
        }
        text = builder.toString().replaceAll(" +", " ").trim();
        return text;
    }

    public static int getLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        return str.getBytes(StandardCharsets.UTF_8).length;
    }
}
