<template>
    <v-app id= "movieRentalShopPage">
    <section>
        <h2 class="my-3"
            contain
            id = "mainText2">
            Todays Movies for you
        </h2>

        <Suggestion/>
    </section>
    <section id="sectionMovieList">
              <h2 class="my-3"
            contain
            id = "mainText2">
            Movie List
        </h2>
 <section id="search">
        <v-toolbar
          dark
          color="transparent"
          class="mb-1"
        >
         <v-text-field
            id="searchText"
            v-model="text"
            clearable
            flat
            solo-inverted
            hide-details
            prepend-inner-icon="mdi-magnify"
            label="Search"
          ></v-text-field>
          <template v-if="$vuetify.breakpoint.mdAndUp">
            <v-spacer></v-spacer>
            <v-select
              id="selectText"
              v-model="sortBy"
              flat
              solo-inverted
              hide-details
              :items="keys"
              prepend-inner-icon="mdi-magnify"
              label="Sort by"
            ></v-select>
           <v-spacer></v-spacer>
            <v-btn>
              SEARCH
            </v-btn>
          </template>
        </v-toolbar>
          <div class="mt-2">Value: {{ text }}</div>
          <v-chip
            close-icon="mdi-close-outline"
            color="orange"
            outlined
            link
          >Drama</v-chip>
           <v-chip
            close-icon="mdi-close-outline"
            color="orange"
            outlined
            link
          >Comedy</v-chip>
        </section>
        <MovieList/>
         <v-btn flat id="buttonRight"
         color="transparent"
         v-on:click="HomeLink">
         Home
       </v-btn>

        </section>
    </v-app>
</template>

<script>
import Suggestion from '../components/MovieRentalShop/Suggestion'
import MovieList from '../components/MovieRentalShop/MovieList'

// if (location.href.indexOf('#reload') == -1)
//   location.href += '#reload'
//  window.onload = function() {
//     if (!window.location.hash) {
//         window.location = window.location + '#loaded';
//         window.location.reload();
//     }
// }

export default {
    name: 'MovieRentalShopPage',
    data() {
      return {
        text: '',
        sortBy: 'name',
        keys: [
          'movie name',
          'actors'
        ],
      }
    },
    components:{
        Suggestion,
        MovieList
    },
    methods:{
      HomeLink: function (){
         this.$router.push('/Home')
     }
    },
    // beforeMount(){
    //   this.$nextTick(function () {
    //   location.reload();     
    // })
    
      
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Permanent+Marker&display=swap');

#movieRentalShopPage
{
    height: auto;
background-image: linear-gradient(to bottom, #353535, #313131, #2d2c2d, #292829, #252425, #212021, #1e1d1d, #1a1919, #151515, #100f0f, #080808, #000000);

}
#mainText3{
    font-family: 'Permanent Marker', cursive;
    position: relative;
    /* right: 3%;
    bottom: 10%; */
    padding: 10px;
    height: auto;
    font-size: 40px;
    color:aliceblue;
    
}

#mainText2
{
    font-family: 'Permanent Marker', cursive;
    position: relative;
    /* right: 3%;
    bottom: 10%; */
    padding: 10px;
    height: auto;
    font-size: 30px;
    color:aliceblue;
}
#buttonRight
{
    font-family: 'Permanent Marker', cursive;
    position: fixed;
    right: 3%;
    bottom: 3%;
    padding: 10px;
    height: auto;
    font-size: 20px;
    color: aliceblue;
    
}

#sectionMovieList{
  height: 1000px;
}

#search{
  margin:20px;
  width: 55%;
  position: relative;
  left: 25%;
}

::-webkit-scrollbar {
  width: 6px;
}
::-webkit-scrollbar-track {
  background-color: transparent;
}
::-webkit-scrollbar-thumb {
  border-radius: 3px;
  background-color: gray;
}
::-webkit-scrollbar-button {
  width: 0;
  height: 0;
}
</style>