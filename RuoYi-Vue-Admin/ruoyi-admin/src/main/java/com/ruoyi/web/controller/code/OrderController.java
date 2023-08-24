package com.ruoyi.web.controller.code;

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
    public List<OrderMaster> getOrdersByPage(@RequestBody OrderQueryDTO queryDTO) {
        return orderMasterService.selectOrdersByPage(queryDTO);
    }
}