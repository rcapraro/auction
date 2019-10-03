package com.teads.auction.algorithm.implementation

import com.teads.auction.algorithm.AuctionAlgorithm
import com.teads.auction.exception.AuctionException
import com.teads.auction.model.AuctionItem
import com.teads.auction.model.AuctionResult

/**
 * Implementation of the auction algorithm based on the Vickrey Auction sealed-bid:
 * - Firstly, determine the highest Bid and the winning Buyer.
 * - Secondly, determine the second highest Bid.
 * - Lastly, set the winning Bid price to the bid price of the second highest Bid.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Vickrey_auction">Vickrey Auction</a>
 */
class VickreyAuctionAlgorithm : AuctionAlgorithm {
    override fun determineWinners(item: AuctionItem): AuctionResult {

        // Filter bids below reserve price
        val effectiveBids = item.bids
            .filter { it.price > item.product.reservePrice }

        val highestBid = (effectiveBids
            .maxBy { it.price }
            ?: throw AuctionException("There are no valid Bids to process !"))

        val secondHighestBid = effectiveBids
            .filter { it.buyer != highestBid.buyer }
            .maxBy { it.price }
            ?: highestBid

        return AuctionResult(highestBid, secondHighestBid.price)
    }
}