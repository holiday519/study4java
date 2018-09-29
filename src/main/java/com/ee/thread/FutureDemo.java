package com.ee.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FutureDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		ExecutorService pool = Executors.newFixedThreadPool(2);
//		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
//			System.out.println("This is " + Thread.currentThread().getName());
//			String name = "ningyu";
//			for (int i=0; i<10; i++) {
//				System.out.println(name + " is waiting, step is " + i);
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//			return name + " has finished, haha.";
//		}, pool).thenApplyAsync(v -> {
//			System.out.println("That is " + Thread.currentThread().getName());
//			return v + " But he must do another now.";
//		});
//        System.out.println("I can do others..");
		
//		CompletableFuture.supplyAsync(() -> {
//			for (int i=0; i<5; i++) {
//				System.out.println("first job step" + i);
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//			return "first result";
//		}).thenCombine(CompletableFuture.supplyAsync(() -> {
//			for (int i=0; i<3; i++) {
//				System.out.println("second job step" + i);
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//			return "second result";
//		}), (r1, r2) -> r1 + " and " + r2).thenAccept(r -> System.out.println(r));
		
		CompletableFuture<String> first = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "first result";
		});
		CompletableFuture<String> second = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "second result";
		});
		
		CompletableFuture.anyOf(new CompletableFuture[] {first, second}).whenComplete((v, e) -> {
			System.out.println(v);
		});
		
		CompletableFuture.allOf(new CompletableFuture[] {first, second});
		
		
        // new Thread().start()起的子线程使主线程一直存活，但是CompletableFuture起的子线程不会使主线程一直存活，所以我加了个死循环
		while (true) {
			
		}
	}
}
