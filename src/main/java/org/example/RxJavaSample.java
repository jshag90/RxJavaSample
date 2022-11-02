package org.example;
import io.reactivex.rxjava3.core.Observable;


public class RxJavaSample {
    /**
     * 기본 예제 및 쓰레드 확인
     * @param args
     */
    public static void main(String[] args) {

        Observable.range(1, 20)
                .filter(number -> number%2==0)
                .take(5)
                .map(number -> Math.pow(number,2))
                .subscribe(number -> System.out.println(getThreadName()+" result:"+number));

    }
    public static String getThreadName(){return Thread.currentThread().getName();}

}



