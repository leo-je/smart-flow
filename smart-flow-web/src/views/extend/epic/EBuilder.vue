<template>
    <div style="background: white;">
        <EBuilder ref="ebRef" :pageSchema="pageSchema" />
        <!-- <button @click="handleReset">重置数据</button> -->
    </div>
</template>

<script lang="ts" setup>
import { ref, onMounted } from "vue";
import { EBuilder, PageSchema } from "epic-designer";
import { getUrlParams } from '/@/utils/param'
import { getRequest, postRequest } from '/@/lib/axios';

const ebRef = ref(null);
const pageSchema = ref<PageSchema>({
    schemas: [
        {
            type: "page",
            id: "root",
            label: "页面",
            children: [
                {
                    label: "表单",
                    type: "form",
                    icon: "epic-icon-daibanshixiang",
                    componentProps: {
                        name: "default",
                        labelWidth: 100,
                        labelCol: {
                            span: 5,
                        },
                        wrapperCol: {
                            span: 19,
                        },
                        hideRequiredMark: false,
                        labelPlacement: "left",
                        labelAlign: "right",
                        requireMarkPlacement: "right",
                        size: "medium",
                    },
                    children: [
                        {
                            label: "姓名",
                            type: "input",
                            field: "input_sb6jhfb8",
                            icon: "epic-icon-write",
                            input: true,
                            componentProps: {
                                defaultValue: "",
                                placeholder: "请输入",
                                type: "text",
                                size: "medium",
                                disabled: false,
                            },
                            id: "input_sb6jhfb8",
                        },
                    ],
                    id: "form_18vemlk8",
                },
            ],
            componentProps: {
                style: {
                    padding: "16px",
                },
            },
        },
    ],
});

// 表单赋值
onMounted(async () => {
    setTimeout(() => {

        let param = getUrlParams()
        if (!param.id) {
            getRequest(`/jeEpicFormConfig/get/1751991083175`).then((res) => {
                console.log('res', res);
                if (res.ok == true) {
                    // 创建流程设计器
                    if (res.data) {
                        let formConfig = JSON.parse(res.data.formConfig)
                        console.log('formConfig', formConfig);
                        pageSchema.value = formConfig;
                        // edRef.value?.setData(JSON.parse(res.data.formConfig))

                    }
                }
            })
        } else
            // ebRef.value?.setData({
            //     input_sb6jhfb8: "自动填写的内容",
            // });
            console.log('params', param);
    }, 200);
});
</script>
<style lang="less" scoped> 
</style>