package ru.zorro;

import java.awt.Frame;
import org.beryx.textio.swing.SwingTextTerminal;

public class ConsoleThread extends Thread {

    private final String threadName;
    private final int index;

    private ConsoleThread(int index, String threadName) {
        this.threadName = threadName;
        this.index = index;
    }

    public static ConsoleThread runConsoleThread(int index, String threadName) {
        ConsoleThread consoleThread = new ConsoleThread(index, threadName);
        consoleThread.setName(threadName);
        consoleThread.start();
        return consoleThread;
    }

    @Override
    public void run() {
        try {
            doThreadTasks();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void doThreadTasks() throws InterruptedException {
        SwingTextTerminal term = new SwingTextTerminal();
        Frame frame = term.getFrame();
        frame.setTitle("terminal of " + threadName);
        frame.setLocation(200 * index,300);

        term.println("thread " + threadName + " is started");

        for (int i = 0; i < 5; i++) {
            term.println("thread " + threadName + " iteration: " + i);
            Thread.sleep(1000);
        }

        term.println("thread " + threadName + " is ended");

        Thread.sleep(3000);
        term.dispose();
    }

}
