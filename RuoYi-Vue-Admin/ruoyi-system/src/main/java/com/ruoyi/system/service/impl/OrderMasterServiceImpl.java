package com.ruoyi.system.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.OrderMaster;
import com.ruoyi.system.domain.dto.OrderMasterDto;
import com.ruoyi.system.domain.dto.OrderQueryDTO;
import com.ruoyi.system.mapper.OrderMasterMapper;
import com.ruoyi.system.service.IOrderMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.converters.DefaultConverterLoader;
import com.alibaba.excel.enums.CellExtraTypeEnum;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson2.JSON;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
     * @param excelpath
     * @return
     */
    @Override
    public AjaxResult handleOrderExcel(String excelpath){
        System.out.println(excelpath);


        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 同步读取会自动finish
        List<OrderMasterDto> list = EasyExcel.read(excelpath).head(OrderMasterDto.class).sheet().doReadSync();
        for (OrderMasterDto data : list) {
            System.out.println(("读取到数据:{}"+JSON.toJSONString(data)));
        }


        AjaxResult result= new AjaxResult();


        return result;


    }






}
