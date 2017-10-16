package com.mastercard.pts.integrated.issuing.soap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class APITransactions {
	final Logger logger = LoggerFactory.getLogger(APITransactions.class);

	public String transactionType(String transaction)

	{
		String transactionCode = null;

		switch (transaction)

		{
		case "Purchase":
			transactionCode = "01";
			break;
		case "Cash Advance/Cash Out":
			transactionCode = "03";
			break;
		case "Transfer Debit":
			transactionCode = "TD";
			break;
		case "Transfer Credit":
			transactionCode = "TC";
			break;
		case "Initial Load":
			transactionCode = "IL";
			break;
		case "Reload":
			transactionCode = "LC";
			break;
		case "Reversal Void":
			transactionCode = "09";
			break;

		case "Transaction Fees":
			transactionCode = "22";
			break;
		case "Pin Change":
			transactionCode = "88";
			break;
		case "P2P Transfer":
			transactionCode = "PP";
			break;
		default:
			logger.info("No tag to update");
		}
		return transactionCode;
	}

}
