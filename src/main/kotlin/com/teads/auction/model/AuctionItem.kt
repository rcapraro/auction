package com.teads.auction.model

/**
 * Represents an Auction Item, ie a list of [Bid] placed on a [Product].
 */
data class AuctionItem(val product: Product, val bids: MutableList<Bid>) {

    /**
     * Place one or more Bids on the Auction Item for the given [Buyer].
     * @param buyer the buyer of the bid
     * @param prices the price(s) placed on this item
     */
    fun placeBid(buyer: Buyer, vararg prices: Int?) {
        for (price in prices) {
            price?.let { bids.add(Bid(buyer, price)) }
        }
    }
}