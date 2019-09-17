变型：只有值得类型是变量类型的子类型时，才运行变量存储该值
Int类是Number的子类
val n: Number = i: Int  (√ 可以)
val n: Number = i: String (× 不可以)
val n: Int? = i: Int (√ 可以)
val n: Int = i:Int? (× 不可以)

# 协变：保留子类型化关系
使用out关键字完成协变