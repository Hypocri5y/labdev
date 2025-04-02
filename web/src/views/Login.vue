<template>
  <a-layout style="height: 100vh">
    <a-layout-content style="display: flex; justify-content: center; align-items: center;">
      <a-card title="登录" style="width: 400px">
        <a-form :model="formState" @finish="handleLogin">
          <a-form-item label="用户名" name="loginName" :rules="[{ required: true, message: '请输入用户名!' }]">
            <a-input v-model:value="formState.loginName" placeholder="请输入用户名" />
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
import axios from "axios";

export default {
  setup() {
    const formState = reactive({
      loginName: '',
      password: '',
    });

    const handleLogin = () => {
      axios.post('/user/login', {
        loginName: formState.loginName,
        password: formState.password,
      })
          .then((resp) => {
            console.log("resp=", resp);
            const result = resp.data;
            if (result.isSuccess) {
              message.success('登录成功！');
              // 根据需要，可以在这里添加跳转到主页或其他逻辑
            } else {
              // 使用 resp 而不是 res
              message.error(resp.data.msg || '登录失败，请重试！');
            }
          })
          .catch((err) => {
            console.error(err);
            // 提供用户友好的错误提示
            message.error('请求失败，请检查网络连接或稍后再试！');
          });
    };

    // 返回响应式数据和方法，供模板使用
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