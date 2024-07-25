package com.example.lambda;

/**
 * @author Elliot Ji
 * @date 2023/11/06
 */
public class VUtils {

    public static ThrowExceptionFunction isTure(boolean b) {
        return (errorMessage) -> {
            if (b) {
                throw new RuntimeException(errorMessage);
            }
        };
    }

    public static BranchHandle isTrueOrFalse(boolean b) {
        return (trueHandle,falseHandle) -> {
            if (b) {
                trueHandle.run();
            }else {
                falseHandle.run();
            }
        };
    }

    public static PresentOrElseHandle isBlankOrNotBlank(String str) {
        return (consumer,runnable) -> {
            if (str == null || str.length() == 0) {
                runnable.run();
            }else {
                consumer.accept(str);
            }
        };
    }

}
