package com.example.testdemo;

import com.google.common.collect.Maps;
import lombok.Data;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author: Elliot Ji
 * @createDate: 2022-09-24
 **/
public class Test2 {

    /**
     * 集合判空
     */
    @Test
    public void test01 () {
        List<String> list1 = new ArrayList<>();
        list1.add("ji");
        System.out.println(!CollectionUtils.isEmpty(list1));
    }

    /**
     * 精度问题的使用
     */
    @Test
    public void test02 () {
        BigDecimal one = BigDecimal.valueOf(Double.valueOf(0.03));
        BigDecimal two = BigDecimal.valueOf(Double.valueOf(0.02));
        System.out.println(two.subtract(one));
        int a = 2;
        int b = 4;
        BigDecimal divide = new BigDecimal(b-a).divide(new BigDecimal(a), 2 ,RoundingMode.DOWN);
        BigDecimal divide2 = new BigDecimal(63).divide(new BigDecimal(12), 2 ,RoundingMode.DOWN);
        System.out.println(divide.floatValue());

    }

    @Test
    public void test3() {
        AtomicInteger applyCount = new AtomicInteger();
        System.out.println(applyCount.get());
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int beforeYear = now.minusYears(1).getYear();
        System.out.println( "[" + beforeYear + " TO " + year +"]");
    }

    @Test
    public void test4() {
        List<String> data = new ArrayList<>();
        data.add("Be");
        data.add("Cd");

        AtomicInteger integer = new AtomicInteger();
        List<String> strings = Arrays.asList("提高 效率", "提高 速度", "提高 寿命", "提高 产量", "提高 耐力", "提高 质量", "提高 性能", "提高 容量",
                "提高 强度", "提高 安全性", "提高 稳定性", "提高 便捷性", "提高 可靠性", "提高 灵活性", "提高 精准度", "降低 成本",
                "降低 耗能", "降低 干扰", "降低 阻力", "降低 噪音", "降低 难度");
        System.out.println(strings.size());
        strings = strings.stream().limit(330).collect(Collectors.toList());
        System.out.println(strings.size());

    }

    @Test
    public void test5() {
        Map<String,List<SolrDataModel>> map = new HashMap<>();
        List<SolrDataModel> d1 = new ArrayList<>();
        d1.add(new SolrDataModel("G",200L));
        d1.add(new SolrDataModel("H",400L));
        map.put("提高效率",d1);
        List<SolrDataModel> d2 = new ArrayList<>();
        d2.add(new SolrDataModel("G",200L));
        d2.add(new SolrDataModel("H",130L));
        d2.add(new SolrDataModel("H",30L));
        map.put("提高速度",d2);
        List<SolrDataModel> d3 = new ArrayList<>();
        d3.add(new SolrDataModel("G",200L));
        map.put("提高排序",d3);
        List<SolrDataModel> d4 = new ArrayList<>();
        d4.add(new SolrDataModel("G",10L));
        d4.add(new SolrDataModel("G",2020L));
        d4.add(new SolrDataModel("G",230L));
        d4.add(new SolrDataModel("G",2220L));
        map.put("提高稳定",d4);
        System.out.println(map.size());
        Map<String,List<SolrDataModel>> newmap = new HashMap<>();
        List<Map.Entry<String, List<SolrDataModel>>> arrayList = new ArrayList<>(map.entrySet());
        arrayList.sort((o1, o2) -> o2.getValue().size() - o1.getValue().size());
        arrayList = arrayList.stream().limit(2).collect(Collectors.toList());
        for (Map.Entry<String,List<SolrDataModel>> m: arrayList) {
            newmap.put(m.getKey(),m.getValue());
        }
        System.out.println(newmap);
        for (Map.Entry<String,List<SolrDataModel>> m2: newmap.entrySet()) {
            System.out.println(m2.getKey());
        }

    }

    @Test
    public void test6(){
//        Integer[] a = {33,21,2,333,34,4545,65,23,5,505};
//        Arrays.sort(a,Collections.reverseOrder());
//        for (int i : a) {
//            System.out.println(i);
//        }

         String s = "企业发明专利申请量、授权量均很少。建议采取措施：加大研发投入，加强产学研结合，挖掘技术创新点，着力提升企业的创新能力；$&" +
                 "从企业委托的代理机构授权率情况来看，水平良莠不齐。建议采取措施：企业对委托的代理机构进行梳理，筛选出优质的代理机构进行合作；$&" +
                 "2021年在H04【电通信技术】技术领域，企业专利申请明显减少；$&在H04【电通信技术】技术领域，企业的技术研发和专利申请逐年递减；" +
                 "$&2021年在G06【计算；推算；计数】技术领域，企业专利申请明显减少；$&" +
                 "在G06【计算；推算；计数】技术领域，企业的技术研发和专利申请相对平稳；$&2021年在H01【基本电气元件】技术领域，企业专利申请明显减少；$&" +
                 "在H01【基本电气元件】技术领域，企业的技术研发和专利申请相对平稳；$&2021年在H02【发电、变电或配电】技术领域，企业专利申请明显减少；$&" +
                 "在H02【发电、变电或配电】技术领域，企业的技术研发和专利申请相对平稳；$&2021年在G02【光学】技术领域，企业专利申请明显减少；$&" +
                 "在G02【光学】技术领域，企业的技术研发和专利申请相对平稳；$&2021年在G01【测量；测试】技术领域，企业专利申请明显减少；$&" +
                 "在G01【测量；测试】技术领域，企业的技术研发和专利申请相对平稳；$&2021年在H03【基本电子电路】技术领域，企业专利申请明显减少；$&" +
                 "在H03【基本电子电路】技术领域，企业的技术研发和专利申请逐年递减；$&2014年在H05【其他类目不包含的电技术】技术领域，企业专利申请明显减少；$&" +
                 "在H05【其他类目不包含的电技术】技术领域，企业的技术研发和专利申请相对平稳；$&2021年在G10【乐器；声学】技术领域，企业专利申请明显减少；$&" +
                 "2015年在G10【乐器；声学】技术领域，企业专利申请明显减少；$&在G10【乐器；声学】技术领域，企业的技术研发和专利申请相对平稳；$&" +
                 "2021年在B60【一般车辆】技术领域，企业专利申请明显减少；$&2019年在B60【一般车辆】技术领域，企业专利申请大幅提升；$&" +
                 "2016年在B60【一般车辆】技术领域，企业专利申请大幅提升；$&在B60【一般车辆】技术领域，企业的技术研发和专利申请相对平稳；$&";
        String[] split = s.split("\\$&");
        StringBuilder builder = new StringBuilder();
        AtomicInteger count = new AtomicInteger(1);
        for (String s1 : split) {
            int i = count.get();
            builder.append(i).append(".").append(s1).append("\n");
            count.incrementAndGet();
        }
        System.out.println(builder.toString());

    }

    @Test
    public void test07(){
//        List<String> strList = new ArrayList<>();
//        strList.add("2021年" + "企业专利申请大幅提升；$&");
//        strList.add("2020年" + "企业专利申请明显减少；$&");
//        strList.add("2019年" + "企业专利申请大幅提升；$&");
//        strList.add("2018年" + "企业专利申请明显减少；$&");
//        strList.add("2017年" + "企业专利申请明显减少；$&");
//        strList.add("2016年" + "企业专利申请明显减少；$&");
//        List<String> strings = strList.subList(0, 5);
//        System.out.println(strings);
        LocalDateTime now = LocalDateTime.now();
        String tm = "[" + now.minusYears(20).getYear() + " TO " + now.minusYears(1).getYear() + "]";
        System.out.println(tm);
    }

    @Test
    public void test08(){
        Map<String,String> map = new HashMap<>();
        map.put("2019B33H","jishuluyydtifasdf_one;");
        map.put("2020A33H","jishuluyydtifef");
        map.put("2022C33H","jishuluyydtiasef");
        map.put("2018H33H","jishuluyydtifef");
        map.put("2021F33H","jishuluyydtigrr");
        Map<String,String> map3 = new HashMap<>();
        map3.put("2019B33H","jishuluyydtifasdf_two;");
        map3.put("2020A33H","jishuluyydtifef");
        map3.put("2022C33H","jishuluyydtiasef");
        map3.put("2018H33H","jishuluyydtifef");
        map3.put("2021F33H","jishuluyydtigrr");
        Map<String,String> map4 = new HashMap<>();
        map4.put("2019B33H","jishuluyydtifasdf_two;");
        map4.put("2020A33H","jishuluyydtifef");
        map4.put("2022C33H","jishuluyydtiasef");
        map4.put("2018H33H","jishuluyydtifef");
        map4.put("2021F33H","jishuluyydtigrr");
        Map<String,Map<String,String>> map2 = new HashMap<>();
        map2.put("1",map);
        map2.put("3",map3);
        map2.put("4",map4);
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String,Map<String,String>> entry: map2.entrySet()) {
            Map<String, String> value = entry.getValue();
            String s = StringUtils.isEmpty(value.get("2019B33Hr")) ? "" : value.get("2019B33Hr");
            builder.append(s).append("&");
        }
        builder = builder.deleteCharAt(builder.lastIndexOf("&"));
        System.out.println(builder.toString());
        String[] split = builder.toString().split("&");
        System.out.println(split.length);
        for (String s: split) {
            System.out.println(s);
        }

        StringBuilder builder2 = new StringBuilder();
        builder2.append("ddddffef").append("&");
        System.out.println(builder2.toString());
        builder2 = builder2.deleteCharAt(builder2.lastIndexOf("&"));
        String[] split1 = builder2.toString().split("&");
        for (String tt: split1) {
            System.out.println(tt);
        }

        String f = "fdafdfds";
        String[] split2 = f.split("&");
        for (String tt: split2) {
            System.out.println(tt);
        }
    }

    @Test
    public void test9() {
        String s = "{福睿斯（江苏）汽车零部件有限公司={}, " +
                "浙江天能电池江苏新能源有限公司={2017H01M=竞争对手浙江天能电池江苏新能源有限公司,2017年在H01MH01M【用于直接转变化学能为电能的方法或装置，例如电池组（一般电化学的方法或装置入C25；用于转变光或热为电能的半导体或其他固态器件入H01L，例如H01L 31/00，H01L 35/00，H01L 37/00）〔2〕】技术领域，企业专利申请明显减少；分隔:0.83, " +
                "2012B22D=竞争对手浙江天能电池江苏新能源有限公司,2012年在B22D【金属铸造；用相同工艺或设备的其他物质的铸造（塑料或塑性状态物质的成型入B29C；冶金工艺，添加到金属中物质的选择入C21，C22）】技术领域，企业专利申请大幅提升；分隔:4.0, " +
                "2014H01M=竞争对手浙江天能电池江苏新能源有限公司,2014年在H01M【用于直接转变化学能为电能的方法或装置，例如电池组（一般电化学的方法或装置入C25；用于转变光或热为电能的半导体或其他固态器件入H01L，例如H01L 31/00，H01L 35/00，H01L 37/00）〔2〕】技术领域，企业专利申请大幅提升；分隔:5.16, " +
                "2020B22D=竞争对手浙江天能电池江苏新能源有限公司,2020年在B22D【金属铸造；用相同工艺或设备的其他物质的铸造（塑料或塑性状态物质的成型入B29C；冶金工艺，添加到金属中物质的选择入C21，C22）】技术领域，企业专利申请大幅提升；分隔:4.0, " +
                "2014G01N=竞争对手浙江天能电池江苏新能源有限公司,2014年在G01N【借助于测定材料的化学或物理性质来测试或分析材料（除免疫测定法以外包括酶或微生物的测量或试验入C12M，C12Q）】技术领域，企业专利申请大幅提升；分隔:2.0, " +
                "2015B23K=竞争对手浙江天能电池江苏新能源有限公司,2015年在B23K【钎焊或脱焊；焊接；用钎焊或焊接方法包覆或镀敷；局部加热切割，如火焰切割；用激光束加工（用金属的挤压来制造金属包覆产品入B21C 23/22；用铸造方法制造衬套或包覆层入B22D 19/08；用浸入方式的铸造入B22D 23/04；用烧结金属粉末制造复合层入B22F 7/00；机床上的仿形加工或控制装置入B23Q；不包含在其他类目中的包覆金属或金属包覆材料入C23C；燃烧器入F23D）】技术领域，企业专利申请明显减少；分隔:0.66, " +
                "2010H01M=竞争对手浙江天能电池江苏新能源有限公司,2010年在H01M【用于直接转变化学能为电能的方法或装置，例如电池组（一般电化学的方法或装置入C25；用于转变光或热为电能的半导体或其他固态器件入H01L，例如H01L 31/00，H01L 35/00，H01L 37/00）〔2〕】技术领域，企业专利申请大幅提升；分隔:10.0, " +
                "2021G01N=竞争对手浙江天能电池江苏新能源有限公司,2021年在G01N【借助于测定材料的化学或物理性质来测试或分析材料（除免疫测定法以外包括酶或微生物的测量或试验入C12M，C12Q）】技术领域，企业专利申请明显减少；分隔:0.77, " +
                "2015H01M=竞争对手浙江天能电池江苏新能源有限公司,2015年在H01M【用于直接转变化学能为电能的方法或装置，例如电池组（一般电化学的方法或装置入C25；用于转变光或热为电能的半导体或其他固态器件入H01L，例如H01L 31/00，H01L 35/00，H01L 37/00）〔2〕】技术领域，企业专利申请明显减少；分隔:0.83, " +
                "2021B65D=竞争对手浙江天能电池江苏新能源有限公司,2021年在B65D【用于物件或物料贮存或运输的容器，如袋、桶、瓶子、箱盒、罐头、纸板箱、板条箱、圆桶、罐、槽、料仓、运输容器；所用的附件、封口或配件；包装元件；包装件】技术领域，企业专利申请大幅提升；分隔:3.0, " +
                "2015G01L=竞争对手浙江天能电池江苏新能源有限公司,2015年在G01L【测量力、应力、转矩、功、机械功率、机械效率或流体压力（称量入G01G）〔4〕】技术领域，企业专利申请大幅提升；分隔:3.0, 2017B22D=竞争对手浙江天能电池江苏新能源有限公司,2017年在B22D【金属铸造；用相同工艺或设备的其他物质的铸造（塑料或塑性状态物质的成型入B29C；冶金工艺，添加到金属中物质的选择入C21，C22）】技术领域，企业专利申请明显减少；分隔:0.66, " +
                "2011H01M=竞争对手浙江天能电池江苏新能源有限公司,2011年在H01M【用于直接转变化学能为电能的方法或装置，例如电池组（一般电化学的方法或装置入C25；用于转变光或热为电能的半导体或其他固态器件入H01L，例如H01L 31/00，H01L 35/00，H01L 37/00）〔2〕】技术领域，企业专利申请明显减少；分隔:0.63, " +
                "2021B22D=竞争对手浙江天能电池江苏新能源有限公司,2021年在B22D【金属铸造；用相同工艺或设备的其他物质的铸造（塑料或塑性状态物质的成型入B29C；冶金工艺，添加到金属中物质的选择入C21，C22）】技术领域，企业专利申请明显减少；分隔:0.8, " +
                "2014B23K=竞争对手浙江天能电池江苏新能源有限公司,2014年在B23K【钎焊或脱焊；焊接；用钎焊或焊接方法包覆或镀敷；局部加热切割，如火焰切割；用激光束加工（用金属的挤压来制造金属包覆产品入B21C 23/22；用铸造方法制造衬套或包覆层入B22D 19/08；用浸入方式的铸造入B22D 23/04；用烧结金属粉末制造复合层入B22F 7/00；机床上的仿形加工或控制装置入B23Q；不包含在其他类目中的包覆金属或金属包覆材料入C23C；燃烧器入F23D）】技术领域，企业专利申请大幅提升；分隔:5.0, " +
                "2020H01M=竞争对手浙江天能电池江苏新能源有限公司,2020年在H01M【用于直接转变化学能为电能的方法或装置，例如电池组（一般电化学的方法或装置入C25；用于转变光或热为电能的半导体或其他固态器件入H01L，例如H01L 31/00，H01L 35/00，H01L 37/00）〔2〕】技术领域，企业专利申请大幅提升；分隔:17.0, " +
                "2016B22D=竞争对手浙江天能电池江苏新能源有限公司,2016年在B22D【金属铸造；用相同工艺或设备的其他物质的铸造（塑料或塑性状态物质的成型入B29C；冶金工艺，添加到金属中物质的选择入C21，C22）】技术领域，企业专利申请大幅提升；分隔:5.0, " +
                "2020G01N=竞争对手浙江天能电池江苏新能源有限公司,2020年在G01N【借助于测定材料的化学或物理性质来测试或分析材料（除免疫测定法以外包括酶或微生物的测量或试验入C12M，C12Q）】技术领域，企业专利申请大幅提升；分隔:3.5}, " +

                "华为技术有限公司={H04L=竞争对手华为技术有限公司,在H04L【数字信息的传输，例如电报通信（电报和电话通信的公用设备入H04M）〔4〕】技术领域，企业的技术研发和专利申请逐年减少；分隔:0.71, " +
                "2008H04M=竞争对手华为技术有限公司,2008年在H04M【电话通信（通过电话电缆控制其他设备，但不包括电话交换设备的电路入G08）】技术领域，企业专利申请明显减少；分隔:0.67, " +
                "2021H04W=竞争对手华为技术有限公司,2021年在H04W【无线通信网络〔2009.01〕】技术领域，企业专利申请明显减少；分隔:0.69, " +
                "2006H04W=竞争对手华为技术有限公司,2006年在H04W【无线通信网络〔2009.01〕】技术领域，企业专利申请大幅提升；分隔:3.2, " +
                "2021H01Q=竞争对手华为技术有限公司,2021年在H01Q【天线（近场治疗处理的微波辐射器入A61N 5/04；用于试验天线或测量天线特性的设备入G01R；波导入H01P；微波加热用辐射器或天线入H05B 6/72）】技术领域，企业专利申请明显减少；分隔:0.68, " +
                "H04W=竞争对手华为技术有限公司,在H04W【无线通信网络〔2009.01〕】技术领域，企业的技术研发和专利申请逐年减少；分隔:0.75, " +
                "2010H04Q=竞争对手华为技术有限公司,2010年在H04Q【选择（开关、继电器、选择器入H01H；无线通信网络入H04W）〔1，2009.01〕】技术领域，企业专利申请明显减少；分隔:0.58, " +
                "2021H04Q=竞争对手华为技术有限公司,2021年在H04Q【选择（开关、继电器、选择器入H01H；无线通信网络入H04W）〔1，2009.01〕】技术领域，企业专利申请明显减少；分隔:0.76, " +
                "2008H04Q=竞争对手华为技术有限公司,2008年在H04Q【选择（开关、继电器、选择器入H01H；无线通信网络入H04W）〔1，2009.01〕】技术领域，企业专利申请明显减少；分隔:0.69, " +
                "2021H04L=竞争对手华为技术有限公司,2021年在H04L【数字信息的传输，例如电报通信（电报和电话通信的公用设备入H04M）〔4〕】技术领域，企业专利申请明显减少；分隔:0.67, " +
                "2018H04/=竞争对手华为技术有限公司,2018年在H04/【】技术领域，企业专利申请明显减少；分隔:0.91, " +
                "2003H04W=竞争对手华为技术有限公司,2003年在H04W【无线通信网络〔2009.01〕】技术领域，企业专利申请大幅提升；分隔:15.0, " +
                "2021H04M=竞争对手华为技术有限公司,2021年在H04M【电话通信（通过电话电缆控制其他设备，但不包括电话交换设备的电路入G08）】技术领域，企业专利申请明显减少；分隔:0.78, " +
                "2021H04N=竞争对手华为技术有限公司,2021年在H04N【图像通信，如电视】技术领域，企业专利申请明显减少；分隔:0.77, " +
                "2005H04W=竞争对手华为技术有限公司,2005年在H04W【无线通信网络〔2009.01〕】技术领域，企业专利申请大幅提升；分隔:3.48, 2013H04Q=竞争对手华为技术有限公司,2013年在H04Q【选择（开关、继电器、选择器入H01H；无线通信网络入H04W）〔1，2009.01〕】技术领域，企业专利申请明显减少；分隔:0.58, 2009H04N=竞争对手华为技术有限公司,2009年在H04N【图像通信，如电视】技术领域，企业专利申请明显减少；分隔:0.62, 2016H04/=竞争对手华为技术有限公司,2016年在H04/【】技术领域，企业专利申请大幅提升；分隔:13.0, 2021G06F=竞争对手华为技术有限公司,2021年在G06F【电数字数据处理（部分计算是用液压或气动完成的计算机入G06D，光学完成的入G06E；基于特定计算模型的计算机系统入G06N）】技术领域，企业专利申请明显减少；分隔:0.52, 2021H04B=竞争对手华为技术有限公司,2021年在H04B【传输〔4〕】技术领域，企业专利申请明显减少；分隔:0.66, 2009H04Q=竞争对手华为技术有限公司,2009年在H04Q【选择（开关、继电器、选择器入H01H；无线通信网络入H04W）〔1，2009.01〕】技术领域，企业专利申请明显减少；分隔:0.68}, " +
                "广东飞普纳电器有限公司={}, " +
                "佛山市顺德区盛熙电器制造有限公司={2015F22B=竞争对手佛山市顺德区盛熙电器制造有限公司,2015年在F22B【蒸汽的发生方法；蒸汽锅炉（以原动机为主的蒸汽机装置入F01K；燃烧生成物或剩渣的清除，例如锅炉管燃烧沾污表面的清洗入F23J 3/00；家用蒸汽的集中供热系统入F24D；一般热交换或热传递入F28；核反应堆堆心中蒸气的发生入G21）】技术领域，企业专利申请大幅提升；分隔:2.0, " +
                "2010F22B=竞争对手佛山市顺德区盛熙电器制造有限公司,2010年在F22B【蒸汽的发生方法；蒸汽锅炉（以原动机为主的蒸汽机装置入F01K；燃烧生成物或剩渣的清除，例如锅炉管燃烧沾污表面的清洗入F23J 3/00；家用蒸汽的集中供热系统入F24D；一般热交换或热传递入F28；核反应堆堆心中蒸气的发生入G21）】技术领域，企业专利申请大幅提升；分隔:5.0, 2014D06F=竞争对手佛山市顺德区盛熙电器制造有限公司,2014年在D06F【纺织品的洗涤、干燥、熨烫、压平或打折（帽类的上楦、熨烫平、汽蒸或伸张设备入A42C；用液体、气体或蒸汽处理纺织材料入D06B；化学物质见D06L，D06M）】技术领域，企业专利申请明显减少；分隔:0.73, 2009D06F=竞争对手佛山市顺德区盛熙电器制造有限公司,2009年在D06F【纺织品的洗涤、干燥、熨烫、压平或打折（帽类的上楦、熨烫平、汽蒸或伸张设备入A42C；用液体、气体或蒸汽处理纺织材料入D06B；化学物质见D06L，D06M）】技术领域，企业专利申请大幅提升；分隔:9.0, 2016D06F=竞争对手佛山市顺德区盛熙电器制造有限公司,2016年在D06F【纺织品的洗涤、干燥、熨烫、压平或打折（帽类的上楦、熨烫平、汽蒸或伸张设备入A42C；用液体、气体或蒸汽处理纺织材料入D06B；化学物质见D06L，D06M）】技术领域，企业专利申请大幅提升；分隔:2.0, 2016A61H=竞争对手佛山市顺德区盛熙电器制造有限公司,2016年在A61H【理疗装置，例如用于寻找或刺激体内反射点的装置；人工呼吸；按摩；用于特殊治疗或保健目的或人体特殊部位的洗浴装置（电疗法、磁疗法、放射疗法、超声疗法入A61N）】技术领域，企业专利申请大幅提升；分隔:2.0, 2013A47J=竞争对手佛山市顺德区盛熙电器制造有限公司,2013年在A47J【厨房用具；咖啡磨；香料磨；饮料制备装置〔6〕】技术领域，企业专利申请明显减少；分隔:0.83, 2012A61H=竞争对手佛山市顺德区盛熙电器制造有限公司,2012年在A61H【理疗装置，例如用于寻找或刺激体内反射点的装置；人工呼吸；按摩；用于特殊治疗或保健目的或人体特殊部位的洗浴装置（电疗法、磁疗法、放射疗法、超声疗法入A61N）】技术领域，企业专利申请明显减少；分隔:0.8, 2019A47L=竞争对手佛山市顺德区盛熙电器制造有限公司,2019年在A47L【家庭的洗涤或清扫（刷子入A46B；大量瓶子或其他同一种类空心物件的洗涤入B08B 9/00；洗衣入D06F）；一般吸尘器（一般清扫入B08）】技术领域，企业专利申请大幅提升；分隔:5.0, 2011F22B=竞争对手佛山市顺德区盛熙电器制造有限公司,2011年在F22B【蒸汽的发生方法；蒸汽锅炉（以原动机为主的蒸汽机装置入F01K；燃烧生成物或剩渣的清除，例如锅炉管燃烧沾污表面的清洗入F23J 3/00；家用蒸汽的集中供热系统入F24D；一般热交换或热传递入F28；核反应堆堆心中蒸气的发生入G21）】技术领域，企业专利申请明显减少；分隔:0.66}}";

     String t = "竞争对手华为技术有限公司,2021年在H04L【数字信息的传输，例如电报通信（电报和电话通信的公用设备入H04M）〔4〕】技术领域，企业专利申请明显减少；分隔:0.67";
        String[] split = t.split("分隔:");
        for (String ss: split) {
            System.out.println(ss);
        }
        //2008H04L
    }

    @Test
    public void test10() {
        StringBuilder builder = new StringBuilder();
        builder.append("技术领域").append("、k");
        builder.deleteCharAt(builder.lastIndexOf("、"));
        //builder.insert(0,"soutuot").append("||teshui");
        System.out.println(builder.toString());

        BigDecimal divide = new BigDecimal(4).
                divide(new BigDecimal(2), 2, RoundingMode.DOWN);
        System.out.println(divide.floatValue());
        System.out.println(divide.floatValue() == 2);

        Integer t = new Integer(1);
        System.out.println(t.equals(1));

        String tt = "贵公司在【F15B】技术领域,2020年专利申请量有所提升,2018年专利申请量大幅提升,2017年专利申请量大幅提升,2015年专利申请量有所提升," +
                "2014年专利申请量有所提升,2013年专利申请量明显减少；$&贵公司在【B22C】技术领域,2019年专利申请量明显减少,2018年专利申请量有所提升；";
        String replace = tt.replace("贵公司", "JSA");
        System.out.println(replace);

    }

    @Test
    public void test11() {
        String s = "F15B,B22C,B22D,B23C,B24B,F16B,F16K,B23B,B23P,B65G,F16H,B22D,F15B,F15B," +
                "F16J,F16B,F16H,B22C,F15B,B24B,B65G,G05D,F15B,C23C,F16H,F16J,F16L,B22D,B05C,B22C,B23P," +
                "B24B,F16J,F15B,F15B,B22C,C23C,F16L,F15B,B22C,F16B,B22D,B24B,B25H,B65G,B66C,B66F,F16C," +
                "F15B,F16B,F16L,F15B,B22C,B22D,F16C,F16J,B23P,B23Q,F04B,F15/,F16H,F15B,F16K,F28F,H02K," +
                "F16F,F15B,B22D,B22C,B24B,F15B,F15B,C23C,F15B,B22D,F15B,B05C,B65G,F15B";

        List<String> list = new ArrayList<>();
        String[] split = s.split(",");
        List<String> strings = Arrays.asList(split);
        Map<String,Integer> map = new HashMap<>();
        Set<String> ic2 = new HashSet<>();
        strings.forEach(x -> {
            if (ic2.add(x)) {
                map.put(x,1);
            }else {
                Integer count = map.get(x);
                count ++;
                map.put(x,count);
            }
        });
        List<Map.Entry<String, Integer>> arrayList = new ArrayList<>(map.entrySet());
        arrayList.sort((o1, o2) -> o2.getValue() - o1.getValue());
        System.out.println(map);
        System.out.println(arrayList);
        for (Map.Entry<String,Integer> m: arrayList) {
             list.add(m.getKey());
        }
        System.out.print(list);
    }

    @Test
    public void test12() {
        List<String> list = Arrays.asList("((提高 效率) OR 高效)", "((提高 速度) OR 提速 OR 加速)", "提高 寿命", "((提高 产量) OR 整产)",
                "提高 耐力", "提高 质量", "提高 性能", "((提高 容量) OR 扩容)",
                "提高 强度", "提高 安全性", "提高 稳定性", "((提高 便捷性) OR 便捷 OR 方便 OR 快捷)",
                "提高 可靠性", "提高 灵活性", "提高 精准度", "((降低 成本) OR (降本 增效))",
                "((降低 耗能) OR 节能 OR 减排)", "((降低 干扰) OR 抗干扰 OR 低干扰)", "降低 阻力", "降低 噪音", "降低 难度",
                "提高 韧性", "耐久性", "抗老化", "耐候性", "机械性能", "耐热性", "阻燃", "耐温", "抗形变",
                "导电性", "绝缘性", "抗静电", "低介电损耗", "热塑性", "散热", "低损耗", "电磁屏蔽",
                "防爆", "抗氧化", "抗干扰", "耐磨", "耐腐", "耐冲击", "自动化", "智能化", "绿色环保",
                "无污染", "环境友好", "适应性好", "性能稳定"
        );
        System.out.println(list.contains("适应性好"));
//        List<String> hotEffect = new ArrayList<>();
//        list.forEach(x -> {
//            x = x.replace(" ", "");
//            if (x.contains("((")) {
//                int i = x.indexOf(")", 0);
//                x = x.substring(2,i);
//                System.out.println(x);
//            }
//            hotEffect.add(x);
//        });
//        System.out.println(hotEffect);
    }

    @Test
    public void test13(){
        String s = "江苏恒立液压股份有限公司";
        String[] ors = s.split("OR");
        System.out.println(ors);
        BigDecimal divide = new BigDecimal(0);
        System.out.println(divide.floatValue() >1);
    }

    @Test
    public void test14(){
        LocalDateTime now = null;
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM");
        System.out.println(df.format(now));
    }

    @Test
    public void test15(){
        String format = DateFormatUtils.format(new Date(), "yyyy-MM");
        boolean ff = StringUtils.isEmpty("ff");
//        Lists.reverse()
        HashMap<Object, Object> map = Maps.newHashMap();
        map.put("f","jj");
        System.out.println(map);
    }

    @Test
    public void test16(){
        List<String> strings = Arrays.asList("CHENGDU VISTAR OPTOELECTRONICS CO., LTD.");
        //System.out.println(String.join(" OR ",strings));
        List<String> collect = strings.stream().map(x -> x = "\"" + x + "\"").collect(Collectors.toList());
        System.out.println(String.join(" OR ",collect));
        //System.out.println("\"fff\"");
    }

    @Test
    public void test17(){
        String time = "2022-07-27 00:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime pubDate = LocalDateTime.parse(time,formatter);
        String format = pubDate.format(formatter);
        System.out.println(format);
        System.out.println(pubDate);
    }

    @Test
    public void test18(){
        List<String> strings = Arrays.asList("1","2","3","4","5","6","7");
        strings = strings.stream().limit(4).collect(Collectors.toList());
        System.out.println(strings);
    }

    @Test
    public void test19(){
        StringBuilder builder = new StringBuilder();
        System.out.println(builder.length());
        builder.append("jjjjj");
        System.out.println(builder.length());
    }

}

@Data
class SolrDataModel {
    private String name;
    private Long count;

    public SolrDataModel(String name, Long count) {
        this.name = name;
        this.count = count;
    }
}