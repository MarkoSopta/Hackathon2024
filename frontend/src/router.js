import { createRouter, createWebHistory } from 'vue-router';
import HomePage from './HomePage.vue';
import PostsPage from './PostsPage.vue';

const routes = [
    { path: '/', component: HomePage, name: 'Home' },
    { path: '/objave', component: PostsPage, name: 'Posts' },
];

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes,
});
  
export default router;
