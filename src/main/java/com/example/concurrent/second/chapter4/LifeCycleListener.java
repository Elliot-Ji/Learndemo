package com.example.concurrent.second.chapter4;

/**
 * Created by Elliot Ji on 2019/8/13.
 */
public interface LifeCycleListener {

    void onEvent(ObservableRunnable.RunnableEvent event);
}
