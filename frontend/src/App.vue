<template>
  <v-app id = "page">
    <!-- <v-img
      max-width="100%"
      max-height="100%"
      v-bind:src="back_image"
      gradient="to top right, rgba(150,150,150,.20), rgba(52,52,52,.9)"
      >
    </v-img> -->
    <section id="section1">
    <v-system-bar
      color="transparent"
      height="41" 
      id= "banner"
      >

<!-- style="position: absolute; right: 1%;" -->
      <v-btn flat class="img-size" 
       @click.stop="drawer = !drawer" id = "navigation_clicker">
       <img src="./assets/menu_icon.png"/>
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
          <v-list-item>
            <v-list-item-title>Foo</v-list-item-title>
          </v-list-item>

          <v-list-item>
            <v-list-item-title>Bar</v-list-item-title>
          </v-list-item>

          <v-list-item>
            <v-list-item-title>Fizz</v-list-item-title>
          </v-list-item>

          <v-list-item>
            <v-list-item-title>Buzz</v-list-item-title>
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
    <v-main>
       <!-- <split-pane :min-percent='20' split="vertical"> -->
      <HelloWorld/>
      <!-- <HelloWorldImage/> -->
       <!-- </split-pane> -->
    </v-main>
    </section>
      <section>
      <MainPageButton1 :scrollValue="this.scrollValue"/>
      </section>
      <section>
      <MainPageButton2 :scrollValue="this.scrollValue"/>
      </section>
  </v-app>
</template>

<script>
import HelloWorld from './components/HelloWorld';
import MainPageButton1 from './components/MainPageButton'
import MainPageButton2 from './components/MainPageButton2'
// import HelloWorldImage from './components/MainPageImage';

export default {
  name: 'App',

  components: {
    HelloWorld,
    MainPageButton1,
    MainPageButton2
    // HelloWorldImage
  },

  data: () => ({
     drawer: false,
     group: null,
     scrollValue: 0
  }),

  watch: {
      group () {
        this.drawer = false
      },
    },
  methods:{
    move: function()
    {
        this.scrollValue = window.scrollY;
        let value = 1 + this.scrollValue/-600;
        let el = document.getElementById("section1");
        el.style.opacity = value;
    }
  },

  created: function()
  {
    window.addEventListener('scroll', this.move);
  },
  destroyed: function()
  {
    window.removeEventListener('scroll', this.move);
  }
};
</script>

<style>
html{
  font-family: 'Nanum Gothic', sans-serif;
}

section
{
  position:relative;
  width:100%;
  min-height: 100vh;
  display:flex;
  overflow: hidden;
}

#section1
{
  top: 0;
  left: 0;
  /* background-image: linear-gradient(to top, #ffffff, #ffffff, #ffffff, #fffefe, #fffefe, #fdfcfc, #fbf9f9, #f9f7f7, #f5f3f3, #f1efef, #edebeb, #e9e7e7),
   url("./assets/white_mountains.jpg"); */
  background: url("./assets/white_mountains.jpg") no-repeat center center fixed; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;

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

#page
{
  background: #000;
}

.img-size img {
    width: 25px;
    height: 15px;
}

#app {
  font-family: 'Nanum Gothic', sans-serif;
}
::-webkit-scrollbar {
  width: 6px;
}
::-webkit-scrollbar-track {
  background-color: transparent;
}
::-webkit-scrollbar-thumb {
  border-radius: 3px;
  background-color: gray;
}
::-webkit-scrollbar-button {
  width: 0;
  height: 0;
}
</style>
