<template>
    <div id="app">
      <HeaderComponent />
  
      <div class="hero">
        <div class="search-bar">
          <input type="text" placeholder="Search..." />
          <button class="search-button">
            <i class="fas fa-search"></i>
          </button>
        </div>
  
        <div class="filters">
          <select class="dropdown">
            <option value="" >Kategorija</option>
            <option value="option1">Option 1</option>
            <option value="option2">Option 2</option>
          </select>
  
          <select class="dropdown">
            <option value="" >Poredaj po</option>
            <option value="option1">Option 1</option>
            <option value="option2">Option 2</option>
          </select>
        </div>
  
        <div class="cards-container">
          <div class="card" v-for="(post, index) in posts" :key="index">
            
            <div class="card-content">
              <h3>{{ post.title }}</h3>
              <p>{{ post.description }}</p>
              <p>{{ post.additionalInfo }}</p>
            </div>
            <div v-if="post.image" class="card-image">
              <img :src="post.image" alt="Post Image" />
            </div>
          </div>
        </div>
      </div>
  
      <FooterComponent />
    </div>
  </template>
  
  <script>
  import HeaderComponent from "@/components/HeaderComponent.vue";
  import FooterComponent from "@/components/FooterComponent.vue";
  
  export default {
    name: "PostsPage",
    components: {
      HeaderComponent,
      FooterComponent,
    },
    data() {
      return {
        posts: [
          {
            title: "Post 1",
            description: "This is the description for post 1.",
            additionalInfo: "Additional info for post 1.",
            image: require('@/assets/hero_img.jpg'),
          },
          {
            title: "Post 2",
            description: "This is the description for post 2.",
            additionalInfo: "Additional info for post 2.",
            image: require('@/assets/logo.png'),
          },
          {
            title: "Post 2",
            description: "This is the description for post 2.",
            additionalInfo: "Additional info for post 2.",
            image: require('@/assets/kvalitet.png'),
          },
          {
            title: "Post 2",
            description: "This is the description for post 2.",
            additionalInfo: "Additional info for post 2.",
            image: require('@/assets/money.png'),
          },
          {
            title: "Post 2",
            description: "This is the description for post 2.",
            additionalInfo: "Additional info for post 2.",
            image: require('@/assets/person.jpg'),
          },
          {
            title: "Post 2",
            description: "This is the description for post 2.",
            additionalInfo: "Additional info for post 2.",
            image: require('@/assets/personog.jpg'),
          },
          // Add more post objects as needed
        ],
      };
    },
  };
  </script>
  
  <style scoped>
  .hero {
  padding: 20px;
  background-color: #f5f5f5;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.cards-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 20px;
  padding: 20px;
  width: 100%;
}


.card {
  background-color: white;
  border: 1px solid #ddd;
  border-radius: 10px;
  box-shadow: 0px 2px 8px rgba(0, 0, 0, 0.1);
  display: flex;
  flex-direction: row;
  width: 100%;
  max-width: 450px; /* Adjust the max width as needed */
  min-height: 300px; /* Make cards taller */
}

.card-image {
  width: 45%; /* Allocate about half of the card for the image */
  overflow: hidden;
  border-radius: 10px 0 0 10px; /* Rounded corners only on the left */
}

.card-image img {
    height: 100%;
    width: 100%;
  
  object-fit: contain; /* Ensures the image covers the area without distortion */
}

.card-content {
  width: 55%; /* Remaining space for the text */
  padding: 15px;
  display: flex;
  flex-direction: column;
  justify-content: center;
}

.card-content h3 {
  margin-top: 0;
  margin-bottom: 10px;
  font-size: 1.2rem;
}

.card-content p {
  margin: 5px 0;
  color: #555;
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

  .filters {
  display: flex;
  justify-content: flex-start; /* Aligns filters to the left */
  align-items: center; /* Vertically centers the dropdowns */
  gap: 15px; /* Space between dropdowns */
  margin-bottom: 20px; /* Space below filters */
  width: 100%;
}

.dropdown {
  padding: 10px;
  font-size: 1rem;
  color: #333;
  background-color: #f9f9f9;
  border: 2px solid #ddd;
  border-radius: 5px;
  appearance: none; /* Removes default styling in most browsers */
  outline: none;
  cursor: pointer;
}

.dropdown:focus {
  border-color: #3498db; /* Highlight border on focus */
}


  </style>
  