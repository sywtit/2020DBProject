<template>
    <v-system-bar
      color="transparent"
      height="41" 
      id= "banner"
      >

<!-- style="position: absolute; right: 1%;" -->
      <v-btn flat class="img-size" 
       @click.stop="drawer = !drawer" id = "navigation_clicker">
       <img src="../assets/menu_icon.png"/>
       </v-btn>

      <v-navigation-drawer v-model="drawer"  absolute bottom temporary
      width="300px"
      height="100%"
      color= "rgba(255, 255, 255, 0.8)"
      >

         <v-list
        nav
        dense
      >
        <v-list-item-group
          v-model="group"
        >
          <v-list-item  v-on:click="MyCinema">
            <v-list-item-title>My Cinema</v-list-item-title>
          </v-list-item>

          <v-list-item v-on:click ="MovieRentalShop">
            <v-list-item-title>Movie Rental Shop</v-list-item-title>
          </v-list-item>

          <v-list-item v-on:click="MyAccount">
            <v-list-item-title>My Account</v-list-item-title>
          </v-list-item>
        </v-list-item-group>
      </v-list>
     </v-navigation-drawer>
      <!-- <div class="d-flex align-center">
        <v-img
          alt="Vuetify Logo"
          class="shrink mr-2"
          contain
          src="https://cdn.vuetifyjs.com/images/logos/vuetify-logo-dark.png"
          transition="scale-transition"
          width="40"
        />

        <v-img
          alt="Vuetify Name"
          class="shrink mt-1 hidden-sm-and-down"
          contain
          min-width="100"
          src="https://cdn.vuetifyjs.com/images/logos/vuetify-name-dark.png"
          width="100"
        />
      </div> -->

      <v-spacer></v-spacer>

      <!-- <v-btn
        href="https://github.com/vuetifyjs/vuetify/releases/latest"
        target="_blank"
        text
      >
        <span class="mr-2">Latest Release</span>
        <v-icon>mdi-open-in-new</v-icon>
      </v-btn> -->
    </v-system-bar>
</template>

<script>
export default {
    name: 'Menu',

    data: () => ({
     drawer: false,
     group: null
  }),

  watch: {
      group () {
        this.drawer = false
      },
    },
  methods:{
    MyAccount: function (){
         this.$router.push('/myAccount')
     },
    MyCinema: function(){
      this.$router.push('/myCinema')
    },
    MovieRentalShop: function(){
      this.$router.push('/movieRentalShop')
    }

  }
}
</script>

<style>

.img-size img {
    width: 25px;
    height: 15px;
}

#navigation_clicker{
  padding: 0; 
  border: 0; 
  box-shadow: none;
  border-radius: 0px;
  background: transparent;
  width:20px;
  height: 25px;
}

</style>