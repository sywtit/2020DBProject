<template>
    <v-app id="loginPage">
            <v-card
            elevation="24"
            shaped
            tile
            id="loginCard"
            >
            <b-tabs content-class="mt-3" id="tab" justified>
              <b-tab title="Login" active><p><Login/></p></b-tab>
              <b-tab title="Sign Up"><p><SignUp/></p></b-tab>
            </b-tabs>
            </v-card>
    </v-app>
</template>

<script>
import Login from '../components/login/Login'
import SignUp from '../components/login/SignUp'
export default {
    name: 'LoginPage',
    data () {
        return {
            // content : {'Components': Login}
        }
        },
        computed: {
  },
    components:
    {
        Login,SignUp
    }
}
</script>

<style>

#loginPage
{
  /* top: 0;
  left: 0; */
  /* background-image: linear-gradient(to top, #ffffff, #ffffff, #ffffff, #fffefe, #fffefe, #fdfcfc, #fbf9f9, #f9f7f7, #f5f3f3, #f1efef, #edebeb, #e9e7e7),
   url("./assets/white_mountains.jpg"); */
  background: url("../assets/white_mountains.jpg") no-repeat center center fixed; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
  display: flex;
  text-align: center;

}

#tab{
  height: auto;
}
#loginCard{
    background-color:white;
    position:relative;
    width: 40%;
    height: 74%;
    margin: auto;

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