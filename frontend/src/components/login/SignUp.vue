<!-- Register Template -->
 <template id="registerTemplate">
    <form @submit.prevent='onSubmit' ref='form' action="" class='register-form'>
      <h2>Register</h2>
      <div class="form-group" >
         <label for="firstname">Prénom</label>
         <input required type="text" v-model.trim='user.firstname' id='firstname' placeholder="Prénom">
      </div>
      <div class="form-group">
         <label for="lastname">Nom</label>
         <input required type="text" v-model.trim='user.lastname' id='lastname' placeholder="Nom">
      </div>
      <div class="form-group">
         <label for="email">Adresse électronique</label>
         <input required type="email" v-model.trim='user.email' id='email' placeholder="Adresse électronique">
      </div>
      <div class="form-group">
         <label for="password">Mot de passe</label>
         <input required type="password" v-model='user.password' placeholder="Mot de passe" id='password'>
      </div>
      <div class="form-group">
         <label for="passwordcheck">Vérification du mot de passe</label>
         <input required type="password" v-model='user.passwordChck' placeholder="Vérification du mot de passe" id='passwordcheck'>
      </div>
      <input type="submit" :disabled='!isFormValid' value='Register'>
    </form>
 </template>

<script>
export default {
    name: 'SignUp',
    data () {
        return { 
            user : {
                firstname:'',
                lastname:'',
                email:'',
                password:'',
                passwordChck:''
            }
        }
    },
}
</script>

<style>

</style>
