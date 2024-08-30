<template>
 
    <div id="app">
      
      <HeaderComponent />
      
      <div class="hero">
        <div class="hero-text">Istraži što grad nudi!</div>
          <div class="search-bar">
            <input type="text" placeholder="Pretraga..." />
            <button class="search-button">
              <i class="fas fa-search"></i> 
            </button>
          </div>
        <div class="button-container">
          <button  @click="routePostsPage" class="hero-button">Pregledaj sve objave!</button>
        </div>
      </div>
      <RouterView />
      <FooterComponent />
    </div>
  </template>
  
  <script>
  import HeaderComponent from "@/components/HeaderComponent.vue";
  import FooterComponent from "@/components/FooterComponent.vue";
  export default {
    name: "App",
    components: {
      HeaderComponent,
      FooterComponent,
    },
    methods: {
      routePostsPage() {
        this.$router.push({ name: 'Posts' });
      }
    }
  };
  </script>
  
  <style scoped>
  .hero {
    position: relative;
    display: flex;
    flex-direction: column;
    align-items: center;
    height: 80vh;
    background-image: url('@/assets/hero_img.jpg'); /* Replace with your image path */
    background-size: cover;
    background-position: center;
    padding-top: 20px; /* Add padding to position content below the header */
  }
  
  .hero-text {
    font-size: 2rem;
    color: white;
    text-align: center;
    margin-bottom: 20px;
    text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
    background-color: rgba(0, 0, 0, 0.5);
    padding: 10px 20px;
    border-radius: 10px;
    width: fit-content;
    
  }
  
  .button-container {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 100%;
    
    position: absolute; /* Position it absolutely relative to the hero section */
    top: 50%; /* Move it 50% down from the top */
    transform: translateY(-50%); /* Adjust position back up by 50% of the button height */
  }
  
  .hero-button {
    padding: 15px 30px;
    font-size: 1.2rem;
    background-color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s ease, transform 0.3s ease;
  }
  
  .hero-button:hover {
    background-color: #f0f0f0;
    transform: scale(1.05);
  }
  
  .search-bar {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 100%;
    margin-bottom: 30px;
  }
  
  .search-bar input {
    padding: 10px 15px;
    width: 70%; /* Adjust the width as needed */
    max-width: 400px;
    font-size: 1rem;
    border: 2px solid #fff;
    border-radius: 5px 0 0 5px; /* Rounded corners, leaving right side flat */
    outline: none;
    box-sizing: border-box; /* Ensures padding and border are included in width */
    flex-grow: 1; /* Allow the input to take available space */
  }
  
  .search-button {
    padding: 10px 20px;
    font-size: 1rem;
    background-color: #fff;
    border: 2px solid #fff;
    border-left: none; /* Remove border on the left to blend with input */
    border-radius: 0 5px 5px 0; /* Rounded corners for the right side */
    cursor: pointer;
    height: 100%; /* Match the height of the input */
    box-sizing: border-box; /* Ensure it aligns perfectly with the input */
    transition: background-color 0.3s ease;
    display: flex;
    align-items: center;
  }
  
  .search-button:hover {
    background-color: #f0f0f0;
  }
  
  
  </style>
  
  
  