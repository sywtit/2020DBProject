<template>
     <div class="pa-3">
                    <v-text-field v-model="identity" label="아이디를 입력하세요">
                    </v-text-field>
                    <v-text-field v-model="password" label="패스워드를 입력하세요" type="password">
                    </v-text-field>
                    <v-btn class="black white--text" depressed block large @click="login({ identity, password })">
                        LOGIN
                    </v-btn>
                </div>
</template>

<script>
export default {
    name: 'Login'
}
</script>

<style>

</style>