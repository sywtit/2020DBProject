<template>
<section id="rental-section">
      <v-btn flat id="buttonRight"
         color="transparent"
         v-on:click="MovieRentalShopLink">
         Movies
         <br>
         Rental Shop
       </v-btn>
</section>
       <!-- <v-img src="../assets/right_arrow.png">
       </v-img> -->
</template>


<script>
  export default {
    name: 'MainPageButton2',

    data: () => ({
        newScrollValue2 : 0
    }),
    props:
    {
       scrollValue : Number
    },
    methods:{
      MovieRentalShopLink: function (){
         this.$router.push('/movieRentalShop');
     }
    },
     watch: {

      scrollValue: function () {
            let detailValue = this.scrollValue;
            if(detailValue >= 774.9999389648438) 
            {
                detailValue = detailValue - 774.9999389648438;

                if(this.newScrollValue2 <= detailValue)
                {
                    let value = -detailValue/-600;
                    let el = document.getElementById("rental-section");
                    el.style.opacity = value;
                }
                else
                {
                    // let value = 1 + detailValue/-600;
                    // let el = document.getElementById("rental-section");
                    // el.style.opacity = value;
                    //do nothing
                }

                this.newScrollValue2 = detailValue;
            }

        }
     }
   
  }
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Permanent+Marker&display=swap');


#buttonRight
{
    font-family: 'Permanent Marker', cursive;
    position: absolute;
    right: 3%;
    bottom: 10%;
    padding: 10px;
    height: auto;
    font-size: 20px;
    
}

#rental-section
{
/* background-image: linear-gradient(to top, #ffffff, #ffffff, #ffffff, #fffefe, #fffefe, #fdfcfc, #fbf9f9, #f9f7f7, #f5f3f3, #f1efef, #edebeb, #e9e7e7),
   url("./assets/white_mountains.jpg"); */
  position:relative;
  width:100%;
  min-height: 100vh;
  display:flex;
  overflow: hidden;
  /* background-image: linear-gradient(to top, #ffffff, #ffffff, #ffffff, #fffefe, #fffefe, #fdfcfc, #fbf9f9, #f9f7f7, #f5f3f3, #f1efef, #edebeb, #e9e7e7); */
  background: url("../assets/dvd-shelves.jpeg") no-repeat center center fixed;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}

</style>
