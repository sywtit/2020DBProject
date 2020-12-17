<template>
    <v-app id= "movieRentalShopPage">
    <section>
        <h2 class="my-3"
            contain
            id = "mainText2">
            Best Seller
        </h2>

        <Suggestion/>
    </section>
    <section id="sectionMovieList">
              <h2 class="my-3"
            contain
            id = "mainText2">
            Movie List
        </h2>
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
import axios from "axios"

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
        resData: {},
            wholeMovieList: [],
            bestSellerList: []
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
    created(){
      var userData = {
            customerId : localStorage.getItem("userId")
          }
          axios
                .post('http://localhost:5000/api/rentalShop/blob', userData)
                .then(res => {
                    console.log('성공' + res.data);
                    this.resData = res.data;
                    console.log(this.resData);
                    this.wholeMovieList = this.resData.wholeMovieList;
                    this.bestSellerList = this.resData.bestSellerList;
                    localStorage.setItem("wholeMovieList", JSON.stringify(this.wholeMovieList));
                    localStorage.setItem("bestSellerList", JSON.stringify(this.bestSellerList));
                })
                .catch((err) => {
                    console.log(err)
                    alert('post 요청 실패' + userData)
                });
    }
    
      
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