package action.ch07._04

import java.time.LocalDate

/**
 * 实现日期区间的迭代器
 * @author SouthLight-Lin on 2019/9/14
 */

operator fun ClosedRange<LocalDate>.iterator() : Iterator<LocalDate> =
        object : Iterator<LocalDate>{
            var current = start

            //
            override fun hasNext(): Boolean {
                return current <= endInclusive
            }

            // 把当前日期增加一天
            override fun next(): LocalDate  = current.apply { current = plusDays(1) }
        }