package com.example.serverc.business;

import com.codingapi.txlcn.common.util.Transactions;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tracing.TracingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Auther:
 * @Description:
 * @Date: 2020/3/24 16:19
 */
@Service
public class ServerC_ServiceImpl implements ServerC_Service {

    @Autowired
    private ServerC_DemoMapper demoMapper;

    @LcnTransaction
    @Transactional
    @Override
    public String execute(String exFlag) {

        ServerC_Demo demo = new ServerC_Demo();
        demo.setGroupId(TracingContext.tracing().groupId());
        demo.setDemoField("Service_C");
        demo.setCreateTime(new Date());
        demo.setAppName(Transactions.getApplicationId());
        demoMapper.save(demo);
//        throw new RuntimeException("hahahah");

        if (exFlag.equals("c")) {
            throw new RuntimeException("by exFlag");
        }
        return "ok-service-C";
    }
}
