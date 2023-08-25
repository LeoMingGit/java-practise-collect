package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.OrderMaster;
import com.ruoyi.system.domain.dto.OrderQueryDTO;
import com.ruoyi.system.mapper.OrderMasterMapper;
import com.ruoyi.system.service.IOrderMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderMasterServiceImpl implements IOrderMasterService {

    @Autowired
    private OrderMasterMapper orderMasterMapper;

    @Override
    public OrderMaster selectOrderById(Integer orderId) {
        return orderMasterMapper.selectOrderById(orderId);
    }

    @Override
    public int createOrder(OrderMaster order) {
        return orderMasterMapper.insertOrder(order);
    }

    @Override
    public int updateOrder(OrderMaster order) {
        return orderMasterMapper.updateOrder(order);
    }

    @Override
    public int deleteOrder(Integer orderId) {
        return orderMasterMapper.deleteOrder(orderId);
    }

    /**
     * 订单分页查询
     * @param queryDTO
     * @return
     */
    @Override
    public List<OrderMaster> selectOrdersByPage(OrderQueryDTO queryDTO) {
        return orderMasterMapper.selectOrdersByPage(queryDTO);
    }

    /**
     * 查询总数
     * @param queryDTO
     * @return
     */
    @Override
    public   long  countTotalOrder  (OrderQueryDTO queryDTO){
        return orderMasterMapper.countTotalOrder(queryDTO);
    }

    /**
     * 处理订单excel
     * @param excel
     * @return
     */
    @Override
    public AjaxResult handleOrderExcel(String excelpath){
        System.out.println(excelpath);

        AjaxResult result= new AjaxResult();


        return result;


    }






}
