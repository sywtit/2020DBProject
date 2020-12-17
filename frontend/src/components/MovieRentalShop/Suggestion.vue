<template>
    <v-app id="Suggestion">
        <carousel-3d :width="800" :height="400">
        <slide v-for="(slide, i) in bestSellerList" :index="i" :key="i">
       <img width="100%" height="80%" v-bind:src="imgsrc[i]" />
      <span id="titleName">{{i+1}}.{{slide.movieName}}</span>
      <v-chip
            close-icon="mdi-close-outline"
            color="orange"
            outlined
            link
            id="typeChip"
          >{{slide.movieType}}</v-chip>
          <v-rating
          id="rate"
          v-model="slide.rating"
          background-color="red lighten-2"
          color="red"
          size="22"
          small
        ></v-rating>
    </slide>
  </carousel-3d>
    </v-app>
</template>

<script>
import { Carousel3d, Slide } from 'vue-carousel-3d';

export default {
    name: 'Suggestion',
    data: () => ({
      slides: 3,
      bestSellerList: [],
      imgsrc:[]
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
     this.bestSellerList=JSON.parse(localStorage.getItem("bestSellerList"));
          this.slides = this.bestSellerList.length;
          for(var i = 0; i<this.slides; i++)
          {
             if(this.bestSellerList[i].movieId == 1)
             {
               this.imgsrc.push(require("../../assets/godfather.jpg"));
             }
             else if(this.bestSellerList[i].movieId == 2)
             {
               this.imgsrc.push(require("../../assets/shawshank.jpg"));

             }
             else if(this.bestSellerList[i].movieId == 3)
             {
               this.imgsrc.push(require("../../assets/borat.jpg"));
             }
             else 
             {
               this.imgsrc.push(require("../../assets/bigshort.jpg"));

             }
          }
  }
      
}
</script>

<style>

#Suggestion
{
    background: transparent;
    height: 500px;
    
}
#typeChip{
  position: relative;
  left:10px;
}
#titleName{
  font-size: 40px;
}
#rate{
  position: absolute;
  right: 10px;
  bottom:10px;
}
.carousel-3d-container.carousel-3d-slide {
    padding: 20px;
}
.carousel-3d-slide{
    background-color:transparent;
    color: white;
    border-color: transparent;
}
.carousel-3d-container.carousel-3d-slide.title{
    font-size: 22px;
}

</style>