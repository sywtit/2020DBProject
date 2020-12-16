<template>
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
        v-for="(slide,n) in userMovieList"
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
        height="400px"
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
          <div id="titleName2">{{userMovieList[model].movieName}}</div>
          <v-chip
                close-icon="mdi-close-outline"
                color="orange"
                outlined
                link
                id="typeChip"
              >{{userMovieList[model].movieType}}</v-chip>
              <v-rating
              id="rate"
              v-model="userMovieList[model].rating"
              background-color="red lighten-2"
              color="red"
              size="22"
              small
            ></v-rating>
            <v-dialog
      v-model="dialog"
      persistent
      max-width="290"
    >
            <template v-slot:activator="{ on, attrs }">
            <v-btn flat 
              dark
              id="returnButton"
               v-bind="attrs"
               v-on="on">
              Return
            </v-btn>
            </template>
            <v-card>
        <v-card-title class="headline">
          Rate! (Return really not functioning)
        </v-card-title>
          <v-rating
              id="newrate"
              v-model="newRate"
              background-color="red lighten-2"
              color="red"
              size="22"
              small
            ></v-rating>        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn
            color="green darken-1"
            text
            @click="dialog = false"
          >
            Cancel
          </v-btn>
          <v-btn
            color="green darken-1"
            text
            @click="returnRate"
          >
            Return
          </v-btn>
        </v-card-actions>
      </v-card>
            </v-dialog>
            </v-col>
        </v-row>
      </v-sheet>
    </v-expand-transition>
  </v-sheet>
<!--   
<v-row id="ownMovies">
    <v-col
    v-for="i in 3"
    :key="i"
    cols="12"
    sm="4"
    md="3">
     <v-card
    class="mx-auto"
    max-width="400"
    @click="showDetail"
  >
    <v-img
      class="white--text align-end"
      height="200px"
      :src="require('../../assets/camera.jpg')"
    >
      <v-card-title>Top 10 Australian beaches</v-card-title>
    </v-img>

    <v-card-subtitle class="pb-0">
      Number 10
    </v-card-subtitle>

    <v-card-text class="text--primary">
      <div>Whitehaven Beach</div>

      <div>Whitsunday Island, Whitsunday Islands</div>
    </v-card-text>
  </v-card>
    </v-col>
          <app-my-modal
          title="This is modal"
          :visible.sync="visible">
        <div>
           This is modal body
         </div>
    </app-my-modal>
</v-row> -->

</template>
<script>
import axios from "axios"

// import MoviesDetailModal from './MoviesDetailModal'
export default {
    name: 'OwnMovies',
    data(){
        return {
        visible: false,
        model: null,
        imgsrc: [],
        userMovieList: [],
        element:null,
        dialog: false,
        newRate: 0
        }
    },
    components: {
        // appMyModal: MoviesDetailModal
    },
    methods: {
        showDetail(){
        this.visible = !this.visible
        },
        returnRate(){
          this.dialog = false;
          var rateData = {
            rating: this.newRate,
            movieId: this.userMovieList[this.model].movieId
          }
          axios
                .post('http://localhost:5000/api/rentalShop/rate', rateData)
                .then(res => {
                    console.log('성공' + res.data);
                })
                .catch((err) => {
                    console.log(err)
                    alert('post 요청 실패' + rateData)
                });
        }
    },
    created(){
      this.userMovieList = JSON.parse(localStorage.getItem("userMovieList"));
      for(var i =0 ; i<this.userMovieList.length; i++)
      {
        if(this.userMovieList[i].movieId == 1)
             {
               this.imgsrc.push(require("../../assets/godfather.jpg"));
             }
             else if(this.userMovieList[i].movieId == 2)
             {
               this.imgsrc.push(require("../../assets/shawshank.jpg"));

             }
             else if(this.userMovieList[i].movieId == 3)
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

#ownMovies{
    margin: 3%;
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
#returnButton{
  position:absolute;
  top:100%;
  right:10%;
}
</style>