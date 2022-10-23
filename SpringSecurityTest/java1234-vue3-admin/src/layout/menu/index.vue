<template>
   <el-menu
      active-text-color="#ffd04b"
      background-color="#2d3a4b"
      class="el-menu-vertical-demo"
      text-color="#fff"
      router
      :default-active="activeIndex"
  >
    <el-menu-item index="/index" @click="openTab({name:'首页',path:'/index'})">
      <el-icon><home-filled /></el-icon>
      <span>首页</span>
    </el-menu-item>
<!--
   <el-sub-menu index="3" >
      <template #title >
        <el-icon><svg-icon icon="hamburger-opened" /></el-icon>
        <span>系统管理</span>
      </template>
      <el-menu-item index="bigType">
        <el-icon><Setting /></el-icon>
        <span>用户管理</span>
      </el-menu-item>
      <el-menu-item index="bigType">
        <el-icon><Setting /></el-icon>
        <span>角色管理</span>
      </el-menu-item>
      <el-menu-item index="smallType">
        <el-icon><Setting /></el-icon>
        <span>菜单管理</span>
      </el-menu-item>
    </el-sub-menu>

     <el-sub-menu index="4">
      <template #title >
        <el-icon><management /></el-icon>
        <span>业务管理</span>
      </template>
      <el-menu-item index="bigType">
        <el-icon><Setting /></el-icon>
        <span>部门管理</span>
      </el-menu-item>
      <el-menu-item index="bigType">
        <el-icon><Setting /></el-icon>
        <span>岗位管理</span>
      </el-menu-item>

    </el-sub-menu>
-->
    <el-sub-menu :index="menu.path" v-for="menu in menuList">
      <template #title >
        <el-icon><svg-icon :icon="menu.icon" /></el-icon>
        <span>{{menu.name}}</span>
      </template>
      <el-menu-item :index="item.path" v-for="item in menu.children" @click="openTab(item)">
        <el-icon><svg-icon :icon="item.icon" /></el-icon>
        <span>{{item.name}}</span>
      </el-menu-item>
    </el-sub-menu>


  </el-menu>
</template>

<script setup>
import {HomeFilled,User,Tickets,Goods,DocumentAdd,Management,Setting,Edit,SwitchButton,Promotion} from '@element-plus/icons-vue'

import { ref ,watch} from 'vue'
import store from '@/store'
import { useRoute,useRouter } from 'vue-router'


const menuList = ref(store.getters.GET_MENULIST);
console.log("menuList2="+menuList)
const activeIndex=ref("/index")



watch(store.state,()=>{
  console.log("editableTabsValue="+store.state.editableTabsValue)
  activeIndex.value=store.state.editableTabsValue
},{deep:true,immediate:true})

const openTab=(item)=>{
  store.commit('ADD_TABS',item)
}

</script>

<style lang="scss" scoped>

</style>
