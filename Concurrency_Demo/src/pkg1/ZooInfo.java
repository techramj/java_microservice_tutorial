package pkg1;


import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class ZooInfo {
    public static void main(String[] args) {

        A ob=new A();
        B b=new B();

        ob.setOb(b);

        System.out.println(ob);



    }

    public static void stramAndParallelStramDemo(){
        Stream<Integer> stream1 = Arrays.asList(1, 2, 3, 4, 5).parallelStream();
        Stream<Integer> stream2 = Arrays.asList(1, 2, 3, 4, 5).stream();

//        stream1.forEach((a)-> {
//                    System.out.print(a + " ");
//                });
        System.out.println();
        stream2.forEach((a)-> {
            System.out.print(a + " ");
        });

        System.out.println();
        stream1.forEachOrdered(a-> System.out.print(a+" "));
    }

    public static void blokcingDequeExample(){
        try {
            BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>();
            blockingDeque.offer(91);
            blockingDeque.offerFirst(5, 2, TimeUnit.MINUTES);
            blockingDeque.offerLast(47, 100, TimeUnit.MICROSECONDS);
            blockingDeque.offer(3, 4, TimeUnit.SECONDS);

            System.out.println(blockingDeque.poll());
            System.out.println(blockingDeque.poll(950, TimeUnit.MILLISECONDS));
            System.out.println(blockingDeque.pollFirst(200, TimeUnit.NANOSECONDS));
            System.out.println(blockingDeque.pollLast(1, TimeUnit.SECONDS));
        } catch (InterruptedException e) {

        }

    }


    public static void skipListCollectionExample(){
        ConcurrentSkipListSet<String> set=new ConcurrentSkipListSet<>();
        set.add("jack");
        set.add("apple");
        set.add("ant");
        System.out.println(set);

        ConcurrentSkipListMap<String,String> map=new ConcurrentSkipListMap<>();
        map.put("b","ball");
        map.put("c","carrot");
        map.put("a","apple");
        System.out.println(map);

        for(String key:map.keySet()){
            map.put("c"+key,"cat");
            if(key.length()>5){
                break;
            }
        }
        System.out.println(map);


    }

    public static void blockingQueueExample(){
        try {
            BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
            blockingQueue.offer(39);
            blockingQueue.offer(3, 4, TimeUnit.SECONDS);
            System.out.println(blockingQueue.poll());
            System.out.println(blockingQueue.poll(10, TimeUnit.MILLISECONDS));
            System.out.println("-----------");
            System.out.println(blockingQueue.poll(10, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void concurrentExample(){
        Map<String,Integer> map = new ConcurrentHashMap<>();
        map.put("zebra", 52);
        map.put("elephant", 10);
        System.out.println(map.get("elephant"));

        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
            queue.offer(31);
        queue.add(30);
        System.out.println(queue.peek());
        System.out.println(queue.poll());

        Deque<Integer> deque = new ConcurrentLinkedDeque<>();
        deque.offer(10);
        deque.push(4);
        System.out.println(deque.peek());
        System.out.println(deque.pop());
    }

    public static void currentModificationException(){
        Map<String,String> map=new HashMap<>();
        map=new ConcurrentHashMap<>();
        map.put("a","apple");
        map.put("b","ball");

        System.out.println(map);
        for(String key:map.keySet()){
            map.remove(key);
        }
        System.out.println(map);
    }

    public static void dirtyReadingExample(){
        ExecutorService service=Executors.newFixedThreadPool(5);
        SheepManager manager=new SheepManager();
        try{
            for(int i=0;i<10;i++){
                service.submit(()->{
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    manager.incrementAndreport();});
            }
        }finally {
            service.shutdown();
        }
    }

    public static void schedulerDemo(){
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        System.out.println("start");
        Runnable r1=()->{
            for(int i=0;i<3;i++){
                try {
                    System.out.println(Thread.currentThread().getName()+": "+i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Callable<String> c1=()->{
            for(int i=0;i<3;i++){
                System.out.println(Thread.currentThread().getName()+": "+i);
                Thread.sleep(1000);
            }
            return "success";
        };

        service.schedule(r1,4,TimeUnit.SECONDS);
        System.out.println("second service");
        service.schedule(c1,10, TimeUnit.SECONDS);

        service.shutdown();

    }


    public static void foo1() throws InterruptedException {
        ExecutorService service= Executors.newSingleThreadExecutor();

        service.submit(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        service.submit(()->{Thread.sleep(10000); return 10;});


        service.shutdown();



        if(service != null) {
            service.awaitTermination(8, TimeUnit.SECONDS);
            // Check whether all tasks are finished
            if(service.isTerminated())
                System.out.println("All tasks finished");
            else
                System.out.println("At least one task is still running");
        }

        System.out.println("End");
    }


    public static void  executeExample(){
        ExecutorService service=null;

        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("Begin");
            service.execute(() -> {
                System.out.println("Printing zoo inventry");
            });

            service.execute(() -> {
                for (int i = 0; i < 3; i++) {
                    System.out.println("Printing record: " + i);
                }
            });
            service.execute(() -> {
                System.out.println("Printing zoo inventry");
            });
        }finally {
            if(service!=null){
                service.shutdown();
            }
        }

        System.out.println("End");
    }


    public static void submitExample(){
        ExecutorService service=null;

        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("Begin");
            Future<?> future1 = service.submit(() -> {
                System.out.println("Printing zoo inventry");
            });

            Future<?> future2 =service.submit(() -> {
                for (int i = 0; i < 3; i++) {
                    System.out.println("Printing record: " + i);
                }
            });
            Future<?> future3= service.submit(() -> {
                System.out.println("Printing zoo inventry");
            });



            System.out.println(future1.get());
            System.out.println(future2.get());
            System.out.println(future3.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            if(service!=null){
                service.shutdown();
            }
        }

        System.out.println("End");
    }
}
