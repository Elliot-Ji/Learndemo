package com.example.iText;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.annotation.Person;
import com.example.util.ArithmeticUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.Year;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


/**
 * 根据图片的网页地址，爬取图片
 * 1.httpClient5  VS httpClient4
 * 2.OkHttp的使用
 * @author Elliot Ji
 * @date 2024/09/05
 */
@Slf4j
public class DownloadImgByUrl {

    public static void main(String[] args) throws UnsupportedEncodingException {

        //getImageByWebUrl("https://www.czkjgx.com/cdn/statics/2024/08/13/10007806微生物过滤装置.jpg","D:\\images");

        //getInstrumentByWeb();

        //getSsqdc();

        List<Integer> list1 = Arrays.asList( 483, 66, 60, 72);
        List<Integer> list2 = Arrays.asList(70,65,75,67,69,118,73,145);
        Set<Integer> set = new HashSet<>(list1);
        set.addAll(list2);
       List<Integer> integers = new ArrayList<>(set);
        System.out.println(set);

    }


    public static Map<String,Integer> transferStringToMap(String s,Map<String,Integer> map) {
        if (org.apache.commons.lang.StringUtils.isNotBlank(s)) {
            System.out.println("beforerror: " + s);
            if (s.contains(";")) {
                String[] split = s.split(";");
                getMapValue(map,split);
            } else if (s.contains("；")) {
                String[] split = s.split("；");
                getMapValue(map,split);
            }else if (s.contains("、")) {
                String[] split = s.split("、");
                getMapValue(map,split);
            }else if (s.contains(",")) {
                String[] split = s.split(",");
                getMapValue(map, split);
            }else if (s.contains("和")) {
                String[] split = s.split("和");
                getMapValue(map,split);
            } else if (s.contains("或")) {
                String[] split = s.split("或");
                getMapValue(map,split);
            }else if (s.contains(" ")) {
                String[] split = s.split(" ");
                getMapValue(map,split);
            } else {
                if (org.apache.commons.lang.StringUtils.isNotEmpty(s)){
                    s = s.trim();
                    if (map.containsKey(s)) {
                        int i = map.get(s) + 1;
                        map.put(s,i);
                    }else {
                        map.put(s,1);
                    }
                }

            }
        }
        return map;
    }



    private static void getMapValue(Map<String,Integer> map,String[] arrays) {
        if (arrays != null) {
            System.out.println("split Error: " + arrays);
            try {
                for (String s : arrays) {
                    if (org.apache.commons.lang.StringUtils.isNotEmpty(s)) {
                        s = s.trim();
                        if (map.containsKey(s)) {
                            int i = map.get(s) + 1;
                            map.put(s,i);
                        }else {
                            map.put(s,1);
                        }
                    }
                }
            }catch (NullPointerException e) {
                System.out.println("rrrrr: " + arrays);
            }

        }
    }

    //路径中的中文替换成utf8编码
    public static String chineseEncodeToUTF8(String url,String encode) {
//        Pattern pattern = Pattern.compile("[\\u4e00-\\u9fa5]");
//        Matcher matcher = pattern.matcher(url);
//        String s = "";
//        while(matcher.find()) {
//            String encodeResult = null;
//            try {
//                encodeResult = URLEncoder.encode(matcher.group(), encode);
//            } catch (UnsupportedEncodingException e) {
//                throw new RuntimeException(e);
//            }
//            s = matcher.replaceAll(encodeResult);
//            //s = matcher.replace(encodeResult);
//        }
//        return StringUtils.isEmpty(s) ? url : s;
        String result;
        String imageName = url.substring(url.lastIndexOf("/") + 1);
        String substring = url.substring(0, url.lastIndexOf("/") + 1);
        try {
            imageName = URLEncoder.encode(imageName, "utf-8");
            result = substring + imageName;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return result;
    }


    /**
     * 实用URL 请求时，路径中不能有中文等字符，会报错！！！！
     * 将网页图片下载到本机保存
     * @param url 网页路径 https://www.czkjgx.com/cdn/statics/2021/12/31/506d95a8-3476-46d8-ba4e-66406d03df92.jpg
     * @param filePath 下载保存的绝对路径 D:\\images\\xxx.jpg
     */
    public static void getImageByWebUrl(String url,String filePath) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            URL urlConnect = new URL(url);
            URLConnection urlConnection = urlConnect.openConnection();
            inputStream = urlConnection.getInputStream();
            //截图图片后缀
            String imageName = url.substring(url.lastIndexOf("/") + 1);
            File file = new File(filePath + "\\" + imageName);
            outputStream = Files.newOutputStream(file.toPath());
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buffer)) != -1) {
                //从buffer数组off位置写length长度的字节到buffer数组中
                outputStream.write(buffer, 0, length);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            //关闭流
            try{
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void getImageByWebUrl2(String url,String filePath) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            //URL  urlClient = new URL(url) 传入的URL中如果出现中文、空格等特殊字符时会报错
            // 因此对那段参数进行编码处理
            //最后一个/ 后面的参数会出现中文、特殊字符，故需要编码处理
            String imageName = url.substring(url.lastIndexOf("/") + 1);
            String query = URLEncoder.encode(imageName, StandardCharsets.UTF_8.toString());
            String enCodeUrl = url.substring(0,url.lastIndexOf("/") + 1) + query;

            HttpGet httpGet = new HttpGet(enCodeUrl);
            CloseableHttpResponse closeableHttpResponse = null;
            closeableHttpResponse = httpClient.execute(httpGet);
            HttpEntity entity = closeableHttpResponse.getEntity();
            if (entity == null || entity.getContent() == null) {
                return;
            }
            inputStream = entity.getContent();
            //截图图片后缀
            //String imageName = url.substring(url.lastIndexOf("/") + 1);
            File file = new File(filePath + "\\" + imageName);
            outputStream = Files.newOutputStream(file.toPath());
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buffer)) != -1) {
                //从buffer数组off位置写length长度的字节到buffer数组中
                outputStream.write(buffer, 0, length);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            //关闭流
            try{
                httpClient.close();
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
      *爬取数据，将图片保存到本地
      *
      */
    public static void getInstrumentByWeb() {
        new Thread(()->{
            String result = "";//9832
            String url = "https://www.czkjgx.com/trum/instrumDetails";
            try{
                // 7001 ~ 8000 8001 ~ 9000 9001 ~ 9832
                // 6001 ~ 7000 5001 ~ 6000 4001 ~ 5000
                // 3001 ~ 4000 2001 ~ 3000 1001 ~ 2000
                // 56 ~ 1000
                for (long i = 56; i <= 1000 ; i++) {
                    CloseableHttpClient httpClient = HttpClients.createDefault();
                    HttpPost httpPost = new HttpPost(url);
                    httpPost.addHeader("Content-Type", "application/json");
                    httpPost.addHeader("Accept", "*/*");
                    QueryParamModel model = new QueryParamModel();
                    model.setId(i);
                    String jsonArray2 = JSON.toJSONString(model);
                    httpPost.setEntity(new StringEntity(jsonArray2,"UTF-8"));
                    CloseableHttpResponse closeableHttpResponse = null;
                    closeableHttpResponse = httpClient.execute(httpPost);
                    result = EntityUtils.toString(closeableHttpResponse.getEntity(),"utf-8");
                    JSONObject tmpResult = JSONObject.parseObject(result);
                    Object data = tmpResult.get("data");
                    if (data != null) {
                        log.info("当前ID: {}",i);
                        TmpModel dataModel = JSON.toJavaObject((JSON) data, TmpModel.class);
                        //将图片存到本地
                        if (!StringUtils.isEmpty(dataModel.getPict())) {
                            getImageByWebUrl2(dataModel.getPict(),"D:\\images");
                        }
                    }
               }
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();
    }


    public static void getSsqdc() {
        new Thread(()->{
            String result = "";
            String url = "https://cacs.mofcom.gov.cn/cacscms/view/case/ssqdc";
            try{
                    CloseableHttpClient httpClient = HttpClients.createDefault();
                    HttpPost httpPost = new HttpPost(url);
                    httpPost.addHeader("Content-Type", "application/json");
                    httpPost.addHeader("Accept", "*/*");
                    httpPost.addHeader("Cookie","name=value; JSESSIONID=00A15E4A9421C857CB25169021FEC9F0; uid=112; insert_cookie=36485949; _pk_id.128.d335=92d481c6d61ea05a.1727161803.; _pk_ses.128.d335=1");
                    QueryParamModel model = new QueryParamModel();
                    //model.setColumn("ssqdc");
                    //model.setType("case");
                    model.setPageNumber(2);
                    model.setPageSize(20);
                    model.setPageItems(new int[]{1,2,3,4,5});
                    String jsonArray2 = JSON.toJSONString(model);
                    httpPost.setEntity(new StringEntity(jsonArray2,"UTF-8"));
                    CloseableHttpResponse closeableHttpResponse = null;
                    closeableHttpResponse = httpClient.execute(httpPost);
                    result = EntityUtils.toString(closeableHttpResponse.getEntity(),"utf-8");
                    JSONObject tmpResult = JSONObject.parseObject(result);
                    Object data = tmpResult.get("rows");
                    if (data != null) {
                        System.out.println(data);
                        //TmpModel dataModel = JSON.toJavaObject((JSON) data, TmpModel.class);

                    }
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();
    }


}

@Data
class N{
    private Integer id;
    private String name;

    public N(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}