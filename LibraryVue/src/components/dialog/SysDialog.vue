<template>
  <!-- el开头的标签，把他当做普通的div看待 -->
  <el-dialog
    :title="title"
    :visible.sync="visible"
    :width="width + 'px'"
    :before-close="onClose"
    :close-on-click-modal="false"
    :show-close="false"
    append-to-body
  >
  <template #title>
    <div>
      <span>{{ title }}</span>
      <span
      style="float: right; cursor: pointer; color: #409eff;"
      @click="onClose"
    >
      关闭
    </span>
    </div>

  </template>
    <div class="containner" :style="{ height: height + 'px' }">
      <slot name="content" />
    </div>
    <span slot="footer" class="dialog-footer">
      <span class="button-span" @click="onClose">取 消</span>
      <span class="button-span" @click="onConfirm"> 确 定</span>

    </span>
  </el-dialog>
</template>

<script>
import { title } from '@/settings';

export default {
  props: {
    title: {
      // 弹框的标题
      type: String,
      default: '标题'
    },
    visible: {
      // 弹框的展示和影藏
      type: Boolean,
      default: false
    },
    width: {
      // 弹框的宽度
      type: Number,
      default: 630
    },
    height: {
      // 弹框的高度
      type: Number,
      default: 250
    }
  },
  methods: {
    // 弹框关闭
    onClose() {
      this.$emit('onClose')
    },
    // 弹框确定
    onConfirm() {
      this.$emit('onConfirm')
    }
  }
}
</script>

<style lang="scss" scoped>
.containner {
  overflow-x: initial;
  overflow-y: auto;
}
// ::v-deep 深度查找
.el-dialog__wrapper {
  ::v-deep .el-dialog {
    border-top-left-radius: 7px !important;
    border-top-right-radius: 7px !important;
    .el-dialog__header {
      border-top-left-radius: 7px !important;
      border-top-right-radius: 7px !important;
      background-color: #ffffff;
      .el-dialog__title {
        color: #4b4545;
        font-size: 15px;
        font-weight: 700;
      }
      .el-dialog__close {
        color: #c9c5c5;
      }
    }
    .el-dialog__body {
      padding: 10px 10px !important;
    }
    .el-dialog__footer {
      border-top: 1px solid #e8eaec !important;
      padding: 10px !important;
    }
  }
}

.button-span {
  margin-right: 20px;
  font-size: 16px;
  padding: 8px 16px; /* 按钮内边距 */
  cursor: pointer;
  border: 1px solid #409eff; /* 边框颜色 */
  border-radius: 4px; /* 按钮圆角 */
  background-color: #409eff; /* 按钮背景颜色 */
  color: #fff; /* 按钮文字颜色 */
  text-align: center;
  display: inline-block;
  transition: all 0.3s ease; /* 添加过渡效果 */
}

.button-span:hover {
  background-color: #66b1ff; /* 鼠标悬浮时的背景颜色 */
  border-color: #66b1ff; /* 鼠标悬浮时的边框颜色 */
}

</style>
