<template>
    <footer class="footer">
      <div class="footer-left">
        <p>Hackaton @ Globalsoft 2024</p>
      </div>
      <div class="footer-right">
        <p>Petar Bošnjak</p>
        <p>Marko Sopta</p>
      </div>
    </footer>
  </template>
  
  <script>
  export default {
    name: "FooterComponent",
  };
  </script>
  
  <style scoped>
  .footer {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 10px;
    background-color: var(--background-color);
    color: var(--text-color);
    font-size: 1rem;
    font-weight: bold;
  }
  
  .footer-left {
    flex: 1;
  }
  
  .footer-right {
    flex: 1;
    text-align: right;
  }
  
  .footer-right p {
    margin: 0;
  }
  </style>
  