package com.teads.auction.algorithm

import com.teads.auction.algorithm.implementation.VickreyAuctionAlgorithm
import com.teads.auction.exception.AuctionException
import com.teads.auction.model.AuctionItem
import com.teads.auction.model.Buyer
import com.teads.auction.model.Product
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.shouldThrow
import io.kotlintest.specs.ShouldSpec

/*
* Unit Tests of the Auction Algorithm.
*/
class VickreyAuctionAlgorithmTest : ShouldSpec({
    val sonyDiscman = Product("Sony D-555", 100)

    should("the winner be the buyer E with a price of 130 given the Example of the development Test") {
        val item = AuctionItem(sonyDiscman, mutableListOf())
        val buyerA = Buyer("A")
        val buyerB = Buyer("B")
        val buyerC = Buyer("C")
        val buyerD = Buyer("D")
        val buyerE = Buyer("E")

        item.placeBid(buyerA, 110, 130)
        item.placeBid(buyerB, null)
        item.placeBid(buyerC, 125)
        item.placeBid(buyerD, 105, 115, 90)
        item.placeBid(buyerE, 132, 135, 140)

        val auctionResult = VickreyAuctionAlgorithm().determineWinner(item)

        auctionResult shouldNotBe null
        auctionResult.bid shouldNotBe null
        auctionResult.bid.buyer shouldBe buyerE
        auctionResult.price shouldBe 130
        auctionResult.bid.price shouldBe 140
    }

    should("the winner be the one who placed the Bid given a unique Bid exceeding the reserve price") {
        val item = AuctionItem(sonyDiscman, mutableListOf())
        val buyerA = Buyer("A")

        item.placeBid(buyerA, 110, 130)

        val auctionResult = VickreyAuctionAlgorithm().determineWinner(item)

        auctionResult shouldNotBe null
        auctionResult.bid shouldNotBe null
        auctionResult.bid.buyer shouldBe buyerA
        auctionResult.price shouldBe 130
        auctionResult.bid.price shouldBe 130
    }

    should("be no winner given a unique Bid below the reserve price") {
        val item = AuctionItem(sonyDiscman, mutableListOf())
        val buyerA = Buyer("A")

        item.placeBid(buyerA, 80, 85, 95)

        shouldThrow<AuctionException> {
            //An exception is thrown because there is no Bid exceeding the reserve price
            VickreyAuctionAlgorithm().determineWinner(item)
        }
    }

    should("be the first buyer who places the highest bid as the winner in case of equality") {
        val item = AuctionItem(sonyDiscman, mutableListOf())
        val buyerA = Buyer("A")
        val buyerB = Buyer("B")
        val buyerC = Buyer("C")
        val buyerD = Buyer("D")
        val buyerE = Buyer("E")

        item.placeBid(buyerA, 110, 130)
        item.placeBid(buyerB, null)
        item.placeBid(buyerC, 125)
        item.placeBid(buyerD, 105, 115, 140)
        item.placeBid(buyerE, 132, 135, 140)

        val auctionResult = VickreyAuctionAlgorithm().determineWinner(item)

        auctionResult shouldNotBe null
        auctionResult.bid shouldNotBe null
        auctionResult.bid.buyer shouldBe buyerD
        auctionResult.price shouldBe 140
        auctionResult.bid.price shouldBe 140
    }
})