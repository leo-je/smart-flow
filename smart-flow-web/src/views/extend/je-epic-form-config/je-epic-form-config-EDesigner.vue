<!--
  * epic表单设计器
  *
  * @Author:    je
  * @Date:      2025-07-08 14:35:15
  * @Copyright  je v1.0
-->
<template>
  <a-modal
      :title="form.id ? '编辑' : '添加'"
      :width="1500"
      :open="visibleFlag"
      @cancel="onClose"
      :maskClosable="false"
      :destroyOnClose="true"
  >
 <div class="epic-designer-container">
    <EDesigner @save="handleSubmit" />
  </div>

    <template #footer>
      <a-space>
        <a-button @click="onClose">取消</a-button>
        <a-button type="primary" @click="onSubmit">保存</a-button>
      </a-space>
    </template>
  </a-modal>
</template>
<script setup>
  import { reactive, ref, nextTick } from 'vue';
  import _ from 'lodash';
  import { message } from 'ant-design-vue';
  import { SmartLoading } from '/@/components/framework/smart-loading';
  //import { jeEpicFormConfigApi } from '/@/api/business/je-epic-form-config/je-epic-form-config-api';
  import { jeEpicFormConfigApi } from './je-epic-form-config-api';
  import { smartSentry } from '/@/lib/smart-sentry';


  // ------------------------ 事件 ------------------------

  const emits = defineEmits(['reloadList']);

  // ------------------------ 显示与隐藏 ------------------------
  // 是否显示
  const visibleFlag = ref(false);

  function show(rowData) {
    Object.assign(form, formDefault);
    if (rowData && !_.isEmpty(rowData)) {
      Object.assign(form, rowData);
    }
    // 使用字典时把下面这注释修改成自己的字典字段 有多个字典字段就复制多份同理修改 不然打开表单时不显示字典初始值
    // if (form.status && form.status.length > 0) {
    //   form.status = form.status.map((e) => e.valueCode);
    // }
    visibleFlag.value = true;
    nextTick(() => {
      formRef.value.clearValidate();
    });
  }

  function onClose() {
    Object.assign(form, formDefault);
    visibleFlag.value = false;
  }

  /**
 * 点击保存按钮操作
 * @param e
 */
function handleSubmit(e) {
  console.log(e);
}

  // ------------------------ 表单 ------------------------

  // 组件ref
  const formRef = ref();

  const formDefault = {
      id: undefined, //主键
      formName: undefined, //表单名称
  };

  let form = reactive({ ...formDefault });

  const rules = {
      // id: [{ required: true, message: '主键 必填' }],
      formName: [{ required: true, message: '表单名称 必填' }],
  };

  // 点击确定，验证表单
  async function onSubmit() {
    try {
      await formRef.value.validateFields();
      save();
    } catch (err) {
      message.error('参数验证错误，请仔细填写表单数据!');
    }
  }

  // 新建、编辑API
  async function save() {
    SmartLoading.show();
    try {
      if (form.id) {
        await jeEpicFormConfigApi.update(form);
      } else {
        // 取时间戳错误id
        form.id = new Date().getTime()+''
        await jeEpicFormConfigApi.add(form);
      }
      message.success('操作成功');
      emits('reloadList');
      onClose();
    } catch (err) {
      smartSentry.captureError(err);
    } finally {
      SmartLoading.hide();
    }
  }

  defineExpose({
    show,
  });
</script>

<style>
.epic-designer-container {
  width: 100%;
  height: 800px;
  border: 1px solid var(--epic-border-color);
}
</style>
