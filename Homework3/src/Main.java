import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InterruptedException {

//        VehicleInputScanner newVehicle = new VehicleInputScanner();
//        Vehicle testVehicle = newVehicle.createVehicle();
//
//        VehicleDisplayInfo display = new VehicleDisplayInfo(testVehicle);
//        display.getFuelType();
//        display.getMaxSpeed();
//        display.getTransportType();
//        display.getVehicleName();
//
//        // reflexion
//        Class<? extends Vehicle> cls = testVehicle.getClass();
//        System.out.println(cls.getName());
//
//        Method[] methods = cls.getMethods();
//        for (Method method: methods){
//            System.out.println(method.getName());
//        }
//
//        Field field = cls.getField("name");
//        field.setAccessible(true);
//        field.set(testVehicle, "new prado");
//        display.getVehicleName();

//        Thread thread = new myThread();
//        thread.start(); // без старта поток не запустится, делает системный вызов и создается новый поток а run просто исполнит код
//        System.out.println("HELLO FROM MAIN");
//        Thread thread1 = new myThread();
//        thread.setName("xd");
//        thread1.start();
//
//        Runnable task = new Runnable() {
//            @Override
//            public void run() {
//             System.out.println("HELLO FROM a "+this); // при помощи run определяем метод потока,
//            }
//        };
//
//

//        Runnable task = () ->{
//            try {
//                System.out.println("Start thread");
//                Thread.sleep(5000);
//                System.out.println("Finished");
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        };
//        Thread thread = new Thread(task);
//        thread.start();
//        thread.join(3000); // блокирует поток мейн, До того как сработает поток инициализир ранее
//
//        System.out.println("working main");
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i = 0; i<5; i++){
            RunnableTask task = new RunnableTask(String.valueOf(i));
            executorService.execute(task);
        }

        executorService.shutdownNow();
    }



}

class myThread extends Thread {
    @Override
    public void run(){
        try{
            Thread.sleep(2000);
            System.out.println("HELLO FROM"+this); // при помощи run определяем метод потока,
        }
        catch(InterruptedException e){
            throw new RuntimeException(e);
        }

    }
}

class RunnableTask implements Runnable{
    private final String taskName;

    public RunnableTask(String taskName){
        this.taskName = taskName;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println("Task" + taskName + " is complete");
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }


    }
}