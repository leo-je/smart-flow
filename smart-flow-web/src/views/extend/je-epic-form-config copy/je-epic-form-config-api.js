/**
 * epic表单设计器 api 封装
 *
 * @Author:    je
 * @Date:      2025-07-08 14:35:15
 * @Copyright  je v1.0
 */
import { postRequest, getRequest } from '/@/lib/axios';

export const jeEpicFormConfigApi = {

  /**
   * 分页查询  @author  je
   */
  queryPage : (param) => {
    return postRequest('/jeEpicFormConfig/queryPage', param);
  },

  /**
   * 增加  @author  je
   */
  add: (param) => {
      return postRequest('/jeEpicFormConfig/add', param);
  },

  /**
   * 修改  @author  je
   */
  update: (param) => {
      return postRequest('/jeEpicFormConfig/update', param);
  },


  /**
   * 删除  @author  je
   */
  delete: (id) => {
      return getRequest(`/jeEpicFormConfig/delete/${id}`);
  },

  /**
   * 批量删除  @author  je
   */
  batchDelete: (idList) => {
      return postRequest('/jeEpicFormConfig/batchDelete', idList);
  },

};
