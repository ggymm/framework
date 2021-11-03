import TabsView from '@/layouts/TabsView'
import PageView from '@/layouts/PageView'

// 路由配置
const options = {
  routes: [
    {
      path: '/login',
      name: '登录页',
      component: () => import('@/pages/login')
    },
    {
      path: '*',
      name: 'Exp404',
      component: () => import('@/pages/exception/404')
    },
    {
      path: '/403',
      name: 'Exp403',
      component: () => import('@/pages/exception/403')
    },
    {
      path: '/500',
      name: 'Exp500',
      component: () => import('@/pages/exception/500')
    },
    {
      path: '/',
      name: '首页',
      component: TabsView,
      redirect: '/login',
      children: [
        {
          path: 'dashboard',
          name: 'Dashboard',
          meta: {
            icon: 'dashboard'
          },
          component: PageView,
          children: [
            {
              path: 'workplace',
              name: '工作台',
              component: () => import('@/pages/dashboard/workplace')
            }
          ]
        },
        {
          path: 'system',
          name: '系统设置',
          meta: {
            icon: 'setting'
          },
          component: PageView,
          children: [
            {
              path: 'orgManage',
              name: '组织管理',
              component: () => import('@/pages/system/org')
            },
            {
              path: 'userManage',
              name: '用户管理',
              component: () => import('@/pages/system/user')
            },
            {
              path: 'roleManage',
              name: '角色管理',
              component: () => import('@/pages/system/role')
            }
          ]
        }
      ]
    }
  ]
}

export default options
