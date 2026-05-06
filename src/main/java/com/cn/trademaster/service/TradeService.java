package com.cn.trademaster.service;

import com.cn.trademaster.dto.TradeDto;
import com.cn.trademaster.model.Trade;
import com.cn.trademaster.repository.TradeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TradeService {

    @Autowired
    private TradeRepo tradeRepo;

    // 1. Create logger object
    private static final Logger logger = LoggerFactory.getLogger(TradeService.class);

    public void executeTrade(TradeDto tradeDto) {
	    // Map TradeDto to Trade entity
	    Trade trade = new Trade();
	    trade.setStockId(tradeDto.getStockId());
	    trade.setStockName(tradeDto.getStockName());
	    trade.setStockHolderUserName(tradeDto.getStockHolderUserName());
	    trade.setQuantity(tradeDto.getQuantity());
	    trade.setPrice(tradeDto.getPrice());
	    // Use buyTrade directly
	    trade.setBuyTrade(tradeDto.isBuyTrade());

	    if (trade.getQuantity() > 1500) {
	        logger.error("Trade quantity {} exceeds allowed maximum of 1500 for user: {}. Trade not executed.",
	                     trade.getQuantity(), trade.getStockHolderUserName());
	        return;
	    }

	    logger.warn("Trade about to be executed. Please remember your unique username: {}", trade.getStockHolderUserName());

	    tradeRepo.save(trade);

	    logger.info("Trade executed successfully for user: {} and stock: {} with quantity: {}.",
	                trade.getStockHolderUserName(), trade.getStockName(), trade.getQuantity());
	}


    public List<Trade> getTradeHistory(String username) {
        // 1. Fetch trades by username
        List<Trade> tradesByUsername = tradeRepo.findByStockHolderUserName(username);

        // 2. Error-level log if no trades found
        if (tradesByUsername == null || tradesByUsername.isEmpty()) {
            logger.error("No trades found for user: {}", username);
        } else {
            // 3. Info-level log if trades found
            logger.info("Found {} trades for user: {}", tradesByUsername.size(), username);
        }
        // 4. Return the list
        return tradesByUsername;
    }
}
