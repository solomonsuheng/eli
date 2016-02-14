package crackbook;

/**
 * Created by Suheng on 12/16/15.
 */
abstract class Animal {

    private String name;

    public int order;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal(String name) {
        this.name = name;
    }
}
