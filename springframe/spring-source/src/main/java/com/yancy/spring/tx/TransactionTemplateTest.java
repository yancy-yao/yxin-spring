package com.yancy.spring.tx;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.math.BigDecimal;

/**
 * Created by yancy on 2017/11/22.
 */
public class TransactionTemplateTest {

    public void test(){
        TransactionTemplate txTemplate = new TransactionTemplate();
        Object result = txTemplate.execute(new TransactionCallback() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                Object result = null;
                //各种事务操作
                return result;
            }
        });

        txTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                //事务操作1
                //事务操作2
                //...
            }
        });

        //资金从一个账户转到两个账户（一个主账户，一个备用账户），如果向主账户转账失败，则金额转入备用账户。
        /*txTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus txStatus) {
                BigDecimal transferAmount = new BigDecimal("2000");
                try{
                    withdraw("WITHDRAW_ACCOUNT_ID", transferAmount);
                    Object savePointBeforeDeposit = txStatus.createSavepoint();
                    try{
                        deposit("MAIN_ACCOUNT_ID", transferAmount);
                    } catch (DepositException ex) {
                        logger.warn("");
                        txStatus.rollbackToSavepoint(savePointBeforeDeposit);

                        deposit("SECONDARY_ACCOUNT_ID", transferAmount);
                    }finally {
                        txStatus.releaseSavepoint(savePointBeforeDeposit);
                    }
                } catch (TransferException e) {

                    txStatus.setRollbackOnly();
                }
            }
        });*/
    }
}
