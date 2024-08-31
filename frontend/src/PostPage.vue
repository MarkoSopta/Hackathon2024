<template>
    <div id="app">
      <HeaderComponent />
  
      <div class="hero">
      <div class="post-info">
        
        
          <p v-if="post.name"><strong>Naziv:</strong> {{ post.name }}</p>
          <p v-if="post.description"><strong>Opis: </strong> {{ post.description }}</p>
          <p v-if="post.price"><strong>Cijena: </strong> {{ post.price }} KM</p>
          <p v-if="post.category"><strong>Kategorija: </strong> {{ post.category }}</p>
          <p v-if="post.type"><strong>Tip: </strong> {{ post.type }}</p>
         

      </div>
      <div class="post-image">
        <img src='@/assets/hero_img.jpg' alt="Post Image" />
      </div>
    </div>
  
      <FooterComponent />
    </div>
  </template>
  
  <script>
  import HeaderComponent from "@/components/HeaderComponent.vue";
  import FooterComponent from "@/components/FooterComponent.vue";
  import ApiClient from "./ApiClient";
  export default {
    name: "PostPage",
    components: {
      HeaderComponent,
      FooterComponent,
    },
    props: ['id'],
    data() {
      return {
        post: {}
      };
    },
    created() {
      this.fetchPost()
    },
    methods: {
      async fetchPost() {
      try {
        const response = await ApiClient.get(`/api/businesses/${this.id}`);
        this.post = response.data;
      } catch (error) {
        console.error('Error fetching post:', error);
      }
    }
    }
  };
  </script>
  
  <style scoped>

  .hero {
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 2rem;
    background-color: #e0e0e0;
    width: 100%;
    height: 80vh;
    box-sizing: border-box; /* Ensures padding is included in width */
  }
  
  .post-info, .post-image {
    width: 100%; /* Take full width within flexbox */
    margin-bottom: 1.5rem; /* Space between elements */
  }
  
  .post-title {
    font-size: 2.5rem;
    margin-bottom: 1rem;
    color: #333;
  }
  
  .post-attributes {
    font-size: 1.1rem;
    color: #555;
  }
  
  .attribute {
    margin-bottom: 0.5rem;
  }
  
  .post-image img {
    width: 100%; /* Image takes full width of container */
    height: auto; /* Maintain aspect ratio */
    border-radius: 10px;
    object-fit: contain;
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
  }
  
  @media (min-width: 768px) {
    .hero {
      flex-direction: row; /* Row layout on larger screens */
      justify-content: space-between;
      align-items: flex-start;
    }
  
    .post-info {
      flex: 1;
      margin-right: 2rem; /* Space between info and image */
    }
  
    .post-image {
      flex: 1;
      max-width: 500px; /* Limit the image size */
    }
  
    .post-title {
      font-size: 2.5rem; /* Ensure title remains prominent */
    }
  
    .post-attributes {
      font-size: 1.2rem;
    }
  }
  </style>
  