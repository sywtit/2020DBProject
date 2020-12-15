<template>
    <v-app id="Suggestion">
        <carousel-3d :width="800" :height="400">
        <slide v-for="(slide, i) in slides" :index="i" :key="i">
      <span class="title">You know</span>
      <p>You know, being a test pilot isn't always the healthiest business in the world.</p>
    </slide>
  </carousel-3d>
    </v-app>
</template>

<script>
import { Carousel3d, Slide } from 'vue-carousel-3d';

export default {
    name: 'Suggestion',
    data: () => ({
      slides: 5,
    }),
    components: {
        // 'carousel-3d': window['carousel-3d'].Carousel3d,
        // 'slide': window['carousel-3d'].Slide
        Carousel3d,
        Slide
    },
//     methods:{
//         loadOnce:function(){
//         location.reload();
//         }
//   },
     methods:{
         },
  created(){
    
  }
      
}
</script>

<style>

#Suggestion
{
    background: transparent;
    height: 500px;
    
}

.carousel-3d-container.carousel-3d-slide {
    padding: 20px;
}
.carousel-3d-container.carousel-3d-slide.title{
    font-size: 22px;
}

</style>