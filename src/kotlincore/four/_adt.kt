package kotlincore.four

import shangshou.scoping_function.User

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
        const val Used = 3         // 已使用
        const val Expire = 4        // 已过期
        const val UnAvailable = 5     // 已失效

        fun fetched(c: Coupon, user: User): Boolean = true
        fun used(c: Coupon, user: User): Boolean = true
        fun isExpired(c: Coupon): Boolean = true
        fun isUnAvailable(c: Coupon): Boolean = true
        fun getCouponStatus(coupon: Coupon, user: User): CouponStatus = when {
            isUnAvailable(coupon) -> CouponStatus.StatusUnAvailable(coupon)
            isExpired(coupon) -> CouponStatus.StatusExpired(coupon)
            used(coupon, user) -> CouponStatus.StatusUsed(coupon, user)
            fetched(coupon, user) -> CouponStatus.StatusFetched(coupon, user)
            else -> CouponStatus.StatusNotFetched(coupon)
        }

        fun showStatus(status: CouponStatus) = when (status) {
            is CouponStatus.StatusUnAvailable -> println("unavailable")
            is CouponStatus.StatusExpired -> println("expire")
            is CouponStatus.StatusUsed -> println("used")
            is CouponStatus.StatusFetched -> println("fetched")
            else -> println("not fetched")
        }
    }

    class CashCoupon(val id: Long, val type: String, val leastCost: Long, val reduceCost: Long) : Coupon()
    class DiscountCoupon(val id: Long, val type: String, val discount: Int) : Coupon()
    class GiftCoupon(val id: Long, val type: String, val gift: String) : Coupon()
}

/**
 * 优惠券状态
 */
sealed class CouponStatus {
    data class StatusNotFetched(val coupon: Coupon) : CouponStatus()
    data class StatusFetched(val coupon: Coupon, val user: User) : CouponStatus()
    data class StatusUsed(val coupon: Coupon, val user: User) : CouponStatus()
    data class StatusExpired(val coupon: Coupon) : CouponStatus()
    data class StatusUnAvailable(val coupon: Coupon) : CouponStatus()
}