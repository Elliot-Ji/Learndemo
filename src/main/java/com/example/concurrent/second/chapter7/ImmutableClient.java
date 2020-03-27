package com.example.concurrent.second.chapter7;

import java.util.stream.IntStream;

/**
 * Created by Elliot Ji on 2019/10/31.
 */
public class ImmutableClient {
    public static void main(String[] args) {
        Person person = new Person("Elliot", "YANCHENG");
        IntStream.range(0,5).forEach(i->
            new UserPersonThread(person).start()
        );
    }
}
