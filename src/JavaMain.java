import java.util.ArrayList;
import java.util.List;

/**
 * Created by linnanwei on 2019/9/6
 *
 * @author linnanwei
 */
public class JavaMain {

    Person find(List<Person> personList) {
        for (int i = 0; i < personList.size(); i++) {
            Person p = personList.get(i);
            if (p.getAge() == 24) {
                return p;
            }
        }
        return null;
    }

}
