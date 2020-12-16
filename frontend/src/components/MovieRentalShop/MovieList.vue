<template>
<section>
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
            <v-btn @click="search">
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
            @click="drama"
          >Drama</v-chip>
           <v-chip
            close-icon="mdi-close-outline"
            color="orange"
            outlined
            link
            @click="comedy"
          >Comedy</v-chip>
        </section>
  <v-sheet
    class="mx-auto"
    elevation="8"
    color="transparent"
  >
    <v-slide-group
      v-model="model"
      class="pa-4"
      show-arrows
      color="white"
    >
      <v-slide-item
        v-for="(slide,n) in wholeMovieList"
        :key="n"
        :index="n"
        v-model="element"
        v-slot="{ active, toggle }"
      >
        <v-card
          :color="active ? 'primary' : 'grey lighten-1'"
          class="ma-4"
          height="200"
          width="340"
          @click="toggle"
        >
        <img width="100%" height="100%" v-bind:src="imgsrc[n]" />
          <v-row
            class="fill-height"
            align="center"
            justify="center"
          >
            <v-scale-transition>
              <!-- <v-icon
                v-if="active"
                color="white"
                size="48"
                v-text="'mdi-close-circle-outline'"
              ></v-icon> -->
            </v-scale-transition>
          </v-row>
        </v-card>
      </v-slide-item>
    </v-slide-group>

    <v-expand-transition>
      <v-sheet
        v-if="model != null"
        height="400"
        tile
        color="transparent"
      >
        <v-row
          class="fill-height"
          align="center"
          justify="center"
        >
        <v-col
            cols="8"
          >
          <img id= "imgInside" width="80%" height="90%" v-bind:src="imgsrc[model]" />
           </v-col>
            <v-col
            cols="4"
          >
          <div id="titleName2">{{wholeMovieList[model].movieName}}</div>
          <v-chip
                close-icon="mdi-close-outline"
                color="orange"
                outlined
                link
                id="typeChip"
              >{{wholeMovieList[model].movieType}}</v-chip>
              <v-rating
              id="rate"
              v-model="wholeMovieList[model].rating"
              background-color="red lighten-2"
              color="red"
              size="22"
              small
            ></v-rating>
            </v-col>
        </v-row>
      </v-sheet>
    </v-expand-transition>
  </v-sheet>
</section>
</template>

<script>
import axios from "axios"
// import func from '../../../vue-temp/vue-editor-bridge';

export default {
    name: 'MovieList',
    data: () => ({
      model: null,
      visible: false,
        imgsrc: [],
        wholeMovieList: [],
        element:null,
        text: '',
        sortBy: '',
        keys: [
          'movie name',
          'actors'
        ],
        resData: [],
        actorDatas: []
    }),

    created(){
      this.wholeMovieList = JSON.parse(localStorage.getItem("wholeMovieList"));
      for(var i =0 ; i<this.wholeMovieList.length; i++)
      {
        if(this.wholeMovieList[i].movieId == 1)
             {
               this.imgsrc.push(require("../../assets/godfather.jpg"));
             }
             else if(this.wholeMovieList[i].movieId == 2)
             {
               this.imgsrc.push(require("../../assets/shawshank.jpg"));

             }
             else if(this.wholeMovieList[i].movieId == 3)
             {
               this.imgsrc.push(require("../../assets/borat.jpg"));
             }
             else 
             {
               this.imgsrc.push(require("../../assets/bigshort.jpg"));

             }
      }
    },
    methods:{
        search: function(){
        if(this.sortBy == "movie name")
        {
        var movieData = {
            movieName : this.text
          }
          axios
                .post('http://localhost:5000/api/rentalShop/byMovieName', movieData)
                .then(res => {
                    console.log('성공' + res.data);
                    this.resData = res.data;
                    console.log(this.resData);
                    this.wholeMovieList = this.resData;
                    localStorage.setItem("wholeMovieList", JSON.stringify(this.wholeMovieList));
                    location.reload();
                })
                .catch((err) => {
                    console.log(err)
                    alert('post 요청 실패' + movieData)
                });
        }
        
        else if(this.sortBy == "actors")
        {
            this.actorDatas = this.text.split(',');
            if(this.actorDatas.length == 1)
            {
                var actorData = {
                    actorName : this.actorDatas[0]
                }
                axios
                .post('http://localhost:5000/api/rentalShop/byActors', actorData)
                .then(res => {
                    console.log('성공' + res.data);
                    this.resData = res.data;
                    console.log(this.resData);
                    this.wholeMovieList = this.resData;
                    localStorage.setItem("wholeMovieList", JSON.stringify(this.wholeMovieList));
                    location.reload();
                })
                .catch((err) => {
                    console.log(err)
                    alert('post 요청 실패' + actorData)
                });
            }
            else if(this.actorDatas.length == 2)
            {
                var actorData2 = [
                    {
                        actorName : this.actorDatas[0]
                    },
                    {
                        actorName: this.actorDatas[1]
                    }
                ]

                axios
                .post('http://localhost:5000/api/rentalShop/byActors', actorData2)
                .then(res => {
                    console.log('성공' + res.data);
                    this.resData = res.data;
                    console.log(this.resData);
                    this.wholeMovieList = this.resData;
                    localStorage.setItem("wholeMovieList", JSON.stringify(this.wholeMovieList));
                    location.reload();
                })
                .catch((err) => {
                    console.log(err)
                    alert('post 요청 실패' + actorData2)
                });
            }

        }
        },
        drama: function(){
             var movieData = {
            movieType : 'Drama'
          }
          axios
                .post('http://localhost:5000/api/rentalShop/byType', movieData)
                .then(res => {
                    console.log('성공' + res.data);
                    this.resData = res.data;
                    console.log(this.resData);
                    this.wholeMovieList = this.resData;
                    localStorage.setItem("wholeMovieList", JSON.stringify(this.wholeMovieList));
                    location.reload();
                })
                .catch((err) => {
                    console.log(err)
                    alert('post 요청 실패' + movieData)
                });
        },
        comedy: function(){
             var movieData = {
            movieType : 'Comedy'
          }
          axios
                .post('http://localhost:5000/api/rentalShop/byType', movieData)
                .then(res => {
                    console.log('성공' + res.data);
                    this.resData = res.data;
                    console.log(this.resData);
                    this.wholeMovieList = this.resData;
                    localStorage.setItem("wholeMovieList", JSON.stringify(this.wholeMovieList));
                    location.reload();
                })
                .catch((err) => {
                    console.log(err)
                    alert('post 요청 실패' + movieData)
                });
        }
    }
  }
</script>

<style>
.title{
    color: white;
}

#search{
  margin:20px;
  width: 55%;
  position: relative;
  left: 25%;
}
#typeChip{
  position: relative;
  left:10px;
}
#titleName2{
  color: white;
  font-size: 40px;
}
#rate{
  position: absolute;
  right: 10%;
  bottom:3%;
}
#imgInside{
  position: relative;
  left:15%;
}
</style>