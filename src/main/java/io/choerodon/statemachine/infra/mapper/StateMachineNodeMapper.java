package io.choerodon.statemachine.infra.mapper;

import io.choerodon.mybatis.common.BaseMapper;
import io.choerodon.statemachine.domain.StateMachineNode;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author peng.jiang, dinghuang123@gmail.com
 */
public interface StateMachineNodeMapper extends BaseMapper<StateMachineNode> {

    StateMachineNode getNodeDeployById(@Param("nodeId") Long nodeId);

    StateMachineNode getNodeDeployByStatusId(@Param("stateMachineId") Long stateMachineId, @Param("statusId") Long statusId);


    List<StateMachineNode> selectByStateMachineId(@Param("stateMachineId") Long stateMachineId);

    Long checkStateDelete(@Param("organizationId") Long organizationId, @Param("statusId") Long statusId);

    StateMachineNode queryById(@Param("organizationId") Long organizationId, @Param("id") Long id);

    List<StateMachineNode> queryByStateMachineIds(@Param("stateMachineIds") List<Long> stateMachineIds, @Param("organizationId") Long organizationId);
}
