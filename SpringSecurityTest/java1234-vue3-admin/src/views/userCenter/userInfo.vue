<template>

  <el-form ref="userRef" :model="form" :rules="rules" label-width="100px" >
      <el-form-item label="手机号码：" prop="phonenumber">
         <el-input v-model="form.phonenumber" maxlength="11" />
      </el-form-item>
      <el-form-item label="用户邮箱：" prop="email">
         <el-input v-model="form.email" maxlength="50" />
      </el-form-item>
      <el-form-item>
      <el-button type="primary" @click="handleSubmit">保存</el-button>

      </el-form-item>
   </el-form>

</template>

<script setup>
import {defineEmits, defineProps, ref, watch} from "vue";
import requestUtil,{getServerUrl} from "@/utils/request";
import { ElMessage } from 'element-plus'
import { Plus } from '@element-plus/icons-vue'
import store from "@/store";
import Cookies from "js-cookie";
import {encrypt} from "@/utils/jsencrypt";
import qs from "qs";
import router from "@/router";

const props=defineProps(
    {
      user:{
        type:Object,
        default:()=>{},
        required:true
      }
    }
)

const form=ref({
  id:-1,
  phonenumber:'',
  email:''
})

const userRef=ref(null)

const rules = ref({
  email: [{ required: true, message: "邮箱地址不能为空", trigger: "blur" }, { type: "email", message: "请输入正确的邮箱地址", trigger: ["blur", "change"] }],
  phonenumber: [{ required: true, message: "手机号码不能为空", trigger: "blur" }, { pattern: /^1[3|4|5|6|7|8|9][0-9]\d{8}$/, message: "请输入正确的手机号码", trigger: "blur" }],
});

form.value=props.user;

const handleSubmit=()=>{

  userRef.value.validate(async (valid)=>{
    if(valid) {
      let result = await requestUtil.post("sys/user/save", form.value);
      let data = result.data;
      if (data.code == 200) {
        ElMessage.success("执行成功！")
        store.commit("SET_USERINFO", form.value)
      }
    }
  })
}


</script>

<style lang="scss" scoped>

</style>
