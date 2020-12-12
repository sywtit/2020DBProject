<template>
    <v-app id="loginPage">
            <v-card
            elevation="24"
            shaped
            tile
            id="loginCard"
            >
              <v-tabs
                v-model="tab"
                background-color="transparent"
                color="basil"
                grow>
                <v-tab
                    v-for="item in items"
                    :key="item"
                >
                 {{ item }}
                </v-tab>
              </v-tabs>
         <!-- @click.prevent='setComponent("register")'>Register -->

               <v-tabs-items v-model="tab">
                <v-tab-item
                    v-for="item in items"
                    :key="item"
                >
                    <v-card
                    color="basil"
                    flat
                    >
                    <!-- {{content.Components}} -->
                </v-card>
            </v-tab-item>
            </v-tabs-items>

            </v-card>
    </v-app>
</template>

<script>
// import Login from '../components/login/Login'

export default {
    name: 'LoginPage',
    data () {
        return {
            tab: null,
            items: [
            'Login', 'Sign Up'
            ],
            // content : {'Components': Login}
        }
        },
    components:
    {
        // Login,
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

#loginCard{
    background-color:aliceblue;
    position:relative;
    width: 40%;
    height: 70%;
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