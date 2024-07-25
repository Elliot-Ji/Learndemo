package com.example.lambda;

import org.apache.poi.ss.formula.functions.T;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * @author Elliot Ji
 * @date 2023/11/07
 */
@FunctionalInterface
public interface PresentOrElseHandle {

    void presentOrElseHandle(Consumer<? super Object> action, Runnable emptyAction);

}
