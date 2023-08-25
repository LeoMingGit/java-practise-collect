package com.ruoyi.web.controller.code;

import com.github.pagehelper.PageInfo;
import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.OrderMaster;
import com.ruoyi.system.domain.dto.OrderQueryDTO;
import com.ruoyi.system.service.IOrderMasterService;
import io.swagger.annotations.Api;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api("代码练习")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderMasterService orderMasterService;

    @GetMapping("/{orderId}")
    public OrderMaster getOrder(@PathVariable Integer orderId) {
        return orderMasterService.selectOrderById(orderId);
    }

    @PostMapping
    public String createOrder(@RequestBody OrderMaster order) {
        orderMasterService.createOrder(order);
        return "Order created successfully";
    }

    @PutMapping
    public String updateOrder(@RequestBody OrderMaster order) {
        orderMasterService.updateOrder(order);
        return "Order updated successfully";
    }

    @DeleteMapping("/{orderId}")
    public String deleteOrder(@PathVariable Integer orderId) {
        orderMasterService.deleteOrder(orderId);
        return "Order deleted successfully";
    }


    @PostMapping("/list")
    public  TableDataInfo getOrdersByPage(@RequestBody OrderQueryDTO queryDTO) {
        List<OrderMaster> list =orderMasterService.selectOrdersByPage(queryDTO);
        long total=orderMasterService.countTotalOrder(queryDTO);
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(HttpStatus.SUCCESS);
        rspData.setMsg("查询成功");
        rspData.setRows(list);
        rspData.setTotal(total);
        return rspData;

    }
}