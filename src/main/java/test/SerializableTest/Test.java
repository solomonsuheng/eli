package test.SerializableTest;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Suheng on 3/16/16.
 */
public class Test {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        User user = new User();
        user.setId(1);
        user.setName("Mr XP.Wang");
        // 创建一个List对象
        List<String> list = new ArrayList<String>();
        list.add("My name");
        list.add(" is");
        list.add(" Mr XP.Wang");
        try {
            ObjectOutputStream os = new ObjectOutputStream(
                    new FileOutputStream("/Users/gesuheng/Desktop/kk"));
            os.writeObject(user);// 将User对象写进文件
            os.writeObject(list);// 将List列表写进文件
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(
                    "/Users/gesuheng/Desktop/kk"));
            User temp = (User) is.readObject();// 从流中读取User的数据
            System.out.println(temp.getId());
            System.out.println(temp.getName());
            List tempList = (List) is.readObject();// 从流中读取List的数据
            for (Iterator iterator = tempList.iterator(); iterator.hasNext();) {
                System.out.print(iterator.next());
            }
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
