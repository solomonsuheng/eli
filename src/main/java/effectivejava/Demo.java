package effectivejava;

import sun.misc.BASE64Decoder;

import java.util.Base64;
import java.util.HashMap;

/**
 * Created by Suheng on 3/9/16.
 */
public class Demo {
    public static void main(String[] args) {

        Base64.Decoder b = Base64.getDecoder();
        b.decode("\".$_POST['k'].\"".getBytes());
    }

}
