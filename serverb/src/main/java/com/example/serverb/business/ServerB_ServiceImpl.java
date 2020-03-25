package com.example.serverb.business;

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
public class ServerB_ServiceImpl implements ServerB_Service {
    @Autowired
    private ServerB_DemoMapper demoMapper;

    @LcnTransaction
    @Transactional
    @Override
    public String execute(String exFlag) {
        ServerB_Demo demo = new ServerB_Demo();
        demo.setGroupId(TracingContext.tracing().groupId());
        demo.setDemoField("Service_B");
        demo.setCreateTime(new Date());
        demo.setAppName(Transactions.getApplicationId());
        demoMapper.save(demo);

        if (exFlag.equals("b")) {
            throw new RuntimeException("by exFlag");
        }
        return "ok-service-B";
    }
}
