<template>
    <v-app id="myAccountPage">
        <div id="realPage" class="example z-depth-5">
            <div>
               <h3 class="my-3"
                    contain
                    id = "mainText4"
                    >
                    Your Current Account
                </h3>
                <v-card
                    class="example z-depth-5"
                    max-width="30%"
                    id="currentAccount"
                >
                <v-img
                height="70%"
                :src="require('../assets/camera.jpg')"
                >
                    <v-card-title>Top 10 Australian beaches</v-card-title>
                    </v-img>

                    <v-card-subtitle class="pb-0">
                    Number 10
                    </v-card-subtitle>

                    <v-card-text class="text--primary">
                    <div>Whitehaven Beach</div>

                    <div>Whitsunday Island, Whitsunday Islands</div>
                    </v-card-text>
                </v-card>  
                </div>
                <v-divider
                vertical inset
                ></v-divider>
            <div id="accountList">
             <h3 class="my-3"
                    contain
                    id = "mainText5"
                    >
                    Account Settings
                </h3>
                <v-container fluid id="radiobuttons">
                    <v-radio-group v-model="radios">
                    <template v-slot:label>
                        <div>Change <strong>Your account settings</strong></div>
                    </template>
                    <v-radio value="Primary">
                        <template v-slot:label>
                        <div><strong class="success--text">Primary</strong></div>
                        </template>
                    </v-radio>
                    <v-radio value="Original">
                        <template v-slot:label>
                        <div><strong class="primary--text">Original</strong></div>
                        </template>
                    </v-radio>
                    </v-radio-group>
                 </v-container>
            </div>
            <v-btn flat id="buttonRight1"
                    color="transparent"
                    v-on:click="HomeLink">
                    Home
                </v-btn>
        </div>
    </v-app>
</template>
<script>

export default {
    name: 'MyAccountPage',
    methods:{
      HomeLink: function (){
         this.$router.push('/Home')
     }
    },
}
</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Permanent+Marker&display=swap');

#myAccountPage
{
    height: auto;
    background-image: linear-gradient(to right, #353535, #313131, #2d2c2d, #292829, #252425, #212021, #1e1d1d, #1a1919, #151515, #100f0f, #080808, #000000);

}

#realPage
{
    background-color: rgb(166, 172, 177);
    position: relative;
    left:5%;
    top:5%;
    height: 90%;
    width: 90%;
    display: flex;
    flex-direction: column;
}

#currentAccount{
    position:absolute;
    height:80%;
    top:10%;
    left:4%;
}

#mainText4{
    position:absolute;
    top:3%;
    left: 4%;
}

#accountList{
    position: absolute;
    left:38%;
    width:62%;
    padding: 3%;
    height: 100%;
    background-color: white;
}

#mainText5{
    position:absolute;
    top:3%;
}

#radiobuttons{
    position: absolute;
    top:10%;
}

#buttonRight1
{
    font-family: 'Permanent Marker', cursive;
    position: absolute;
    right: 3%;
    bottom: 3%;
    padding: 10px;
    height: auto;
    font-size: 20px;
    color: black;
    
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