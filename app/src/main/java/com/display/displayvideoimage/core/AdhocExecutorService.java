package com.display.displayvideoimage.core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jzxiang on 16/11/22.
 */

public class AdhocExecutorService {

    private ExecutorService mExecutorService;
    private ExecutorService mExecutorServiceSaveCache;

    public static AdhocExecutorService getInstance() {
        return SingleTon.service;
    }

    private AdhocExecutorService() {
        //no instance
        mExecutorService = Executors.newFixedThreadPool(3);
        mExecutorServiceSaveCache = Executors.newSingleThreadExecutor();
    }

    private static class SingleTon {
        private static final AdhocExecutorService service = new AdhocExecutorService();
    }


    public void execute(Runnable runnable) {
        mExecutorService.execute(runnable);
    }

    public void executeSaveCache(Runnable runnable) {
        mExecutorServiceSaveCache.execute(runnable);
    }

}
