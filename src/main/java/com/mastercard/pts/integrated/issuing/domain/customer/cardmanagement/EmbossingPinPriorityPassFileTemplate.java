package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmbossingPinPriorityPassFileTemplate {

	private String templateCode;
	private String description;
	private String fileType;

	List<RecordFieldFormat> recordField;

	List<OrderByFormat> orderByFormat;

	public List<RecordFieldFormat> getRecordField() {
		return recordField;
	}

	public void setRecordField(List<RecordFieldFormat> recordField) {
		this.recordField = recordField;
	}

	public List<OrderByFormat> getOrderByFormat() {
		return orderByFormat;
	}

	public void setOrderByFormat(List<OrderByFormat> orderByFormat) {
		this.orderByFormat = orderByFormat;
	}

	public String getTemplateCode() {
		return templateCode;
	}

	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public static class RecordFieldFormat {
		private String field;
		private String value;
		private String length;
		private static final String FILLER = "FILLER [FILLER]";

		public String getLength() {
			return length;
		}

		public void setLength(String length) {
			this.length = length;
		}

		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		private static List<RecordFieldFormat> createDataWithRecordFieldPin() {
			List<RecordFieldFormat> recordFieldPin = new ArrayList<>();
			
			
			String[] recFPin1 = { FILLER,"1", ">" };
			
			String[] recFPin2 = { FILLER,"1", ">" };
			
			String[] recFPin3 = { FILLER,"1", ">" };
			
			
			String[] recFPin4 = { "PACK_ID [PACK_ID]","24", "" };
			
			String[] recFPin5 = { "PIN_OFFSET [[PIN_OFFSET]]","16", "" };
			
			String[] recFPin6 = { "CARD_NUMBER [CARD_NUMBER]","24", "" };
			
			String[] recFPin7 = { "UNIQUE_REFERENCE_NUMBER [UNIQUE_REFERENCE_NUMBER]","15", "" };

			List<String[]> data = Arrays.asList(recFPin1, recFPin2, recFPin3, recFPin4,recFPin5,recFPin6,recFPin7);
			
               for(String [] record: data )
               {
            	RecordFieldFormat recFieldFormat = new RecordFieldFormat();
       			recFieldFormat.setField(record[0]);
       			recFieldFormat.setLength(record[1]);
       			recFieldFormat.setValue(record[2]);
        		recordFieldPin.add(recFieldFormat);
               }

			return recordFieldPin;

		}

		public static List<RecordFieldFormat> createDataWithRecordFieldPass() {

			List<RecordFieldFormat> recordFieldPass = new ArrayList<>();

			String[] rFFP1 = { "PRIORITY PASS NUMBER [PRIORITY_PASS_NUMBER]",
					"14", "" };

			String[] rFFP2 = {
					"PRIORITY PASS EXPIRY DATE [PRIORITY_PASS_EXPIRY_DATE]",
					"4", "" };

			String[] rFFP3 = {
					"PRIORITY PASS CARD NO STATUS [PRIORITY_PASS_CARD_NO_STATUS]",
					"1", "" };

			String[] rFFP4 = { "CARD HOLDER NAME [FIRST_NAME]", "26", "" };

			List<String[]> data = Arrays.asList(rFFP1, rFFP2, rFFP3, rFFP4);

			for (String[] record : data) {
				RecordFieldFormat recFieldFormatPass = new RecordFieldFormat();
				recFieldFormatPass.setField(record[0]);
				recFieldFormatPass.setLength(record[1]);
				recFieldFormatPass.setValue(record[2]);
				recordFieldPass.add(recFieldFormatPass);
			}

			return recordFieldPass;
		}

		public static List<RecordFieldFormat> createDataWithRecordFieldEmbossing() {

			List<RecordFieldFormat> recordFieldEmbossingData = new ArrayList<>();

			String[] rFEMB11 = { FILLER, "1", "|" };

			String[] rFEMB12 = { FILLER, "1", "|" };

			String[] rFEMB13 = { FILLER, "1", "|" };

			String[] rFEMB14 = { "PVV [[PVV]]", "4", "" };

			String[] rFEMB15 = { "PVKI [[PVKI]]", "1", "" };

			String[] rFEMB16 = { "CVV2 [[CVV2]]", "3", "" };
			String[] rFEMB17 = { "CARD NUMBER [DEVICE_NUMBER]", "19", "" };
			String[] rFEMB18 = { "CVV [[CVV]]", "3", "" };

			String[] rFEMB19 = { "SERVICE CODE [SERVICE_CODE]", "3", "" };
			String[] rFEMB110 = { FILLER, "1", "|" };
			String[] rFEMB111 = { FILLER, "1", "|" };

			String[] rFEMB112 = { "EXPIRY DATE (MMYY) [EXPIRY_DATE]", "4", "" };
			String[] rFEMB113 = { FILLER, "1", "|" };
			String[] rFEMB114 = { "ICVV [[ICVV]]", "3", "" };

			String[] rFEMB115 = { FILLER, "1", "|" };
			String[] rFEMB116 = { FILLER, "1", "|" };
			String[] rFEMB117 = { "SEQUENCE_NUMBER [SEQUENCE_NUMBER]", "6", "" };

			List<String[]> data = Arrays.asList(rFEMB11, rFEMB12, rFEMB13,
					rFEMB14, rFEMB15, rFEMB16, rFEMB17, rFEMB18, rFEMB19,
					rFEMB110, rFEMB111, rFEMB112, rFEMB113, rFEMB114, rFEMB115,
					rFEMB116, rFEMB117);

			for (String[] record : data) {
				RecordFieldFormat recFieldFormatEmbossing = new RecordFieldFormat();
				recFieldFormatEmbossing.setField(record[0]);
				recFieldFormatEmbossing.setLength(record[1]);
				recFieldFormatEmbossing.setValue(record[2]);
				recordFieldEmbossingData.add(recFieldFormatEmbossing);

			}

			return recordFieldEmbossingData;
		}

	}

	public static class OrderByFormat {
		private String field;
		private String priority;

		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}

		public String getPriority() {
			return priority;
		}

		public void setPriority(String priority) {
			this.priority = priority;
		}

		public static List<OrderByFormat> embossingOrderByFormatData() {
			List<OrderByFormat> embossingFormatData = new ArrayList<>();

			String[] embOrdF1 = { "VIP FLAG [VIP_FLAG]", "5"};
			
			String[] embOrdF2 = { "PRODUCT TYPE [PRODUCT_TYPE]", "3" };
			
			String[] embOrdF3 = { "PROGRAM CODE [PROGRAM_CODE]", "4" };
			
			List<String[]> data = Arrays.asList(embOrdF1, embOrdF2, embOrdF3);
			
			for(String[] record : data)
			{
			OrderByFormat orderByFormat = new OrderByFormat();
			orderByFormat.setField(record[0]);
			orderByFormat.setPriority(record[1]);
			embossingFormatData.add(orderByFormat);
			}
			

			return embossingFormatData;

		}

		public static List<OrderByFormat> priorityPassOrderByFormatData() {
			List<OrderByFormat> priorityPassFormatData = new ArrayList<>();
			
			
         	String[] prPOrdF1 = { "PRODUCT TYPE [PRODUCT_TYPE]", "4"};
			
			String[] prPOrdF2 = { "CARD PACK ID [CARD_PACK_ID]", "1" };
			
			String[] prPOrdF3 = { "PROGRAM CODE [PROGRAM_CODE]", "3" };
			
			String[] prPOrdF4 = { "CARD NUMBER [DEVICE_NUMBER]", "2" };
			
			List<String[]> data = Arrays.asList(prPOrdF1, prPOrdF2, prPOrdF3,prPOrdF4);
			
			for(String [] record : data)
			{

			OrderByFormat orderByFormat = new OrderByFormat();
			orderByFormat.setField(record[0]);
			orderByFormat.setPriority(record[1]);
			priorityPassFormatData.add(orderByFormat);
			}
			

			return priorityPassFormatData;
		}

		public static List<OrderByFormat> pinOrderByFormatData() {
			List<OrderByFormat> pinFormatData = new ArrayList<>();

			OrderByFormat orderByFormat = new OrderByFormat();
			orderByFormat.setField("CARD PACK ID [CARD_PACK_ID]");
			orderByFormat.setPriority("1");
			pinFormatData.add(orderByFormat);
			return pinFormatData;

		}

	}

	public static List<EmbossingPinPriorityPassFileTemplate> createDataWithProvider() {
		List<EmbossingPinPriorityPassFileTemplate> dataProvider = new ArrayList<>();

		EmbossingPinPriorityPassFileTemplate autoPinOff = new EmbossingPinPriorityPassFileTemplate();
		autoPinOff.setTemplateCode("AUTOPINOFF");
		autoPinOff.setDescription("Automation Pin File Template");
		autoPinOff.setFileType("PIN File Template [O]");
		autoPinOff.setRecordField(RecordFieldFormat
				.createDataWithRecordFieldPin());
		autoPinOff.setOrderByFormat(OrderByFormat.pinOrderByFormatData());
		dataProvider.add(autoPinOff);

		EmbossingPinPriorityPassFileTemplate autoprPass = new EmbossingPinPriorityPassFileTemplate();
		autoprPass.setTemplateCode("AUTOPRPASS");
		autoprPass.setDescription("Automation Priority Pass File Template");
		autoprPass.setFileType("Priority Pass Template [P]");
		autoprPass.setRecordField(RecordFieldFormat
				.createDataWithRecordFieldPass());
		autoprPass.setOrderByFormat(OrderByFormat
				.priorityPassOrderByFormatData());
		dataProvider.add(autoprPass);

		EmbossingPinPriorityPassFileTemplate autoEmboss = new EmbossingPinPriorityPassFileTemplate();
		autoEmboss.setTemplateCode("AUTOEMBOSS");
		autoEmboss.setDescription("Automation Embossing File Template");
		autoEmboss.setFileType("Embossing File Template [E]");
		autoEmboss.setRecordField(RecordFieldFormat
				.createDataWithRecordFieldEmbossing());
		autoEmboss.setOrderByFormat(OrderByFormat.embossingOrderByFormatData());
		dataProvider.add(autoEmboss);

		return dataProvider;

	}

}
