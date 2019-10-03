package com.teads.auction.model

/**
 * The Result of an auction.
 *
 * @property bid the winning bid with the price determined by the Vickrey Algorithm
 * @property price the "real" price placed on the item
 */
data class AuctionResult(val bid: Bid, val price: Int)