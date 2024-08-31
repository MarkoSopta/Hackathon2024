import { createRouter, createWebHistory } from 'vue-router';
import HomePage from './HomePage.vue';
import PostsPage from './PostsPage.vue';
import PrijavaPage from './PrijavaPage.vue';
import PostPage from './PostPage.vue';
import AddPostPage from './AddPostPage.vue';
const routes = [
    { path: '/', component: HomePage, name: 'Home' },
    { path: '/objave', component: PostsPage, name: 'Posts' },
    { path: '/prijava', component: PrijavaPage, name: 'Prijava' },
    { path: '/post/:id', name: 'Post', component: PostPage, props: true },
    { path: '/dodaj-objavu', name: 'AddPost', component: AddPostPage }, 
];

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes,
});
  
export default router;
