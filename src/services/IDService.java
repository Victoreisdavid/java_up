package services;

import java.util.UUID;

public class IDService {
    public IDService() {
    }

    public static String generateID() {
        return Integer.toString((int)(Math.random() * 100) + 1);
    }
}
