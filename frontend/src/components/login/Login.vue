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
export default {
    name: 'Login'
    ,
    data: () => ({
        email: null,
        password: null,
    }),
    methods:{
        login: function(){
            this.$router.push('/Home');
        }
    }
}
</script>

<style>

</style>