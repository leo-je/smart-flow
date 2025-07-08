package net.lab1024.sa.admin.module.epic.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * epic表单设计器 列表VO
 *
 * @Author je
 * @Date 2025-07-08 14:35:15
 * @Copyright je v1.0
 */

@Data
public class JeEpicFormConfigVO {


    @Schema(description = "主键")
    private String id;

    @Schema(description = "配置信息")
    private String formConfig;

    @Schema(description = "版本")
    private String version;

    @Schema(description = "表单名称")
    private String formName;

}
