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
                    </v-img>

                    <v-card-subtitle class="pb-0">
                    ending-credit
                    </v-card-subtitle>

                    <v-card-text class="text--primary" id="smalltext">
                    <div>{{accountType}}</div>

                    <div>{{lastName}}.{{firstName}}</div>
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
                        <div><strong class="success--text">Unlimited</strong></div>
                        </template>
                    </v-radio>
                    <v-radio value="Original">
                        <template v-slot:label>
                        <div><strong class="primary--text">limited</strong></div>
                        </template>
                    </v-radio>
                    </v-radio-group>
                 </v-container>
            </div>
            <v-divider
                vertical inset
                ></v-divider>
            <div id="info">
                <h3 class="my-3"
                    contain
                    id = "mainText5"
                    >
                    Other Info
                </h3>
                <div class="pa-3">
        <v-row>
            <v-col
            cols="12"
            sm="6"
          >
          <v-text-field v-model="lastName" label="lastname">
                    </v-text-field>
            </v-col>
             <v-col
            cols="12"
            sm="6"
          >
                     <v-text-field v-model="firstName" label="firstname">
                    </v-text-field>
             </v-col>
        </v-row>
                    <v-text-field v-model="email" label="email" type="email">
                    </v-text-field>
                    <v-text-field v-model="phoneNum" label="phone-number">
                    </v-text-field>
                    <v-text-field v-model="creditNum" label="credit-number">
                    </v-text-field>
                    <v-text-field v-model="password" label="password" type="password">
                    </v-text-field>
                    <v-select
                     :items="items"
                     label="Standard"
                     v-model="accountType"
                  ></v-select>
                </div>
            </div>
            <v-btn flat id="buttonRight2"
                    color="transparent"
                    v-on:click="HomeLink">
                    Update
                </v-btn>
            <v-btn flat id="buttonRight1"
                    color="transparent"
                    v-on:click="HomeLink">
                    Home
                </v-btn>
        </div>
    </v-app>
</template>
<script>
import axios from "axios"

export default {
    name: 'MyAccountPage',
    methods:{
      HomeLink: function (){
         this.$router.push('/Home')
     }
    },
     data() {
          return {
            resData: {},
            items: ['umlimited', 'limited'],
            
                lastName:'',
                firstName:'',
                email:'',
                phoneNum:'',
                creditNum:'',
                password:'',
                accountType:'',
                 radios: null,
          
          }
        },
    created(){
      var userData = {
            customerId : localStorage.getItem("userId")
          }
          axios
                .post('http://localhost:5000/api/account/info', userData)
                .then(res => {
                    console.log('성공' + res.data);
                    this.resData = res.data;
                    console.log(this.resData);
                    this.lastName = this.resData.lastName;
                    this.firstName= this.resData.firstName;
                    this.email= this.resData.email;
                    this.phoneNum= this.resData.phoneNum;
                    this.creditNum= this.resData.creditNum;
                    this.password= this.resData.password;
                    this.accountType= this.resData.accountType;
                    if(this.accountType == "unlimited")
                    this.radios = "Primary";
                    else if(this.accountType == "limited")
                    this.radios = "Original";
                })
                .catch((err) => {
                    console.log(err)
                    alert('post 요청 실패' + userData)
                });
    }
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

#smalltext{
        font-family: 'Permanent Marker', cursive;
        font-size: 20px;
}
#accountList{
    position: absolute;
    left:38%;
    width:25%;
    padding: 3%;
    height: 100%;
    background-color: white;
}

#info{
    position: absolute;
    left: 63%;
    width: 37%;
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

#buttonRight2
{
    font-family: 'Permanent Marker', cursive;
    position: absolute;
    right: 10%;
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