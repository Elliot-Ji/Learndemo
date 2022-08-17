package com.example.pattern.builder;

/**
 * @author: Elliot Ji
 * @createDate: 2022-08-17
 **/
public class CommonHouse  extends AbstractHouse{
    @Override
    public void buildBasic() {
        System.out.println("普通房子打地基");
    }

    @Override
    public void buildWalls() {
        System.out.println("普通房子砌墙");
    }

    @Override
    public void roofed() {
        System.out.println("普通房子封顶");
    }
}
