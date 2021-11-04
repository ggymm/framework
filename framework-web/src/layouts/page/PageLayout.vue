<template>
  <div class="page-layout">
    <page-header
      v-if="!fixedTabs || !multiPage"
      ref="pageHeader"
      :breadcrumb="breadcrumb"
      :title="pageTitle"
      :logo="logo"
      :avatar="avatar"
    >
      <slot slot="action" name="action" />
      <slot slot="content" name="headerContent" />
      <div v-if="!this.$slots.headerContent && desc" slot="content">
        <p>{{ desc }}</p>
        <div v-if="linkList" class="link">
          <template v-for="(link, index) in linkList">
            <a :key="index" :href="link.href"><a-icon :type="link.icon" />{{ link.title }}</a>
          </template>
        </div>
      </div>
      <slot v-if="this.$slots.extra" slot="extra" name="extra" />
    </page-header>
    <div ref="page" :class="['page-content', layout, pageWidth]" :style="pageContent()">
      <slot />
    </div>
  </div>
</template>

<script>
import PageHeader from '@/layouts/page/PageHeader'
import { mapState, mapMutations } from 'vuex'
import { getI18nKey } from '@/utils/routerUtil'

export default {
  name: 'PageLayout',
  components: { PageHeader },
  props: ['desc', 'logo', 'title', 'avatar', 'linkList', 'extraImage'],
  data() {
    return {
      page: {},
      pageHeaderHeight: 0
    }
  },
  computed: {
    ...mapState('setting', ['layout', 'multiPage', 'pageMinHeight', 'pageWidth', 'fixedTabs', 'customTitles']),
    pageTitle() {
      const pageTitle = this.page && this.page.title
      return this.customTitle || (pageTitle && this.$t(pageTitle)) || this.title || this.routeName
    },
    routeName() {
      const route = this.$route
      return this.$t(getI18nKey(route.matched[route.matched.length - 1].path))
    },
    breadcrumb() {
      const page = this.page
      const breadcrumb = page && page.breadcrumb
      if (breadcrumb) {
        const i18nBreadcrumb = []
        breadcrumb.forEach(item => {
          i18nBreadcrumb.push(this.$t(item))
        })
        return i18nBreadcrumb
      } else {
        return this.getRouteBreadcrumb()
      }
    },
    marginCorrect() {
      return this.multiPage ? 20 : 0
    }
  },
  watch: {
    $route() {
      this.page = this.$route.meta.page
    }
  },
  updated() {
  },
  activated() {
  },
  deactivated() {
  },
  mounted() {
  },
  created() {
    this.page = this.$route.meta.page
  },
  beforeDestroy() {
  },
  methods: {
    ...mapMutations('setting', ['correctPageMinHeight', 'multiPage']),
    getRouteBreadcrumb() {
      const routes = this.$route.matched
      const path = this.$route.path
      const breadcrumb = []
      routes.filter(item => path.includes(item.path))
        .forEach(route => {
          const path = route.path.length === 0 ? '/home' : route.path
          breadcrumb.push(this.$t(getI18nKey(path)))
        })
      const pageTitle = this.page && this.page.title
      if (this.customTitle || pageTitle) {
        breadcrumb[breadcrumb.length - 1] = this.customTitle || pageTitle
      }
      return breadcrumb
    },
    pageContent() {
      return {
        'height': `calc(100vh - ${this.multiPage ? '205px' : '157px'})`
      }
    }
  }
}
</script>

<style lang="less">
  .link{
    /*margin-top: 16px;*/
    line-height: 20px;
    a{
      font-size: 14px;
      margin-right: 32px;
      i{
        font-size: 22px;
        margin-right: 8px;
      }
    }
  }
  .page-content{
    position: relative;
    padding: 20px;
    overflow-y: auto;
    &.side{
    }
    &.head.fixed{
      margin: 0 auto;
      max-width: 1400px;
    }
  }
</style>
