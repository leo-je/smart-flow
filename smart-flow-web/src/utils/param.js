/**
 * 从URL获取参数集合
 * @returns {Object} 参数对象
 */
export function getUrlParams() {
  const search = window.location.search || window.location.hash.split('?')[1] || '';
  const params = new URLSearchParams(search);
  const result = {};

  for (const [key, value] of params.entries()) {
    result[key] = value;
  }

  return result;
}