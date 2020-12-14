<template>
  <div class="my-modal2"  elevation="24"
    v-if="visible2">
    <!-- @click.self="handleWrapperClick2" -->
    <div class="my-modal__dialog2">
      <!-- <header class="my-modal__header2">
        <span>{{title}}</span>
      </header> -->
      <div class="my-modal__body2">
        <slot></slot>
        <v-rating
          v-model="rating"
          background-color="red lighten-2"
          color="red"
          size="22"
          small
        ></v-rating>
      <button @click="wholeUpdate" id="returnButton" >Return</button>
      <button @click="$emit('update:visible2', !visible2)" id="cancelButton">Cancel</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'MovieRatingModal',
  data: () => ({
      rating: 0,
    }),
  props: {
    visible2: {
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
    // handleWrapperClick2(){
    //   this.$emit('update:visible', false)
    // },
    wholeUpdate(){
         this.$emit('update:visible2', false);
    }
  },
}
</script>

<style lang="scss">
$module: 'my-modal2';
.#{$module} {
  // This is modal bg
  background-color: rgba(36, 36, 36, 0.7);
  color: white;
  width: 30%;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  position:absolute;
  //This is modal layer
  &__dialog2{
    left: 50%;
    top: 50%;
    width: 80%;
    position: absolute;
    background: #fff;
    margin-bottom: 50px;
  }

  &__header2 {
    font-size: 28px;
    font-weight: bold;
    line-height: 1.29;
    padding: 16px 16px 0 25px;
    position: relative;
  }
  &__body2 {
    padding: 25px;
    min-height: 150px;
    max-height: auto;
    overflow-y: scroll;
  }
}
#returnButton
{
  position:absolute;
  right:23%;
  bottom:1%;
}
#cancelButton
{
    position:absolute;
    right:5%;
    bottom:1%;
}
</style>