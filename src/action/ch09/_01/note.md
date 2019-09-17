类型参数约束
比如类型参数可以用在List<Int>和List<Double>上，但不可以用在List<String>，说明这个参数必须是数字，用来表达这个限制
在Java中，用extends关键字表达这种概念
Java：<T extends Number> T sum(List<T>  list)
Kotlin：fun <T: Number> List<T>.sum: T
