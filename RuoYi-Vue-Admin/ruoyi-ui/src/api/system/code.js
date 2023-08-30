import request from '@/utils/request'

// 查询部门列表
export function orderList(data) {
  return request({
    url: '/order/list',
    method: 'post',
    data: data
  })
}
