package net.lab1024.sa.admin.module.epic.domain.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.lab1024.sa.base.common.domain.PageParam;

/**
 * epic表单设计器 分页查询表单
 *
 * @Author je
 * @Date 2025-07-08 14:35:15
 * @Copyright je v1.0
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class JeEpicFormConfigQueryForm extends PageParam {

    @Schema(description = "表单名称")
    private String formName;

}
