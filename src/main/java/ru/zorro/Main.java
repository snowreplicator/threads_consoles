package ru.zorro;

import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n----------- start\n");
        testGson();
        testConsoles();
        System.out.println("\nend -----------\n");
    }

    private static void testGson() {
        Gson gson = new Gson();
        String json = gson.toJson(new Person("John", 30));
        System.out.println(json);
    }

    private static void testConsoles() {
        try {
            MultiThreadConsoles.run();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}