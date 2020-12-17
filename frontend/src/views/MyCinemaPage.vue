<template>
    <v-app id= "myCinemaPage">
    <section id="cinemaSection">
        <!-- <h1 class="my-3"
            contain
            id = "mainText3"
            >
          Hi, Lewis
        </h1> -->

        <h2 class="my-3"
            contain
            id = "mainText2">
            Here, Movies you reserved
        </h2>

        <LikeToSee/>
    </section>
    <section id="moviesSection">
              <h2 class="my-3"
            contain
            id = "mainText2">
            Your Movies
        </h2>

        <OwnMovies/>
         <v-btn flat id="buttonRight"
         color="transparent"
         v-on:click="HomeLink">
         Home
       </v-btn>

        </section>
    </v-app>
</template>

<script>
import LikeToSee from '../components/MyCinema/LikeToSee'
import OwnMovies from '../components/MyCinema/OwnMovies'
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
    name: 'MyCinemaPage',
    components:{
        LikeToSee,
        OwnMovies
    },
    methods:{
      HomeLink: function (){
         this.$router.push('/Home')
     }
    },
    data() {
          return {
            resData: {},
            movieQueue: [],
            userMovieList: [],
          }
        },
    created(){
      var userData = {
            customerId : localStorage.getItem("userId")
          }
          axios
                .post('http://localhost:5000/api/cinema', userData)
                .then(res => {
                    console.log('성공' + res.data);
                    this.resData = res.data;
                    console.log(this.resData);
                    this.movieQueue = this.resData.movieQueue;
                    this.userMovieList = this.resData.userMovieList;
                    localStorage.setItem("movieQueue", JSON.stringify(this.movieQueue));
                    localStorage.setItem("userMovieList", JSON.stringify(this.userMovieList));
                })
                .catch((err) => {
                    console.log(err)
                    alert('post 요청 실패' + userData)
                });
    }

    // beforeMount(){
    //   this.$nextTick(function () {
    //   location.reload();     
    // })
    
      
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Permanent+Marker&display=swap');

#myCinemaPage
{
    height: auto;
}

#cinemaSection{
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
#moviesSection{
  height: 900px;
  /* background-image: linear-gradient(to bottom, #353535, #313131, #2d2c2d, #292829, #252425, #212021, #1e1d1d, #1a1919, #151515, #100f0f, #080808, #000000); */
  background-color: #000000;
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