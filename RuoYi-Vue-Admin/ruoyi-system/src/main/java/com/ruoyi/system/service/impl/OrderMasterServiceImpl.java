package com.ruoyi.system.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.OrderMaster;
import com.ruoyi.system.domain.dto.OrderMasterDto;
import com.ruoyi.system.domain.dto.OrderQueryDTO;
import com.ruoyi.system.mapper.OrderMasterMapper;
import com.ruoyi.system.service.IOrderMasterService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.validation.Validator;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import javax.annotation.Resource;
import java.util.*;

@Service
public class OrderMasterServiceImpl implements IOrderMasterService {

    private static final Logger log = LoggerFactory.getLogger(OrderMasterServiceImpl.class);

    @Autowired
    private OrderMasterMapper orderMasterMapper;


    @Autowired
    private DataSourceTransactionManager transactionManager;

    @Resource
    private MongoTemplate mongoTemplate;

    @Autowired
    GridFsTemplate gridFsTemplate;

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
    public AjaxResult handleOrderExcel(String excelpath)  {
        System.out.println(excelpath);
        log.error("\n=== 返回值 ===\n" +excelpath);

        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 同步读取会自动finish
        List<OrderMasterDto> list = EasyExcel.read(excelpath).head(OrderMasterDto.class).sheet().doReadSync();
        for (OrderMasterDto data : list) {
            System.out.println((JSON.toJSONString(data)));
        }
        File file = new File(excelpath);
        //把excel文件上传到mongodb中去
        if (!file.exists()) {
            return new AjaxResult(500,"文件找不到");
        }
        try (FileInputStream inputStream = new FileInputStream(file);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream)) {
            String fileId = gridFsTemplate.store(bufferedInputStream, file.getName(), "").toString();
            if (StringUtils.isBlank(fileId)) {
                return new AjaxResult(500, "上传文件失败");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

         //把excel的数据存储到数据库中去
        //开启事物
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        definition.setPropagationBehaviorName("PROPAGATION_REQUIRED");
        TransactionStatus transactionStatus = transactionManager.getTransaction(definition);
        try {
          List<OrderMaster> saveDataList=new ArrayList<>();

            for (int i = 0; i < list.size(); i++) {
                OrderMasterDto itemSource=list.get(i);
                OrderMaster  itemData=new OrderMaster();
                BeanUtils.copyProperties(itemSource, itemData);
                itemData.setOrderId(UUID.randomUUID().toString());
                saveDataList.add(itemData);
                orderMasterMapper.insertOrder(itemData);

                if(i==2){
                    //throw new Exception("测试事务回滚");
                }
            }
             //提交事物
            transactionManager.commit(transactionStatus);
        }catch (Exception e){
            e.printStackTrace();
            //回滚事物
            transactionManager.rollback(transactionStatus);
            return new AjaxResult(500,"程序内部错误");
        }

        return new AjaxResult(200,"操作成功");


    }






}
