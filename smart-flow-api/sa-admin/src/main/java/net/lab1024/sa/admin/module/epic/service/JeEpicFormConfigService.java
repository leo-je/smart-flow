package net.lab1024.sa.admin.module.epic.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import net.lab1024.sa.admin.module.epic.dao.JeEpicFormConfigDao;
import net.lab1024.sa.admin.module.epic.domain.entity.JeEpicFormConfigEntity;
import net.lab1024.sa.admin.module.epic.domain.form.JeEpicFormConfigAddForm;
import net.lab1024.sa.admin.module.epic.domain.form.JeEpicFormConfigQueryForm;
import net.lab1024.sa.admin.module.epic.domain.form.JeEpicFormConfigUpdateForm;
import net.lab1024.sa.admin.module.epic.domain.vo.JeEpicFormConfigVO;
import net.lab1024.sa.base.common.domain.PageResult;
import net.lab1024.sa.base.common.domain.ResponseDTO;
import net.lab1024.sa.base.common.util.SmartBeanUtil;
import net.lab1024.sa.base.common.util.SmartPageUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * epic表单设计器 Service
 *
 * @Author je
 * @Date 2025-07-08 14:35:15
 * @Copyright je v1.0
 */

@Service
public class JeEpicFormConfigService {

    @Resource
    private JeEpicFormConfigDao jeEpicFormConfigDao;

    /**
     * 分页查询
     */
    public PageResult<JeEpicFormConfigVO> queryPage(JeEpicFormConfigQueryForm queryForm) {
        Page<?> page = SmartPageUtil.convert2PageQuery(queryForm);
        List<JeEpicFormConfigVO> list = jeEpicFormConfigDao.queryPage(page, queryForm);
        return SmartPageUtil.convert2PageResult(page, list);
    }

    /**
     * 添加
     */
    public ResponseDTO<String> add(JeEpicFormConfigAddForm addForm) {
        JeEpicFormConfigEntity jeEpicFormConfigEntity = SmartBeanUtil.copy(addForm, JeEpicFormConfigEntity.class);
        jeEpicFormConfigDao.insert(jeEpicFormConfigEntity);
        return ResponseDTO.ok();
    }

    /**
     * 更新
     *
     */
    public ResponseDTO<String> update(JeEpicFormConfigUpdateForm updateForm) {
        JeEpicFormConfigEntity jeEpicFormConfigEntity = SmartBeanUtil.copy(updateForm, JeEpicFormConfigEntity.class);
        jeEpicFormConfigDao.updateById(jeEpicFormConfigEntity);
        return ResponseDTO.ok();
    }

    /**
     * 批量删除
     */
    public ResponseDTO<String> batchDelete(List<String> idList) {
        if (CollectionUtils.isEmpty(idList)){
            return ResponseDTO.ok();
        }

        jeEpicFormConfigDao.deleteBatchIds(idList);
        return ResponseDTO.ok();
    }

    /**
     * 单个删除
     */
    public ResponseDTO<String> delete(String id) {
        if (null == id){
            return ResponseDTO.ok();
        }

        jeEpicFormConfigDao.deleteById(id);
        return ResponseDTO.ok();
    }

    public ResponseDTO<JeEpicFormConfigEntity> getById(String id) {
        JeEpicFormConfigEntity jeEpicFormConfigEntity = jeEpicFormConfigDao.selectById(id);
        return ResponseDTO.ok(jeEpicFormConfigEntity);
    }
}
