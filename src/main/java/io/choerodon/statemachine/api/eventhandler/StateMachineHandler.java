package io.choerodon.statemachine.api.eventhandler;

import com.alibaba.fastjson.JSONObject;
import io.choerodon.asgard.saga.annotation.SagaTask;
import io.choerodon.statemachine.api.service.InitService;
import io.choerodon.statemachine.domain.Status;
import io.choerodon.statemachine.domain.event.OrganizationEventPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Created by HuangFuqiang@choerodon.io on 2018/09/28.
 * Email: fuqianghuang01@gmail.com
 */
@Component
public class StateMachineHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(StateMachineHandler.class);

    @Autowired
    private InitService initService;

    private void loggerInfo(Object o) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.info("data: {}", o);
        }
    }

    /**
     * 创建组织事件
     */
    @SagaTask(code = "statemachine-init-organization",
            description = "创建组织事件",
            sagaCode = "org-create-organization",
            maxRetryCount = 0,
            seq = 1)
    public String handleOrganizationCreateEvent(String payload) {
        OrganizationEventPayload organizationEventPayload = JSONObject.parseObject(payload, OrganizationEventPayload.class);
        loggerInfo(organizationEventPayload);
        //初始化状态
        List<Status> initStatuses = initService.initStatus(organizationEventPayload.getId());
//        //初始化敏捷状态机
//        initService.initAGStateMachine(organizationEventPayload.getId(), initStatuses);
        return payload;
    }

}
