<template>
    <div id="app">
      <HeaderComponent />
  
      <div class="content">
        <div class="form-container">
          <h1>Dodaj Novi Oglas</h1>
          <form @submit.prevent="handleSubmit">
            <div class="input-group">
              <label for="title">Naslov</label>
              <input type="text" id="title" v-model="post.title" required />
            </div>
  
            <div class="input-group">
              <label for="description">Opis</label>
              <textarea id="description" v-model="post.description" required></textarea>
            </div>
  
            <div class="input-group">
              <label for="price">Cijena</label>
              <input type="number" id="price" v-model="post.price" required />
            </div>
  
            <div class="input-group">
              <label for="category">Kategorija</label>
              <select id="category" v-model="post.category" required>
                <option value="Elektronika">Elektronika</option>
                <option value="Nekretnine">Nekretnine</option>
                <option value="Automobili">Automobili</option>
                <!-- Add more categories as needed -->
              </select>
            </div>
  
            <div class="input-group">
              <label for="image">Dodaj Sliku</label>
              <input type="file" id="image" @change="handleImageUpload" />
            </div>
  
            <button type="submit" class="submit-button">Dodaj Oglas</button>
          </form>
        </div>
  
        <div class="image-preview" v-if="post.image">
          <h2>Pregled Slike</h2>
          <img :src="post.image" alt="Preview" />
        </div>
      </div>
  
      <FooterComponent />
    </div>
  </template>
  
  <script>
  import HeaderComponent from "@/components/HeaderComponent.vue";
  import FooterComponent from "@/components/FooterComponent.vue";
  
  export default {
    name: "AddPostPage",
    components: {
      HeaderComponent,
      FooterComponent,
    },
    data() {
      return {
        post: {
          title: '',
          description: '',
          price: '',
          category: '',
          image: null,
        },
      };
    },
    methods: {
      handleImageUpload(event) {
        const file = event.target.files[0];
        if (file) {
          this.post.image = URL.createObjectURL(file);
        }
      },
      handleSubmit() {
        // Handle form submission
        console.log('Post submitted:', this.post);
        // You can add logic here to send the post data to a server or store it locally
      },
    },
  };
  </script>
  
  <style scoped>

  .content {
    height: 80vh;
    display: flex;
    flex-direction: row;
    align-items: flex-start;
    gap: 40px;
    padding: 20px;
    width: 60rem;
  }
  
  .form-container {
    flex: 1;
    
  }
  
  .form-container h1 {
    margin-bottom: 20px;
  }
  
  .input-group {
    margin-bottom: 15px;
  }
  
  .input-group label {
    display: block;
    margin-bottom: 5px;
    font-weight: bold;
  }
  
  .input-group input,
  .input-group textarea,
  .input-group select {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
  }
  
  .submit-button {
    padding: 10px 20px;
    font-size: 1rem;
    background-color: #3498db;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s ease;
  }
  
  .submit-button:hover {
    background-color: #2980b9;
  }
  
  .image-preview {
    flex: 1;
    text-align: center;
  }
  
  .image-preview h2 {
    margin-bottom: 20px;
  }
  
  .image-preview img {
    max-width: 100%;
    max-height: 300px;
    border-radius: 10px;
    object-fit: contain;
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
  }
  </style>
  