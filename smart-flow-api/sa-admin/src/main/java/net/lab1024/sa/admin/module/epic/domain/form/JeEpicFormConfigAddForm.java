package net.lab1024.sa.admin.module.epic.domain.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * epic表单设计器 新建表单
 *
 * @Author je
 * @Date 2025-07-08 14:35:15
 * @Copyright je v1.0
 */

@Data
public class JeEpicFormConfigAddForm {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "主键 不能为空")
    private String id;

    @Schema(description = "表单名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "表单名称 不能为空")
    private String formName;

}