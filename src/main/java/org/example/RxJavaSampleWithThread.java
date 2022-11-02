package org.example;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RxJavaSampleWithThread {
    /**
     * 기본 예제 + subscribeOn(), observeOn()
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        Observable.range(1, 20)
                .doOnNext(data -> System.out.println(getThreadName()+" #doOnNext()"+ data))
                .subscribeOn(Schedulers.io())
             //   .observeOn(Schedulers.computation())
                .filter(number -> number%2==0)
                .take(5)
                .map(number -> Math.pow(number,2))
                .subscribe(number -> System.out.println(getThreadName()+" result:"+number));

        Thread.sleep(500);

    }

    public static String getThreadName(){return Thread.currentThread().getName();}
}