package at.fhtw.swen3.util;

import java.util.UUID;

public class UuidGenerator {
    public static String generateTrackingId(){
        String uuid = UUID.randomUUID().toString().toUpperCase();
        uuid = uuid.replace("-", "");
        return uuid.substring(0, 9);
    }
}
