<template>
  <div class="home">
 
  </div>
</template>

<script lang="ts">
    import { onMounted } from 'vue';
    import axios, { Axios } from 'axios';

    export default {

        setup() {

        onMounted(() => {
            axios.get("/start");
        });

        return {

        }
    }
}
</script>
