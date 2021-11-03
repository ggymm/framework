<template>
  <a-layout-sider
    v-model="collapsed"
    :theme="sideTheme"
    :class="['side-menu', 'beauty-scroll', isMobile ? null : 'shadow']"
    width="220px"
    :collapsible="collapsible"
    :trigger="null"
  >
    <div :class="['logo', theme]">
      <router-link to="/dashboard/workplace">
        <img src="@/assets/img/logo.png">
        <h1>{{ systemName }}</h1>
      </router-link>
    </div>
    <i-menu :theme="theme" :collapsed="collapsed" :options="menuData" class="menu" @select="onSelect" />
  </a-layout-sider>
</template>

<script>
import IMenu from './menu'
import { mapState } from 'vuex'
export default {
  name: 'SideMenu',
  components: { IMenu },
  props: {
    collapsible: {
      type: Boolean,
      required: false,
      default: false
    },
    collapsed: {
      type: Boolean,
      required: false,
      default: false
    },
    menuData: {
      type: Array,
      required: true
    },
    theme: {
      type: String,
      required: false,
      default: 'dark'
    }
  },
  computed: {
    sideTheme() {
      return this.theme === 'light' ? this.theme : 'dark'
    },
    ...mapState('setting', ['isMobile', 'systemName'])
  },
  methods: {
    onSelect(obj) {
      this.$emit('menuSelect', obj)
    }
  }
}
</script>

<style lang="less" scoped>
.shadow{
  box-shadow: 2px 0 6px rgba(0, 21, 41, .35);
}
.side-menu{
  min-height: 100vh;
  overflow-y: auto;
  z-index: 10;
  .logo{
    height: 48px;
    position: relative;
    line-height: 48px;
    padding-left: 24px;
    -webkit-transition: all .3s;
    transition: all .3s;
    overflow: hidden;
    background-color: @layout-trigger-background;
    &.light{
      background-color: #fff;
      h1{
        color: @primary-color;
      }
    }
    h1{
      color: @menu-dark-highlight-color;
      font-size: 20px;
      margin: 0 0 0 12px;
      display: inline-block;
      vertical-align: middle;
    }
    img{
      width: 32px;
      vertical-align: middle;
    }
  }
}
.menu{
  padding: 16px 0;
}
</style>
