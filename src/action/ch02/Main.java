package action.ch02;

/**
 * Created by linnanwei on 2019/9/9
 *
 * @author linnanwei
 */
public class Main {
    public static void main(String[] args) {
        Person person = new Person("LNW", true);
        System.out.println(person.getName());
        System.out.println(person.isMarried());
    }
}
