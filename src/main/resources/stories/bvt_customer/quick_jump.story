Narrative:
In order to validate the quick jump functionality
As a user
I want to assert all quick jump page codes

Meta:
@BVTQuickJump

Scenario:1 User logs in to Customer portal
Given user is logged in institution

Scenario:2 Validation of Quick Jump functionality
When user tries quick jump for page <code>
Then respective page <name> should be present

Examples:
|code|name|
|ISW008|Device Joining and Membership Fee Plan |
|DDPLN001|Dedupe Plan|
|CESL01|Country|
|CESM01|Institution|
|ISSS01|Business Calendar|
|ISSE01|Master Derivation Keys(MDK)|
|ISSH01|Device Keys|
|ISSBB0|Billing Cycle|
|ISSA01|Administrative|
|LOS002|Loyalty Plan|
|WLWLM001|White Listed Merchant Plan|
|IS0005|Device Event Based Fee Plan|
|MRKFP001|Markup Fee Plan|
|CESL02|State/Province|
|CESM02|Network|
|ISSS02|Holiday Configuration|
|ISSE02|Issuer Public Key (IPK) Certificate Information|
|ISSH02|Network Keys|
|ISSBPP|Payment Priority|
|ISSA02|Balance|
|LOS003|Promotion Plan|
|WLFEP001|Wallet Fee Plan|
|ISW011|Device Promotion Plan|
|STMSG001|Statement Message Plan|
|CESL03|Area/City|
|CESM03|Merchant Category Code|
|ISSS03|Cutover Profile|
|ISSBPB|Payment Bounce Reason|
|ISSA03|Unpaid|
|LOS004|Loyalty Plan  Promotion Mapping|
|MCGHLD01|MCG Additional Hold Plan|
|ISW009|Device Plan|
|MKMSG001|Marketing Message Plan|
|CESL04|Postal Code|
|CESM04|Currency|
|ISSS04|Network Membership|
|ISSBIC|Invalid Cheque Reason|
|ISSA04|Classification|
|LOS007|Event Based Loyalty Points|
|ISS001|Device Template|
|STPLN001|Prepaid Statement Plan|
|CESM05|System Parameters|
|ISSS05|Institution Currency|
|ISSBTR|Transaction Rule Plan|
|ISSA05|Internal Rating|
|LOS008|Gift/Reward Catalogue|
|MCGLP001|MCG Limit Plan|
|ISW003|Transaction Fee Plan|
|TXP001|Transaction Plan|
|CESM06|Transaction Type|
|ISSS06|Office|
|DISA02|Retrieval Response|
|DISA10|Arbitration|
|DISA11|Dispute History|
|DISA09|Manual Dispute Posting|
|DISA01|Retrieval Request|
|DISA03|Chargeback New|
|DISA04|Chargeback Modify|
|DISA05|Chargeback Reversal|
|DISA06|Second Chargeback New|
|DISA07|Second Chargeback Modify|
|DISA08|Second Chargeback Reversal|
|DISSR1|Retrieval Request Reason Code|
|DISSR2|Chargeback Reason Code|
|DISSR4|Arbitration Type|
|DISSR3|Re-Presentment Reason Code|
|ISERA2|Term|
|ISERA3|Auto Debit|
|ISAA0D|De-Dupe/SDN Verification|
|LOAE02|Event Based Loyalty Points Posting|
|ISW014|Fee Reason|
|ISTRA0S1|Transaction Search|
|ISATO2|Reversal Transaction|
|ISTRA0S2|Settled Transaction|
|ISTRA0S3|Unsettled Transaction|
|ISATPLC|Local Cheque|
|ISATPOCC|Outstation Cheque Collection|
|ISATPOCP|Outstation Cheque Processing|
|ISATPC|Cash|
|ISATO1|Adjustment Transaction|
|ISATO0|Other Transactions|
|ISAT38|Fraud Write Off|
|ISAS03|Stop List Bin|
|ISAS04|Stop List Country|
|ISAS01|Stop List Device|
|ISAS02|Stop List Device Range|
|ISAS07|Withdraw Bin|
|ISAS08|Withdraw Country|
|ISAS06|Withdraw Device Range|
|ISAS05|Withdraw Device|
|ISSADC|Document Checklist|
|ISSBMF|Business Mandatory Fields|
|ISSAF1|Variable Score|
|ISSAA1|Approval Score|
|ISSAR0|Risk Analysis Rule|
|ISSAW0|Workflow Rule|
|ISSACR|Credit Limit Rule|
|ISSAF0|Fixed Score|
|ISS025|SDN Verification Setup|
|OPRBAT01|Batch Process|
|ISSAC1|Create Corporate|
|ISOACC|Close Batch|
|ISOACS|Application Scoring|
|ISORCA|Risk Analysis|
|ISOACV|Credit Bureau Verification|
|AG0001|Courier Master|
|AG0002|Interest Master|
|AGAR01|Activity Reports|
|AGA001|Dispatch|
|AGA004|Order Cancellation|
|AGA003|Acceptance Of Returned Inventory|
|AGA002|Settlement Confirmation|
|ISAP0N|New Application|
|ISSAP0V|Verify|
|ISEAPS|Application Details|
|ISSAP0R|Incomplete Application|
|ISSAP0F|Refer|
|ISSAP0A|Approve/Reject|
|ISOCPG|Device Generation|
|ISE031|Application Batch Details|
|ISAC03|Stop Device Renewal|
|ISA004|Stoplist Device|
|ISSAC2|Update Client Details|
|ISAW01|Update Wallet Details|
|ISAC05|Stop Device Replace|
|ISAC07|Update Device Details|
|ISEDVS|Device Details|
|ISAV01|Fee Collection|
|ISSBIR|Interest Rate Plan|
|WALLP001|Wallet Plan|
|IS0009|Transaction Fee Waiver Plan|
|TXLP001|Transaction Limit Plan|
|ISSS07|Plastic Code|
|ISSBLP|Late Payment Fee Plan|
|WLPRP001|Wallet Promotion Plan|
|ISW013|Embossing,PIN and Priority Pass File Template|
|ISSS08|Picture Code|
|ISSBCP|Credit Plan|
|IS0002|Interest Calculation Plan|
|ISSP02|Country White List/Black List Plan|
|ISSS09|Device BIN|
|ISSS10|Device Status|
|ISSS11|Stoplist Reason|
|ISSS12|Account Type|
|PRMG001|Program|
|DVRNG001|Device Range|
|ISS016|3D E-Commerce Security Parameters|
|ISS017|Tax On Income|
|ISS018|Currency Exchange Rates Mapping|
|ISS019|Currency Exchange Rates|
|ISS020|Surcharge Plan|
|ISS021|Surcharge Waiver Plan|
|ISS022|Merchant Category Group (MCG)|
|ISS023|Vendor|
|ISS024|Embossing,PIN and Priority Pass File Name Parameter|
|SYS003|Audit Configuration|
|SYRP01|Screen Level|
|SYA001|Batch Definition|
|BLKDGN01|Bulk Device Generation Batch|
|BLKDRQ01|Device Production-Bulk Device Request|
|BATPRO01|Process Batches|
|BATPRO02|Batch Job History|
|PREPRD01|Pre-Production Batch|
|ISATC0|Card Fees|
|ISS026|Linking API to Institution|
|SERA01|Device Usage|
|MCCOVLM0|MCC Overlimit|
|ISSRM1|Transaction Routing|
|ISSRM2|Account Range Routing|
|CESM08|Interface|
|SERA02|Authorization Search|
|ISAA01|Request|
|ISAA02|Generate Reversal|
|ISAA03|Override|
|LOTYP001|Loan Type|
|LOPLN001|Loan Plan|
|EPPR001|Easy Pay Plan Rule|
|RTLS001|Loan Approval(Retail Transaction To Loan)|
|BATEPV|Easy Pay Plan Verification Batch|
|ISELAD|Loan Account Details|
|LOCAN001|Loan Cancellation|
|LOPC001|Loan Pre-Closure|
|ISEC01|Client Details|
|ISEW01|Wallet Details|
|HEA002|General|
|HEA001|Customer Care|
|HLPSEC|Service Code|
|HLPDYQ|Dynamic Quizzing|
|DEPRDC01|Device Production Cancellation|
|PINRE001|Pin Re Print|
|ISAD0N|New Device|
|PINPRD01|Pin Generation Batch|
|DEVPRD01|Device Production Batch|
|ISRC01|Batch Processing|
|HLPAPR|Assign Product|
|HLPASR|Assign Service Code|
|ISSF05|Miscellaneous  Fee|
|ISAC04|Replace / Upgrade Device|
|ISRC04|Stop List|
|ISBR01|Billing Reports|
|ISSS25|Transaction Registration|
|HEAS01|Forwarded|
|HEAS02|Escalation - I|
|HEAS03|Escalation - II|
|HEAS04|Service Request|
|DISA12|Chargeback Cancellation|
|ADS007|Reset Password|
|ISEC02|Client Portfolio|
|CESM12|Supported Languages|
|CESM13|Institution Languages|
|CESE01|Batch Job History|
|ISAV03|Initiate Visa Money Transfer|
|ISAV02|Fraud Notification - TC40|
|ISAM04|Add Mpe|
|ISAV05|VISA Bin Range|
|ISAM03|Account File|
|ISAV04|Exception File Message|
|ISAM06|Safe Update|
|ISAM01|Fee Collection|
|ISSEA3|Event/Alert History|
|ISSEA2|Manual Alerts|
|ISSGC01|Gateway Configuration|
|ISSEA1|Event & Alerts|
|ISREA1|Application|
|ISRC02|Event & Alert|
|ISSR01|High Risk Country|
|ISSR02|High Risk MCC|
|ISSR03|High Risk MCG|
|ISSR04|High Risk Merchant Location|
|ADS001|Role|
|ADS002|User|
|ADS004|Report Level|
|ADS005|Batch Level|
|ADS008|Operational Inquiry|
|ADS009|Authentication Inquiry|
|ADS011|Enable Maker Checker|
|CHRE02|Disputes Management Report|
|LORE02|Redemption|
|SYRE02|User Management Report|
|LOAE03|Reward Redemption|
|ADS012|User Groups|
|ISSS14|Program Change Scheme|
|EPPR002|Program Change Rule|
|LOYP00|Loyalty Points|
|ISAC12|Carrier Acknowledgement|
|BATPRO03|Collection Batch Process|
|CESM09|System Codes|
|ISAC08|Device Tracking|
|ISREV1|Device Activity|
|ISRET0|Transaction Reports|
|ISRER0|RAMP Report|
|ISRCO1|Compliance Reports|
|ISRCR0|Corporate Reports|
|ISRFR0|Financial Reports|
|CERPC0|Batch Processing Reports|
|ISREM0|EMI Reports|
|HERE01|Help Desk Reports|
|CEROTHR|Other Reports|
|ISTRA0S4|Visa Fraud Notification|
|DISA14|Second Chargeback Cancellation|
|RPINPROD|Resend PIN Request|
|ISSP03|Currency Black List Plan|
|ISSD03|MCC Rules|
|ISERA1|Navigation|
|SERA03|Batch Trace History|
|LOS009|Loyalty Transaction Plan|
|ISSBGL|GL Account Head|
|ISAC0P|Receive From  Personalisation Vendor|
|ISACR0|Re-Send To Personalization Vendor|
|ISACS0|Send To Carrier|
|ISSAC3|Update Client Events|
|ISAR03|File Upload Message|
|CARRVCM|RuPay VIP Card Management|
|FTODWN01|Client Photo/Flat File Download Batch|
|ISSS17|Institution Domestic Country|
|ISSS18|Institution Cross Currency Mapping|
|ISSGS1|Institution States|
|ISSGS3|Add Fee Type|
|ISSGS2|GST Rates|
|CESM00|Processing Center|
|CESM10|Applicable Institution|
|ISSS19|Dump Configuration|
|ISSP04|Currency Payout List Plan|
|ISLOUR|Loan Offer Reports|
|ISAMT0|MID/TID Blocking|
|HLPSRV|Assign Program|
|HLPCTC|Call Tagging|
|PINRPR01|Pin Re Print Batch|
|ISSPGL|GL Account Head|
|ISCIB1|CIBIL Configuration|
|ISSS20|CoBrand Partner|
|SYA005|Batch Alert Configuration|
|ISATLA|Approve|
|ISATLR|Request|
|ISST01|Statement Reprint|
|ISSS26|Multi-Currency Transaction Posting Method|
|ISSRM3|Channel Routing Plan|
|CESM14|Customization Checklist|
|ISSS014|RuPay Settlement BIN|
|ISSHA1|Account Head|
|ISSHA2|Account Master|
|ISSHA3|Account Head Mapping|
|CARPMFCD|Member Fund Collection and Fund Disbursement|
|CARPBMFU|RuPay BIN Range|
|TSPG001|Travel Type Configuration|
|TSPG002|Travel Limit Detail|
|ISSS015|Aggregate Load Limits|
|CESM11|Statement Template Image|
|ISSS21|Statement Template|
|BLKTMP01|TAM User Creation|
|ISSS016|Credit transactions for load|
|UFEG002|Unspent Foreign Exchange|
|HEAS05|Approve Cardholder Replace Request|
|SYRE03|Audit Report|
|ISAA05|Refund|
|ISSS16|Sanction Score|
|ADS003|Report Definition|
|ADS006|Cardholder Portal Menu Config|
|SERA04|Report Job History|
|ISSS27|Institution Load Currency|
|ISSS15|System Codes|
|ISSH03|PINSet Keys|
|ISAX01|Exception File Message|
|ISSGC02|Gateway Configuration|
|HEAS06|Force Process|
|MSVPLN01|Mastercard Send (OI) Validation Plan|
|ISS027|Online PIN Set Configuration|

Scenario:3 User logs out from Customer portal
When user sign out from customer portal