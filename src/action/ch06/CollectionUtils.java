package action.ch06;

import java.util.List;

/**
 * Created by linnanwei on 2019/9/11
 *
 * @author linnanwei
 */
public class CollectionUtils {
    public static List<String> uppercaseAll(List<String> items){
        for (int i = 0; i < items.size(); i++) {
            items.set(i, items.get(i).toUpperCase());
        }
        return items;
    }
}
