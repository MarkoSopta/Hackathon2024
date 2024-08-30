<template>
    <HeaderComponent />
    <div class="login-page">
      <div class="login-container">
        <h1 class="login-title">Prijava</h1>
        <form @submit.prevent="handleLogin">
          <div class="input-block">
            <label for="email">Email</label>
            <input id="email" type="email" v-model="email" required />
          </div>
          <div class="input-block">
            <label for="password">Lozinka</label>
            <input id="password" type="password" v-model="password" required />
          </div>
          <button type="submit" class="login-button">Prijava</button>
        </form>
      </div>
    </div>
    <FooterComponent />
  </template>
  
  <script>
  import HeaderComponent from "@/components/HeaderComponent.vue";
  import FooterComponent from "@/components/FooterComponent.vue";


  export default {
    name: "LoginPage",
    data() {
      return {
        email: '',
        password: '',
        
      };
    },
    components:{
        HeaderComponent,
        FooterComponent,
    },
    methods: {
      handleLogin() {
        console.log("Logging in with", this.email, this.password);
        // Implement your login logic here
      },
    },
  };
  </script>
  
  <style scoped>
  /* General Styles */
  
  .login-page {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background-color: #e0e0e0;
  }
  
  /* Login Container */
  .login-container {
    background-color: white;
    padding: 40px 30px;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    max-width: 400px;
    width: 100%;
    box-sizing: border-box;
  }
  
  /* Title */
  .login-title {
    margin-bottom: 30px;
    font-size: 24px;
    color: #333;
    text-align: center;
  }
  
  /* Input Blocks */
  .input-block {
    margin-bottom: 20px;
  }
  
  .input-block label {
    display: block;
    margin-bottom: 5px;
    font-size: 14px;
    color: #333;
    
  }
  
  .input-block input {
    width: 100%;
    padding: 10px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 5px;
    background-color: #f9f9f9;
    box-sizing: border-box;
  }
  
  /* Login Button */
  .login-button {
    width: 100%;
    padding: 10px;
    font-size: 16px;
    font-weight: bold;
    color: var(--text-color);
    background-color: var(--background-color);
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s ease;
  }
  
  .login-button:hover {
    background-color: var(--secondary-color);
  }
  
  
  </style>
  