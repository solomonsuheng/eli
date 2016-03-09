package effectivejava;

import java.util.HashMap;

/**
 * Created by Suheng on 3/9/16.
 */
public class Demo {
    public static void main(String[] args) {

        (new Integer(10)).intValue();
    }

    public static <K, V> HashMap<K, V> newInstance() {
        return new HashMap<K, V>();
    }

}
