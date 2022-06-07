package com.lyw.batch.repay.mapper;

import com.lyw.batch.core.mapper.LineMapper;
import com.lyw.batch.repay.model.RepayHeader;
import com.lyw.batch.repay.model.RepayRecord;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RepayLineMapper implements LineMapper<RepayRecord, RepayHeader> {
    @Override
    public List<RepayRecord> mapper(List<String> lines) {
        List<RepayRecord> result = new ArrayList<>();
        for (String line : lines) {
            String[] splitItems = line.split(DEFAULT_SPLITTER);
            RepayRecord repayRecord = new RepayRecord();
            repayRecord.setIndex(splitItems[0]);
            repayRecord.setFinCustomerId(splitItems[1]);
            repayRecord.setOrgMerchant(splitItems[2]);
            repayRecord.setMercOrderNo(splitItems[3]);
            repayRecord.setMerchantId(splitItems[4]);
            repayRecord.setIsInitiative(splitItems[5]);
            repayRecord.setBorrowTransId(splitItems[6]);
            repayRecord.setRepayType(splitItems[7]);
            repayRecord.setTransAmount(new BigDecimal(splitItems[8]));
            repayRecord.setPeriods(splitItems[9]);
            repayRecord.setRepayCompleteTime(splitItems[10]);
            repayRecord.setBankCardNo(splitItems[11]);
            repayRecord.setExtCustomerId(splitItems[12]);
            repayRecord.setCurrency(splitItems[13]);
            repayRecord.setRepayDate(splitItems[14]);
            repayRecord.setAmount(new BigDecimal(splitItems[15]));
            result.add(repayRecord);
        }
        return result;
    }

    @Override
    public RepayHeader mapperHeader(List<String> lines) {
        String line = lines.get(0);
        String[] headerSplit = line.split(DEFAULT_SPLITTER);
        RepayHeader header = new RepayHeader();
        header.setLineType(headerSplit[0]);
        header.setRecordType(headerSplit[2]);
        header.setFileDate(headerSplit[3]);
        header.setTotalCount(Integer.parseInt(headerSplit[4]));
        header.setTotalAmount(new BigDecimal(headerSplit[5]));
        header.setNeedAmount(true);
        header.setNeedCount(true);
        return header;
    }
}
