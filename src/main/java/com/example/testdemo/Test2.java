package com.example.testdemo;

import lombok.Data;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
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
        BigDecimal divide = new BigDecimal(68).divide(new BigDecimal(72), 2 ,RoundingMode.DOWN);
        System.out.println(divide);
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
        Integer[] a = {33,21,2,333,34,4545,65,23,5,505};
        Arrays.sort(a,Collections.reverseOrder());
        for (int i : a) {
            System.out.println(i);
        }
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