<template>
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
</v-row>

</template>
<script>

import MoviesDetailModal from './MoviesDetailModal'
export default {
    name: 'OwnMovies',
    data(){
        return {
        visible: false
        }
    },
    components: {
        appMyModal: MoviesDetailModal
    },
    methods: {
        showDetail(){
        this.visible = !this.visible
        } 
    }
}
</script>
<style>

#ownMovies{
    margin: 3%;
}
</style>