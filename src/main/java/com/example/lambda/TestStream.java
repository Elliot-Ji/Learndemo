package com.example.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @author: Elliot Ji
 * @createDate: 2022-06-06
 **/
public class TestStream {

    public static void main(String[] args) {

//        list.stream().filter(x -> x >6).forEach(System.out::println);
//        Optional<Integer> first = list.stream().filter(x -> x > 6).findFirst();
//        System.out.println(first.get());
//        //形成新的集合
//        List<Integer> collect = list.stream().filter(x -> x > 6).collect(Collectors.toList());
//        //映射 可以将一个流的元素按照一定的映射规则映射到另一个流中
//        //map(): 接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
//        //flatMap():接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
//
//        System.out.println(collect);

        List<String> strings = Arrays.asList("efe", "fasdf", "fesww", "iriri", "iejkd");

//        if (strings.size() > 3) {
//            strings = strings.stream().limit(2).collect(Collectors.toList());
//        }
        StringBuilder builder = new StringBuilder();
        builder.append("an:(");
        strings.forEach(x -> {
            builder.append(x + " OR ");
        });
        builder.deleteCharAt(builder.lastIndexOf("R"));
        builder.deleteCharAt(builder.lastIndexOf("O"));
        builder.append(")");
        System.out.println(builder.toString());


//        String time = "2022-05-12 17:05:00";
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime parse = LocalDateTime.parse(time, formatter);
//        System.out.println(parse);

        System.out.println( String.format(BOOL_MUST_QUERY_FORMAT,"re_cn:我是特使"));
    }

    public static final String BOOL_MUST_QUERY_FORMAT = " {\n" +
            "    \"bool\": {\n" +
            "      \"must\": [\n" +
            "        {\n" +
            "          \"query_string\": {\n" +
            "            \"query\": \"%s\"\n" +
            "          }\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  }";

    public static String getWOrd(Integer age,String... code) {
        if (code != null && code.length > 0) {

        }
        return null;
    }


    public static List<Integer> getListByPage(Integer page,Integer size){
        List<Integer> list = Arrays.asList(4, 5, 6, 7, 3, 2, 9,10,8,12,33,43,123,432,5423);

        return null;
    }

}
