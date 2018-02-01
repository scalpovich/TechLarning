Insert into SECURE_NET_CRYPTOGRAM_3DES (BANK_CODE,NETCR_FIELD,NETCR_SEC_NET,NETCR_KEY_INDEX,NETCR_KEYTYP,NETCR_KEYTR_INDEX,NETCR_CRYPTO,NETCR_KCHK_VALUE,USER_CREATE,DATE_CREATE,USER_MODIF,DATE_MODIF,USER_DELETE,DATE_DELETE,TERMINAL_IP,TERMINAL_NAME,RECORD_SOURCE_ID,CHANNEL,NETCR_CRDATE,NETCR_CRSTATE,NETCR_BANKCODE) 
values ('121212','03','01','00','4','00','80F5706D510BF6F7D54D6DA3053CAB8A','2A7944',null,to_date('05-DEC-16','DD-MON-RR'),'Rohan',to_date('30-MAR-17','DD-MON-RR'),null,null,'172.27.137.195','wjb4stl350','ISSH02','WBO','2016110806390700','0',null);

Insert into SECURE_NET_CRYPTOGRAM_3DES (BANK_CODE,NETCR_FIELD,NETCR_SEC_NET,NETCR_KEY_INDEX,NETCR_KEYTYP,NETCR_KEYTR_INDEX,NETCR_CRYPTO,NETCR_KCHK_VALUE,USER_CREATE,DATE_CREATE,USER_MODIF,DATE_MODIF,USER_DELETE,DATE_DELETE,TERMINAL_IP,TERMINAL_NAME,RECORD_SOURCE_ID,CHANNEL,NETCR_CRDATE,NETCR_CRSTATE,NETCR_BANKCODE) 
values ('121212','04','01','00','4','00','80F5706D510BF6F7D54D6DA3053CAB8A','2A7944',null,to_date('05-DEC-16','DD-MON-RR'),'Rohan',to_date('30-MAR-17','DD-MON-RR'),null,null,'172.27.137.195','wjb4stl350','ISSH02','WBO','2016110806390700','0',null);

Insert into SECURE_BIN (BANK_CODE,BINCR_BIN_INF,BINCR_BIN_SUP,BINCR_CARDTYP,BINCR_PINGENMODE,BINCR_OFFSETMETHOD,BINCR_OFFSETPVV,BINCR_PVVLEN,BINCR_IS_PVKI,BINCR_OFFSETPVKI,BINCR_PVKIVALUE,BINCR_MIN_PINLG,BINCR_MAX_PINLG,BINCR_HEXDECIMIBM,BINCR_INDEXFLDBLD,BINCR_TABPTRDBLD,BINCR_ALG_NUMDBLD,BINCR_IS_CV,BINCR_CV_CTL,BINCR_OFFSETCVV,BINCR_CVK_A,BINCR_KCHK_VALUE_A,BINCR_CVK_B,BINCR_KCHK_VALUE_B,BINCR_PINVALDATA,ACB_MASTER_FLAG,SW_CVV,USER_CREATE,DATE_CREATE,USER_MODIF,DATE_MODIF,USER_DELETE,DATE_DELETE,PAY_PASS_WAVE_KEY,PAY_PASS_WAVE_KCHK,BINCR_IS_PVK_DATA,BINCR_IS_PIN_DATA,RECORD_SOURCE_ID,CHANNEL,TERMINAL_IP,TERMINAL_NAME,KEY_DERIV_METHOD,BINCR_IS_CVV3,ATC_OFFSET_ON_TRACK_II,ATC_LENGTH,UN_OFFSET_ON_TRACK_II,UN_LENGTH,CVC3_OFFSET_ON_TRACK_II,CVC3_LENGTH)
values ('121212','5887650000','5887659999','3','3','3',10,4,'1',15,1,'04','12','1234567890123456','1','001','01','1','1',16,'4A43436017024880','0EBBE7','B4638CBCEC1E6E52','985BDD','012345678901N','N','N','Admin',to_date('22-NOV-16','DD-MON-RR'),'rajeev',to_date('01-MAR-17','DD-MON-RR'),null,null,'7B634E89DB88BBD9BB33C702FD1C9151','42E3FF','1','1','ISSH01','WBO','172.27.139.46','ecs0bom10',null,'1',10,null,16,null,20,null);


Insert into SECURE_BIN_PVK (BANK_CODE,PVK_BIN_INF,PVK_I,PVK,PVK_KCHK_VALUE,USER_CREATE,DATE_CREATE,USER_MODIF,DATE_MODIF,USER_DELETE,DATE_DELETE,TERMINAL_IP,TERMINAL_NAME,RECORD_SOURCE_ID,CHANNEL)
values ('121212','5887650000','1','181CFD03C3F7385FCA36BF63DDD4BD01','829DD2','ISSDEV10',to_date('05-DEC-16','DD-MON-RR'),'ISSDEV10',to_date('01-MAR-17','DD-MON-RR'),null,null,'172.27.139.46','ecs0bom10','ISSH01','WBO');


Insert into SECURE_BIN (BANK_CODE,BINCR_BIN_INF,BINCR_BIN_SUP,BINCR_CARDTYP,BINCR_PINGENMODE,BINCR_OFFSETMETHOD,BINCR_OFFSETPVV,BINCR_PVVLEN,BINCR_IS_PVKI,BINCR_OFFSETPVKI,BINCR_PVKIVALUE,BINCR_MIN_PINLG,BINCR_MAX_PINLG,BINCR_HEXDECIMIBM,BINCR_INDEXFLDBLD,BINCR_TABPTRDBLD,BINCR_ALG_NUMDBLD,BINCR_IS_CV,BINCR_CV_CTL,BINCR_OFFSETCVV,BINCR_CVK_A,BINCR_KCHK_VALUE_A,BINCR_CVK_B,BINCR_KCHK_VALUE_B,BINCR_PINVALDATA,ACB_MASTER_FLAG,SW_CVV,USER_CREATE,DATE_CREATE,USER_MODIF,DATE_MODIF,USER_DELETE,DATE_DELETE,PAY_PASS_WAVE_KEY,PAY_PASS_WAVE_KCHK,BINCR_IS_PVK_DATA,BINCR_IS_PIN_DATA,RECORD_SOURCE_ID,CHANNEL,TERMINAL_IP,TERMINAL_NAME,KEY_DERIV_METHOD,BINCR_IS_CVV3,ATC_OFFSET_ON_TRACK_II,ATC_LENGTH,UN_OFFSET_ON_TRACK_II,UN_LENGTH,CVC3_OFFSET_ON_TRACK_II,CVC3_LENGTH)
values ('121212','5897650000','5897659999','3','3','3',10,4,'1',15,1,'04','12','1234567890123456','1','001','01','1','1',16,'4A43436017024880','0EBBE7','B4638CBCEC1E6E52','985BDD','012345678901N','N','N','Admin',to_date('22-NOV-16','DD-MON-RR'),'rajeev',to_date('01-MAR-17','DD-MON-RR'),null,null,'7B634E89DB88BBD9BB33C702FD1C9151','42E3FF','1','1','ISSH01','WBO','172.27.139.46','ecs0bom10',null,'1',10,null,16,null,20,null);

commit;


Insert into SECURE_BIN_PVK (BANK_CODE,PVK_BIN_INF,PVK_I,PVK,PVK_KCHK_VALUE,USER_CREATE,DATE_CREATE,USER_MODIF,DATE_MODIF,USER_DELETE,DATE_DELETE,TERMINAL_IP,TERMINAL_NAME,RECORD_SOURCE_ID,CHANNEL)
values ('121212','5897650000','1','181CFD03C3F7385FCA36BF63DDD4BD01','829DD2','ISSDEV10',to_date('05-DEC-16','DD-MON-RR'),'ISSDEV10',to_date('01-MAR-17','DD-MON-RR'),null,null,'172.27.139.46','ecs0bom10','ISSH01','WBO');


Insert into SECURE_BIN (BANK_CODE,BINCR_BIN_INF,BINCR_BIN_SUP,BINCR_CARDTYP,BINCR_PINGENMODE,BINCR_OFFSETMETHOD,BINCR_OFFSETPVV,BINCR_PVVLEN,BINCR_IS_PVKI,BINCR_OFFSETPVKI,BINCR_PVKIVALUE,BINCR_MIN_PINLG,BINCR_MAX_PINLG,BINCR_HEXDECIMIBM,BINCR_INDEXFLDBLD,BINCR_TABPTRDBLD,BINCR_ALG_NUMDBLD,BINCR_IS_CV,BINCR_CV_CTL,BINCR_OFFSETCVV,BINCR_CVK_A,BINCR_KCHK_VALUE_A,BINCR_CVK_B,BINCR_KCHK_VALUE_B,BINCR_PINVALDATA,ACB_MASTER_FLAG,SW_CVV,USER_CREATE,DATE_CREATE,USER_MODIF,DATE_MODIF,USER_DELETE,DATE_DELETE,PAY_PASS_WAVE_KEY,PAY_PASS_WAVE_KCHK,BINCR_IS_PVK_DATA,BINCR_IS_PIN_DATA,RECORD_SOURCE_ID,CHANNEL,TERMINAL_IP,TERMINAL_NAME,KEY_DERIV_METHOD,BINCR_IS_CVV3,ATC_OFFSET_ON_TRACK_II,ATC_LENGTH,UN_OFFSET_ON_TRACK_II,UN_LENGTH,CVC3_OFFSET_ON_TRACK_II,CVC3_LENGTH)
values ('121212','5877650000','5877659999','3','3','3',10,4,'1',15,1,'04','12','1234567890123456','1','001','01','1','1',16,'4A43436017024880','0EBBE7','B4638CBCEC1E6E52','985BDD','012345678901N','N','N','Admin',to_date('22-NOV-16','DD-MON-RR'),'rajeev',to_date('01-MAR-17','DD-MON-RR'),null,null,'7B634E89DB88BBD9BB33C702FD1C9151','42E3FF','1','1','ISSH01','WBO','172.27.139.46','ecs0bom10',null,'1',10,null,16,null,20,null);


Insert into SECURE_BIN_PVK (BANK_CODE,PVK_BIN_INF,PVK_I,PVK,PVK_KCHK_VALUE,USER_CREATE,DATE_CREATE,USER_MODIF,DATE_MODIF,USER_DELETE,DATE_DELETE,TERMINAL_IP,TERMINAL_NAME,RECORD_SOURCE_ID,CHANNEL)
values ('121212','5877650000','1','181CFD03C3F7385FCA36BF63DDD4BD01','829DD2','ISSDEV10',to_date('05-DEC-16','DD-MON-RR'),'ISSDEV10',to_date('01-MAR-17','DD-MON-RR'),null,null,'172.27.139.46','ecs0bom10','ISSH01','WBO');






