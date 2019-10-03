package com.teads.auction.model

/**
 * A Bid placed on an Item by a [Buyer].
 *
 * @property buyer the buyer who place the Bid
 * @property price the price of the Bid
 */
data class Bid(val buyer: Buyer, val price: Int)