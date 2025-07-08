<template>
  <div class="epic-designer-container">
    <EDesigner @save="handleSubmit" />
  </div>
</template>
<script setup>
import { EDesigner } from "epic-designer";
import { getRequest, postRequest } from '/@/lib/axios';

/**
 * 点击保存按钮操作
 * @param e
 */
function handleSubmit(e) {
  console.log(e);
}
</script>
<style>
.epic-designer-container {
  width: 100%;
  height: 800px;
  border: 1px solid var(--epic-border-color);
}
</style>