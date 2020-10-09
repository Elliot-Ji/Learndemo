package com.example.dataStructure.tree.huffmancode;

import java.io.*;
import java.util.*;

/**
 * 赫夫曼编码
 */
public class HuffmanCode {
    static Map<Byte,String> huffmanCodes = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
         String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length );
        byte[] bytes = huffmanZip(contentBytes);
        System.out.println("压缩后的数据:" + Arrays.toString(bytes));
        System.out.println(byteToByString(true,(byte)-2));
        byte[] decode = decode(huffmanCodes, bytes);
        System.out.println("解压后的数据:"+ new String(decode));
    }

    //将文件进行解压
    private static void unzipFile(String zipFile,String dstFile){
        InputStream is = null;
        ObjectInputStream ois = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(zipFile);
            ois = new ObjectInputStream(is);
            byte[] huffmanBytes = (byte[])ois.readObject();
            Map<Byte,String> huffmanCodes = (Map<Byte, String>) ois.readObject();
            //解码
            byte[] bytes = decode(huffmanCodes,huffmanBytes);
            //将bytes写入到目标文件
            os = new FileOutputStream(dstFile);
            os.write(bytes);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                os.close();
                ois.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //将文件进行压缩
    private static void zipFile(String srcFile,String dstFile){
        //输出流
        OutputStream os = null;
        ObjectOutputStream oos = null;
        //输入流
        FileInputStream is = null;
        try {
            is = new FileInputStream(srcFile);
            byte[] b = new byte[is.available()];
            System.out.println(b);
            //读取文件
            is.read(b);
            System.out.println(b);
            byte[] huffmanBytes = huffmanZip(b);

            os = new FileOutputStream(dstFile);
            oos = new ObjectOutputStream(os);
            oos.writeObject(huffmanBytes);
            oos.writeObject(huffmanCodes);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
                os.close();
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //huffman编码字节数组解码
    private static byte[] decode(Map<Byte,String> huffmanCodes,byte[] huffmanBytes){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i<huffmanBytes.length;i++){
            boolean flag = (i == huffmanBytes.length-1);
            stringBuilder.append(byteToByString(!flag,huffmanBytes[i]));
        }
        //huffman编码方向调换
        Map<String,Byte> map = new HashMap<>();
        for(Map.Entry<Byte,String> entry: huffmanCodes.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }

        List<Byte> list = new ArrayList<>();
        for(int i = 0;i<stringBuilder.length();){
            int count = 1;
            Boolean flag = true;
            Byte b = null;
            while(flag){
                String key = stringBuilder.substring(i,i+count);//i不动,count往后移动
                b = map.get(key);
                if(b == null){//没有取到
                    count++;
                }else{
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }
        //将list中的数据放入到byte数组中
        byte b[] = new byte[list.size()];
        for(int i = 0;i<b.length;i++){
            b[i] = list.get(i);
        }
        return b;
    }


    /**
     * 将一个byte转成二进制的字符串
     * flag: true:补高位;
     *       false: 截取;
     * 区分正数和负数,正数补高位,负数则截取
     * @param b
     * @return
     */
    private static String byteToByString(boolean flag,byte b){
        int temp = b;
        //如果是true,还需补高位
        if(flag){
            temp |= 256; //按位与
        }
        String s = Integer.toBinaryString(temp); //返回的是temp对应的二进制的补码
        if(flag){
            return s.substring(s.length()-8);
        }else{
            return s;
        }
    }

    /**
     *将以下的方法封装,便于调用
     * @param bytes 原始的字符串对应的字节数组
     * @return 返回Huffman编码处理后的字节数组
     */
    private static byte[] huffmanZip(byte[] bytes){
        List<Node> nodes = getNodes(bytes);
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
        byte[] huffmanCodeByte = zip(bytes, huffmanCodes);
        return huffmanCodeByte;
    }

    //将Huffman编码转成字节数组
    private static byte[] zip(byte[] bytes,Map<Byte,String> huffmanCodes){
        StringBuilder stringBuilder = new StringBuilder();
        for(byte b : bytes){
             stringBuilder.append(huffmanCodes.get(b));
        }
        //将Huffman编码对应的字符串转成byte[]

       int len;
        if(stringBuilder.length() % 8 == 0 ){
            len = stringBuilder.length() / 8;
        }else{
            len = stringBuilder.length() / 8 + 1;
        }
        byte[] huffmanCodesByte = new byte[len];
        int index = 0;
        for(int i = 0;i<stringBuilder.length();i+=8){
            String strByte;
            if((i+8) > stringBuilder.length()){ //不够8位
                strByte = stringBuilder.substring(i);
            }else{
                strByte = stringBuilder.substring(i,i+8);
            }

            huffmanCodesByte[index] = (byte)Integer.parseInt(strByte,2);
            index++;
        }
         return huffmanCodesByte;
    }

    //重载getCodes方法
    private static Map<Byte,String> getCodes(Node root){
        if(root == null){
            return null;
        }
        getCodes(root.left,"0",stringBuilder);
        getCodes(root.right,"1",stringBuilder);
        return huffmanCodes;
    }

    //生成Huffman编码
    private static void getCodes(Node node,String code,StringBuilder stringBuilder){
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if(node != null){
            if(node.data == null){
                getCodes(node.left,"0",stringBuilder2);
                getCodes(node.right,"1",stringBuilder2);
            }else{
                huffmanCodes.put(node.data,stringBuilder2.toString());
            }
        }
    }

    //前序遍历
    private static void preOrder(Node root){
        if(root != null){
            root.preOrder();
        }else{
            System.out.println("huffman树为空");
        }
    }

    private static List<Node> getNodes(byte[] bytes){
        List<Node> nodes = new ArrayList<>();
        Map<Byte,Integer> counts = new HashMap<>();
        for(Byte b : bytes){
            Integer count = counts.get(b);
            if(count == null){
                counts.put(b,1);
            }else{
                counts.put(b,count + 1);
            }
        }
        //遍历map
        for(Map.Entry<Byte,Integer> entry : counts.entrySet()){
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }

        return nodes;
    }

    //创建huffMan树
    private static Node createHuffmanTree(List<Node> nodes){
        while(nodes.size()>1){
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(null,leftNode.weight+rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;

            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        //返回Huffman树的根结点
        return nodes.get(0);
    }

}
//创建结点
class Node implements Comparable<Node>{
    Byte data;
    int weight;
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }
}