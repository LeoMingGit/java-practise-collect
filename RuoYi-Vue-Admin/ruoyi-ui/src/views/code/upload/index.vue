<template>
  <div class="app-container">
    <el-form
      :model="queryParams"
      ref="queryForm"
      size="small"
      :inline="true"
      v-show="showSearch"
      label-width="68px"
    >
      <el-form-item label="订单编号" prop="orderId">
        <el-input
          v-model="queryParams.orderId"
          placeholder="订单编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
 
   
      <el-form-item>
        <el-button
          type="primary"
          icon="el-icon-search"
          size="mini"
          @click="handleQuery"
          >搜索</el-button
        >
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery"
          >重置</el-button
        >
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['monitor:job:add']"
        >
          <i class="el-icon-upload"></i> 上传数据
        </el-button>
      </el-col>

      <right-toolbar
        :showSearch.sync="showSearch"
        @queryTable="getList"
      ></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="dataList" @selection-change="handleSelectionChange"
    >
      <el-table-column label="订单编号" width="100" align="center" prop="orderId" />
      <el-table-column label="买家姓名" align="center" prop="buyerName" />
      <el-table-column label="买家电话" align="center" prop="buyerPhone" />
      <el-table-column label="订单金额" align="center" prop="orderAmount" />
      <el-table-column label="订单状态" align="center" prop="status" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
    </el-table>

    <pagination
      v-show="total > 0"
      :total="total"
      :page.sync="queryParams.pageIndex"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />
    <!-- 添加或修改定时任务对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="800px" append-to-body>
      <el-upload
        class="upload-demo"
        :action="uploadUrl"
        :headers="myHeaders"
        :on-success="handleUploadSuccess"
        :on-error="handleUploadError"
        :file-list="fileList"
        :accept="'.xls,.xlsx'"
      >
        <el-button size="small" type="primary">点击上传</el-button>
        <div slot="tip" class="el-upload__tip">
          只能上传Excel文件
        </div>
      </el-upload>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>
  
  <script>
import {
  orderList

} from "@/api/system/code";
import Crontab from "@/components/Crontab";
import { getToken } from '@/utils/auth'

export default {
  components: { Crontab },
  name: "Job",
  dicts: ["sys_job_group", "sys_job_status"],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,

      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 是否显示详细弹出层
      openView: false,

      // 查询参数
      queryParams: {
        pageIndex: 1,
        pageSize: 10
      },
      fileList: [],
      dataList: [],
      uploadUrl:'',
      myHeaders:[],
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        jobName: [
          { required: true, message: "任务名称不能为空", trigger: "blur" },
        ],
        invokeTarget: [
          {
            required: true,
            message: "调用目标字符串不能为空",
            trigger: "blur",
          },
        ],
        cronExpression: [
          {
            required: true,
            message: "cron执行表达式不能为空",
            trigger: "blur",
          },
        ],
      },
    };
  },
  created() {
    this.init();
    this.getList();
  },


  methods: {
    /** 查询定时任务列表 */
    getList() {
      this.loading = true;
      orderList(this.queryParams).then(response => {
        this.dataList = response.rows;
        this.total = response.total;
        this.loading = false;
      });

    },
    init(){
      debugger
      this.uploadUrl=BASE_URL+"/order/excel/upload"
      var token=getToken()
      this.myHeaders={Authorization: token}

     },
    submitForm() {},
    // 取消按钮
    cancel() {
      this.open = false;
    },

    /** 新增按钮操作 */
    handleAdd() {
      this.open = true;
      this.title = "上传文件";
    },
    handleQuery() {},
    resetQuery() {},

    handleUploadError() {},
    handleUploadSuccess() {},
    handleSelectionChange() {},
  },
};
</script>
  