package com.example.auction.item.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.pcollections.PSet;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

/**
 * An item entity.
 */
public final class Item {

    // null fields are temporarily null because they aren't implemented yet
    private final UUID id;
    private final UUID creator;
    private final String title;
    private final String description;
    private final UUID categoryId = null;
    private final String currencyId;
    private final Location location = null;
    private final int increment;
    private final int reservePrice;
    private final PSet<DeliveryOption> deliveryOptions = null;
    private final PSet<PaymentOption> paymentOptions = null;
    private final int price;
    private final ItemStatus status;
    private final Duration auctionDuration;
    private final Optional<Instant> auctionStart;
    private final Optional<Instant> auctionEnd;
    private final Optional<UUID> auctionWinner;

    /**
     * Constructor that Jackson uses when deserialising items.
     */
    @JsonCreator
    private Item(Optional<UUID> id, UUID creator, String title, String description, String currencyId,
            int increment, int reservePrice, Optional<Integer> price, Optional<ItemStatus> status, Duration auctionDuration,
            Optional<Instant> auctionStart, Optional<Instant> auctionEnd, Optional<UUID> auctionWinner) {
        this.id = id.orElse(null);
        this.creator = creator;
        this.title = title;
        this.description = description;
        this.currencyId = currencyId;
        this.increment = increment;
        this.reservePrice = reservePrice;
        this.price = price.orElse(0);
        this.status = status.orElse(null);
        this.auctionDuration = auctionDuration;
        this.auctionStart = auctionStart;
        this.auctionEnd = auctionEnd;
        this.auctionWinner = auctionWinner;
    }

    /**
     * Constructor to use when creating new items.
     */
    public Item(UUID creator, String title, String description, String currencyId,  int increment, int reservePrice,
            Duration auctionDuration) {
        this(Optional.empty(), creator, title, description, currencyId, increment, reservePrice, Optional.empty(),
                Optional.empty(), auctionDuration, Optional.empty(), Optional.empty(), Optional.empty());
    }

    public Item(UUID id, UUID creator, String title, String description, String currencyId, int increment, int reservePrice, int price,
            ItemStatus status, Duration auctionDuration, Optional<Instant> auctionStart, Optional<Instant> auctionEnd,
            Optional<UUID> auctionWinner) {
        this.id = id;
        this.creator = creator;
        this.title = title;
        this.description = description;
        this.currencyId = currencyId;
        this.increment = increment;
        this.reservePrice = reservePrice;
        this.price = price;
        this.status = status;
        this.auctionDuration = auctionDuration;
        this.auctionStart = auctionStart;
        this.auctionEnd = auctionEnd;
        this.auctionWinner = auctionWinner;
    }

    public UUID getId() {
        return id;
    }

    public UUID getCreator() {
        return creator;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public int getIncrement() {
        return increment;
    }

    public int getReservePrice() {
        return reservePrice;
    }

    public int getPrice() {
        return price;
    }

    public ItemStatus getStatus() {
        return status;
    }

    public Duration getAuctionDuration() {
        return auctionDuration;
    }

    public Optional<Instant> getAuctionStart() {
        return auctionStart;
    }

    public Optional<Instant> getAuctionEnd() {
        return auctionEnd;
    }

    public Optional<UUID> getAuctionWinner() {
        return auctionWinner;
    }
}
