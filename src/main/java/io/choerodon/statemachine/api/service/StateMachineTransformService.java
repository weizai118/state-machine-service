package io.choerodon.statemachine.api.service;

import io.choerodon.mybatis.service.BaseService;
import io.choerodon.statemachine.api.dto.StateMachineTransformDTO;
import io.choerodon.statemachine.domain.StateMachineTransformDraft;
import io.choerodon.statemachine.infra.feign.dto.TransformInfo;

import java.util.List;

/**
 * @author peng.jiang,dinghuang123@gmail.com
 */
public interface StateMachineTransformService extends BaseService<StateMachineTransformDraft> {

    /**
     * 创建转换
     *
     * @param organizationId
     * @param transformDTO
     * @return
     */
    StateMachineTransformDTO create(Long organizationId, StateMachineTransformDTO transformDTO);

    /**
     * 更新转换
     *
     * @param organizationId 组织id
     * @param transformId       转换id
     * @param transformDTO      转换对象
     * @return 更新转换
     */
    StateMachineTransformDTO update(Long organizationId, Long transformId, StateMachineTransformDTO transformDTO);

    /**
     * 删除转换
     *
     * @param organizationId 组织id
     * @param transformId       节点id
     * @return
     */
    Boolean delete(Long organizationId, Long transformId);

    /**
     * 获取初始转换
     *
     * @param stateMachineId
     * @return
     */
    Long getInitTransform(Long organizationId, Long stateMachineId);

    /**
     * 校验转换名字是否未被使用
     *
     * @param stateMachineId 状态机id
     * @param transformId       转换id
     * @param name           名称
     * @return
     */
    Boolean checkName(Long organizationId,Long stateMachineId, Long transformId, String name);

    /**
     * 根据id获取转换
     *
     * @param organizationId
     * @param transformId
     * @return
     */
    StateMachineTransformDTO queryById(Long organizationId, Long transformId);

    /**
     * 获取当前状态拥有的转换列表，包括【全部】类型的转换
     * @param organizationId
     * @param stateMachineId
     * @param statusId
     * @return
     */
    List<TransformInfo> queryListByStatusIdByDeploy(Long organizationId, Long stateMachineId, Long statusId);

    /**
     * 创建【全部转换到此状态】转换，所有节点均可转换到当前节点
     *
     * @param organizationId 组织id
     * @param endNodeId
     * @return
     */
    StateMachineTransformDTO createAllStatusTransform(Long organizationId, Long stateMachineId, Long endNodeId);

    /**
     * 删除【全部转换到此状态】转换
     * @param organizationId
     * @param transformId
     * @return
     */
    Boolean deleteAllStatusTransform(Long organizationId, Long transformId);

    /**
     * 更新转换的条件策略
     * @param organizationId
     * @param transformId
     * @param conditionStrategy
     * @return
     */
    Boolean updateConditionStrategy(Long organizationId, Long transformId, String conditionStrategy);
}
