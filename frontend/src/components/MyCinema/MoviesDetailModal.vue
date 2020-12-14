<template>
  <div class="my-modal"  elevation="24"
    v-if="visible"  @mousedown.stop>
    <!-- @click.self="handleWrapperClick" -->
    <div class="my-modal__dialog">
      <header class="my-modal__header">
        <span>{{title}}</span>
        <v-img
      height="200px"
      :src="require('../../assets/white_mountains.jpg')"
      />
      </header>
      <div class="my-modal__body">
        <slot></slot>
        <v-rating
          v-model="rating"
          background-color="red lighten-2"
          color="red"
          size="22"
          small
        ></v-rating>
        <!-- <v-rating
          background-color="red lighten-2"
          color="red"
          empty-icon="$mdiStarOutline"
          full-icon="$mdiStar"
          half-icon="$mdiStarHalfFull"
          hover
          length="5"
          readonly
          size="22"
          value="3.5"
        ></v-rating> -->
      <button @click="showRating" id="updateButton">Return</button>
      <button @click="$emit('update:visible', !visible)" id="closeButton">Close</button>
      <app-my-modal
          :visible2.sync="visible2">
        <div>
           Do You Enjoy?
         </div>
      </app-my-modal>
      </div>
    </div>
  </div>
</template>

<script>

import MovieRatingModal from './MovieRatingModal'

export default {
  name: 'MoviesDetailModal',
    components: {
        appMyModal: MovieRatingModal
    },
  data(){
    return{
      rating: 4,
      visible2: false,
      visible2Count: 0,
    }
    },
  props: {
    visible: {
      type: Boolean,
      require: true,
      default: false
    },
    title: {
      type: String,
      require: false,
    },
  },
  methods: {
    // handleWrapperClick(){
    //   this.$emit('update:visible', false)
    // },
    showRating(){
        this.visible2 = !this.visible2;
        this.visible2Count++;
        // this.$emit('update:visible', false);
        } 
  },
  watch: {
    visible2: function () {
      if(this.visible2Count>0 && this.visible2 == false)
      {
        this.$emit('update:visible', false);
      }
    }
  },
}
</script>

<style lang="scss">
$module: 'my-modal';
.#{$module} {
  // This is modal bg
  background-color: rgba(0,0,0,.7);
  width: 80%;
  left: 50%;
  top: 50%;
  transform: translate(-90%, -50%);
  position:absolute;
  //This is modal layer
  &__dialog{
    left: 50%;
    top: 50%;
    width: 80%;
    position: absolute;
    background: #fff;
    margin-bottom: 50px;
  }

  &__header {
    font-size: 28px;
    font-weight: bold;
    line-height: 1.29;
    padding: 16px 16px 0 25px;
    position: relative;
  }
  &__body {
    padding: 25px;
    min-height: 150px;
    max-height: auto;
    overflow-y: scroll;
  }
}
#updateButton
{
  position:absolute;
  right:10%;
  bottom:1%;
}
#closeButton
{
    position:absolute;
    right:5%;
    bottom:1%;
}
</style>