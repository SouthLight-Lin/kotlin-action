package action.ch06.pingtai;

import java.io.File;
import java.util.List;

/**
 * Created by linnanwei on 2019/9/11
 *
 * @author linnanwei
 */
public interface FileContentProcessor {
    void processContents(File path,
                         byte[] binaryContents,
                         List<String> textContents);
}
