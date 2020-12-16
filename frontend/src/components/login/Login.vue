<template>
     <div class="pa-3">
                    <v-text-field v-model="email" label="email" type="email">
                    </v-text-field>
                    <v-text-field v-model="password" label="password" type="password">
                    </v-text-field>
                    <v-btn class="black white--text" depressed block large 
                    top = "40px"
                    @click="login">
                        LOGIN
                    </v-btn>
                </div>
</template>

<script>
import axios from "axios"

export default {
    name: 'Login'
    ,
    data: () => ({
        email: null,
        password: null,
    }),
    methods:{
        login: function(){
        var userData = {
                email:this.email
          }
          axios
                .post('http://localhost:5000/api/user/account/auth', userData)
                .then(res => {
                    console.log('성공' + res.data)
                    this.email = '';
                    this.password = '';
                    localStorage.setItem('userId', res.data);
                    this.$router.push('/Home');
                })
                .catch((err) => {
                    console.log(err)
                    alert('post 요청 실패' + userData)
                });
        }
    }
}
</script>

<style>

</style>