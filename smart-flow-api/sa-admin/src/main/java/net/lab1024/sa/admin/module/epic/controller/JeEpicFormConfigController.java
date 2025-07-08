package net.lab1024.sa.admin.module.epic.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import net.lab1024.sa.admin.module.epic.domain.entity.JeEpicFormConfigEntity;
import net.lab1024.sa.admin.module.epic.domain.form.JeEpicFormConfigAddForm;
import net.lab1024.sa.admin.module.epic.domain.form.JeEpicFormConfigQueryForm;
import net.lab1024.sa.admin.module.epic.domain.form.JeEpicFormConfigUpdateForm;
import net.lab1024.sa.admin.module.epic.domain.vo.JeEpicFormConfigVO;
import net.lab1024.sa.admin.module.epic.service.JeEpicFormConfigService;
import net.lab1024.sa.base.common.domain.PageResult;
import net.lab1024.sa.base.common.domain.ResponseDTO;
import net.lab1024.sa.base.common.domain.ValidateList;
import org.springframework.web.bind.annotation.*;

/**
 * epic表单设计器 Controller
 *
 * @Author je
 * @Date 2025-07-08 14:35:15
 * @Copyright je v1.0
 */

@RestController
@Tag(name = "epic表单设计器")
public class JeEpicFormConfigController {

    @Resource
    private JeEpicFormConfigService jeEpicFormConfigService;

    @Operation(summary = "分页查询 @author je")
    @PostMapping("/jeEpicFormConfig/queryPage")
    @SaCheckPermission("jeEpicFormConfig:query")
    public ResponseDTO<PageResult<JeEpicFormConfigVO>> queryPage(@RequestBody @Valid JeEpicFormConfigQueryForm queryForm) {
        return ResponseDTO.ok(jeEpicFormConfigService.queryPage(queryForm));
    }

    @Operation(summary = "添加 @author je")
    @PostMapping("/jeEpicFormConfig/add")
    @SaCheckPermission("jeEpicFormConfig:add")
    public ResponseDTO<String> add(@RequestBody @Valid JeEpicFormConfigAddForm addForm) {
        return jeEpicFormConfigService.add(addForm);
    }

    @Operation(summary = "更新 @author je")
    @PostMapping("/jeEpicFormConfig/update")
    @SaCheckPermission("jeEpicFormConfig:update")
    public ResponseDTO<String> update(@RequestBody @Valid JeEpicFormConfigUpdateForm updateForm) {
        return jeEpicFormConfigService.update(updateForm);
    }

    @Operation(summary = "批量删除 @author je")
    @PostMapping("/jeEpicFormConfig/batchDelete")
    @SaCheckPermission("jeEpicFormConfig:delete")
    public ResponseDTO<String> batchDelete(@RequestBody ValidateList<String> idList) {
        return jeEpicFormConfigService.batchDelete(idList);
    }

    @Operation(summary = "单个删除 @author je")
    @GetMapping("/jeEpicFormConfig/delete/{id}")
    @SaCheckPermission("jeEpicFormConfig:delete")
    public ResponseDTO<String> batchDelete(@PathVariable String id) {
        return jeEpicFormConfigService.delete(id);
    }

    @Operation(summary = "获取单个 @author je")
    @GetMapping("/jeEpicFormConfig/get/{id}")
    @SaCheckPermission("jeEpicFormConfig:delete")
    public ResponseDTO<JeEpicFormConfigEntity> getById(@PathVariable String id) {
        return jeEpicFormConfigService.getById(id);
    }

}
