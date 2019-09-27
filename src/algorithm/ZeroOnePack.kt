package algorithm

/**
 * 0-1背包问题
 * Created by linnanwei on 2019/9/24
 * @author linnanwei
 */
class ZeroOnePack {
    companion object{
        /**
         * @param V 当前背包的容量
         * @param C 每件物品的资金消费
         * @param W 每件物品的重量
         */
        fun zeroOnePack(V: Int, C: IntArray, W:IntArray): Int{
            // 输入检测
            if (V <= 0 || C.size != W.size){
                return 0
            }

            val n = C.size

            val dp = Array(W.size){IntArray(W.size)}
            // 背包为空初始值为0
            dp[0][0] = 0

            for(i in 1..n){
                for (j in 1..V){
                    // 不选物品，当前价值就取前一个物品的最大值
                    dp[i][j] = dp[i-1][j];

                    // 如果选择物品 i 使得当前价值相对不选更大，那就选取i，更新当前最大值
                    if ((j >= C[i-1]) && (dp[i-1][j] < dp[i-1][j-C[i-1]] + W[i-1])){
                        dp[i][j] = dp[i-1][j-C[i-1]] + W[i-1]
                    }
                }
            }
            // 返回，对于所有物品(0~N)，容量为V时的最大值
            return dp[n][V]
        }
    }
}