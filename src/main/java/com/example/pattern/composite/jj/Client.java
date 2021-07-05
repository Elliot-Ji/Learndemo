package com.example.pattern.composite.jj;

/**
 * @author: Elliot Ji
 * @createDate: 2021-07-01
 **/
public class Client {
    public static void main(String[] args) {
        OrganizationComponent university = new University("苏州大学","还不错");
        OrganizationComponent computerCollege =  new College("计算机科学院","很难进");
        OrganizationComponent tongCollege = new College("通信工程学校","很好进");

        university.add(computerCollege);
        university.add(tongCollege);

        OrganizationComponent de = new Department("软件工程","就那样");
        OrganizationComponent de2 = new Department("硬件工程","很酷");

        OrganizationComponent de3 = new Department("信息工程","很好");
        OrganizationComponent de4 = new Department("硬件通信","O(∩_∩)O哈哈~");

        computerCollege.add(de);
        computerCollege.add(de2);
        tongCollege.add(de3);
        tongCollege.add(de4);

       university.print();
        System.out.println("------------------");
       computerCollege.print();
        System.out.println("------------------");
       tongCollege.print();
        System.out.println("==================");
        de4.print();

    }
}
