package com.ruoyi.web.controller.code;

import com.github.pagehelper.PageInfo;
import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.core.domain.AjaxResult;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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


    /**
     * 处理上传的订单excel数据
     * @param file
     * @return
     */

    @PostMapping("/excel/upload")
    public AjaxResult uploadExcel(@RequestParam("file") MultipartFile file) {
        // 处理上传的Excel文件逻辑
        try {

            // 创建tempfile文件夹（如果不存在）
            String tempFolderPath = System.getProperty("user.dir") + File.separator + "tempfile";
            File tempFolder = new File(tempFolderPath);
            if (!tempFolder.exists()) {
                tempFolder.mkdir();
            }
            // 保存上传的Excel文件到tempfile目录
            // 生成唯一的UUID作为文件名
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            String filePath = tempFolderPath + File.separator + fileName;
            File excelFile = new File(filePath);
            file.transferTo(excelFile);
            return  orderMasterService.handleOrderExcel(filePath);

        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error("Excel文件上传失败: " + e.getMessage());
        }
    }



}