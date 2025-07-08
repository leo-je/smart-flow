<template>
  <div class="epic-designer-container">
    <EDesigner @save="handleSubmit" />
  </div>
</template>
<script setup>
import { EDesigner } from "epic-designer";
import { getRequest, postRequest } from '/@/lib/axios';
import { reactive, ref, nextTick } from 'vue';

const formDefault = {
  id: undefined, //主键
  formName: undefined, //表单名称
  formConfig: undefined,
};

let formInfo = reactive({ ...formDefault });


/**
 * 点击保存按钮操作
 * @param e
 */
function handleSubmit(e) {
  console.log(e);
  formInfo.formConfig = JSON.stringify(e);
  postRequest('/jeEpicFormConfig/update', formInfo).then((res) => {
    if (res.code == 200) {
      console.log("保存成功");
      // message.success('保存成功');
    } else {
      console.log("保存失败");
      // message.error(res.msg);
    }
  });
}

/**
 * 从URL获取参数集合
 * @returns {Object} 参数对象
 */
function getUrlParams() {
  const search = window.location.search || window.location.hash.split('?')[1] || '';
  const params = new URLSearchParams(search);
  const result = {};

  for (const [key, value] of params.entries()) {
    result[key] = value;
  }

  return result;
}

// ---   

// 从URL获取参数集合
const params = getUrlParams();
console.log('params', params);

if (params.id) {
  formInfo.id = params.id;

  // 获取流程数据
  getRequest(`/jeEpicFormConfig/get/${params.id}`).then((res) => {
    console.log('res', res);
    if (res.ok == true) {
      // 创建流程设计器
      if (res.data) {
        formInfo = res.data;
      }
    }
  })
}

</script>
<style>
.epic-designer-container {
  width: 100%;
  height: 800px;
  border: 1px solid var(--epic-border-color);
}
</style>