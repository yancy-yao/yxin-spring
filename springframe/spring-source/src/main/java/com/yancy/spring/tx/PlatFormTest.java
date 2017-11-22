package com.yancy.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * Created by yancy on 2017/11/22.
 */
public class PlatFormTest {

    @Autowired
    private PlatformTransactionManager transactionManager;

    public void transactionManager(){
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        definition.setTimeout(20);

        TransactionStatus txStatus = transactionManager.getTransaction(definition);
        try{
            // 业务代码
        }
//        catch (ApplicationException e) {
//            transactionManager.rollback(txStatus);
//            throw e;
//        }
        catch(RuntimeException e){
            transactionManager.rollback(txStatus);
            throw e;
        }
        catch (Error e) {
            transactionManager.rollback(txStatus);
            throw e;
        }
        transactionManager.commit(txStatus);
    }
}
