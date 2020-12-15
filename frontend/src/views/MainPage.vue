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
    <Menu/>
<!-- style="position: absolute; right: 1%;" -->
      
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
import HelloWorld from '../components/HelloWorld';
import MainPageButton1 from '../components/MainPageButton'
import MainPageButton2 from '../components/MainPageButton2'
import Menu from '../components/Menu'
// import HelloWorldImage from './components/MainPageImage';

export default {
  name: 'MainPage',

  components: {
    HelloWorld,
    MainPageButton1,
    MainPageButton2,
    Menu
    // HelloWorldImage
  },

  data: () => ({
     scrollValue: 0
  }),

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
    localStorage.setItem('userId', 444-44-4444);

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
  background: url("../assets/white_mountains.jpg") no-repeat center center fixed; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;

}


#page
{
  background: #000;
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