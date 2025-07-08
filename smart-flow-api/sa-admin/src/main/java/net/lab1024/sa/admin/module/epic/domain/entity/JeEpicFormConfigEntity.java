package net.lab1024.sa.admin.module.epic.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * epic表单设计器 实体类
 *
 * @Author je
 * @Date 2025-07-08 14:35:15
 * @Copyright je v1.0
 */

@Data
@TableName("t_je_epic_form_config")
public class JeEpicFormConfigEntity {

    /**
     * 主键
     */
    @TableId
    private String id;

    /**
     * 配置信息
     */
    private String formConfig;

    /**
     * 版本
     */
    private String version;

    /**
     * 表单名称
     */
    private String formName;

}
