package kotlincore.four

/**
 * 优惠券
 */
sealed class Coupon {
    companion object {
        // 代金券
        const val CashType = "CASH"
        // 折扣卷
        const val DiscountType = "DISCOUNT"
        // 礼品卷
        const val GiftType = "GIFT"

        const val NotFetched = 1    // 未领取
        const val Fetched = 2       // 已领取但未使用
        const val Used  = 3         // 已使用
        const val Expire = 4        // 已过期
        const val UnAvilable = 5     // 已失效

    }

    class CashCoupon(val id: Long, val type: String, val leastCost: Long, val reduceCost: Long): Coupon()
    class DiscountCoupon(val id: Long, val type: String, val discount: Int): Coupon()
    class GiftCoupon(val id: Long, val type: String, val gift: String): Coupon()
}