#sql积累
1.  暗示走索引  
```sql
SELECT /*+index(t,IX_FTS_TRANS_CRATE_TIME)*/
   		count(1) as total_count,
   		nvl(sum(t.trans_amt), 0) total_amt
   		from FTSDATA.T_FTS_TRANSACTION t
   		WHERE
           CREATE_TIME >= TO_DATE(20181030000000,'YYYYMMDDHH24MISS')
```
2. having
```sql
SELECT customer_id, COUNT(customer_id) FROM t_fis_user_account  GROUP BY customer_id HAVING COUNT(customer_id) > 1 GROUP BY customer_id
```
3. 创建seq并创建同义词
```sql
CREATE SEQUENCE SEQ_T_CIS_A_APPLICATION
  MINVALUE 1
  MAXVALUE 99999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 400
  NOORDER
  CYCLE;

CREATE SYNONYM CISOPR.SEQ_T_CIS_A_APPLICATION FOR CISDATA.SEQ_T_CIS_A_APPLICATION;

GRANT SELECT ON SEQ_T_CIS_A_APPLICATION TO R_CISDATA_DML;
```
