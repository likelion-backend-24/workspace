package org.example.singleton;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StaticInnerClassSingletonMain {
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 20;
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        CountDownLatch latch = new CountDownLatch(1); // 동시 출발 신호대기선

        StaticInnerClassSingleton[] singletons = new StaticInnerClassSingleton[threadCount];

        for (int i = 0; i < threadCount; i++) {
            final int index = i;
            executorService.submit(() -> {
                try {
                    latch.await(); // 모든 스레드가 준비될 때까지 대기
                    singletons[index] = StaticInnerClassSingleton.getInstance();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        System.out.println("--- Static Inner Class 싱글톤 테스트 시작 ---");
        latch.countDown(); // 20개 스레드 동시 출발!

        executorService.shutdown();
        while (!executorService.isTerminated()) {
            Thread.sleep(10);
        }
        System.out.println("--- 테스트 완료 ---");

        // 모든 스레드가 얻어온 인스턴스가 완전히 동일한 주소를 갖는지 검증
        boolean isSameInstance = true;
        StaticInnerClassSingleton targetInstance = singletons[0];

        for (StaticInnerClassSingleton instance : singletons) {
            if (instance != targetInstance) {
                isSameInstance = false;
                break;
            }
        }

        System.out.println("모든 인스턴스가 동일한가요? : " + isSameInstance);

        if (targetInstance != null) {
            targetInstance.showMessage();
        }
    }
}
