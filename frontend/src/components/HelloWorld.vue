<template>
  <v-container id="mainPageContainer">
    <!-- <v-row class="text-center"> -->
      <!-- <v-col cols="12"> -->
        <!-- <v-img
          :src="require('../assets/brand_logo.png')"
          class="my-3"
          contain
          height="400"
        /> -->
        <h1 class="my-3"
            contain
            id = "mainText"
            >
          ending_credit
        </h1>
        
      <!-- </v-col> -->

      <v-col class="mb-4">
        <h1 class="display-2 font-weight-bold mb-3" id="subTitle">
          Welcome to your own cinema
        </h1>

        <p class="subheading font-weight-regular" id = "subContent">
          Hello, ending_credit users! your here to make your own cinema
          <br>if you have any trouble please contact
          <a
            href="youworthit17@ajou.ac.kr"
            target="_blank"
          >Developer E-mail</a>
        </p>
      </v-col>
      
       <!-- <v-btn flat class="button1-class"
       color="transparent">
         My Cinema
       </v-btn> -->

    <!-- </v-row> -->
  </v-container>

</template>

<script>
  export default {
    name: 'HelloWorld',

    data: () => ({
  
   
    }),
  }
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Fjalla+One&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Permanent+Marker&display=swap');

#mainText {
  font-family: 'Fjalla One', sans-serif;
  color: mintcream;
}

#subTitle{
    font-family: 'Fjalla One', sans-serif;
  color:mintcream;
}

#mainPageContainer
{
  padding-top: 18%;
}

#subContent
{
  font-family: 'Permanent Marker', cursive;
}

/* .button1-class
{
  clear:initial;
  position: absolute;
  bottom: 6%;
  width: 100px;
  height: auto;
  font-family: 'Permanent Marker', cursive;

} */
</style>
