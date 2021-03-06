package io.choerodon.statemachine.domain.event;

import java.util.List;
import java.util.Map;

/**
 * @author shinan.chen
 * @date 2018/10/31
 */
public class DeployStatusPayload {
    private Map<String, List<Long>> projectIdsMap;
    private List<StatusPayload> statusPayloads;

    public Map<String, List<Long>> getProjectIdsMap() {
        return projectIdsMap;
    }

    public void setProjectIdsMap(Map<String, List<Long>> projectIdsMap) {
        this.projectIdsMap = projectIdsMap;
    }

    public List<StatusPayload> getStatusPayloads() {
        return statusPayloads;
    }

    public void setStatusPayloads(List<StatusPayload> statusPayloads) {
        this.statusPayloads = statusPayloads;
    }
}
