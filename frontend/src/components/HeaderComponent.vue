<template>
    
    <Header class="header">
      <div class="logo">
       <p>LOGO OVDJE</p>
      </div>
      <nav class="nav-buttons">
        <button @click="routeHomePage"  class="nav-button">Početna</button>
        <button @click="routePostsPage" class="nav-button">Objave</button>
        <button @click="routePrijavaPage" class="nav-button">Prijava</button>
        <button class="nav-button">O nama</button>
      </nav>
    </Header>
  </template>
  
  <script>
  export default {
    name: "HeaderComponent",
    methods: {
    routePostsPage() {
      this.$router.push({ name: 'Posts' });
    },
    routeHomePage(){
        this.$router.push({ name: 'Home' })
    },
    routePrijavaPage(){
      this.$router.push({ name: 'Prijava' })
    }
  }
  };
  </script>
  
  <style scoped>
  .header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 10px;
    background-color: var(--background-color);
    color: var(--primary-color);
    flex-wrap: wrap;
  }
  
  .logo img {
    max-width: 100%;
    height: auto;
    max-height: 50px;
  }
  
  .nav-buttons {
    display: flex;
    gap: 10px;
    flex-wrap: wrap;
    justify-content: flex-end;
  }
  
  .nav-button {
    background: none;
    border: 2px solid var(--primary-color);
    padding: 10px 15px; /* Increase padding for larger buttons */
  font-size: 0.8rem;
    color: var(--text-color);
    cursor: pointer;
    border-radius: 8px;
    transition: background-color 0.3s ease;
    white-space: nowrap;
    font-weight: bolder;
  }
  
  .nav-button:hover {
    background-color: var(--secondary-color);
    color: var(--text-color);
  }
  
  
  </style>
  