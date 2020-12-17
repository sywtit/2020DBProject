<template>
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
                    <v-btn class="black white--text" depressed block large 
                    @click="signup">
                        Sign Up
                    </v-btn>
                    <v-snackbar
                     v-model="snackbar"
                     :timeout="timeout"
                  >
                     {{ text }}
                     <template v-slot:action="{ attrs }">
                     <v-btn
                        color="blue"
                        text
                        v-bind="attrs"
                        @click="snackbar = false"
                     >
                        Close
                     </v-btn>
                     </template>
                  </v-snackbar>
                </div>
                
</template>

<script>
import axios from "axios"

export default {
    name: 'SignUp',
    data () {
        return { 
           items: ['umlimited', 'limited'],
            user : {
                lastName:'',
                firstName:'',
                email:'',
                phoneNum:'',
                creditNum:'',
                password:'',
                accountType:''
            },
            snackbar: false,
            text: 'Success Sign Up',
            timeout: 2000,
        }
    },
    methods:{
       signup: function(){
          var userDate = {
                lastName:this.lastName,
                firstName:this.firstName,
                email:this.email,
                phoneNum:this.phoneNum,
                creditNum:this.creditNum,
                password:this.password,
                accountType:this.accountType
          }
          axios
                .post('http://localhost:5000/api/user/account/signup', userDate)
                .then(res => {
                    console.log('성공' + res)
                    this.snackbar = true;
                    this.lastName = '';
                    this.firstName='';
                    this.email='';
                    this.phoneNum='';
                    this.creditNum = '';
                    this.password = '';
                    this.accountType ='';
                })
                .catch((err) => {
                    console.log(err)
                    alert('post 요청 실패' + userDate)
                });
       }
    }
}
</script>

<style>

</style>
