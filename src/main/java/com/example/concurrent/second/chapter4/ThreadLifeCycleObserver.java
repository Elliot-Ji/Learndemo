package com.example.concurrent.second.chapter4;

import java.util.List;

/**
 * Created by Elliot Ji on 2019/8/13.
 */
public class ThreadLifeCycleObserver implements LifeCycleListener {

    private final Object LOCK = new Object();

    public void concurrentQuery(List<String> ids){
        if(ids ==null || ids.isEmpty()){
            return;
        }

        ids.stream().forEach(id->new Thread(new ObservableRunnable(this) {
            @Override
            public void run() {
                try{
                    notifyChange(new RunnableEvent(RunnableState.RUNNING,Thread.currentThread(),null));
                    System.out.println("query for the id "+ id);
                    Thread.sleep(1000);//模拟待执行的任务
                    notifyChange(new RunnableEvent(RunnableState.DONE,Thread.currentThread(),null));
                }catch(Exception e){
                    notifyChange(new RunnableEvent(RunnableState.ERROR,Thread.currentThread(),e));
                }
            }
        },id).start());
    }

    @Override
    public void onEvent(ObservableRunnable.RunnableEvent event) {
        synchronized (LOCK){
            System.out.println("The runnable ["+event.getThread().getName()+"] data changed and state is ["+event.getState()+"]");
            if(event.getCause()!=null){
                System.out.println("The runnable ["+event.getThread().getName()+"] process failed");
                event.getCause().printStackTrace();
            }
        }

    }
}
