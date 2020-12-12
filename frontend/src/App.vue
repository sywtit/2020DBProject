<template>
<v-app>
    <div>
        <!-- <v-icon id = "logo">ending_credit</v-icon> -->
                <router-view :key="$route.fullPath"></router-view>
    </div>
</v-app>
</template>

<script>
export default {
    name: 'App'
}
</script>

<style>

</style>