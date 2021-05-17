package com.example.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Elliot Ji on 2019/2/28.
 */
public class TestList {



   public static void main(String[] args) throws ParseException {
       /*List<Map<Long,String>> set = new ArrayList<>();
       for (int i = 0; i < 40; i++) {
           Map<Long,String> map = new HashMap<>();
           map.put((long)i,"知识维度"+i);
           set.add(map);
       }

       for (Map<Long,String> map: set) {
           Set<Long> longs = map.keySet();
           System.out.println(longs);
       }*/
       String failReason = "";
       StringBuffer stringBuffer = new StringBuffer();
       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       stringBuffer.append(failReason).append("不清晰2").append("(审核时间：").append(format.format(new Date())+");");
       System.out.println(stringBuffer.toString());



      /* String sss = "   ";
       System.out.println(sss.length()+ "=============");

       String date1 = "1595397673000";
       String format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(Long.parseLong(date1)));
       System.out.println(format1);

       System.out.println("==============================");

       Map<String,String> s = new HashMap<>();
      s.put("ef","dfdfdf");
       System.out.println(s.get("ef"));
       System.out.println(s.get("efefef"));

       String auth = "20131109";
       Date date = new SimpleDateFormat("yyyyMMdd").parse(auth);
       String format = new SimpleDateFormat("yyyy-MM-dd").format(date);
       String audit = "20151231";
       Date parse = new SimpleDateFormat("yyyyMMdd").parse(audit);
       boolean b = date.getTime() <= parse.getTime();
       System.out.println(b);

       System.out.println(format);*/


  /*     String sub = auth.substring(0, 4);
       System.out.println(sub);
       boolean equals = !"2021".equals(sub);
       System.out.println(equals);
*/



      /* String  s = "['asdfas','asefe','egtrgr2342','etgh55','etyfdsgr']";
       String substring = s.substring(1, s.length()-1);
       System.out.println(substring);
       String[] split = substring.split(",");
       for (String s1 : split) {
           System.out.println(s1);
       }*/


////        List<Map<String,String>> list = new ArrayList<>();
////        for(int i=0;i<10;i++){
////            Map<String,String> map = new HashMap<>();
////            map.put("name","Jerry"+i);
////            map.put("age","19"+i);
////            System.out.println(map);
////            list.add(map);
////
////        }
////
////        System.out.println(list);
//
//        List<String> ors = new ArrayList<>();
//        ors.add("dfefa");
//        ors.add("efadf");
//        System.out.println(ors.get(0));
       /*DecimalFormat numFormat = new DecimalFormat("0.00");
       Integer a = 23;
       Integer b = 34;
       Float c = Float.valueOf(b).floatValue();
       System.out.println(numFormat.format((a/c)*100)+"%");
       System.out.println(Runtime.getRuntime().availableProcessors());*/

       /*String strDate = "20151214";
       boolean b = patentFee(strDate);
       System.out.println(b);*/
      /* String begin = "2020-10-01 15:33:16";
       String end = "2020-12-31 15:33:22";
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       Date beginParse = dateFormat.parse(begin);
       Date endParse = dateFormat.parse(end);
       long time = beginParse.getTime();
       long time1 = endParse.getTime();
       long time2 = new Date().getTime();
       System.out.println(time2-time1);

       List<String> invention = new ArrayList<>();
       List<String> utility = new ArrayList<>();
       List<String> design = new ArrayList<>();
       List<String> all = new ArrayList<>();
       utility.add("CN201821722612.1");
       utility.add("CN201821588038.5");
       utility.add("CN201420288758.5");
       invention.add("CN201711126854.4");
       invention.add("CN201810658204.2");
       design.add("CN201730440595.7");
       design.add("CN201730223435.7");
       Gson gson = new Gson();
       List<Pack> json = new ArrayList<>();
       Pack pack1 = new Pack();
       System.out.println(pack1.getFlag());
       List<String> value1 = pack1.getValue();
       pack1.setName("发明专利");
       for(String id:invention){
           value1.add(id);
       }
       json.add(pack1);
       Pack pack2 = new Pack();
       pack2.setName("实用新型专利");
       List<String> value2 = pack2.getValue();
      for(String id : utility){
          value2.add(id);
      }
      json.add(pack2);
       Pack pack3 = new Pack();
       pack3.setName("外观设计专利");
       List<String> value3 = pack3.getValue();
       for(String id : design){
           value3.add(id);
       }
       json.add(pack3);
       for(Pack pack:json){
           System.out.println(pack.getName() + ": "+ pack.getValue());
       }
       String s = gson.toJson(json);
       System.out.println(s);

       all.addAll(invention);
       all.addAll(utility);
       all.addAll(design);
       float v = (float) invention.size() / (float) all.size();
       if(v > 0.25f){
           System.out.println(0.2857143 - 0.25);
           System.out.println("jjjj");
       }else{
           System.out.println("bbbb");
       }
       System.out.println((float) invention.size()/(float) all.size());
       System.out.println(all);
*/
//      Long d = new Long(4);
//       System.out.println( d.longValue() == 4L );
//       String s = "d";
//       if(StringUtils.isNotEmpty(s)){
//           System.out.println("ddd");
//       }else{
//           System.out.println("111");
//       }

  /*   List<Pack> list = new ArrayList<>();
     Pack p1 = new Pack();
     p1.setCount(1);
       Pack p2 = new Pack();
       p2.setCount(2);
       Pack p3 = new Pack();
       p3.setCount(3);
       Pack p4 = new Pack();
       p4.setCount(4);
       list.add(p2);
       list.add(p4);
       list.add(p1);
       list.add(p3);
       for(Pack p : list){
           System.out.println(p.getCount());
       }
       Collections.sort(list,new Comparator<Pack>(){
           @Override
           public int compare(Pack o1, Pack o2) {
               return o2.getCount() - o1.getCount();
           }
       });
       for(Pack p : list){
           System.out.print(p.getCount());
       }
   }
    public  static boolean patentFee(String appDate){
        try {
            Date date = new SimpleDateFormat("yyyyMMdd").parse(appDate);
            String apply[] = new SimpleDateFormat("yyyy-MM-dd").format(date).split("-");
            String now[] = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).split("-");
            System.out.println(Integer.parseInt(now[0])- Integer.parseInt(apply[0]));
            return Integer.parseInt(now[0])- Integer.parseInt(apply[0]) >=6 ? true: false;
        }catch (ParseException e){
            e.printStackTrace();
            return false;
        }*/
    }
}
class Pack{
    private Integer count;
    private Boolean flag;
    private String name;
    private List<String> value = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getValue() {
        return value;
    }

    public void setValue(List<String> value) {
        this.value = value;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}

