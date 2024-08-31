<template>
  <div id="app">
    <HeaderComponent />

    <div class="hero">
      <div class="search-bar">
        <input type="text" placeholder="Pretraga..." v-model="searchQuery" @input="filterPosts" />
        <button class="search-button">
          <i class="fas fa-search"></i>
        </button>
      </div>

      <div class="filters">
        <div class="filter-options">
          <select class="dropdown" v-model="selectedCategory">
            <option value="">Kategorija</option>
            <option v-for="category in categories" :key="category" :value="category">
              {{ category }}
            </option>
          </select>

          <select class="dropdown" v-model="selectedSort">
            <option value="">Poredaj po</option>
            <option value="jeftino">Cijena-najniža</option>
            <option value="skupo">Cijena-najviša</option>
          </select>

          <!-- Conditionally show the "Osvježi" button -->
          <button v-if="selectedCategory || selectedSort" class="refresh-button" @click="filterPosts">
            Osvježi
          </button>
        </div>

        <router-link to="/dodaj-objavu" class="action-button">Dodaj objavu</router-link>
      </div>

      <div class="cards-container">
        <router-link
          v-for="(post, index) in filteredPosts"
          :key="index"
          :to="{ name: 'Post', params: { id: post.id } }"
          class="card"
        >
          <div class="card-content">
            <h3><strong>Naziv: </strong>{{ post.naslov }}</h3>
            <p><strong>Opis: </strong>{{ post.description }}</p>
            <p><strong>Kategorija: </strong>{{ post.category }}</p>
            <p><strong>Cijena: </strong>{{ post.price }} KM</p>
            <p v-if="post.type == 'Potraznja'" style="color: red">Potražnja</p>
          </div>
          <div v-if="post.image" class="card-image">
            <img :src="post.image" alt="Post Image" />
          </div>
        </router-link>
      </div>
    </div>

    <FooterComponent />
  </div>
</template>

<script>
import HeaderComponent from "@/components/HeaderComponent.vue";
import FooterComponent from "@/components/FooterComponent.vue";
import ApiClient from '@/ApiClient.js';

export default {
  name: "PostsPage",
  components: {
    HeaderComponent,
    FooterComponent,
  },
  data() {
    return {
      posts: [],
      filteredPosts: [],
      categories: [],
      selectedCategory: '',
      selectedSort: '',
      searchQuery: '', 
      loading: true,
      error: null,
    };
  },
  mounted() {
    this.fetchPosts();
  },
  methods: {
    async fetchPosts() {
      try {
        const response = await ApiClient.get('/api/businesses');
        this.posts = response.data;
        this.filteredPosts = this.posts;

        // Extract unique categories
        const categoriesSet = new Set();
        this.posts.forEach(post => {
          if (post.category) {
            categoriesSet.add(post.category);
          }
        });
        this.categories = Array.from(categoriesSet);

      } catch (error) {
        console.error('Error fetching posts:', error);
        this.error = 'Failed to load posts. Please try again later.';
      } finally {
        this.loading = false;
      }
    },
    filterPosts() {
      let filtered = this.posts;

      // Filter by search query
      if (this.searchQuery) {
        const query = this.searchQuery.toLowerCase();
        filtered = filtered.filter(post => post.naslov.toLowerCase().includes(query));
      }

      // Filter by category
      if (this.selectedCategory) {
        filtered = filtered.filter(post => post.category === this.selectedCategory);
      }

      // Sort by price
      if (this.selectedSort === 'jeftino') {
        filtered = filtered.sort((a, b) => a.price - b.price);
      } else if (this.selectedSort === 'skupo') {
        filtered = filtered.sort((a, b) => b.price - a.price);
      }

      this.filteredPosts = filtered;
    }
  },
  watch: {
    // Watch for route changes to update the search query and filter posts
    '$route.query.search'(newSearch) {
      this.searchQuery = newSearch || "";
      this.filterPosts();
    }
  }
};
</script>

  
  <style scoped>
  .hero {
  min-height: 100vh;
  padding: 20px;
  background-color: #e0e0e0;
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
  text-decoration: none;
  color: inherit;
}

.card:hover {
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); /* Example hover effect */
  transform: translateY(-2px); /* Slight lift effect */
  transition: all 0.3s ease;
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
  text-decoration: none;
}

.card-content p {
  margin: 5px 0;
  color: #555;
  text-decoration: none;
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
  justify-content: space-between; /* Space between the filter group and the button */
  align-items: center; /* Vertically centers the elements */
  width: 100%; /* Take the full width */
  margin-bottom: 20px; /* Space below filters */
}

.filter-options {
  display: flex;
  gap: 15px; /* Space between the dropdowns */
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

.action-button {
  padding: 10px 20px;
  font-size: 1rem;
  background-color: var(--background-color);
  color: var(--text-color);
  border:lab(from color l a b);
  border-radius: 10px;
  cursor: pointer;
  font-weight: bolder;
  text-decoration: none;
  transition: background-color 0.3s ease;
}

.action-button:hover {
  background-color: var(--secondary-color);
}

  </style>
  