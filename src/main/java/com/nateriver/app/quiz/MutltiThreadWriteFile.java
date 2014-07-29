package com.nateriver.app.quiz;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Give four threads, thread 1 output 1, thread 2 output 2 , ....
 * Please write file as below sequence
 *  File 1: 1,2,3,4
 *  File 2: 2,3,4,1
 *  File 3: 3,4,1,2
 *  File 4: 4,1,2,3
 */


public class MutltiThreadWriteFile {
    public static int fileNum = 1;
    public static int curValue = 1;

    public void startWrite() {
        ExecutorService service = Executors.newCachedThreadPool();
        for(int i = 1; i<=4 ; i++){
            service.execute(new WriteRunnable(i,i));
        }

        service.shutdown();
    }

    public synchronized static void updateNext(){
        if(fileNum < 4){
            curValue = curValue%4 +1;
        }
        else {
            curValue = curValue < 4 ? curValue + 4 -3 + 1 : curValue - 3 + 1;
        }
        fileNum = fileNum %4 + 1;
    }
}

class WriteRunnable implements Runnable {
    private int writeValue = 1;
    private int threadNum = 1;

    WriteRunnable(int writeValue, int threadNum) {
        this.writeValue = writeValue;
        this.threadNum = threadNum;
    }

    public void run() {
        for (int i = 0; i < 16; i++){
            synchronized(MutltiThreadWriteFile.class){
                if(MutltiThreadWriteFile.curValue != writeValue){
                    try {
                        MutltiThreadWriteFile.class.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                } else {
                    writeFile(String.valueOf(MutltiThreadWriteFile.fileNum));
                    MutltiThreadWriteFile.updateNext();
                    MutltiThreadWriteFile.class.notifyAll();
                }
            }
        }
    }

    public void writeFile(String filePath) {
        System.out.println(
                String.format(
                        "thread %s write file %s and value is %s",
                        this.threadNum,
                        filePath,
                        this.writeValue
                )
        );
    }

    public static void main(String[] args) throws Exception {
        MutltiThreadWriteFile mf = new MutltiThreadWriteFile();
        mf.startWrite();
    }

}
