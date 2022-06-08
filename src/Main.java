public class Main {
    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];

    public static long one(float[] arr) {
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

        }
        long oneTime = System.currentTimeMillis() - a;
        System.out.println("Время первого прохода: " + oneTime);
        return oneTime;
    }

    public static long two(float[] arr) {

        float[] a1 = new float[h];
        float[] a2 = new float[h];

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        MyThread t1 = new MyThread("a1", a1);
        MyThread t2  = new MyThread("a2", a2);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        a1=t1.getArr();
        a2=t2.getArr();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        long twoTime = System.currentTimeMillis() - a;
        System.out.println("Время второго прохода: "+twoTime);
        return twoTime;
    }


    public static void main(String[] args) {


        for (int i = 0; i < size; i++) {
            arr[i] = 1;

        }
        long one = one(arr);
        long two = two(arr);



    }


}
