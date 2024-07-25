package com.example.lambda;

/**
 * @author Elliot Ji
 * @date 2023/11/07
 */
@FunctionalInterface
public interface BranchHandle {

    void trueOrFalseHandle(Runnable trueHandle,Runnable falseHandle);

}
