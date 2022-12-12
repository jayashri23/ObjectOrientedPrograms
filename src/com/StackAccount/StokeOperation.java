package com.StackAccount;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StokeOperation {
    static List<StockManagement> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    public double valueOf() {
        System.out.println(" Current Balance is : " + Account.getBalance());
        return Account.getBalance();
    }
    public StockManagement findStock(String symbol) {
        for (StockManagement temp : list) {
            if (temp.getStockSymbol().equalsIgnoreCase(symbol)) {
                return temp;
            }
        }
        return null;
    }
    public StockManagement createStockData(String symbol) {

        System.out.println("Enter the stock name");
        String stockName = sc.next();
        System.out.println("Enter no of shares");
        int numOfShares = sc.nextInt();
        System.out.println("Enter price of each share");
        int sharePrice = sc.nextInt();
        int totalvalue=sharePrice*numOfShares;
        System.out.println("Total Value of ecah stock: "+totalvalue);
        StockManagement obj = new StockManagement(stockName, symbol, numOfShares, sharePrice,totalvalue);
        list.add(obj);
        return obj;
    }
    public StockManagement sellStockData(String symbol) {
        System.out.println("Enter the stock name");
        String stockName = sc.next();
        int numOfShares = 0;
        System.out.println("Enter price of each share");
        int sharePrice = sc.nextInt();
        int totalvalue=numOfShares*sharePrice;
        System.out.println("total value sell stock: "+totalvalue);
        StockManagement obj = new StockManagement(stockName, symbol, numOfShares, sharePrice,totalvalue);
        list.add(obj);
        return obj;
    }
    public void buy(int amount, String symbol) {
        if (amount > Account.getBalance()) {
            System.out.println("Insufficient fund");
            return;
        }

        StockManagement stock = findStock(symbol);

        if (stock == null) {
            stock = createStockData(symbol);
        }
        int quantity = (amount / stock.getSharePrice());
        if (quantity < stock.getNumOfShares()) {
            System.out.println("Buying shares on : " + dateGenerator());
            stock.setNumOfShares(stock.getNumOfShares() - quantity);
            stock.setTotalValue(stock.getSharePrice() * stock.getNumOfShares());
            double debitValue = quantity * stock.getSharePrice();
            Account.debit(debitValue);
        } else {
            System.out.println("Insufficient");
        }
    }
    public void sell(int amount, String symbol) {
        StockManagement stock = findStock(symbol);

        if (stock == null) {
            stock = sellStockData(symbol);
        }

        int quantity = (amount / stock.getSharePrice());
        System.out.println("Selling shares on : " + dateGenerator());
        stock.setNumOfShares(stock.getNumOfShares() + quantity);
        stock.setTotalValue(stock.getSharePrice() * stock.getNumOfShares());
        double creditValue = stock.getSharePrice() * quantity;
        Account.credit(creditValue);
    }

    public String dateGenerator() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }
    public void printStockData() {
        if (!list.isEmpty()) {
            for (StockManagement stock : list) {
                System.out.println(stock);
            }
        } else {
            System.out.println("list empty.");
        }
    }
}
