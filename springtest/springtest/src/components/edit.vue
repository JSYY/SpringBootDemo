<template>
    <div class="editMain">
        <div>
            <div>id:can not change!</div>
            <input v-model="pid" disabled="true">
        </div>
        <div>
            <div>name</div>
            <input v-model="pname">
        </div>
        <button @click="update">更新</button>
        <button @click="cancel">取消</button>
    </div>
</template>

<script lang="ts">
    import { onMounted, ref, watch } from 'vue';
    import axios from 'axios';
    import ENS from '../service/event-notify.service';

    export default {
        props:{
            id:String,
            name:String
        },
        setup(props,ctx) {
            let pid=ref();
            let pname=ref();

        //props 中传入的值需要用watch来监听变化然后再给值初始化到组件中
        watch(() => {
            pid.value=props.id;
            pname.value=props.name;
        },
            state => {
                props.id,props.name
            },
            { deep: true }
        )

            onMounted(()=>{

            });

            function update(){
                let person = {"id":pid.value,"name":pname.value};
                axios.post("/TestApi/updatePerson",person).then((res)=>{
                    if(res.data == 1){
                        //notify parent component update
                        ENS.emitEvent("updatePersonList",null);
                    }
                });
                ctx.emit("closeEditpage");
            }

            function cancel(){
                ctx.emit("closeEditpage");
            }

            return {
               pid,
               pname,
               update,
               cancel
            }
        }
    }

</script>

<style scoped>
    .editMain{
        width:200px;
        height: 130px;
        background-color: burlywood;
    }
</style>
