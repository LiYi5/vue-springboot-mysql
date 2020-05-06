import Vue from 'vue'
import Router from 'vue-router'
import DeptUpdate from "../components/DeptUpdate"
import  DeptManager from '../components/DeptManager'
import  AddDept from '../components/AddDept'
import Index from '../components/index'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: '部门管理',
      component: Index,
      redirect:'/DeptManager',
      children:[
        {
          path: '/DeptManager',
          name: '部门查询',
          component: DeptManager
        },
        {
          path: '/AddDept',
          name: '添加部门',
          component: AddDept
        },
        {
          path: '/update',
          // name: '添加部门',
          component: DeptUpdate
        },
      ]
    },
  ]
})
