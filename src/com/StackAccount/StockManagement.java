package com.StackAccount;

public class StockManagement {
    private String stockName;
    private String stockSymbol;
    private int numOfShares, sharePrice, totalValue;
    public StockManagement(String stockName, String stockSymbol, int numOfShares, int sharePrice,int totalValue)
    {    this.stockName=stockName;
        this.stockSymbol=stockSymbol;
        this.numOfShares=numOfShares;
        this.sharePrice=sharePrice;
        this.totalValue=totalValue;
    }
    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }
    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }
    public int getNumOfShares() {
        return numOfShares;
    }

    public void setNumOfShares(int numOfShares) {
        this.numOfShares = numOfShares;
    }

    public int getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(int sharePrice) {
        this.sharePrice = sharePrice;
    }

    public int getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(int totalValue) {
        this.totalValue = sharePrice*numOfShares;
    }
    @Override
    public String toString() {
        return "StockManagement { " +
                "stockName='" + stockName + '\'' +
                ", numOfShares=" + numOfShares +
                ", sharePrice=" + sharePrice +
                ", totalValue=" + totalValue +
                '}';
    }
}
