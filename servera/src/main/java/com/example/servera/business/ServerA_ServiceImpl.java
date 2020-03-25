package com.example.servera.business;

import com.codingapi.txlcn.common.util.Transactions;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tracing.TracingContext;
import com.example.servera.feign.ServerBFeign;
import com.example.servera.feign.ServerCFeign;
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
public class ServerA_ServiceImpl implements ServerA_Service {

    @Autowired
    private ServerA_DemoMapper demoMapper;
    @Autowired
    private ServerBFeign serverBFeign;
    @Autowired
    private ServerCFeign serverCFeign;


    @LcnTransaction
    @Transactional
    @Override
    public String execute(String exFlag) {
        ServerA_Demo demo = new ServerA_Demo();
        demo.setGroupId(TracingContext.tracing().groupId());
        demo.setDemoField("Service_A");
        demo.setCreateTime(new Date());
        demo.setAppName(Transactions.getApplicationId());
        demoMapper.save(demo);
        try {
            String server_b = serverBFeign.execute(exFlag);
//            String server_c = serverCFeign.execute(exFlag);

            if (exFlag.equals("a")) {
                throw new RuntimeException("by exFlag");
            }

        } catch (Exception e) {
            throw new RuntimeException("123");
        }


        return "ok-service";
    }
}
