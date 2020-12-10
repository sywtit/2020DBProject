<template slot="paneL">
  <v-card
    class="mx-auto my-12"
    max-width="374"
  >
   <v-img
      height="250"
      :src="require('../assets/camera.jpg')"
    ></v-img>

  </v-card>
</template>


<script>
  export default {
    name: 'HelloWorldImage',

    data: () => ({
    }),
  }
</script>