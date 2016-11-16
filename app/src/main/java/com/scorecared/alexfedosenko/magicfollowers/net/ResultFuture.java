package com.scorecared.alexfedosenko.magicfollowers.net;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import retrofit2.Call;

public class ResultFuture<T> implements Future<T> {
    private final Call<T> call;

    public ResultFuture (Call<T> call) {
        this.call = call;
    }
    @Override
    public boolean cancel(boolean b) {
        call.cancel();
        return true;
    }

    @Override
    public boolean isCancelled() {
        return call.isCanceled();
    }

    @Override
    public boolean isDone() {
        return call.isExecuted();
    }

    @Override
    public T get() throws InterruptedException, ExecutionException {
        try {
            return call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
        return null;
    }

    @Override
    public T get(long l, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return get();
    }
}
