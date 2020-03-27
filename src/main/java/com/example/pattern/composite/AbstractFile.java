package com.example.pattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象构建,组合模式:用来表示树形结构
 * Created by Elliot Ji on 2019/12/16.
 */
public interface AbstractFile {
    void killVirus();//杀毒
}

class ImageFile implements AbstractFile{
    private String name;

    public ImageFile(String name) {
        super();
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("----图像文件,"+name+"进行查杀!");
    }
}

class TextFile implements AbstractFile{
    private String name;

    public TextFile(String name) {
        super();
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("----文本文件,"+name+"进行查杀!");
    }
}

class VideoFile implements AbstractFile{
    private String name;

    public VideoFile(String name) {
        super();
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("----图像文件,"+name+"进行查杀!");
    }
}

//容器组件(构建)
class Folder implements AbstractFile{
    private String name;
    private List<AbstractFile> list = new ArrayList<>();//存放子节点(子文件或子文件夹)

    public Folder(String name) {
        super();
        this.name = name;
    }

    public void add(AbstractFile file){
        list.add(file);
    }

    public void remove(AbstractFile file){
        list.remove(file);
    }

    public AbstractFile getChild(int index){
        return list.get(index);
    }

    @Override
    public void killVirus() {
        System.out.println("----文件夹,"+name+"开始查杀!");
        for(AbstractFile file : list){
            file.killVirus();
        }
    }
}


