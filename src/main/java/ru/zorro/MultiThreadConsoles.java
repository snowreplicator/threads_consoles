package ru.zorro;

import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.TextTerminal;

import java.util.ArrayList;
import java.util.List;

public class MultiThreadConsoles {

    private final static String THREAD_NAME_PREFIX = "_my_thread_";
    private static final int MAX_TASKS = 4;

    public static void run() throws InterruptedException {
        TextIO textIO = TextIoFactory.getTextIO();
        TextTerminal<?> terminal = textIO.getTextTerminal();
        terminal.printf("-----------------\n");
        terminal.printf("main terminal started\n\n");

        List<ConsoleThread> consoleThreads = new ArrayList<ConsoleThread>();
        for (int i = 0; i < MAX_TASKS; i++) {
            String threadName = THREAD_NAME_PREFIX + "number_" + i;
            terminal.printf("run thread with name: " + threadName + "\n");
            ConsoleThread consoleThread = ConsoleThread.runConsoleThread(i, threadName);
            consoleThreads.add(consoleThread);
            Thread.sleep(300);
        }

        terminal.printf("\nmain terminal ended\n");
        Thread.sleep(3000);
        terminal.dispose();
    }
}
