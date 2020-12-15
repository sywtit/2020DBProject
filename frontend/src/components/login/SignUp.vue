<template>
     <div class="pa-3">
        <v-row>
            <v-col
            cols="12"
            sm="6"
          >
          <v-text-field v-model="identity" label="lastname">
                    </v-text-field>
            </v-col>
             <v-col
            cols="12"
            sm="6"
          >
                     <v-text-field v-model="identity" label="firstname">
                    </v-text-field>
             </v-col>
        </v-row>
                    <v-text-field v-model="identity" label="email" type="email">
                    </v-text-field>
                    <v-text-field v-model="password" label="phone-number">
                    </v-text-field>
                    <v-text-field v-model="password" label="credit-number">
                    </v-text-field>
                    <v-text-field v-model="password" label="password" type="password">
                    </v-text-field>
                    <v-select
                     :items="items"
                     label="Standard"
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
export default {
    name: 'SignUp',
    data () {
        return { 
           items: ['Primary', 'Original'],
            user : {
                firstname:'',
                lastname:'',
                email:'',
                password:'',
                passwordChck:''
            },
            snackbar: false,
            text: 'Success Sign Up',
            timeout: 2000,
        }
    },
    methods:{
       signup: function(){
          this.snackbar = true
       }
    }
}
</script>

<style>

</style>
