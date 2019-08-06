package com.ee.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class SoftReferenceDemo {

	private static ReferenceQueue<MyObject> queue = new ReferenceQueue<>();
	
	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(3000);
        MyObject object = new MyObject();
        SoftReference<MyObject> softRef = new SoftReference(object, queue);
        new Thread(new CheckRefQueue()).start();

        object = null;
        System.gc();
        System.out.println("After GC : Soft Get = " + softRef.get());
        System.out.println("分配大块内存");
        
        byte[] b = new byte[5*1024*790];

        System.out.println("After new byte[] : Soft Get = " + softRef.get());
	}
	
	public static class CheckRefQueue implements Runnable {

        Reference<MyObject> obj = null;

        @Override
        public void run() {
            try {
                obj = (Reference<MyObject>) queue.remove();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (obj != null) {
                System.out.println("Object for softReference is " + obj.get());
            }

        }
    }
	
	public static class MyObject {

        @Override
        protected void finalize() throws Throwable {
            System.out.println("MyObject's finalize called");
            super.finalize();
        }

        @Override
        public String toString() {
            return "I am MyObject.";
        }
    }

}
