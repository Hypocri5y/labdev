<template>
  <a-layout style="height: 100vh">
    <a-layout-content style="display: flex; justify-content: center; align-items: center;">
      <a-card title="登录" style="width: 400px">
        <a-form :model="formState" @finish="handleLogin">
          <a-form-item label="用户名" name="username" :rules="[{ required: true, message: '请输入用户名!' }]">
            <a-input v-model:value="formState.username" placeholder="请输入用户名" />
          </a-form-item>
          <a-form-item label="密码" name="password" :rules="[{ required: true, message: '请输入密码!' }]">
            <a-input-password v-model:value="formState.password" placeholder="请输入密码" />
          </a-form-item>
          <a-form-item>
            <a-button type="primary" html-type="submit" block>登录</a-button>
          </a-form-item>
        </a-form>
      </a-card>
    </a-layout-content>
  </a-layout>
</template>

<script>
import { reactive } from 'vue';
import { message } from 'ant-design-vue';

export default {
  setup() {
    const formState = reactive({
      username: '',
      password: '',
    });

    const handleLogin = () => {
      if (formState.username && formState.password) {
        message.success('登录成功！');
      } else {
        message.error('请填写完整信息！');
      }
    };

    return {
      formState,
      handleLogin,
    };
  },
};
</script>

<style scoped>
.ant-layout {
  background: #f0f2f5;
}
</style>