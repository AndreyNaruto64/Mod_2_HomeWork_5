public class MyThread extends Thread{
    private float[] arr;
    private String name;

    MyThread(String name, float[] arr){
        this.name = name;
        this.arr = arr;
    }

    public float[] getArr() {
        return arr;
    }

    public void run(){
        calculate();
    }

    private void calculate() {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

        }
    }
}
