package server.cache;



import java.util.concurrent.ConcurrentHashMap;

public class LoginCache {
    public static ConcurrentHashMap<String, String> TOKEN_CACHE = new ConcurrentHashMap<String, String>();
}
