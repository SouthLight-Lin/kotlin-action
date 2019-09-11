package action.ch04._11

import java.io.File
import java.util.Comparator

/**
 * Created by linnanwei on 2019/9/10
 * @author linnanwei
 */
class CaseInsensitiveFileComparator: Comparator<File> {
    override fun compare(o1: File, o2: File): Int {
        return o1.path.compareTo(o2.path, ignoreCase = true)
    }

}