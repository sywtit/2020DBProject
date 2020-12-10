<template>
<section id="cinema-section">
    <v-container id="mainPageCinemaContainer">
        <h1 class="my-3"
            contain
            id = "mainText"
            >
          ending_credit
        </h1>
        
      <!-- </v-col> -->

      <v-col class="mb-4">
        <h1 class="display-2 font-weight-bold mb-3" id="subTitle">
          You can get your own cinema
        </h1>

        <p class="subheading font-weight-regular" id = "subCinemaContent">
          WILL GIVE INSTRUCTION ON DB PROJECT
          <br>if you have any trouble please contact
        </p>
      </v-col>
      
       <!-- <v-btn flat class="button1-class"
       color="transparent">
         My Cinema
       </v-btn> -->

    <!-- </v-row> -->
  </v-container>
      <v-btn flat id="buttonLeft"
         color="transparent">
         My Cinema
       </v-btn>
</section>
</template>


<script>
  export default {
    name: 'MainPageButton1',

    data: () => ({
        newScrollValue : this.scrollValue
    }),
    props:
    {
       scrollValue : Number
    },
    methods:{
    },
  watch: {
      scrollValue: function () {
            let detailValue = this.scrollValue;
            if(detailValue >= 774.9999389648438) 
            {
                detailValue = detailValue - 774.9999389648438;
                let value = 1 + detailValue/-600;
                let el = document.getElementById("cinema-section");
                el.style.opacity = value;
            }
            else
            {
                let value = -detailValue/-600;
                let el = document.getElementById("cinema-section");
                el.style.opacity = value;
            }
    }
  }

  }
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Permanent+Marker&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Permanent+Marker&display=swap');


#buttonLeft
{
    font-family: 'Permanent Marker', cursive;
    position: absolute;
    left: 3%;
    bottom: 10%;
    padding: 10px;
    height: auto;
    font-size: 20px;
    color: white;
    
}

#cinema-section
{
/* background-image: linear-gradient(to top, #ffffff, #ffffff, #ffffff, #fffefe, #fffefe, #fdfcfc, #fbf9f9, #f9f7f7, #f5f3f3, #f1efef, #edebeb, #e9e7e7),
   url("./assets/white_mountains.jpg"); */
  position:relative;
  width:100%;
  min-height: 100vh;
  display:flex;
  overflow: hidden;
  background: url("../assets/cinema.jpg") no-repeat center center fixed;
  opacity:0;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}

#mainPageCinemaContainer
{
  padding-top: 9%;
  padding-left: 50%;
}

#subCinemaContent
{
    color: white;
    font-family: 'Permanent Marker', cursive;

}
</style>