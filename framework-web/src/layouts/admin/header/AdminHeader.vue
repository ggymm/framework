<template>
  <a-layout-header :class="[headerTheme, 'admin-header']">
    <div :class="['admin-header-wide', layout, pageWidth]">
      <router-link v-if="isMobile || layout === 'head'" to="/" :class="['logo', isMobile ? null : 'pc', headerTheme]">
        <img width="32" src="@/assets/img/logo.png" alt="">
        <h1 v-if="!isMobile">{{ systemName }}</h1>
      </router-link>
      <a-divider v-if="isMobile" type="vertical" />
      <a-icon v-if="layout !== 'head'" class="trigger" :type="collapsed ? 'menu-unfold' : 'menu-fold'" @click="toggleCollapse" />
      <div v-if="layout !== 'side' && !isMobile" class="admin-header-menu" :style="`width: ${menuWidth};`">
        <i-menu class="head-menu" :theme="headerTheme" mode="horizontal" :options="menuData" @select="onSelect" />
      </div>
      <div :class="['admin-header-right', headerTheme]">
        <header-avatar class="header-item" />
      </div>
    </div>
  </a-layout-header>
</template>

<script>
import HeaderAvatar from './HeaderAvatar'
import IMenu from '../menu/menu'
import { mapState, mapMutations } from 'vuex'

export default {
  name: 'AdminHeader',
  components: { IMenu, HeaderAvatar },
  props: ['collapsed', 'menuData'],
  data() {
    return {
      langList: [
        { key: 'CN', name: '简体中文', alias: '简体' },
        { key: 'HK', name: '繁體中文', alias: '繁體' },
        { key: 'US', name: 'English', alias: 'English' }
      ],
      searchActive: false
    }
  },
  computed: {
    ...mapState('setting', ['theme', 'isMobile', 'layout', 'systemName', 'lang', 'pageWidth']),
    headerTheme() {
      if (this.layout === 'side' && this.theme.mode === 'dark' && !this.isMobile) {
        return 'light'
      }
      return this.theme.mode
    },
    langAlias() {
      const lang = this.langList.find(item => item.key === this.lang)
      return lang.alias
    },
    menuWidth() {
      const { layout, searchActive } = this
      const headWidth = layout === 'head' ? '100% - 188px' : '100%'
      const extraWidth = searchActive ? '600px' : '400px'
      return `calc(${headWidth} - ${extraWidth})`
    }
  },
  methods: {
    toggleCollapse() {
      this.$emit('toggleCollapse')
    },
    onSelect(obj) {
      this.$emit('menuSelect', obj)
    },
    ...mapMutations('setting', ['setLang'])
  }
}
</script>

<style lang="less" scoped>
.admin-header{
  padding: 0;
  z-index: 2;
  box-shadow: @shadow-down;
  position: relative;
  background: @base-bg-color;
  .head-menu{
    height: 54px;
    line-height: 54px;
    vertical-align: middle;
    box-shadow: none;
  }
  &.dark{
    background: @header-bg-color-dark;
    color: white;
  }
  &.night{
    .head-menu{
      background: @base-bg-color;
    }
  }
  .admin-header-wide{
    padding-left: 20px;
    &.head.fixed{
      max-width: 1400px;
      margin: auto;
      padding-left: 0;
    }
    &.side{
      padding-right: 12px;
    }
    .logo {
      height: 54px;
      line-height: 58px;
      vertical-align: top;
      display: inline-block;
      padding: 0 12px 0 20px;
      cursor: pointer;
      font-size: 20px;
      color: inherit;
      &.pc{
        padding: 0 12px 0 0;
      }
      img {
        vertical-align: middle;
      }
      h1{
        color: inherit;
        display: inline-block;
        font-size: 16px;
      }
    }
    .trigger {
      font-size: 20px;
      line-height: 54px;
      padding: 0 20px 0 0;
      cursor: pointer;
      transition: color .3s;
      &:hover{
        color: @primary-color;
      }
    }
    .admin-header-menu{
      display: inline-block;
    }
    .admin-header-right{
      float: right;
      display: flex;
      color: inherit;
      .header-item{
        color: inherit;
        padding: 0 12px;
        cursor: pointer;
        align-self: center;
        a{
          color: inherit;
          i{
            font-size: 16px;
          }
        }
      }
      each(@theme-list, {
        &.@{value} .header-item{
          &:hover{
            @class: ~'hover-bg-color-@{value}';
            background-color: @@class;
          }
        }
      })
    }
  }
}
</style>
